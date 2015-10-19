package com.br.walmart.bestroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.walmart.bestroute.exception.MapNotFoundException;
import com.br.walmart.bestroute.exception.PathNotFoundException;
import com.br.walmart.bestroute.objects.dto.CitiesMapDTO;
import com.br.walmart.bestroute.objects.dto.ShortestPathDTO;
import com.br.walmart.bestroute.objects.interfaces.PathInterface;
import com.br.walmart.bestroute.service.MapService;
import com.br.walmart.bestroute.utils.typeadapter.PathTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/rest")
public class MapController {

	// Classe que contem as regras de negócio
	@Autowired
	private MapService mapService;

	/**
	 * Retorna o mapa gravado no banco de dados correspondente a String passada
	 * como parâmetro.
	 * 
	 * 
	 * @param name
	 *            - Nome do mapa a ser obtido
	 * 
	 * @return - Objeto do tipo CitiesMapDTO preenchido com as informações
	 *         recuperadas em banco
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/getMap")
	public @ResponseBody CitiesMapDTO getMap(@RequestParam(value = "name") String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("You must specify the map name to be found.");
		}

		return mapService.getMap(name);
	}

	/**
	 * Salva o mapa passado como parâmetro no banco de dados.
	 * 
	 * @param map
	 *            - Mapa a ser salvo no banco de dados
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/setMap")
	public void setMap(@RequestParam(value = "map") String json) {

		if (json == null || json.isEmpty()) {
			throw new IllegalArgumentException("You must specify the map to be saved.");
		}

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(PathInterface.class, new PathTypeAdapter());
		Gson gson = gsonBuilder.create();

		CitiesMapDTO map = gson.fromJson(json, CitiesMapDTO.class);

		if (map.getName() == null || map.getName().isEmpty()) {
			throw new IllegalArgumentException("You must specify the map name to be saved.");
		}

		mapService.setMap(map);
	}

	/**
	 * Calcula o custo da menor rota possivel no mapa informado.
	 * 
	 * @param name		- Nome do mapa a ser calculado
	 * @param start		- Vertice de origem
	 * @param end		- Vertice de destino
	 * @param autonomy	- Autonomia do caminhao
	 * @param price		- preco da gasolina
	 * 
	 * @return
	 * @throws MapNotFoundException 	- Mapa nao existe
	 * @throws PathNotFoundException	- Caminho nao existe
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/bestRoute")
	public @ResponseBody ShortestPathDTO bestRoute(@RequestParam(value = "name") String name,
			@RequestParam(value = "start") String start, @RequestParam(value = "end") String end,
			@RequestParam(value = "autonomy") String autonomy, @RequestParam(value = "price") String price)
			throws MapNotFoundException, PathNotFoundException {

		if (name == null || name.isEmpty() || start == null || start.isEmpty() || end == null || end.isEmpty()
				|| autonomy == null || autonomy.isEmpty() || price == null || price.isEmpty()) {
			throw new IllegalArgumentException("It is necessary to inform all the parameters.");
		}

		return mapService.calcBestRoute(name, start, end, autonomy, price);
	}
}
