package com.br.walmart.bestroute.objects.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.br.walmart.bestroute.objects.interfaces.CitiesMapInterface;

@Entity
public class CitiesMap implements CitiesMapInterface {
	@Id
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "map", targetEntity = Path.class, fetch=FetchType.LAZY)
	private List<Path> paths;
	
	public CitiesMap () {
		this.paths = new ArrayList<Path>();
	}
	
	public CitiesMap(String name) {
		this.name = name;
		this.paths = new ArrayList<Path>();
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
		return paths;
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
