package com.br.walmart.bestroute.dijkstra.objects;

public class Edge {
	private final String id;
	private final Vertex source;
	private final Vertex destination;
	private final double weight;

	public Edge(String id, Vertex source, Vertex destination, double distance) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = distance;
	}
	
	/**
	 * Obtem o ID da aresta
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * Obtem o vertice de destino
	 * 
	 * @return
	 */
	public Vertex getDestination() {
		return destination;
	}

	/**
	 * Obtem o vertice de origem
	 * 
	 * @return
	 */
	public Vertex getSource() {
		return source;
	}

	/**
	 * Obtem a distancia do ponto de origem ate o de destino
	 * 
	 * @return
	 */
	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return source + " " + destination + " " + weight;
	}
}
