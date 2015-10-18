package com.br.walmart.bestroute.objects.interfaces;

import java.util.List;

public interface CitiesMapInterface {
	
	/**
	 * Retorna o nome do mapa
	 * 
	 * @return
	 */
	public String getName();

	/**
	 * Insere o nome do mapa
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * Retorna uma lista de caminhos referentes a esse map
	 * 
	 * @return
	 */
	public List<PathInterface> getPaths();

	/**
	 * Adiciona uma lista de trajetos
	 * 
	 * @return
	 */
	public void setPaths(List<PathInterface> paths);

	/**
	 * Adiciona um trajeto a lista de trajetos
	 * 
	 * @param path
	 */
	public void addPath(PathInterface path);
}
