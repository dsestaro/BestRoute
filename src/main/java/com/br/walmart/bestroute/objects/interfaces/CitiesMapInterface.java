package com.br.walmart.bestroute.objects.interfaces;

import java.util.List;

import com.br.walmart.bestroute.objects.hibernate.Path;

public interface CitiesMapInterface {
	
	public String getName();

	public void setName(String name);

	public List<Path> getPaths();

	public void setPaths(List<Path> paths);
	
	public void addPath(Path path);
}
