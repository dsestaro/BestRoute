package com.br.walmart.bestroute.controller;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.walmart.bestroute.objects.dao.impl.CitiesMapDAOImpl;
import com.br.walmart.bestroute.objects.dto.CitiesMapDTO;
import com.br.walmart.bestroute.objects.hibernate.CitiesMap;

@RestController
@RequestMapping("/rest")
public class MapController {

	@RequestMapping(method = RequestMethod.GET, value = "/getMap")
	public @ResponseBody CitiesMapDTO getMap(@RequestParam(value = "name") String name) {

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

	@RequestMapping(method = RequestMethod.POST, value = "/setMap")
	public void setMap(@RequestParam(value = "map") CitiesMap map) {
		// Session session = new HibernateUtils().getSession();
		// Transaction transaction = session.beginTransaction();
		//
		// session.saveOrUpdate(map);
		//
		// for(Path path : map.getPaths()) {
		//
		// //Para a geração automatica de chave estrangeira do Hibernate
		// path.setMap(map);
		//
		// MapService.getDatabasePath(session, path);
		//
		// session.saveOrUpdate(path);
		// }
		//
		// session.close();
		//
		// return;
	}
}
