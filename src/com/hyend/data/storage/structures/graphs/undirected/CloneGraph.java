package com.hyend.data.storage.structures.graphs.undirected;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * @author gopi_karmakar
 */
public class CloneGraph {

	private static Map<Vertex<Integer>, Vertex<Integer>> map = new HashMap<>();
	public static void main(String[] args) {
		
		int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};		
		
		Vertex<Integer> v = createSampleGraph(adjList);
		//dfs(v);
		bfs(v);
		System.out.println(map);		
	}
	
	private static Vertex<Integer> bfs(Vertex<Integer> v) {
		
		Vertex<Integer> clone = new Vertex<>(v.v);
		
		Queue<Vertex<Integer>> q = new LinkedList<>();
		q.add(v);
		map.put(v, clone);
		
		while(!q.isEmpty()) {
			
			Vertex<Integer> node = q.poll();
			Vertex<Integer> vCopy = map.getOrDefault(node, new Vertex<Integer>(node.v));
			
			for(Vertex<Integer> e : node.edges) {
				
				Vertex<Integer> eCopy = map.getOrDefault(e, new Vertex<Integer>(e.v));
				vCopy.edges.add(eCopy);
				
				if(!map.containsKey(e)) {
					q.add(e);
					map.put(e, eCopy);
				}
			}
		}			
		return clone;
	}
	
	private static Vertex<Integer> dfs(Vertex<Integer> v) {
		
		if(v == null)
			return null;
		
		Vertex<Integer> clone = new Vertex<>(v.v);
		map.put(v, clone);
		
		for(Vertex<Integer> e : v.edges) {
			
			if(!map.containsKey(e)) {
				clone.edges.add(dfs(e));
			}
			else {
				clone.edges.add(map.get(e));
			}
		}
		return clone;
	}
	
	//////////////////// Helper Methods ///////////////////
	
	private static Map<Integer, Vertex<Integer>> graph = new HashMap<>();
	
	private static Vertex<Integer> createSampleGraph(int[][] adjList) {				
				
		int vertice = 1;     
		for(int[] adj : adjList) {
			
			Vertex<Integer> v = graph.getOrDefault(vertice, new Vertex<Integer>(vertice));						
			for(int i = 0; i < adj.length; ++i) {		
				
				Vertex<Integer> e = graph.getOrDefault(adj[i], new Vertex<Integer>(adj[i]));
				v.edges.add(e);
				e.edges.add(v);
				graph.put(e.v, e);
			}
			graph.put(v.v, v);
			vertice++;
		}

		Vertex<Integer> v = graph.entrySet().iterator().next().getValue();
		System.out.println(graph);
		return v;
	}
}
