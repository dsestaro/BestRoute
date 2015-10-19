package com.br.walmart.bestroute.objects.interfaces;

import java.util.LinkedList;

public interface ShortestPathInterface {
	
	/**
	 * Retorna o menor caminho do ponto de origem ao destino
	 * 
	 * @return
	 */
	public LinkedList<String> getPath();
	
	/**
	 * Adiciona o menor caminho ao objeto
	 * 
	 * @param path
	 */
	public void setPath(LinkedList<String> path);
	
	
	/**
	 * Pega o valor gasto do ponto de origem ao destino
	 * 
	 * @return
	 */
	public double getCost();
	
	/**
	 * Adiciona o valor gasto do ponto de origem ao destino
	 * 
	 * @param length
	 */
	public void setCost(double cost);
	
	/**
	 * Adiciona um vertice ao caminho, o vertice e adicionado na ultima posicao
	 * 
	 * @param path
	 */
	public void addPath(String path);
}
