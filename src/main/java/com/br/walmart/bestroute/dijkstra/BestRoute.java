package com.br.walmart.bestroute.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.br.walmart.bestroute.dijkstra.core.Dijkstra;
import com.br.walmart.bestroute.dijkstra.objects.Edge;
import com.br.walmart.bestroute.dijkstra.objects.Graph;
import com.br.walmart.bestroute.dijkstra.objects.Vertex;
import com.br.walmart.bestroute.objects.dto.CitiesMapDTO;
import com.br.walmart.bestroute.objects.interfaces.PathInterface;

/**
 * Classe para se obter o menor caminho entre dois pontos de um determinado mapa.
 * Foi utilizado o algoritmo Dijkstra para realização do cálculo.
 * 
 * @author davidson.sestaro
 *
 */
public class BestRoute {

	private List<Vertex> nodes;
	private List<Edge> edges;

	/**
	 * Metodo para a conversão do mapa em um grafo e chamada do cálculo de menor caminho
	 * 
	 * @param map		- Mapa no qual será procurado o menor caminho
	 * @param start		- Ponto de inicio
	 * @param end		- Destino final
	 */
	public LinkedList<Vertex> execute(CitiesMapDTO map, String start, String end) {

		//Mapa para a conversao de entidades para grafos
		Map<String, Vertex> nodesMap = new HashMap<String, Vertex>();
		
		nodes = new LinkedList<Vertex>();
		edges = new LinkedList<Edge>();

		//Adiciona os caminhos salvos em banco para o grafo
		for (PathInterface path : map.getPaths()) {
			if(!nodesMap.containsKey(path.getStart())) {
				setNode(nodesMap, path.getStart());
			}
			if(!nodesMap.containsKey(path.getEnd())) {
				setNode(nodesMap, path.getEnd());
			}
		}

		//Adiciona as arestas ao grafo
		int quant = 0;
		for (PathInterface path : map.getPaths()) {
			addLane("Edge_" + quant++, path.getStart(), path.getEnd(), path.getDistance(), nodesMap);
		}

		//Inicializa o grafo
		Graph graph = new Graph(nodes, edges);
		
		Dijkstra dijkstra = new Dijkstra(graph);
		dijkstra.execute(nodesMap.get(start));
		
		//Obtem a distancia do ponto de inicio ao ponto final e o caminho realizado
		LinkedList<Vertex> path = dijkstra.getPath(nodesMap.get(end));

		return path;
	}

	/**
	 * Adiciona um vértice ao grafo
	 * 
	 * @param nodesMap		- Mapa com os vertices
	 * @param path			- Vértice a ser adicionado
	 */
	private void setNode(Map<String, Vertex> nodesMap, String path) {
		Vertex location = new Vertex(path, path);
		nodes.add(location);
		
		nodesMap.put(path, location);
	}

	/**
	 * Adiciona uma aresta ao grafo
	 * 
	 * @param laneId		- Nome da aresta
	 * @param start			- Ponto de inicio
	 * @param end			- Ponto de destino
	 * @param distance		- Distancia
	 * @param nodesMap		- Mapa com os vertices
	 */
	private void addLane(String laneId, String start, String end, double distance, Map<String, Vertex> nodesMap) {
		Edge lane = new Edge(laneId, nodesMap.get(start), nodesMap.get(end), distance);
		edges.add(lane);
	}
}
