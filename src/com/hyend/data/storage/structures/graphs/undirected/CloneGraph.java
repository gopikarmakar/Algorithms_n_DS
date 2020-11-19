package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * https://leetcode.com/problems/clone-graph/
 * 				1		2		3		4
 * for e.g: {{2, 4}, {1, 3}, {2, 4}, {1, 3}}
 * 		
 * 		1-------------2
 * 		|			  |
 * 		|			  |
 * 		|			  |
 * 		4-------------3
 * @author gopi_karmakar
 */
public class CloneGraph<V extends Comparable<V>> {

	private Map<Vertex<V>, Vertex<V>> map = new HashMap<>();
	
	public static void main(String[] args) {
		
		int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};				
		
		CloneGraph<Integer> clone = new CloneGraph<>();
		
		Vertex<Integer> v = clone.createSampleGraph(adjList);
		
		clone.dfs(v);
		System.out.println("After DFS Clone : ");
		clone.map.values().forEach(e -> {
			System.out.println(e);
		});
		
		clone.bfs(v);
		System.out.println("After BFS Clone : ");
		clone.map.values().forEach(e -> {
			System.out.println(e);
		});		
	}
	
	private Vertex<V> bfs(Vertex<V> v) {
		
		Vertex<V> clone = new Vertex<>(v.v);
		
		Queue<Vertex<V>> q = new LinkedList<>();
		q.add(v);
		map.put(v, clone);
		
		while(!q.isEmpty()) {
			
			Vertex<V> node = q.poll();
			Vertex<V> vCopy = map.getOrDefault(node, new Vertex<V>(node.v));
			
			for(Vertex<V> e : node.edges) {
				
				Vertex<V> eCopy = map.getOrDefault(e, new Vertex<V>(e.v));
				vCopy.edges.add(eCopy);
				
				if(!map.containsKey(e)) {
					q.add(e);
					map.put(e, eCopy);
				}
			}
		}			
		return clone;
	}
	
	private Vertex<V> dfs(Vertex<V> v) {
		
		if(v == null)
			return null;
		
		Vertex<V> clone = new Vertex<>(v.v);
		map.put(v, clone);
		
		for(Vertex<V> e : v.edges) {
			
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
	
	private Map<Integer, Vertex<Integer>> graph = new HashMap<>();
	
	private Vertex<Integer> createSampleGraph(int[][] adjList) {				
				
		int vertice = 1;     
		for(int[] adj : adjList) {
			
			Vertex<Integer> v = graph.getOrDefault(vertice, new Vertex<Integer>(vertice));									
			for(int i = 0; i < adj.length; ++i) {		
				
				Vertex<Integer> e = graph.getOrDefault(adj[i], new Vertex<Integer>(adj[i]));
				v.edges.add(e);
				e.edges.add(v);
				graph.put(e.v, e);
			}
			//graph.put(v.v, v);
			vertice++;
		}

		Vertex<Integer> v = graph.entrySet().iterator().next().getValue();
		//System.out.println(graph.size());
		System.out.println(graph);		
		return v;
	}
}
