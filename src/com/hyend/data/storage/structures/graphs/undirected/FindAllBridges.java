package com.hyend.data.storage.structures.graphs.undirected;

import java.util.Set;
import java.util.LinkedHashSet;

import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * Find all the bridges in a connected undirected graph.
 * An edge in an undirected connected graph is called a bridge 
 * if removing it disconnects the whole graph.
 * 
 * For e.g: In the below graph C->D, D->E and F->H are the bridges 
 * because removing any edge out of those 3 edges will disconnects 
 * the entire connected graph in to two connected graphs.
 *   
 * For e.g: 			A---|				H
 * 						|	|				|
 * 						|	C---|		G---F
 * 						|	|	|		  \	|
 * 						B---|	D-----------E
 * 
 * Variant: Find all the weak links in a connected network such that removing any of those links can 
 * disconnect and isolate the entire single connected network in to two connected networks. 
 * 
 * @author gopi_karmakar
 */
public class FindAllBridges {

	private static int visitCount = 0;
	
	public static void main(String[] args) {
		
		String[][] data = {{"A", "B"}, {"B", "C"}, {"C", "A"}, {"C", "D"}, {"D", "E"}, {"E", "F"}, {"F", "H"}, {"F", "G"}, {"G", "E"}};
		
		//String[][] data = {{"A", "B"}, {"B", "C"}, {"C", "A"}, {"B", "D"}, {"B", "E"}, {"B", "G"}, {"D", "F"}, {"E", "F"}};
		
		UndirectedGraph<String> uDiGraph = BuildUndirectedGraph.buildVertexGraph(data);
		
		uDiGraph.printVertexGraph();
		
		Set<Vertex<String>> result = new LinkedHashSet<>();
		
		dfs(uDiGraph.getVertexGraph().iterator().next(), result);
		
		System.out.println("\nTotal Bridges Are : " + result.size());		
		
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
		v.lowerTime = visitCount;
		v.discoveryTime = visitCount;		
		
		visitCount += 1;
		
		for(Vertex<String> e : v.edges) {
			
			if(!e.visited) {
				      
				e.parent = v;
   				dfs(e, result);								
				
				if(e.lowerTime > v.discoveryTime) {
				
					Vertex<String> edge = new Vertex<>(v.v);
					edge.edges.add(new Vertex<>(e.v));
					result.add(edge);								
				}				
				v.lowerTime = Math.min(v.lowerTime, e.lowerTime);
			}
			else {
				
				//It's a cycle and if it's not from it's own parent then it's a back edge.
				if(!e.equals(v.parent)) {
					
					v.lowerTime = Math.min(v.lowerTime, e.discoveryTime);
				}
			}		
		}		
	}
}
