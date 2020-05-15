package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Queue;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.LinkedHashSet;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * 
 * The max time complexity will be O(V+E) to create a graph of neighbor strings.
 * Space complexity will be O(V+E) where n is the length of dictionary.
 * 
 * @author gopi_karmakar
 */
public class WordLadder2 {

	public static void main(String[] args) {
		
		//Scanner scanner = new Scanner(System.in);
		//String line = scanner.nextLine();		
		//String[] input = scanner.nextLine().split(" ");
		//String beginWord = input[0];	
		//String endWord = input[1];
		
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String beginWord = "hit";
		String endWord = "cog";			
		
		WordLadder2 wl = new WordLadder2();
		Map<String, Set<String>> uGraph = wl.createGraph(words);
		wl.printGraph(uGraph);
		
		Set<String> visited = new LinkedHashSet<>();
		List<List<String>> paths = new ArrayList<>();		
		
		for(String v : uGraph.get(words[0])) {
			
			List<String> path = new ArrayList<>();
			path.add(words[0]);
			visited.add(words[0]);
			wl.bfs(uGraph, visited, path, v, endWord);
			
			path.add(0, beginWord);
			paths.add(path);
		}
				
		for(List<String> path : paths) {
			System.out.println("\n" + path);
		}
	}
	
	private void bfs(Map<String, Set<String>> uGraph, Set<String> visited, 
			List<String> path, String start, String end) {
		
		if(!uGraph.containsKey(end))
			return;
						
		Queue<String> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			
			String v = q.poll();
			path.add(v);
			visited.add(v);			
			
			for(String e : uGraph.get(v)) {
				
				if(!visited.contains(e)) {					
					q.add(e);
				}
				
				if(e.equals(end)) {		
					path.add(end);
					return;
				}
			}
		}
	}
	
	////////////////////// Helper Methods ////////////////////////
	private Map<String, Set<String>> createGraph(String[] words) {
		
		Map<String, Set<String>> uGraph = new HashMap<>();
		
		for(int i = 0; i < words.length-1; ++i) {
			
			for(int j = i+1; j < words.length; ++j) {
				
				String word1 = words[i];
				String word2 =  words[j];
				if(isNeighbor(word1, word2)) {
					addEdge(uGraph, word1, word2);
					addEdge(uGraph, word2, word1);
				}
			}
		}
		return uGraph;
	}
	
	private void addEdge(Map<String, Set<String>> uGraph, String v, String e) {		
		Set<String> edges = uGraph.getOrDefault(v, new LinkedHashSet<>());
		edges.add(e);
		uGraph.put(v, edges);
	}
	
	private boolean isNeighbor(String word1, String word2) {
		
		int diff = 0;
		for(int i = 0; i < word1.length(); ++i) {
			
			if(word1.charAt(i) != word2.charAt(i))
				diff++;
				
			if(diff > 1)
				return false;
		}
		return true;
	}
	
	private void printGraph(Map<String, Set<String>> uGraph) {
		
		uGraph.entrySet().forEach(e -> {
			
			System.out.print(e.getKey() + " -> ");
			
			e.getValue().forEach(v -> {
				System.out.print(v + " ");
			});		
			System.out.println();
		});
	}
}
