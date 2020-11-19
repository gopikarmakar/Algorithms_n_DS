package com.hyend.data.storage.structures.graphs.directed;

import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.HashMap;
import java.util.LinkedHashSet;

import com.hyend.data.storage.structures.graphs.Vertex;
import com.hyend.data.storage.structures.graphs.Vertex.Color;

/**
 * Microsoft + Google Interview Question
 * https://leetcode.com/problems/alien-dictionary/
 * 
 * For Description Watch: 
 * https://www.youtube.com/watch?v=RPpnRavqb8g
 * https://leetcode.com/discuss/interview-question/248131/microsoft-interview-round-1-alien-dictionary
 * 
 * @author gopi_karmakar
 */
public class AlienDictionary {

	public static void main(String[] args) {
		
		String[] dict1 = {"Z", "X", "Z"};
		String[] dict2 = {"wrt", "wrf", "er", "ett", "rftt"};
		
		AlienDictionary aDict = new AlienDictionary();
		Set<Vertex<Character>> graph = aDict.createGraph(dict2);
		
		Stack<Vertex<Character>> s = new Stack<>();
		
		for(Vertex<Character> v : graph) {			
			if(v.color == Color.WHITE && aDict.hasCycle(v, s))
				System.out.println("Not Possible");
		}		
		System.out.println();
		while(!s.isEmpty()) {
			System.out.println(s.pop().v);
		}
	}
	
	private boolean hasCycle(Vertex<Character> v, Stack<Vertex<Character>> s) {
		
		if(v.color == Color.GRAY)
			return true;
						
		v.color = Color.GRAY;
		
		for(Vertex<Character> e : v.edges) {
			
			if(e.color != Color.BLACK) {
				if(hasCycle(e, s))
					return true;
			}						
		}
		v.color = Color.BLACK;
		s.push(v);
		return false;
	}	
	
	/////////////////////// Helper Methods //////////////////////
	private Map<Character, Vertex<Character>> map = new HashMap<>();
	
	private Set<Vertex<Character>> createGraph(String[] dict) {
		
		Set<Vertex<Character>> graph = new LinkedHashSet<>();
		for(int i = 1; i < dict.length; ++i) {
			
			String w1 = dict[i-1];
			String w2 = dict[i];
			int len = Math.min(w1.length(), w2.length());
			
			for(int j = 0; j < len; ++j) {
				
				if(w1.charAt(j) != w2.charAt(j)) {
					createPool(w1.charAt(j), w2.charAt(j));
					addEdge(graph, getVertex(w1.charAt(j)), getVertex(w2.charAt(j)));
				}
			}
		}
		graph.forEach(e -> {
			System.out.println(e);
		});
		return graph;
	}
	
	private void addEdge(Set<Vertex<Character>> graph, 
			Vertex<Character> v1, Vertex<Character> v2) {
		
		v1.edges.add(v2);
		graph.add(v1);	
	}

	private void createPool(Character c1, Character c2) {
		
		map.putIfAbsent(c1, new Vertex<Character>(c1));
		map.putIfAbsent(c2, new Vertex<Character>(c2));
	}
	
	private Vertex<Character> getVertex(Character c) {		
		return map.get(c);
	}		
}