package com.hyend.data.storage.structures.graphs.directed;

import java.util.List;
import java.util.ArrayList;
import com.hyend.data.storage.structures.graphs.Vertex;
import com.hyend.data.storage.structures.graphs.Vertex.Color;

/**
 * https://leetcode.com/problems/sequence-reconstruction/
 * 
 * Can original sequence be uniquely generated?
 * 
 * For details watch:
 * https://blog.csdn.net/littlehaes/article/details/104225987
 * 
 * @author gopi_karmakar
 */
public class SequenceGeneration {

	public static void main(String[] args) {
		
		Integer[] original1 = {1, 2, 3};
		Integer[][] sequence1 = {{1, 2}, {1, 3}};
		Integer[][] sequence2 = {{1, 2}, {1, 3}, {2, 3}};
		
		Integer[] original2 = {4, 1, 5, 3, 6, 2};
		Integer[][] sequence3 = {{5, 2, 6, 3}, {4, 1, 5, 2}};
		
		DirectedGraph<Integer> diGraph = BuildDirectedGraph.buildVertexGraph(sequence3);
		
		diGraph.getVertexGraph().forEach(e -> {
			System.out.println(e);
		});
		
		List<Integer> list = new ArrayList<>();
		for(Vertex<Integer> v : diGraph.getVertexGraph()) {
			
			if(v.color == Color.WHITE)
				dfs(v, list);
		}			
				
		System.out.println(list);			
	}	
	
	private static void dfs(Vertex<Integer> v, List<Integer> list) {
		
		if(v.color == Color.GRAY)
			return;
			
		v.color = Color.GRAY;
		
		for(Vertex<Integer> e : v.edges) {
			
			if(e.color != Color.BLACK) {
				dfs(e, list);
			}
		}
		v.color = Color.BLACK;
		list.add(0, v.v);
	}
}
