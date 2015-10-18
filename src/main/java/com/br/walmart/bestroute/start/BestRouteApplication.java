package com.br.walmart.bestroute.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe inicial do spring boot. São carregadas as configurações e iniciado a injeção das dependências, além
 * da inicialização e mapeamento dos serviços.
 * 
 * @author davidson.sestaro
 *
 */
@SpringBootApplication
@RestController
@EnableAutoConfiguration
@ComponentScan(value = "com.br.walmart.bestroute")
public class BestRouteApplication {

	/**
	 * Método de start da aplicação
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BestRouteApplication.class, args);
	}
}
