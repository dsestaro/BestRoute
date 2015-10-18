package com.br.walmart.bestroute.controller;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.walmart.bestroute.objects.dao.impl.CitiesMapDAOImpl;
import com.br.walmart.bestroute.objects.dto.CitiesMapDTO;
import com.br.walmart.bestroute.objects.hibernate.CitiesMap;
import com.br.walmart.bestroute.service.MapService;

@RestController
@RequestMapping("/rest")
public class MapController {

	@Autowired
	private MapService mapService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getMap")
	public @ResponseBody CitiesMapDTO getMap(@RequestParam(value = "name") String name) {
		return mapService.getMap(name);
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
