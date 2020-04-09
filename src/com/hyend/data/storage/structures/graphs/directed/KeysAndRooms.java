package com.hyend.data.storage.structures.graphs.directed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 
 * https://leetcode.com/problems/keys-and-rooms/
 * 
 * @author gopi_karmakar
 */
public class KeysAndRooms {

	public static void main(String[] args) {
		
		Integer[][] Rooms = {{1}, {2}, {3}, {}};
		
		Integer[][] Rooms2 = {{1, 3}, {3, 0, 1}, {2}, {0}};
		
		Integer[][] Rooms3 = {{2, 3}, {}, {2}, {1, 3, 1}};
		
		List<List<Integer>> rooms = new ArrayList<>();
		
		for(Integer[] room : Rooms2) {
			
			rooms.add(Arrays.asList(room));
		}	
		
		System.out.println(isAllRoomsVisited(rooms));
	}
	
	private static boolean isAllRoomsVisited(List<List<Integer>> rooms) {
		
		List<Integer>[] graph = buildGraph(rooms);
		System.out.println(graph.length);
		
		for(int i = 0; i < graph.length; ++i) {
			
			System.out.println(i + " -> " + graph[i]);
		}
		
		boolean[] isVisited = new boolean[graph.length];
		Queue<Integer> queue = new LinkedList<>();				
		
		if(isVisited.length > 0)
			isVisited[0] = true;
		
		for(Integer e : graph[0]) {
			
			if(!isVisited[e])
				queue.add(e);				
									
			while(!queue.isEmpty()) {
				
				Integer key = queue.poll();
								
				isVisited[key] = true;				
				
				for(Integer v : graph[key]) {
								
					System.out.println(v);
					if(!isVisited[v]) {
						isVisited[v] = true;
						queue.add(v);
					}
				}								
			}
		}
		
		for(boolean visited : isVisited) {
		
			if(!visited)
				return false;
		}		
		return true;
	}
	
	private static List<Integer>[] buildGraph(List<List<Integer>> rooms) {
		
		List<Integer>[] graph = new ArrayList[rooms.size()];
		
		for(int i = 0; i < graph.length; ++i) {
			
			graph[i] = new ArrayList<>();
		}
		
		int i = 0;
		for(List<Integer> room : rooms) {
								
			if(room.size() == 0)
				graph[i].add(i);
			else
				graph[i].addAll(room);
						
			i+=1;
		}
		return graph;
	}
}
