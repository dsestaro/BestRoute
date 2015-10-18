package com.br.walmart.bestroute.service;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.br.walmart.bestroute.objects.dao.impl.CitiesMapDAOImpl;
import com.br.walmart.bestroute.objects.dto.CitiesMapDTO;
import com.br.walmart.bestroute.objects.hibernate.CitiesMap;
import com.br.walmart.bestroute.objects.hibernate.Path;
import com.br.walmart.bestroute.utils.DozerUtils;

@Service
public class MapService {
	
	/**
	 * Retorna o mapa gravado no banco de dados correspondente a String passada como parâmetro. 
	 *  
	 * 
	 * @param name		- Nome do mapa a ser obtido
	 * 
	 * @return			- Objeto do tipo CitiesMapDTO preenchido com as informações recuperadas em banco
	 */
	public CitiesMapDTO getMap(String name) {
		CitiesMapDAOImpl mapDAO = new CitiesMapDAOImpl();

		// Tenta obter o mapa do banco de dados
		CitiesMap map = mapDAO.findMap(name);

		// DTO para a serialização do retorno;
		CitiesMapDTO returnDTO = new CitiesMapDTO();

		// Caso exista o mapa será buscado os caminhos
		if (map != null) {
			returnDTO = DozerUtils.convert2DTO(map);
		}

		return returnDTO;
	}
	
	/**
	 * Salva o mapa passado como parâmetro no banco de dados.
	 * 
	 * @param map		- Mapa a ser salvo no banco de dados
	 */
	public void setMap(CitiesMapDTO mapDTO) {
		CitiesMap map = DozerUtils.convertFromDTO(mapDTO);
		
		CitiesMapDAOImpl mapDAO = new CitiesMapDAOImpl();
		
		mapDAO.saveOrUpdate(map);
		
//		
//		 for(Path path : map.getPaths()) {
//		
//		 //Para a geração automatica de chave estrangeira do Hibernate
//		 path.setMap(map);
//		
//		 MapService.getDatabasePath(session, path);
//		
//		 session.saveOrUpdate(path);
//		 }
//		
//		 session.close();
	}
}
