package com.br.walmart.bestroute.objects.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.br.walmart.bestroute.objects.dao.interfaces.PathDAO;
import com.br.walmart.bestroute.objects.hibernate.Path;
import com.br.walmart.bestroute.utils.HibernateUtils;

/**
 * Implementação da classe de acesso ao banco de dados
 * 
 * @author davidson.sestaro
 */
@Service
@Configurable
public class PathDAOImpl implements PathDAO {

	private static HibernateUtils hibernateUtils;

	@Autowired
	public PathDAOImpl(HibernateUtils utils) {
		this.hibernateUtils = utils;
	}

	public PathDAOImpl() {

	}

	@Override
	public Path getDatabasePath(Path path) {
		Session session = hibernateUtils.getSession();
		
		String sql = "SELECT * FROM PATH WHERE " + "START = '" + path.getStart() + "' AND " + "END = '"
				+ path.getEnd() + "' AND " + "MAP_NAME = '" + path.getMap().getName() + "'";

		List<Path> paths = session.createSQLQuery(sql).addEntity(Path.class).list();

		if (!paths.isEmpty()) {
			// Pela regra de negócio estabelecida so pode existir um unico
			// caminho entre o ponto
			// inicial e o final para o mapa pesquisado.
			Path pathReturn = paths.get(0);

			// Atualiza a distancia com a nova distancia informada
			pathReturn.setDistance(path.getDistance());
			
			session.close();
			
			return pathReturn;
		}

		session.close();

		return path;
	}
	
	@Override
	public void saveOrUpdate(Path path) {
		Session session = hibernateUtils.getSession();

		//TODO remover para annotation
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(path);
		
		//TODO remover para annotation
		transaction.commit();
		session.flush();
		
		session.close();
	}
}
