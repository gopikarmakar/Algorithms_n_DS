package com.hyend.data.storage.structures;

import java.util.Stack;

public class DirectedGraph {
	
	private int edges = 0, vertices = 0;	
	private MyLinkedList<Integer>[] adjacencyList;
	
	@SuppressWarnings("unchecked")
	public DirectedGraph(int V) {
		this.vertices = V;
		this.edges = 0;
		
		adjacencyList = new MyLinkedList[this.vertices];
		for(int v = 0; v < this.vertices; v++) {
			adjacencyList[v] = new MyLinkedList<Integer>();
		}
	}
	
	public int edges() {		
		return this.edges;
	}
	
	public int vertices() {	
		return this.vertices;
	}
	
	public void addEdge(int v, int w) {
		adjacencyList[v].add(w);
		this.edges += 1;
	}
	
	public Iterable<Integer> getAdjacencyListFor(int V) {		
		return adjacencyList[V];
	}
	
	public DirectedGraph reverse() {		
		DirectedGraph diGraphs = new DirectedGraph(this.vertices);
		for(int v = 0; v < this.vertices; v++) {
			for(int w : adjacencyList[v]) {
				addEdge(w, v);
			}
		}
		return diGraphs;
	}
	
	public String toString() {		
		return null;
	}
	
	class DirectedDFS {
		boolean[] marked;
		
		public DirectedDFS(DirectedGraph diGraph, int source) {
			marked = new boolean[diGraph.vertices];
		}
		
		public DirectedDFS(DirectedGraph diGraph, Iterable<Integer> sources) {
			for(int v : sources) {
				if(!marked[v]) {
					dfs(diGraph, v);						
				}
			}
		}
		
		public void dfs(DirectedGraph diGraph, int V) {
			marked[V] = true;
			for(int w : diGraph.getAdjacencyListFor(V)) {
				if(!marked[V]) {
					dfs(diGraph, w);
				}
			}
		}
	}
	
	class DirectedCycle {
		
		private int edgeTo[];
		private boolean marked[];
		private boolean onStack[];
		private Stack<Integer> cycle;
		
		public DirectedCycle(DirectedGraph diGraph) {
			edgeTo = new int[diGraph.vertices()];
			marked = new boolean[diGraph.vertices()];
			onStack = new boolean[diGraph.vertices()];
			for(int v = 0; v < diGraph.vertices(); v++) {
				if(!marked[v]) dfs(diGraph, v);
			}
		}
		
		private void dfs(DirectedGraph diGraph, int v) {
			marked[v] = true;
			onStack[v] = true;
			for(int w : diGraph.getAdjacencyListFor(v)) {
				if(hasCycle()) return;
				if(!marked[w]) {
					edgeTo[w] = v;
					dfs(diGraph, w);
				}
				else if(onStack[w]) {
					cycle = new Stack<>();
					for(int x = v; x != w; x = edgeTo[x]) {
						cycle.push(x);
					}					
					cycle.push(w);
					cycle.push(v);
				}				
			}
			onStack[v] = false;
		}
		
		public boolean hasCycle() {
			return (cycle != null);
		}
		
		public Iterable<Integer> cycle() {
			return cycle;
		}
	}
}