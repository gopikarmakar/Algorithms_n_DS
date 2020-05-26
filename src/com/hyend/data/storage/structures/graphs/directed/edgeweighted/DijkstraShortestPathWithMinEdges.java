package com.hyend.data.storage.structures.graphs.directed.edgeweighted;

/**
 * Find the shortest path with least distance between 
 * a source and a destination with least edges.
 * 
 * Kindly see the below link for the Graph data and design:
 * https://www.geeksforgeeks.org/algorithms-gq/graph-shortest-paths-gq/
 * 
 * Time complexity O((|E| + |V|)log|V|).
 * Space Complexity O(E + V)
 * 
 * @author gopi_karmakar
 */
public class DijkstraShortestPathWithMinEdges<V extends Comparable<V>> {
	
	public static void main(String[] args) {				
		
		String[][] data = {{"A", "C", "1"}, {"B", "D", "4"}, {"B", "S", "3"}, 
							{"C", "D", "3"}, {"C", "E", "1"}, {"D", "E", "1"}, 
							{"D", "T", "3"}, {"D", "F", "5"}, {"E", "G", "2"}, 
							{"E", "T", "4"}, {"G", "E", "2"}, {"G", "T", "3"}, 
							{"T", "F", "5"}, {"S", "D", "7"}, {"S", "B", "3"}, 	
							{"S", "A", "4"}};
		
		/*Integer[][] data2 = {{0, 1, 4}, {1, 2, 8}, {2, 3, 7}, {3, 4, 9}, {4, 5, 10}, 
							{2, 5, 4}, {1, 7, 11}, {0, 7, 8}, {2, 8, 2}, {3, 5, 14},
							{5, 6, 2}, {6, 8, 6}, {6, 7, 1}, {7, 8, 7}};*/
		
		DijkstraShortestPathWithMinEdges<String> dijkstra = 
				new DijkstraShortestPathWithMinEdges<>(); 
		
		EdgeWeightedGraph<String> diGraph = dijkstra.createGraph(data);				
		
		dijkstra.computeMST(diGraph, "S", "T");				
	}	
	
	private EdgeWeightedGraph<V> createGraph(V[][] data) {
		
		EdgeWeightedGraph<V> diGraph = new EdgeWeightedGraph<>();
		
		for(V[] v: data) {
			
			diGraph.addDirectedEdge(v[0], v[1], 
					((v[2] instanceof String) ? 
						Integer.parseInt(v[2].toString()) : (Integer)v[2]));
		}		
		diGraph.printGraph();
		
		return diGraph;
	}
	
	private void computeMST(EdgeWeightedGraph<V> diGraph, V source, V end) {			
		
		GraphVertex<V> path  = ShortestPath.shortestPath(
				diGraph.getGraphVertex(source), diGraph.getGraphVertex(end));
							
		System.out.println("\nShortest Path With Minimum Edges:");	
		
		printShortestPath(path);
	}
	
	private static void printShortestPath(GraphVertex<?> v) {
		
		if(v != null) {
			printShortestPath(v.parent);
			System.out.print(v.v + " ");
		}
	}
}
