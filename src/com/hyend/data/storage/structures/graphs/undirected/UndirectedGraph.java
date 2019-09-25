package com.hyend.data.storage.structures.graphs.undirected;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.hyend.data.storage.structures.hashtable.MyHashTable;
import com.hyend.data.storage.structures.linkedlists.singly.MyLinkedList;


/**
 * An undirected 2D graph which keeps track of it's all adjacent node/vertex.
 * The implementation has been done by two ways.
 * 1) An array of Linked List by taking vertices as an index. In this case vertices
 *    should be integer only. Every vertex makes a linked list of it's adjacent vertices.
 * 2) A hash symbol table, for which a vertex not mandatorily need to be an integer only.
 *    Every vertex key holds a linked list of it's adjacent vertices as value for the key.
 * 
 * @author gopi_karmakar
 *
 */
public class UndirectedGraph {
	
	public static final int ADJACENCY_LIST = 1;
	public static final int ADJACENCY_HASH_SET = 2;
	
	private int E;
	private final int V;
	private int count = 0;
	
	private int[] edgeTo;
	private boolean[] marked;
	
	private MyLinkedList<Integer>[] myAdjList;	
	private MyHashTable<Integer, MyLinkedList<Integer>> myAdjHashSet;
	
	@SuppressWarnings("unchecked")
	public UndirectedGraph(int V) {
		this.V = V;
		this.E = 0;
		edgeTo = new int[this.V];
		marked = new boolean[this.V];
		myAdjList = (MyLinkedList<Integer>[]) new MyLinkedList[this.V];
		myAdjHashSet = new MyHashTable<Integer, MyLinkedList<Integer>>();
		for(int v = 0; v < this.V; v++) {
			myAdjList[v] = new MyLinkedList<Integer>();
		}		
	}
	
	public UndirectedGraph(int[][] graph, int type) {
		this(graph.length);		
		for(int v = 0; v < graph.length; v++) {
			for(int e = 1; e < graph[v].length; e++) {
				System.out.print(graph[v][0] + ", " + graph[v][e]);
				addEdge(graph[v][0], graph[v][e], type);				
				System.out.print("\n");
			}
		}
	}
	
	/**
	 * For an undirected graph possibly the edges will be 2(V) 
	 * @return
	 */
	public int getTotalEdges(int type) {
		if(type == ADJACENCY_LIST) {
			System.out.print("\n");
			for(int v = 0; v < V-1; v++) {
				System.out.print(v + " = ");
				Iterator<Integer> itr = getAdjList(v).iterator();				 
				while(itr.hasNext()) {
					int edge = itr.next(); 
					System.out.print(edge + ", ");
					this.E++;
					/*if((myAdjList[v].contains(edge)) && (myAdjList[edge].contains(v))) {
						this.E++;
					}*/
				}
				System.out.print("\n");
			}
		}
		else if(type == ADJACENCY_HASH_SET) {
			Iterator<Integer> itrV = getVerticesSet();
			Iterator<MyLinkedList<Integer>> itrE = getEdgesSet();			
			while(itrV.hasNext()) {
				int v = itrV.next();
				System.out.print(v + " = ");
				if(itrE.hasNext()) {
					MyLinkedList<Integer> edgesList = itrE.next();
					Iterator<Integer> edges = edgesList.iterator();
					while(edges.hasNext()) {
						int edge = edges.next();
						this.E++;
						System.out.print(edge + ", ");
					}
					System.out.print("\n");		
				}				
			}				
		}
		return this.E;
	}
	
	public int getTotalVertices() {
		return this.V;
	}
	
	/**
	 * Adding a vertex and it's adjacent vertex to
	 * each other's adjacency list.
	 * 
	 * @param v
	 * @param adjV
	 */
	private void addEdge(int v, int adjV, int type) {
		myAdjList[v].add(adjV);
		myAdjHashSet.put(v, myAdjList[v]);
		myAdjList[adjV].add(v);
		myAdjHashSet.put(adjV, myAdjList[adjV]);
	}
	
	public Iterable<Integer> getAdjList(int v) {
		return myAdjList[v];
	}
	
	public Iterator<Integer> getVerticesSet() {
		return myAdjHashSet.getKeySet();
	}
	
	public Iterator<MyLinkedList<Integer>> getEdgesSet() {
		return myAdjHashSet.getValueSet();
	}
	
	/**
	 * DFS marks all the vertices connected to a given source in time 
	 * proportional to the sum of their degrees
	 * @param source
	 */
	public void dfsPath(int source) {
		count+=1;
		marked[source] = true;
		//System.out.print("" + v + "->");
		for(int e : getAdjList(source)) {
			if(!marked[e]) {
				//System.out.print("->" + e);
				edgeTo[e] = source;
				dfsPath(e);
			}
		}
	}
	
	/**
	 * Breadth first search short path.
	 * @param source
	 */
	public void bfsPath(int source) {
		
		Queue<Integer> queue = new LinkedList<Integer>();	
		marked[source] = true;		
		queue.add(source);
		
		while(!queue.isEmpty()) {
						
			int v = queue.remove();
			//System.out.println("\nDQ = " + v + " Size in DQ = " + queue.size);
			for(int e : getAdjList(v)) {
				if(!marked(e)) {
					edgeTo[e] = v;
					marked[e] = true;
					queue.add(e);
					//System.out.println("\nNQ = " + e + " Size in NQ = " + queue.size);
				}
			}
		}
	}
	
	public Iterable<Integer> pathTo(int source, int v) {
		
		if(!hasPathTo(v)) return null;
		
		Stack<Integer> paths = new Stack<>();
		for(int x = v; x != source; x = edgeTo[x])
			paths.push(x);
		paths.push(source);
		return paths;				
	}
	
	public int getDFSCount() {
		return count;
	}
	
	public boolean marked(int v) {
		return marked[v];
	}
	
	public boolean hasPathTo(int v) {
		return marked(v);
	}
	
	public void printGraph() {}
	
	class Cycle {
		
		private boolean[] marked;
		private boolean hasCycle;
		
		public Cycle(UndirectedGraph unDiGraph) {
			marked = new boolean[unDiGraph.getTotalVertices()];
			for(int s = 0; s < unDiGraph.getTotalVertices(); s++) {
				if(!marked(s))
					dfs(unDiGraph, s, s);
			}
		}
		
		public void dfs(UndirectedGraph unDiGraph, int v, int u) {
			marked[v] = true;
			for(int w : unDiGraph.getAdjList(v)) {
				if(!marked(w)) dfs(unDiGraph, w, v);
				else if(w != u) hasCycle = true;
			}
		}
		
		public boolean hasCycle() {
			return hasCycle;
		}
	}
}
