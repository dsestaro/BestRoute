package com.br.walmart.bestroute;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.br.walmart.bestroute.start.BestRouteApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BestRouteApplication.class)
@WebAppConfiguration
public class BestRouteApplicationTests {

	@Test
	public void contextLoads() {
	}

}
