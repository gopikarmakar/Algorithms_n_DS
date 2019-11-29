package com.hyend.data.storage.structures.graphs.directed.edgeweighted;

import java.util.Set;

/**
 * Find the shortest path with least distance between 
 * a source and a destination with least edges.
 * 
 * NOTE: Assuming it's a DAG, So not checking for cyclicity.
 * 
 * Kindly see the below link for the Graph data and design:
 * https://www.geeksforgeeks.org/algorithms-gq/graph-shortest-paths-gq/
 * 
 * Time complexity O((|E| + |V|)log|V|).
 * 
 * @author gopi_karmakar
 */
public class DijkstraShortestPathWithMinEdges<V extends Comparable<V>> {
	
	public static void main(String[] args) {
		
		Integer[][] data = {{0, 1, 4}, {1, 2, 8}, {2, 3, 7}, {3, 4, 9}, {4, 5, 10}, 
							{2, 5, 4}, {1, 7, 11}, {0, 7, 8}, {2, 8, 2}, {3, 5, 14},
							{5, 6, 2}, {6, 8, 6}, {6, 7, 1}, {7, 8, 7}};
		
		String[][] data2 = {{"A", "C", "1"}, {"B", "D", "4"}, {"B", "S", "3"}, 
							{"C", "D", "3"}, {"C", "E", "1"}, {"D", "E", "1"}, 
							{"D", "T", "3"}, {"D", "F", "5"}, {"E", "G", "2"}, 
							{"E", "T", "4"}, {"G", "E", "2"}, {"G", "T", "3"}, 
							{"T", "F", "5"}, {"S", "D", "7"}, {"S", "B", "3"}, 	
							{"S", "A", "4"}};	
				
		EdgeWeightedDiGraph<String> eDiGraph = new EdgeWeightedDiGraph<>();
		
		for(String[] row : data2) {			
			
			eDiGraph.addEdge(row[0], row[1], Integer.valueOf(row[2]));
		}
		
		Set<VertexWithDistance<String>> graph = eDiGraph.getGraph();
		
		eDiGraph.printGraph();
		
		GraphVertex<?> v = ShortestPath.shortestPath(graph, eDiGraph.getGraphVertex("S"), eDiGraph.getGraphVertex("T"));
		
		outputShortestPath(v);
	}	
	
	private static void outputShortestPath(GraphVertex<?> v) {
		
		if(v != null) {
			outputShortestPath(v.parent);
			System.out.println(v.v + " ");
		}
	}
}
