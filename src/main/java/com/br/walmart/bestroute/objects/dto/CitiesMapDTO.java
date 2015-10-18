package com.br.walmart.bestroute.objects.dto;

import java.util.ArrayList;
import java.util.List;

import com.br.walmart.bestroute.objects.hibernate.Path;
import com.br.walmart.bestroute.objects.interfaces.CitiesMapInterface;

public class CitiesMapDTO implements CitiesMapInterface {
	
	private String name;
	
	private List<Path> paths;
	
	public CitiesMapDTO() {
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<Path> getPaths() {
		return this.paths;
	}

	@Override
	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}

	@Override
	public void addPath(Path path) {
		this.paths.add(path);
	}
}
