package com.br.walmart.bestroute.objects.dao.interfaces;

import com.br.walmart.bestroute.objects.hibernate.CitiesMap;


public interface CitiesMapDAO {
	
	/**
	 * Retorna o mapa gravado no banco de dados correspondente a String passada como parâmetro. 
	 *  
	 * 
	 * @param name		- Nome do mapa a ser obtido
	 * 
	 * @return			- Objeto do tipo CitiesMap preenchido com as informações recuperadas em banco
	 */
	public CitiesMap findMap(String name);
	
	/**
	 * Salva ou atualiza o mapa no banco de dados
	 * 
	 * @param map		- Mapa a ser inserido no banco de dados
	 */
	public void saveOrUpdate(CitiesMap map);
}
