package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;
import java.util.LinkedHashSet;

import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * Find bridges in a connected undirected graph.
 * An edge in an undirected connected graph is a bridge if removing it disconnects the graph.
 * 
 * For e.g: In the below graph C->D, D->E and F->H are the bridges because removing any edge out of 
 * those 3 edges will disconnects the entire graph in to two graphs.
 *   
 * For e.g: 			A---|				H
 * 						|	|				|
 * 						|	C---|		G---F
 * 						|	|	|		  \	|
 * 						B---|	D-----------E
 * 
 * @author gopi_karmakar
 */
public class FindAllBridges {

	private static int visitCount = 0;
	
	public static void main(String[] args) {
		
		String[][] data = {{"A", "B", "C"}, {"C", "B", "D"}, {"D", "E"}, {"E", "F"}, {"F", "G", "H"}, {"G", "E"}};
		
		//String[][] data = {{"A", "B"}, {"B", "C"}, {"C", "A"}, {"B", "D"}, {"B", "E"}, {"B", "G"}, {"D", "F"}, {"E", "F"}};
		
		UndirectedGraph<String> uDiGraph = BuildUndirectedGraph.buildVertexGraph(data);
		
		uDiGraph.printVertexGraph();
		
		Set<Vertex<String>> result = new LinkedHashSet<>();
		
		dfs(uDiGraph.getVertexGraph().iterator().next(), result);
		
		System.out.println("\nBridges Are : " + result.size());		
		
		result.forEach(v -> {
			
			for(Vertex<String> e : v.edges) {
			
				System.out.println(v.v + "  ->  " + e.v);
			}
		});	
	}
	
	/**
	 * Time Complexity is O(V + E) with 
	 * O(V) Space complexity.
	 */
	private static void dfs(Vertex<String> v, Set<Vertex<String>> result) {
		
		v.visited = true;
		v.totalDirectVisits = visitCount;
		v.totalIndirectVisits = visitCount;
		
		visitCount += 1;
		
		for(Vertex<String> e : v.edges) {
			
			if(!e.visited) {
				
				e.parent = v;
				dfs(e, result);
				
				v.totalIndirectVisits = Math.min(v.totalIndirectVisits, e.totalIndirectVisits);
				
				if(e.totalIndirectVisits > v.totalDirectVisits) {
				
					Vertex<String> edge = new Vertex<>(v);
					edge.edges.add(e);
					result.add(edge);								
				}								
			}
			else {
				
				if(!e.equals(v.parent)) {
					v.totalIndirectVisits = Math.min(v.totalDirectVisits, e.totalIndirectVisits);
				}
			}		
		}		
	}
}
