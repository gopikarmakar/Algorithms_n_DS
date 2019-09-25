package com.hyend.data.storage.structures.graphs;

import java.util.LinkedList;

public class EdgeWeightedDiGraph {
	
	private final int V = 0;
	private int E = 0;
	
	private LinkedList<DirectedEdge>[] adjList;
	
	class DirectedEdge {
		
		private final int v;
		private final int w;
		private final double weight;
		
		public DirectedEdge(int v, int w, double weight) {
			this.v = v;
			this.w = w;
			this.weight = weight;
		}
		
		public double weight() {
			return weight;
		}
		
		public int from() {
			return v;
		}
		
		public int to() {
			return w;
		}
		
		public String toString() {
			return String.format("%d->%d %.2f", v, w, weight);
		}		
	}
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedDiGraph(int V) {
		adjList = new LinkedList[V];
		for(int v = 0; v < V; v++) {
			adjList[v] = new LinkedList<DirectedEdge>();
		}
	}
	
	public EdgeWeightedDiGraph(int[][] graph) {
		this(graph.length);
	}
	
	public int V() {
		return this.V;
	}
	
	public int E() {
		return this.E;
	}	
	
	public void addEdge(DirectedEdge edge) {
		adjList[edge.from()].add(edge);
		E += 1;
	}
	
	public Iterable<DirectedEdge> getAdjacencyList(int V) {
		return adjList[V];
	}
	
	public Iterable<DirectedEdge> edges() {
		LinkedList<DirectedEdge> edges = new LinkedList<>();
		for(int v = 0; v < this.V; v++) {
			for(DirectedEdge edge : adjList[v]) {
				edges.add(edge);
			}
		}
		return edges;
	}	
	
	class ShortestPath {
		
		public ShortestPath(int source) {
			
		}
		
		public double distTo(int v) {
			return 0.0;
		}
		
		public boolean hasPathTo(int v) {
			return false; 
		}
		
		public Iterable<DirectedEdge> pathTo(int v) {
			return null;
		}
	}
}
