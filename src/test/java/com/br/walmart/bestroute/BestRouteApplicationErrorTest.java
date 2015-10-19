package com.br.walmart.bestroute;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.br.walmart.bestroute.exception.MapNotFoundException;
import com.br.walmart.bestroute.exception.PathNotFoundException;
import com.br.walmart.bestroute.objects.dto.CitiesMapDTO;
import com.br.walmart.bestroute.objects.dto.PathDTO;
import com.br.walmart.bestroute.service.MapService;
import com.br.walmart.bestroute.start.BestRouteApplication;
import com.br.walmart.bestroute.utils.HibernateUtils;
import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BestRouteApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class BestRouteApplicationErrorTest {

	@Value("${local.server.port}")
	private int port;
	
	@Mock
	private HibernateUtils hibernateUtils;
	@Mock
	private Session session;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		RestAssured.port = port;
	}
	
	@Test
	public void getMapTestError() {
		given().
    		parameters("name", "").
    	expect().
    		statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR).
    		body("message", equalTo("É necessário especificar o nome do mapa a ser encontrado.")).
    	when().
    		get("/rest/getMap");
    	
	}
	
	@Test	
	public void setMapTestError() {
		CitiesMapDTO map = new CitiesMapDTO();
		
		map.setName(null);
		
		PathDTO pathDTO = new PathDTO();
		
		pathDTO.setStart("Q");
		pathDTO.setEnd("P");
		pathDTO.setDistance(20);
		
		map.addPath(pathDTO);
		
		given().
			parameters("map", map).
    	expect().
    		statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR).
    		body("message", equalTo("É necessário especificar o nome do mapa a ser salvo.")).
    	when().
    		post("/rest/setMap");
    	
	}
	
	@Test
	public void bestRouteTest () {
		given().
			parameters("name", "").
			parameters("start", "").
			parameters("end", "").
			parameters("autonomy", "").
			parameters("price", "").
		expect().
			statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR).
			body("message", equalTo("É necessário informar todos os parâmetros.")).
		when().
			get("/rest/bestRoute");
	}
	
	@Test(expected=PathNotFoundException.class)
	public void dijkstraTest () throws PathNotFoundException, MapNotFoundException {
		MapService service = new MapService();
		
		service.calcBestRoute("SP", "A","D", "10", "2.50");
	}
}
