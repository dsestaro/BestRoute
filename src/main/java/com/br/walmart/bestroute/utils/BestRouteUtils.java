package com.br.walmart.bestroute.utils;

import com.br.walmart.bestroute.objects.dto.ShortestPathDTO;

/**
 * Classe Utils com métodos referentes a propria aplicacao
 * 
 * @author davidson.sestaro
 *
 */
public class BestRouteUtils {
	
	/**
	 * Calcula o custo do trajeto dado um determinado caminho
	 * 
	 * @param path		- Menor caminho
	 * @param autonomy	- Autonomia do caminhao
	 * @param price		- Preco da gasolina
	 * 
	 * @return
	 */
	public static ShortestPathDTO calculateCost (ShortestPathDTO path, String autonomy, String price) {
		double priceDouble = Double.parseDouble(price);
		double autonomyDouble = Double.parseDouble(autonomy);
		
		double cost = (path.getCost() / autonomyDouble) * priceDouble;
		
		path.setCost(cost);
		
		return path;
	}
}
