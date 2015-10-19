package com.br.walmart.bestroute.dijkstra.objects;

import java.util.List;

public class Graph {
	private final List<Vertex> vertexes;
	private final List<Edge> edges;

	public Graph(List<Vertex> vertexes, List<Edge> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	/**
	 * Obtem os vertices do grafo
	 * 
	 * @return
	 */
	public List<Vertex> getVertexes() {
		return vertexes;
	}

	/**
	 * Obtem as arestas do grafo
	 * 
	 * @return
	 */
	public List<Edge> getEdges() {
		return edges;
	}
}
