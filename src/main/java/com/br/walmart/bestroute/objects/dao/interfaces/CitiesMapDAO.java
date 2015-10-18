package com.br.walmart.bestroute.objects.dao.interfaces;

import com.br.walmart.bestroute.objects.hibernate.CitiesMap;


public interface CitiesMapDAO {
	
	public CitiesMap findMap(String name);
	
}
