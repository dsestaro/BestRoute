package com.br.walmart.bestroute.dijkstra.objects;

public class Vertex {
	final private String id;
	final private String name;
	private double distancia;

	public Vertex(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Obtem o ID do vertice
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Obtem o nome do vertice
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Obtem a distancia do vertice ao ponto de origem
	 * 
	 * @return
	 */
	public double getDistancia() {
		return distancia;
	}

	/**
	 * Adicona a distancia do vertice ao ponto de origem
	 * 
	 * @param distancia
	 */
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
