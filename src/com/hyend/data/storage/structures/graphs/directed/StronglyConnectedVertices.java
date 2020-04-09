package com.hyend.data.storage.structures.graphs.directed;

import java.util.Collection;
import java.util.Map;
import java.util.Stack;
import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * Kosaraju's algorithm to find strongly connected vertices in graph
 * 
 * @author gopi_karmakar
 */
public class StronglyConnectedVertices {

	public static void main(String[] args) {
		
		//Integer[][] data = {{1, 0}, {0, 2}, {2, 1}, {0, 3}, {3, 4}};
		//DirectedGraph<Integer> diGraph = BuildDirectedGraph.buildVertexGraph(data);
		
		Integer[][] data = {{0, 1, 5}, {2, 0, 3}, {3, 2, 5}, {4, 3, 2}, {5, 4},
							{6, 0, 4, 9}, {7, 6, 8}, {8, 7, 9}, {9, 10, 11}, 
							{10, 12}, {11, 4, 12}, {12, 9}};
		
		DirectedGraph<Integer> diGraph = BuildDirectedGraph.buildMappedVertexGraph(data);		
		
		System.out.println("Graph");
		diGraph.printMappedVertexGraph();
		
		Collection<Vertex<Integer>> reversedGraph = diGraph.reverseVertexGraph();
		
		printReverseVertexGraph(reversedGraph);
		
		Stack<Integer> stack = new Stack<>();
		
		for(Vertex<Integer> v : reversedGraph) {
			if(!v.visited)
				dfs(v, stack);
		}		
		
		while(!stack.isEmpty()) {
			
			int e = stack.pop();
			Vertex<Integer> v = diGraph.getMappedVertexGraph().getOrDefault(e, new Vertex<>(e));
			if(!v.visited)
				dfs(v, null);
		}
		
		printConnectedComponent(diGraph.getMappedVertexGraph());					
	}
	
	/**
	 * Runtime complexity - O(V + E)
	 * Space complexity - O(V)
	 */
	private static void dfs(Vertex<Integer> v, Stack<Integer> stack) {
		
		v.visited = true;
		
		for(Vertex<Integer> e : v.edges) {
			
			if(!e.visited) {
								
				dfs(e, stack);				
			}
		}
		if(stack != null)
			stack.push(v.v);
	}
	
	private static void printReverseVertexGraph(Collection<Vertex<Integer>> reversedGraph) {
		
		System.out.println("\nReversed Graph");		
		
		for(Vertex<Integer> v : reversedGraph) {
			
			System.out.print(v.v + "\t->\t");
			
			v.edges.forEach(e -> {
				
				System.out.print(e.v + " ");
			});	
			System.out.println();
		}
	}
	
	private static void printConnectedComponent(Map<Integer, Vertex<Integer>> reversedGraph) {
		
		System.out.println("\nStrongly Connected Components");
		
		for(Vertex<Integer> v : reversedGraph.values()) {
			
			if(v.visited)
				System.out.print(v.v + "\t->\t");
			
			v.edges.forEach(e -> {
				
				if(e.visited)
					System.out.print(e.v + " ");
			});				
			System.out.println();
		}
	}
}
