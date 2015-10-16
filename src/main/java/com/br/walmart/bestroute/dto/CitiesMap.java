package com.br.walmart.bestroute.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CitiesMap {
	@Id
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "map", targetEntity = Path.class)
	private List<Path> paths;
	
	public CitiesMap(String name) {
		this.name = name;
		this.paths = new ArrayList<Path>();
	}
	
	public CitiesMap () {
		this.paths = new ArrayList<Path>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Path> getPaths() {
		return paths;
	}

	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}
	
	public void addPath(Path path) {
		this.paths.add(path);
	}
}
