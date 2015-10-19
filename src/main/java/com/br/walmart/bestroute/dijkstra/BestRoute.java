package com.br.walmart.bestroute.dijkstra;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

public class BestRoute {

	private List<Vertex> nodes;
	private List<Edge> edges;

	public void execute(CitiesMapDTO map, String start, String end) {

		Map<String, Vertex> nodesMap = new HashMap<String, Vertex>();
		
		nodes = new LinkedList<Vertex>();
		edges = new LinkedList<Edge>();

		for (PathInterface path : map.getPaths()) {
			if(!nodesMap.containsKey(path.getStart())) {
				setNode(nodesMap, path.getStart());
			}
			if(!nodesMap.containsKey(path.getEnd())) {
				setNode(nodesMap, path.getEnd());
			}
		}

		int quant = 0;
		for (PathInterface path : map.getPaths()) {
			addLane("Edge_" + quant++, path.getStart(), path.getEnd(), path.getDistance(), nodesMap);
		}

		Graph graph = new Graph(nodes, edges);
		Dijkstra dijkstra = new Dijkstra(graph);
		dijkstra.execute(nodesMap.get(start));
		
		LinkedList<Vertex> path = dijkstra.getPath(nodesMap.get(end));

		for (Vertex vertex : path) {
			System.out.println(vertex);
		}
	}

	private void setNode(Map<String, Vertex> nodesMap, String path) {
		Vertex location = new Vertex(path, path);
		nodes.add(location);
		
		nodesMap.put(path, location);
	}

	private void addLane(String laneId, String start, String end, double distance, Map<String, Vertex> nodesMap) {
		Edge lane = new Edge(laneId, nodesMap.get(start), nodesMap.get(end), distance);
		edges.add(lane);
	}
}
