package com.hyend.data.storage.structures.graphs.directed;

import java.util.Queue;
import java.util.Stack;

import com.hyend.data.storage.structures.linkedlists.singly.MyLinkedList;

import java.util.LinkedList;

/**
 * A Concrete implementation of Directed Graph with 
 * DFS and BFS traversals, Reversing a graph, Finding directed cycles,
 * Depth first order traversals, Finding strong connections, Shortest paths traversals
 *   
 * @author gopi_karmakar
 */
public class DirectedGraph_Old {
	
	private int edges = 0, vertices = 0;
	private MyLinkedList<Integer>[] adjacencyList;
	
	public static void main(String[] args) {
		
	}
	
	@SuppressWarnings("unchecked")	
	public DirectedGraph_Old(int V) {
		this.vertices = V;
		this.edges = 0;
		adjacencyList = new MyLinkedList[this.vertices];
		for(int v = 0; v < this.vertices; v++) {
			adjacencyList[v] = new MyLinkedList<Integer>();
		}		
	}		
	public DirectedGraph_Old(int[][] graph) {
		this(graph.length);
		for(int v = 0; v < this.vertices; v++) {
			for(int w = 1; w < graph[v].length; w++) {
				addEdge(graph[v][0], graph[v][w]);
			}
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
	/**
	 * Reversal of a DiGraph.
	 * @return
	 */
	public DirectedGraph_Old reverse() {		
		DirectedGraph_Old diGraph = new DirectedGraph_Old(this.vertices());
		for(int v = 0; v < this.vertices(); v++) {
			for(int w : getAdjacencyListFor(v)) {
				diGraph.addEdge(w, v);
			}
		}
		return diGraph;
	}	
	public String toString() {		
		return null;
	}
	/**
	 * DFS and BFS traversals of DiGraph
	 * @author gopi_karmakar
	 *
	 */
	class DirectedTraversals {		
		private int[] edgeTo;
		private boolean[] marked;		
		public DirectedTraversals() {
			edgeTo = new int[DirectedGraph_Old.this.vertices()];
			marked = new boolean[DirectedGraph_Old.this.vertices()];
		}
		public DirectedTraversals(int v) {
			this();
			if(!marked[v]) dfs(v);					
		}
		public DirectedTraversals(Iterable<Integer> sources) {
			this();
			for(int v : sources)
				if(!marked[v]) dfs(v);							
		}		
		public void dfs(int V) {
			marked[V] = true;
			for(int w : DirectedGraph_Old.this.getAdjacencyListFor(V)) {				
				if(!marked[w]) {
					System.out.print(w + "->");
					edgeTo[w] = V;
					dfs(w);
				}
			}
		}		
		public void bfs(int source) {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(source);
			marked[source] = true;			
			while(!queue.isEmpty()) {
				int v = queue.remove();
				for(int w : DirectedGraph_Old.this.getAdjacencyListFor(v)) {
					if(!marked[w]) {
						System.out.print(w + "->");
						edgeTo[w] = v;
						marked[w] = true;
						queue.add(w);
					}
				}
			}
		}		
		public Iterable<Integer> pathTo(int source, int destination) {						
			if(!hasPathTo(destination)) return null;			
			Stack<Integer> path = new Stack<>();			
			for(int x = destination; x != source; x = edgeTo[x])
				path.push(x);
			path.push(source);
			return path;
		}
		public boolean hasPathTo(int V) {
			return marked[V];
		}
	}
	/**
	 * Cycle Detection in a DiGraph.
	 * @author gopi_karmakar
	 *
	 */
	class DirectedCycle {
		private int edgeTo[];
		private boolean marked[];
		private boolean onStack[];
		private Stack<Integer> cycle;		
		public DirectedCycle() {
			edgeTo = new int[DirectedGraph_Old.this.vertices()];
			marked = new boolean[DirectedGraph_Old.this.vertices()];
			onStack = new boolean[DirectedGraph_Old.this.vertices()];
			for(int v = 0; v < DirectedGraph_Old.this.vertices(); v++) {
				if(!marked[v]) dfs(v);
			}
		}
		private void dfs(int v) {
			marked[v] = true;
			onStack[v] = true;
			for(int w : DirectedGraph_Old.this.getAdjacencyListFor(v)) {
				if(hasCycle()) return;
				if(!marked[w]) {
					edgeTo[w] = v;
					dfs(w);
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
	/**
	 * Order traversals of a DiGraph.
	 * @author gopi_karmakar
	 *
	 */
	class DepthFirstOrder {	
		private int[] edgeTo;
		private boolean[] marked;
		private Queue<Integer> pre;
		private Queue<Integer> post;
		private Stack<Integer> reversePost;		
		public DepthFirstOrder() {
			pre = new LinkedList<>();
			post = new LinkedList<>();
			reversePost = new Stack<>();
		}		
		public DepthFirstOrder(DirectedGraph_Old diGraph) {
			this();
			marked = new boolean[diGraph.vertices()];
			for(int v = 0; v < diGraph.vertices(); v++)
				if(!marked[v]) dfs(diGraph, v);
		}		
		private void dfs(DirectedGraph_Old diGraph, int V) {
			marked[V] = true;
			pre.add(V);
			for(int w : diGraph.getAdjacencyListFor(V)) {				
				if(!marked[w]) {
					edgeTo[w] = V;
					dfs(diGraph, w);
				}
			}
			post.add(V);
			reversePost.push(V);
		}		
		public Iterable<Integer> getPreOrder() {
			return pre;
		}		
		public Iterable<Integer> getPostOrder() {
			return post;
		}		
		public Iterable<Integer> getReversePostOrder() {
			return reversePost;
		}
	}
	
	/**
	 * Kosaraju's Algorithm to find strong connections 
	 * between two vertices in a graph.
	 * 
	 * The algorithm computes the reverse of the digraph and does two depth-first searches. 
	 * Each of these three steps takes time proportional to V+􏰁E. The reverse copy of the digraph 
	 * uses space proportional to V􏰁+E.
	 * 
	 * @author gopi_karmakar
	 */
	class StrongConnections {		
		private int count;		
		private int[] id;
		private boolean[] marked;		
		public StrongConnections() {
			id = new int[DirectedGraph_Old.this.vertices()];
			marked = new boolean[DirectedGraph_Old.this.vertices()];
			DepthFirstOrder order = new DepthFirstOrder(DirectedGraph_Old.this.reverse());
			for(int s : order.getReversePostOrder()) {
				if(!marked[s]) {
					dfs(s);
					count += 1;
				}
			}			
		}		
		private void dfs(int v) {
			marked[v] = true;
			id[v] = count;
			for(int w : DirectedGraph_Old.this.getAdjacencyListFor(v)) {
				if(!marked[w]) dfs(w);
			}
		}
		public boolean isStronglyConnected(int v, int w) {
			return (id[v] == id[w]);
		}		
		public int id(int v) 	{ return id[v]; }		
		public int count() 		{ return count; }
	}
	/**
	 * All-Pairs Reachability.
	 * @author gopi_karmakar
	 *
	 */
	class TransitiveClosure {
		private DirectedTraversals[] all;
		public TransitiveClosure() {
			all = new DirectedTraversals[DirectedGraph_Old.this.vertices()];
			for(int v = 0; v < DirectedGraph_Old.this.vertices(); v++) {
				all[v] = new DirectedTraversals(v);
			}
		}
		public boolean isReachable(int v, int w) {
			return all[v].hasPathTo(w);
		}
	}
}