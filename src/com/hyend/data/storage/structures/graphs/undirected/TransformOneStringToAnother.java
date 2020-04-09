package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * Given a dictionary D and two strings s and t, write a program to determine if s produces t. 
 * Assume that all characters are lower case alphabets. If s does produce t, 
 * output the path of a shortest production sequence; otherwise, output "".
 * 
 * For e.g: {bat, cot dog, dag, dot, cat} input {cat, dog}
 * Output: {cat, cot, dot, dog}
 *
 * @author gopi_karmakar
 */
public class TransformOneStringToAnother {

	public static void main(String[] args) {		
		
		Scanner scanner = new Scanner(System.in);			
		
		String line = scanner.nextLine();			
		
		String[] input = scanner.nextLine().split(" ");
		
		Map<String, Set<String>> uGraph = buildGraph(line.split(" "));
		printGraph(uGraph);
		
		Set<String> visited = new LinkedHashSet<>();
		
		System.out.println(dfs(uGraph, visited, input[0], input[1]));
		
		System.out.println(visited);
		
		scanner.close();
	}
	
	/**
	 * The max time complexity will be O(n ^ 2) to create a graph of neighbor strings.	 
	 * Space complexity will be O(n) where n is the length of dictionary. 
	 */
	private static Map<String, Set<String>> buildGraph(String...words) {
							
		Map<String, Set<String>> uGraph = new HashMap<>();
		
		for(int i = 0; i < words.length; ++i) {
			
			for(int j = i+1; j < words.length; ++j) {
			
				if(isNeighbor(words[i], words[j])) {
					
					addEdge(uGraph, words[i], words[j]);
					addEdge(uGraph, words[j], words[i]);
				}								
			}
		}		
		return uGraph;		
	}
	
	private static void addEdge(Map<String, Set<String>> graph, String v, String e) {
		
		Set<String> edges = graph.getOrDefault(v, new HashSet<String>());
		edges.add(e);
		graph.put(v, edges);
	}
	
	private static boolean dfs(Map<String, Set<String>> uGraph, Set<String> visited, String source, String dest) {
		
		if(source.equals(dest)) {
			visited.add(dest);
			return true;
		}
		
		if(visited.contains(source)) return false;
		
		/*if(!visited.isEmpty()) {
			
			String last = visited.stream().skip(visited.size()-1).findFirst().get();
			if(!isNeighbor(source, last)) {
				visited.remove(last);
			}
		}*/
		visited.add(source);
		
		for(String e : uGraph.get(source)) {
			if(dfs(uGraph, visited, e, dest))
				return true;
		}
		return false;
	}
	
	private static boolean isNeighbor(String s1, String s2) {
		
		assert s1.length() == s2.length();
		
		int diff = 0;
		for(int i = 0; i < s1.length(); ++i) {
			
			if(s1.charAt(i) != s2.charAt(i)) diff += 1;
			
			if(diff > 1) return false;
		}				
		return true;
	}	
	
	private static void printGraph(Map<String, Set<String>> uGraph) {
		
		System.out.println(uGraph);
	}
}