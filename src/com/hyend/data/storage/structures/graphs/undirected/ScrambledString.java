package com.hyend.data.storage.structures.graphs.undirected;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * https://leetcode.com/problems/scramble-string/
 * 
 * @author gopi_karmakar
 */
public class ScrambledString {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] input = scanner.nextLine().split(" ");
		
		System.out.println(isScrambledString(input[0], input[1]));
		
		scanner.close();
	}
	
	/**
	 * Time complexity will be quadratic O(n ^ 2)
	 */
	private static boolean isScrambledString(String s1, String s2) {
				
		String left = s1.substring(0, s1.length()/2);
		UndirectedGraph<String> leftGraph = buildGraph(left);
		
		String right = s1.substring(s1.length()/2, s1.length());		
		UndirectedGraph<String> rightGraph = buildGraph(right);						
		
		for(char l : left.toCharArray()) {			
								
			String lt = bfs(leftGraph, "" + l);
			
			for(char r : right.toCharArray()) {
				
				String rt = bfs(rightGraph, "" + r);
				
				System.out.println(lt + rt);
				
				if((lt+rt).equals(s2))
					return true;								
			}			
		}
		return false;
	}
		
	private static String bfs(UndirectedGraph<String> uGraph, String s) {
		
		String path = "";
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new LinkedHashSet<>();
				
		queue.add(s);				
		
		while(!queue.isEmpty()) {
				
			String v = queue.poll();
			visited.add(v);
			path += v;
			
			for(String e : uGraph.getAdjacencySet(v)) {				
				if(!visited.contains(e)) {					
					queue.add(e);					
				}
			}			
		}				
		return path;
	}
	
	private static UndirectedGraph<String> buildGraph(String s) {
		
		List<List<String>> list = new ArrayList<>();
		
		for(int i = 0; i < s.length()-1; ++i) {
			
			List<String> subList = new ArrayList<>();
			subList.add("" + s.charAt(i));
			subList.add("" + s.charAt(i+1));
			list.add(subList);
		}		
		return new BuildUndirectedGraph<String>().buildGraph(list);
	}
}
