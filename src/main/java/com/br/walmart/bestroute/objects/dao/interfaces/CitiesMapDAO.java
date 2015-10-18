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
	
}
