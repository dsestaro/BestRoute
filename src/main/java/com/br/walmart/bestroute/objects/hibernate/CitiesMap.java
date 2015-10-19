package com.br.walmart.bestroute.objects.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.br.walmart.bestroute.objects.interfaces.CitiesMapInterface;
import com.br.walmart.bestroute.objects.interfaces.PathInterface;

/**
 * Classe com anotações com o hibernate para realizar as operações com o banco de dados
 * 
 * @author davidson.sestaro
 *
 */
@Entity
public class CitiesMap implements CitiesMapInterface {
	@Id
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "map", targetEntity = Path.class, fetch=FetchType.EAGER)
	private List<PathInterface> paths;

	public CitiesMap () {
		//Instancia para evitar nullpointer no metodo addPath();
		this.paths = new ArrayList<PathInterface>();
	}
	
	public CitiesMap(String name) {
		this.name = name;
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
		return paths;
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
