package com.br.walmart.bestroute.objects.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.br.walmart.bestroute.objects.interfaces.PathInterface;

/**
 * Classe com anotações com o hibernate para realizar as operações com o banco de dados
 * 
 * @author davidson.sestaro
 *
 */
@Entity
public class Path implements PathInterface {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="start")
	private String start;
	@Column(name="end")
	private String end;
	@Column(name="distance")
	private double distance;
	
	@ManyToOne(targetEntity = CitiesMap.class)
	private CitiesMap map;

	public Path(String start, String end, double distance, CitiesMap map) {
		this.start = start;
		this.end = end;
		this.distance = distance;
		this.map = map;
	}
	
	public Path() {
	}
	
	/**
	 * Retorna o id da instancia do banco de dados
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Insere o id da instancia do banco de dados
	 * 
	 * @param name
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna o mapa a qual esse objeto pertence
	 * 
	 * @return
	 */
	public CitiesMap getMap() {
		return map;
	}

	/**
	 * Insere o mapa a qual esse objeto pertence
	 * 
	 * @param name
	 */
	public void setMap(CitiesMap map) {
		this.map = map;
	}

	@Override
	public String getStart() {
		return start;
	}

	@Override
	public void setStart(String start) {
		this.start = start;
	}

	@Override
	public String getEnd() {
		return end;
	}

	@Override
	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public double getDistance() {
		return distance;
	}

	@Override
	public void setDistance(double distance) {
		this.distance = distance;
	}
}
