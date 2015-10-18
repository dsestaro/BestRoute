package com.br.walmart.bestroute.objects.dto;

import java.util.ArrayList;
import java.util.List;

import com.br.walmart.bestroute.objects.interfaces.CitiesMapInterface;
import com.br.walmart.bestroute.objects.interfaces.PathInterface;

/**
 * Classe utilizada para a serialização do retorno dos web services
 * 
 * @author davidson.sestaro
 */
public class CitiesMapDTO implements CitiesMapInterface {
	
	private String name;
	
	private List<PathInterface> paths;
	
	public CitiesMapDTO() {
		this.paths = new ArrayList<PathInterface>();
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
	public List<PathInterface> getPaths() {
		return this.paths;
	}

	@Override
	public void setPaths(List<PathInterface> paths) {
		this.paths = paths;
	}

	@Override
	public void addPath(PathInterface path) {
		this.paths.add(path);
	}
}
