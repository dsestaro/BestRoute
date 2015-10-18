package com.br.walmart.bestroute.bean;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.br.walmart.bestroute")
@EnableAutoConfiguration
public class ConfigurationBean{

	/**
	 * Insere a session factory nas classes que fazem conexão com o banco de dados
	 * 
	 * @return		- Session Factory de conexão com o banco
	 */
	@Bean
    public SessionFactory createSessionFactory(){
		return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }
}
