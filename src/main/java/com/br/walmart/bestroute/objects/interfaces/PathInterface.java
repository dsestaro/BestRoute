package com.br.walmart.bestroute.objects.interfaces;

public interface PathInterface {
	
	/**
	 * Retorna o nome do ponto de inicio
	 * 
	 * @return
	 */
	public String getStart();

	/**
	 * Insere o nome do ponto de inicio
	 * 
	 * @param name
	 */
	public void setStart(String start);

	/**
	 * Retorna o nome do ponto de termino
	 * 
	 * @return
	 */
	public String getEnd();

	/**
	 * Insere o nome do ponto de termino
	 * 
	 * @param name
	 */
	public void setEnd(String end);

	/**
	 * Retorna a distancia entre os dois pontos
	 * 
	 * @return
	 */
	public double getDistance();

	/**
	 * Insere a distancia entre os dois pontos
	 * 
	 * @param name
	 */
	public void setDistance(double distance);
}
