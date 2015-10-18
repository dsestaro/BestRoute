package com.br.walmart.bestroute;

import static com.jayway.restassured.RestAssured.given;
import static org.mockito.Mockito.when;

import org.apache.http.HttpStatus;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.br.walmart.bestroute.objects.dao.impl.CitiesMapDAOImpl;
import com.br.walmart.bestroute.objects.hibernate.CitiesMap;
import com.br.walmart.bestroute.objects.hibernate.Path;
import com.br.walmart.bestroute.start.BestRouteApplication;
import com.br.walmart.bestroute.utils.HibernateUtils;
import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BestRouteApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class BestRouteApplicationTests {

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
	public void getMapTest() {
		given().
    		parameters("name", "SP").
    	expect().
    		statusCode(HttpStatus.SC_OK).
    	when().
    		get("/rest/getMap");
	}

	@Test
	public void findMapTest () {
		CitiesMapDAOImpl dao = new CitiesMapDAOImpl(this.hibernateUtils);
		
		CitiesMap map = new CitiesMap("SP");
		map.addPath(new Path("A", "B", 10, map));

		when(hibernateUtils.getSession()).thenReturn(this.session);
		when(session.get(CitiesMap.class, "SP")).thenReturn(map);

		Assert.assertEquals(dao.findMap("SP"), map);
	}
}
