package com.br.walmart.bestroute.objects.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.br.walmart.bestroute.objects.dao.interfaces.CitiesMapDAO;
import com.br.walmart.bestroute.objects.hibernate.CitiesMap;
import com.br.walmart.bestroute.utils.HibernateUtils;

/**
 * Implementação da classe de acesso ao banco de dados
 * 
 * @author davidson.sestaro
 */
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
	
	@Override
	public CitiesMap findMap(String name) {
		Session session = hibernateUtils.getSession();
		
		//Tenta obter o mapa do banco de dados
		CitiesMap map = (CitiesMap) session.get(CitiesMap.class, name);
		
		session.close();
		return map;
	}
	
	@Override
	public void saveOrUpdate(CitiesMap map) {
		Session session = hibernateUtils.getSession();
		
		//TODO remover para annotation
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(map);

		//TODO remover para annotation
		transaction.commit();
		session.flush();
		
		session.close();
	}
}

