package com.hyend.data.storage.structures.graphs.undirected;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 * 
 * @author gopi_karmakar
 */
public class WordLadder {
	
	public static void main(String[] args) {
		
		String beginWord = "hit";
		String endWord = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		//String beginWord = "hot";
		//String endWord = "dog";
		//String[] words = {"hot", "dog", "cog", "pot", "dot"};		
	
        System.out.println(bfs(Arrays.asList(words), beginWord, endWord));
	}

	private static int bfs(List<String> wordsList, String begin, String end) {
        		
		if(!wordsList.contains(end))
			return 0;
		
		int step = 1;
        Deque<String> dq = new ArrayDeque<>();
        dq.addLast(begin);
        
        Set<String> visited = new HashSet<>();
        
        while(!dq.isEmpty()) {
        
        	int size = dq.size();
        	
        	for(int i = 0; i < size; ++i) {
        		
        		System.out.println(dq);
        		String next = dq.pollFirst();
        		if(next.equals(end)) {
        			return step;
        		}        			
        		
        		for(String word : wordsList) {
        			
        			if(!visited.contains(word) && isNeighbor(next, word)) {
        				dq.addLast(word);
        				visited.add(word);
        			}
        		}
        	}
        	step++;
        }        
        return 0;
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
