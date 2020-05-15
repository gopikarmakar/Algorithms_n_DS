package com.hyend.data.storage.structures.graphs.directed;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * Kosaraju's algorithm to find strongly connected vertices in graph
 * 
 * For explanation watch : https://www.youtube.com/watch?v=RpgcYiky7uw
 * 
 * @author gopi_karmakar
 */
public class StronglyConnectedVertices {

	public static void main(String[] args) {			
		
		/*Integer[][] data = {{0, 1}, {0, 5}, {2, 0}, {2, 3}, {3, 2}, {3, 5}, {4, 2},
							{4, 3}, {5, 4}, {6, 0}, {6, 4}, {6, 9}, {7, 6}, {7, 8}, 
							{8, 7}, {8, 9}, {9, 10}, {9, 11}, {10, 12}, {11, 4}, 
							{11, 12}, {12, 9}};*/
		
		String[][] data = {{"A", "B"}, {"B", "C"}, {"B", "D"}, {"C", "A"},
						   {"D", "E"}, {"E", "F"}, {"F", "D"}, {"G", "F"},
		   				   {"G", "H"}, {"H", "I"}, {"I", "J"}, {"J", "G"},
		   				   {"J", "K"}};
		
		StronglyConnectedVertices scv = new StronglyConnectedVertices();		
		
		DirectedGraph<String> diGraph = BuildDirectedGraph.buildMappedVertexGraph(data);
		
		System.out.println("Graph");
		diGraph.printMappedVertexGraph(); 
		
		diGraph = BuildDirectedGraph.reverseMappedVertexGraph(diGraph);
		
		System.out.println("Reverse Graph");
		diGraph.printReverseMappedVertexGraph();
		
		Stack<Vertex<String>> stack = new Stack<>();				
		 
		for(Vertex<String> v : diGraph.getMappedVertexGraph().values()) {
			if(!v.visited) {
				scv.dfs(v, stack);
			}
		}
		
		List<List<Vertex<String>>> cmps = new ArrayList<>();
		
		while(!stack.isEmpty()) {
			
			Vertex<String> e = stack.pop();
			Vertex<String> v = diGraph.getReversedMappedVertexGraph().get(e.v);
			
			if(!v.visited) {
				List<Vertex<String>> list = new ArrayList<>();
				scv.dfs(v, list);
				cmps.add(list);
			}
		}
		
		System.out.println("\nStrongly Connected Components Are : " + cmps.size());
		
		for(List<Vertex<String>> cmp : cmps) {
			
			for(Vertex<String> e : cmp) {
				System.out.print(e.v + " ");
			}
			System.out.println();
		}		
	}
	
	/**
	 * Runtime complexity - O(V + E)
	 * Space complexity - O(V)
	 */
	private void dfs(Vertex<String> v, Stack<Vertex<String>> stack) {
		
		if(v == null) return;
		
		v.visited = true;		
		for(Vertex<String> e : v.edges) {
			
			if(!e.visited) {								
				dfs(e, stack);				
			}
		}
		if(stack != null) {
			stack.push(new Vertex<String>(v.v));
		}
	}
	
	private void dfs(Vertex<String> v, List<Vertex<String>> list) {
		
		if(v == null) return;
		
		v.visited = true;		
		for(Vertex<String> e : v.edges) {
			
			if(!e.visited) {								
				dfs(e, list);				
			}
		}
		list.add(v);
	}
}
