package com.br.walmart.bestroute.objects.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.br.walmart.bestroute.objects.dao.interfaces.CitiesMapDAO;
import com.br.walmart.bestroute.objects.hibernate.CitiesMap;
import com.br.walmart.bestroute.utils.HibernateUtils;

@Service
@Configurable
public class CitiesMapDAOImpl implements CitiesMapDAO {
	
	private static HibernateUtils hibernateUtils;
	
	@Autowired
	public CitiesMapDAOImpl(HibernateUtils utils) {
		this.hibernateUtils = utils;
	}
	
	public CitiesMapDAOImpl() {
		
	}
	
	public CitiesMap findMap(String name) {
		Session session = hibernateUtils.getSession();
		
		session.beginTransaction();

		//Tenta obter o mapa do banco de dados
		CitiesMap map = (CitiesMap) session.get(CitiesMap.class, name);
		
		session.close();
		return map;
	}
}
