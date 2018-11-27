package com.hyend.data.storage.structures;

import java.util.Iterator;


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
	
	private final int V;	
	private int E;
	
	private MyLinkedList<Integer>[] myAdjList;	
	private MyHashTable<Integer, MyLinkedList<Integer>> myAdjHashSet;
	
	@SuppressWarnings("unchecked")
	public UndirectedGraph(int V) {
		this.V = V;
		this.E = 0;		
		myAdjList = (MyLinkedList<Integer>[]) new MyLinkedList[V];
		myAdjHashSet = new MyHashTable<Integer, MyLinkedList<Integer>>();
		for(int v = 0; v < V; v++) {
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
			for(int v = 0; v < V; v++) {	
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
	
	public void printGraph() {}
}
