package com.br.walmart.bestroute.objects.dao.interfaces;

import org.hibernate.Session;

import com.br.walmart.bestroute.objects.hibernate.Path;

public interface PathDAO {
	
	/**
	 * Verifica se o trajeto já existe no banco de dados, caso positivo atualiza o valor inserido no objeto. 
	 * 
	 * @param path		- Trajeto a ser verificado.
	 * 
	 * @return			- Trajeto com as informações atualizadas
	 */
	public Path getDatabasePath(Path path);
	
	/**
	 * Salva ou atualiza o trajeto no banco de dados
	 * 
	 * @param map		- Trajeto a ser inserido no banco de dados
	 */
	public void saveOrUpdate(Path path);
}
