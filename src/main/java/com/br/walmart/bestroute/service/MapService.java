package com.br.walmart.bestroute.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.br.walmart.bestroute.objects.dao.impl.CitiesMapDAOImpl;
import com.br.walmart.bestroute.objects.dto.CitiesMapDTO;
import com.br.walmart.bestroute.objects.hibernate.CitiesMap;
import com.br.walmart.bestroute.objects.hibernate.Path;

@Service
public class MapService {
	
	
	public CitiesMapDTO getMap(String name) {
		CitiesMapDAOImpl mapDAO = new CitiesMapDAOImpl();

		// Tenta obter o mapa do banco de dados
		CitiesMap map = mapDAO.findMap(name);

		// DTO para a serialização do retorno;
		CitiesMapDTO returnDTO = new CitiesMapDTO();

		// Caso exista o mapa será buscado os caminhos
		if (map != null) {
			Mapper mapper = new DozerBeanMapper();
			returnDTO = mapper.map(map, CitiesMapDTO.class);
		}

		return returnDTO;
	}
	
	
	//Mover para a PathsDAO
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
