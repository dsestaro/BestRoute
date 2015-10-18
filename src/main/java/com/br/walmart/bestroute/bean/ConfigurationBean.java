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

	@Bean
    public SessionFactory createSessionFactory(){
		return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }
}
