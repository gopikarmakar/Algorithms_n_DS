package com.hyend.data.storage.structures.graphs.undirected;

import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Works for 3 length strings "abc"
 * a	->	[b, c]
 * b	->	[a, c]
 * c	->	[a, b]
 * 
 * TODO: Still need to fix for >3 length strings
 * @author gopi_karmakar
 */
public class Permutations {

	public static void main(String[] args) {
		
		UndirectedGraph<String> uGraph = buildGraph("abc");
		uGraph.printGraph();
		permutation(uGraph);		
	}
	
	private static void permutation(UndirectedGraph<String> uGraph) {
		
		List<String> perms = new ArrayList<>();
		
		uGraph.getAllVertices().forEach(v -> {
					
			for(String e : uGraph.getAdjacencySet(v)) {
				perms.add(bfs(uGraph, v, e));
			}
		});
		for(String x : perms)
			System.out.println(x);
	}
	
	private static String bfs(UndirectedGraph<String> uGraph, String v, String V) {
		
		Set<String> visisted = new LinkedHashSet<>();
		
		visisted.add(v);
		visisted.add(V);
			
		for(String e : uGraph.getAdjacencySet(V)) {
			
			if(!visisted.contains(e)) {
				visisted.add(e);
			}				
		}
		return visisted.toString();
	}
	
	private static UndirectedGraph<String> buildGraph(String s) {
		
		List<List<String>> list = new ArrayList<>();
		
		for(int i = 0; i < s.length()-1; ++i) {
			
			List<String> subList = new ArrayList<>();
			subList.add("" + s.charAt(i));
			
			for(int j = i+1; j < s.length(); ++j) {												
				subList.add("" + s.charAt(j));			
			}
						
			list.add(subList);
		}		
		return new BuildUndirectedGraph<String>().buildGraph(list);
	}
}
