package com.br.walmart.bestroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.walmart.bestroute.objects.dto.CitiesMapDTO;
import com.br.walmart.bestroute.objects.hibernate.CitiesMap;
import com.br.walmart.bestroute.service.MapService;

@RestController
@RequestMapping("/rest")
public class MapController {

	//Classe que contem as regras de negócio
	@Autowired
	private MapService mapService;
	
	/**
	 * Retorna o mapa gravado no banco de dados correspondente a String passada como parâmetro. 
	 *  
	 * 
	 * @param name		- Nome do mapa a ser obtido
	 * 
	 * @return			- Objeto do tipo CitiesMapDTO preenchido com as informações recuperadas em banco
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getMap")
	public @ResponseBody CitiesMapDTO getMap(@RequestParam(value = "name") String name) {
		return mapService.getMap(name);
	}

	/**
	 * Salva o mapa passado como parâmetro no banco de dados.
	 * 
	 * @param map		- Mapa a ser salvo no banco de dados
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/setMap")
	public void setMap(@RequestParam(value = "map") CitiesMap map) {
		// return mapService.setMap(map);
	}
}
