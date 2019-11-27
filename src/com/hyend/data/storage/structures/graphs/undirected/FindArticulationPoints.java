package com.hyend.data.storage.structures.graphs.undirected;

import java.util.LinkedHashSet;
import java.util.Set;
import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * Find articulation points in a connected undirected graph.
 * Articulation points are vertices such that removing any one of them disconnects the graph.
 * 
 * For e.g: In the below graph F, E, D C are articulation points because removing any one of 
 * those 4 vertices disconnects the entire graph in to two graphs.
 *   
 * For e.g: 			A---|				H
 * 						|	|				|
 * 						|	C---|		G---F
 * 						|	|	|		  \	|
 * 						B---|	D-----------E
 * 	
 * Variant: Find the nodes which can be a single point failure for an entire connected cloud network.
 * 
 * @author gopi_karmakar
 */
public class FindArticulationPoints {

	private static int visitCount = 0;
	
	public static void main(String[] args) {
		
		String[][] data = {{"A", "B", "C"}, {"C", "B", "D"}, {"D", "E"}, {"E", "F"}, {"F", "G", "H"}, {"G", "E"}};
		
		UndirectedGraph<String> uDiGraph = BuildUndirectedGraph.buildVertexGraph(data);
		
		uDiGraph.printVertexGraph();
		
		Set<Vertex<String>> result = new LinkedHashSet<>();
		
		dfs(uDiGraph.getVertexGraph().iterator().next(), result);
		
		System.out.println("\nArticulation Points Are : ");
		
		result.forEach(e -> {
			
			System.out.println(e.v);
		});		
	}
	
	/**
	 * Time complexity is O(E + V)
	 * Space complexity is O(V)
	 */
	private static void dfs(Vertex<String> v, Set<Vertex<String>> result) {
		
		v.visited = true;
		v.totalDirectVisits = visitCount;
		v.totalIndirectVisits = visitCount;
		
		visitCount += 1;
		
		int childCount = 0;
		boolean isArticulationPoint = false;
		
		for(Vertex<String> e: v.edges) {
			
			if(!e.equals(v.parent)) {												
				
				if(!e.visited) {									
					
					e.parent = v;
					childCount += 1;
					dfs(e, result);
					
					if(v.totalDirectVisits <= e.totalIndirectVisits) {
						isArticulationPoint = true;
					}
					else {
						
						v.totalIndirectVisits = Math.min(v.totalIndirectVisits, e.totalIndirectVisits);
					}
				}
				else {
					
					v.totalIndirectVisits = Math.min(e.totalDirectVisits, v.totalIndirectVisits);
				}
			}
		}
		
		if((v.parent == null && childCount == 2) || v.parent != null && isArticulationPoint)
			result.add(v);
	}
}