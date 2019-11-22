package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
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
		buildGraph(line.split(" "));
				
		Set<String> visited = new LinkedHashSet<>();
		
		String[] input = scanner.nextLine().split(" ");
		
		UndirectedGraph<String> uGraph = buildGraph(line.split(" "));
		uGraph.printGraph();
		
		System.out.println(dfs(uGraph, visited, input[0], input[1]));
		
		System.out.println(visited);
		
		scanner.close();
	}
	
	/**
	 * The max time complexity will be O(n ^ 2) to create a graph of neighbor strings.	 
	 * Space complexity will be O(n) where n is the length of dictionary. 
	 */
	private static UndirectedGraph<String> buildGraph(String...words) {
							
		Map<String, Set<String>> map = new HashMap<>();
		
		for(int i = 0; i < words.length; ++i) {
			
			for(int j = i+1; j < words.length; ++j) {
			
				if(isNeighbor(words[i], words[j])) {
					
					Set<String> set = map.getOrDefault(words[i], new LinkedHashSet<String>());
					set.add(words[j]);
					map.put(words[i], set);
				}								
			}
		}		
		return new BuildUndirectedGraph<String>().buildGraph(map);		
	}
	
	private static boolean dfs(UndirectedGraph<String> uGraph, Set<String> visited, String source, String dest) {
		
		if(source.equals(dest)) {
			visited.add(dest);
			return true;
		}
		
		if(visited.contains(source)) return false;
		
		if(!visited.isEmpty()) {
			
			String last = visited.stream().skip(visited.size()-1).findFirst().get();
			if(!isNeighbor(source, last)) {
				visited.remove(last);
			}
		}
		visited.add(source);
		
		for(String e : uGraph.getAdjacencySet(source)) {
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
}