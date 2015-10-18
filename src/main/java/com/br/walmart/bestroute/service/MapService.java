package com.br.walmart.bestroute.service;

import java.util.List;

import org.hibernate.Session;

import com.br.walmart.bestroute.objects.hibernate.Path;

public class MapService {
	
	public static Path getDatabasePath(Session session, Path path) {
		String sql = "SELECT * FROM PATH WHERE " +
				 		"START = '" + path.getStart() + "1' AND " +
				 		"END = '" + path.getEnd() + "' AND " +
				 		"MAP_NAME = '" + path.getMap().getName() + "'";
		
		List<Path> paths = session.createSQLQuery(sql).addEntity(Path.class).list();
		
		if(!paths.isEmpty()) {
			//Pela regra de negócio estabelecida so pode existir um unico caminho entre o ponto
			//inicial e o final para o mapa pesquisado.
			Path pathReturn = paths.get(0);
			
			//Atualiza a distancia com a nova distancia informada
			pathReturn.setDistance(path.getDistance());
			
			return pathReturn;
		}
		
		return path;
	}
	
}
