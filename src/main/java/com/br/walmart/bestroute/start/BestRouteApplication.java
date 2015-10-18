package com.br.walmart.bestroute.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@ComponentScan(value = "com.br.walmart.bestroute")
public class BestRouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestRouteApplication.class, args);
	}
}
