package com.br.walmart.bestroute.dijkstra.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.br.walmart.bestroute.dijkstra.objects.Edge;
import com.br.walmart.bestroute.dijkstra.objects.Graph;
import com.br.walmart.bestroute.dijkstra.objects.Vertex;

public class Dijkstra {

	private final List<Edge> edges;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;
	private Map<Vertex, Vertex> predecessors;
	private Map<Vertex, Double> distance;

	public Dijkstra(Graph graph) {
		// Instancia para evitar nullpointer
		this.edges = new ArrayList<Edge>(graph.getEdges());
	}

	/**
	 * Metodo principal que realiza o cálculo das distancia de um determinado ponto
	 * 
	 * @param source		- Vertice de origem
	 */
	public void execute(Vertex source) {
		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();
		distance = new HashMap<Vertex, Double>();
		predecessors = new HashMap<Vertex, Vertex>();
		distance.put(source, 0.0);
		unSettledNodes.add(source);
		
		//Verifica se ainda existem vertices a ser verificados
		while (unSettledNodes.size() > 0) {
			//Obtem o vertice mais proxumo
			Vertex node = getMinimum(unSettledNodes);
			
			//Adiciona aos vertices verificados
			settledNodes.add(node);
			
			//Remove o vertice dos nao verificados
			unSettledNodes.remove(node);
			
			//Calcula a distancia minima
			findMinimalDistances(node);
		}
	}

	/**
	 * Calcula a distancia minima
	 * 
	 * @param node		- Vertice que se deseja calcula a distancia
	 */
	private void findMinimalDistances(Vertex node) {
		//Obtem os vertices vizinhos
		List<Vertex> adjacentNodes = getNeighbors(node);
		
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}
	}

	/**
	 * Calcula a distancia entre dois vertices
	 * 
	 * @param node			- Vertice de origem
	 * @param target		- Vertice de destino
	 * @return
	 */
	private double getDistance(Vertex node, Vertex target) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		
		throw new RuntimeException("Erro no processamento do algoritmo Dijkstra.");
	}

	/**
	 * Obtem os vertices adjacentes ao vertice de origem.
	 * 
	 * @param node			- Vertice de origem
	 * @return
	 */
	private List<Vertex> getNeighbors(Vertex node) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}

	/**
	 * Obtem o vertice mais proximo do ponto de origem.
	 * 
	 * @param vertexes		- Lista de vertices que se deve calcula a distancia
	 * @return				- Vertice mais proximo
	 */
	private Vertex getMinimum(Set<Vertex> vertexes) {
		Vertex minimum = null;
		for (Vertex vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Vertex vertex) {
		return settledNodes.contains(vertex);
	}

	/**
	 * Obtem a distancia do map de distancias
	 * 
	 * @param destination		- Destino que se quer calcular
	 * @return
	 */
	private double getShortestDistance(Vertex destination) {
		Double d = distance.get(destination);
		if (d == null) {
			return Double.MAX_VALUE;
		} else {
			return d;
		}
	}

	/**
	 * Calcula o caminho entro o ponto de origem e o de destino.
	 * 
	 * @param target		- Vertice de destino
	 * @return				- Caminho obtido ou null caso não exista
	 */
	public LinkedList<Vertex> getPath(Vertex target) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		
		target.setDistancia(0);
		
		// verifica se o caminho existe
		if (predecessors.get(step) == null) {
			return null;
		}
		
		path.add(step);
		
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		
		//Coloca os vertices na ordem correta
		Collections.reverse(path);
		
		//Obtem as distancias do mapa de distancia
		for(Vertex vertex : path) {
			vertex.setDistancia(this.distance.get(vertex));
		}
		
		return path;
	}
}
