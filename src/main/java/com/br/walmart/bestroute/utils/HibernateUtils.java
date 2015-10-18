package com.br.walmart.bestroute.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe Utils com métodos referentes ao framework hibernate
 * 
 * @author davidson.sestaro
 */
@Service
public class HibernateUtils {
	private final SessionFactory sessionFactory;
	
	@Autowired
	public HibernateUtils(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Retorna uma sessão aberta do hibernate
	 * 
	 * @return		- Sessão de conexão com o banco de dados
	 */
	public Session getSession() {
		return sessionFactory.openSession();
	}
}
