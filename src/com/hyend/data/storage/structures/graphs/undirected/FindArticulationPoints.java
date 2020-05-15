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

	private static int visitTime = 0;
	
	public static void main(String[] args) {
		
		String[][] data = {{"A", "C", "B"}, {"C", "B", "D"}, {"D", "E"}, {"E", "F"}, {"F", "G", "H"}, {"G", "E"}};
		
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
		//lower time is back for edge
		v.lowerTime = visitTime;
		v.discoveryTime = visitTime;
		
		visitTime += 1;
		
		int childCount = 0;
		boolean isArticulationPoint = false;
		
		for(Vertex<String> e: v.edges) {												
				
			if(!e.visited) {									
				
				e.parent = v;
				childCount += 1;
				dfs(e, result);
				
				if(e.lowerTime >= v.discoveryTime) {
					isArticulationPoint = true;
				}
				else {
					
					v.lowerTime = Math.min(v.lowerTime, e.lowerTime);
				}
			}
			else {
								
				//It's a cycle and if it's not from it's own parent then it's a back edge.				 
				if(!e.equals(v.parent)) {	
					
					v.lowerTime = Math.min(v.lowerTime, e.discoveryTime);
				}
			}			
		}
		
		/**
		 * (v.parent == null && childCount == 2) condition for root vertex because  
		 * because the traversal can start from any vertex.
		 */
		if((v.parent == null && childCount == 2) || v.parent != null && isArticulationPoint)
			result.add(v);
	}
}