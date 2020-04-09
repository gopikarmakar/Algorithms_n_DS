package com.hyend.data.storage.structures.graphs.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {
	
	public static void main(String[] args) {
		
		/*String beginWord = "hit";
		String endWord = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};*/
		String beginWord = "hot";
		String endWord = "dog";
		String[] words = {"hot", "dog", "cog", "pot", "dot"};
		
		List<String> wordList = new ArrayList<>(Arrays.asList(words));
		if(!wordList.contains(beginWord))
			wordList.add(beginWord);
		
		Collections.sort(wordList);
		System.out.println(wordList);
		
		Map<String, Set<String>> uGraph = createGraph(wordList);
		System.out.println(uGraph);
        if(!uGraph.containsKey(endWord)) 
            System.out.println(0);
        
        Set<String> visited = new LinkedHashSet<>();
        dfs(uGraph, visited, beginWord, endWord);
        
        System.out.println(visited);
        System.out.println(visited.size());
	}

	private static boolean dfs(Map<String, Set<String>> uGraph, Set<String> visited, String begin, String end) {
        
        if(begin.equals(end)) {
            visited.add(end);
            return true;
        }
        
        if(visited.contains(begin)) return false;
                    
        visited.add(begin);
        
        Set<String> adjList = uGraph.get(begin);
        if(adjList.contains(end)) {
        	visited.add(end);
        	return true;
        }
        for(String e : adjList) {
            
            if(dfs(uGraph, visited, e, end)) {
                return true;                
            }                
        }
        return false;
    }
    
    private static Map<String, Set<String>> createGraph(List<String> words) {
        
        Map<String, Set<String>> uGraph = new HashMap<>();
        
        for(int i = 0; i < words.size(); ++i) {
            
            for(int j = i+1; j < words.size(); ++j) {
                
                if(isNeighbor(words.get(i), words.get(j))) {
                    
                    addEdge(uGraph, words.get(i), words.get(j));
                    addEdge(uGraph, words.get(j), words.get(i));
                }
            }
        }
        return uGraph;
    }
        
    
    private static void addEdge(Map<String, Set<String>> uGraph, String v, String e) {
        
        Set<String> edges = uGraph.getOrDefault(v, new LinkedHashSet<>());
        edges.add(e);
        uGraph.put(v, edges);
    }
    
    private static boolean isNeighbor(String s1, String s2) {
        
        int diff = 0;
        for(int i = 0; i < s1.length(); ++i) {            
            if(s1.charAt(i) != s2.charAt(i)) {
                diff += 1; 
            }            
            if(diff > 1)
                return false;
        }                 
        return true;
    }
}
