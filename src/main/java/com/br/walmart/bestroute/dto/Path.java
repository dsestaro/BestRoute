package com.br.walmart.bestroute.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Path {
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CitiesMap getMap() {
		return map;
	}

	public void setMap(CitiesMap map) {
		this.map = map;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}
