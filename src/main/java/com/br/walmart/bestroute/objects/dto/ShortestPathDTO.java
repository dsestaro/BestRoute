package com.br.walmart.bestroute.objects.dto;

import java.util.LinkedList;

import com.br.walmart.bestroute.objects.interfaces.ShortestPathInterface;

public class ShortestPathDTO implements ShortestPathInterface {
	private LinkedList<String> path;
	private double cost;
	
	public ShortestPathDTO() {
		this.path = new LinkedList<String>();
	}
	
	@Override
	public LinkedList<String> getPath() {
		return path;
	}
	
	@Override
	public void setPath(LinkedList<String> path) {
		this.path = path;
	}
	
	@Override
	public double getCost() {
		return cost;
	}
	
	@Override
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public void addPath(String path) {
		this.path.add(path);
	}
}
