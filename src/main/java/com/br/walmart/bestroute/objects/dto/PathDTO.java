package com.br.walmart.bestroute.objects.dto;

import com.br.walmart.bestroute.objects.interfaces.PathInterface;

/**
 * Classe utilizada para a serialização do retorno dos web services
 * 
 * @author davidson.sestaro
 */
public class PathDTO implements PathInterface{

	private String start;
	private String end;
	private double distance;
	
	public PathDTO(String start, String end, double distance) {
		this.start = start;
		this.end = end;
		this.distance = distance;
	}
	
	public PathDTO() {

	}

	@Override
	public String getStart() {
		return this.start;
	}

	@Override
	public void setStart(String start) {
		this.start = start;
	}

	@Override
	public String getEnd() {
		return this.end;
	}

	@Override
	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public double getDistance() {
		return this.distance;
	}

	@Override
	public void setDistance(double distance) {
		this.distance = distance;;
	}

}
