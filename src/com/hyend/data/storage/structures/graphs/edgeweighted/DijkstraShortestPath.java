package com.hyend.data.storage.structures.graphs.edgeweighted;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import com.hyend.data.storage.structures.graphs.Vertex;

import java.util.SortedSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Find Shortest Path Between a Source and a Destination 
 * with fewer edges contains least distance. 
 * 
 * @author gopi_karmakar
 */
public class DijkstraShortestPath {
	
	public static void main(String[] args) {

		int[][] data = {{0, 1, 4}, {1, 2, 8}, {2, 3, 7}, {3, 4, 9}, {4, 5, 10}, 
						{2, 5, 4}, {1, 7, 11}, {0, 7, 8}, {2, 8, 2}, {3, 5, 14},
						{5, 6, 2}, {6, 8, 6}, {6, 7, 1}, {7, 8, 7}};
		
		int[][] data2 = {{0, 2, 1}, {1, 3, 4}, {1, 18, 3}, {2, 3, 3}, {2, 4, 1}, 
						 {3, 4, 1}, {3, 5, 5}, {3, 19, 3}, {4, 6, 2}, {4, 19, 4},
						 {6, 4, 2}, {6, 19, 3}, {18, 1, 3}, {18, 3, 7}, {19, 5, 5}};
		
		createGraphVertex(data2);
		
		Set<VertexWithDistance<String>> graph = createGraph(data2);
		
		printGraph(graph);
		
		dijkstraShortestPath(getGraphVertex(18), getGraphVertex(19));
	}
	
	private static void dijkstraShortestPath(GraphVertex<String> s, GraphVertex<String> t) {
		
		s.distanceWithFewestEdges = new DistanceWithFewestEdges(0, 0);
		SortedSet<GraphVertex<String>> bst = new TreeSet<>();
		bst.add(s);
		
		while(!bst.isEmpty()) {
			
			GraphVertex<String> v = bst.first();
			if(v.equals(t))
				break;
			
			bst.remove(bst.first());
			
			for(VertexWithDistance<String> e: v.edges) {
				
				int eDistance = v.distanceWithFewestEdges.distance + e.distance;
				int eNumEdges = v.distanceWithFewestEdges.minNumEdges + 1;
				
				if(e.vertex.distanceWithFewestEdges.distance > eDistance ||
					(e.vertex.distanceWithFewestEdges.distance == eDistance && 
					e.vertex.distanceWithFewestEdges.minNumEdges > eNumEdges)) {
					
					bst.remove(e.vertex);
					e.vertex.predecessor = v;
					e.vertex.distanceWithFewestEdges = new DistanceWithFewestEdges(eDistance, eNumEdges);
					bst.add(e.vertex);
				}
			}
		}
		outputShortestPath(t);
	}
	
	private static void outputShortestPath(GraphVertex<String> v) {
		
		if(v != null) {
			outputShortestPath(v.predecessor);
			System.out.println(v.v + " ");
		}
	}
	
	private static class VertexWithDistance<V> {
		int distance;
		GraphVertex<String> vertex;		
		
		public VertexWithDistance(GraphVertex<String> vertex) {
			this(vertex, 0);
		}
		
		public VertexWithDistance(GraphVertex<String> vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(obj == null || !(obj instanceof VertexWithDistance))
				return false;
			
			if(this == obj)
				return true;
			
			@SuppressWarnings("unchecked")
			VertexWithDistance<V> that = (VertexWithDistance<V>) obj;
			return (this.vertex.v.equals(that.vertex.v));					
		}
		
		@Override
		public int hashCode() {			
			return Objects.hash(this.vertex.v);
		}
		
		@Override
		public String toString() {
			String msg = "v = " + this.vertex.v + " d = " + this.distance + "\t->\t";
			for(VertexWithDistance<String> e: this.vertex.edges) {
				
				String edgeMsg = " v = " + e.vertex.v + ", d = " + e.distance;
				msg += edgeMsg;
			} 
			return msg;
		}
	}
	
	private static class DistanceWithFewestEdges {
		int distance;
		int minNumEdges;
		
		public DistanceWithFewestEdges(int distance, int minNumEdges) {
			this.distance = distance;
			this.minNumEdges = minNumEdges;
		}
	}
	
	private static class GraphVertex<V extends Comparable<V>> extends Vertex<V> implements Comparable<GraphVertex<V>> {
		
		public V v;				
		
		// The predecessor in the shortest path.
		public GraphVertex<V> predecessor = null;
		
		public List<VertexWithDistance<V>> edges = null;
		
		public DistanceWithFewestEdges distanceWithFewestEdges = 
				new DistanceWithFewestEdges(Integer.MAX_VALUE, 0);
		
		public GraphVertex(V v) {
			super(v);
			this.v = v;			
			edges = new ArrayList<>();
		}				
		
		@Override
		public int compareTo(GraphVertex<V> vertex) {
						
			if(distanceWithFewestEdges.distance != vertex.distanceWithFewestEdges.distance) {
				
				return Integer.compare(distanceWithFewestEdges.distance, vertex.distanceWithFewestEdges.distance);
			}
			
			if(distanceWithFewestEdges.minNumEdges != vertex.distanceWithFewestEdges.minNumEdges) {
				
				return Integer.compare(distanceWithFewestEdges.minNumEdges, vertex.distanceWithFewestEdges.minNumEdges);
			}
			
			return v.compareTo(v);
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(obj == null || !(obj instanceof GraphVertex))
				return false;
			
			if(this == obj)
				return true;
			
			@SuppressWarnings("unchecked")
			GraphVertex<V> that = (GraphVertex<V>) obj;
			return (this.v.equals(that.v) &&
					this.distanceWithFewestEdges.distance == that.distanceWithFewestEdges.distance && 
					this.distanceWithFewestEdges.minNumEdges == that.distanceWithFewestEdges.minNumEdges);					
		}
		
		@Override
		public int hashCode() {			
			return Objects.hash(this.distanceWithFewestEdges.distance, this.distanceWithFewestEdges.minNumEdges);
		}
	}	
	
	
	/////////////////////////////// Graph Creation ///////////////////////////////
	
	private static Set<VertexWithDistance<String>> createGraph(int[][] data) {
				
		Set<VertexWithDistance<String>> list = new LinkedHashSet<>();				
		
		/**
		 * Graph Creation
		 */
		for(int[] col: data) {			
			
			VertexWithDistance<String> v1 = new VertexWithDistance<>(getGraphVertex(col[0]));
			VertexWithDistance<String> v2 = new VertexWithDistance<>(getGraphVertex(col[1]), col[2]);
			
			v1.vertex.edges.add(v2);			
			list.add(v1);						
		}		
		return list;
	}
	
	private static Map<Integer, GraphVertex<String>> map = new HashMap<>();
	private static void createGraphVertex(int[][] data) {

		for(int[] col: data) {
						
			for(int e = 0; e < col.length-1; ++e) {
			
				String v = col[e] >= 0 && col[e] <= 26 ? String.valueOf((char)(col[e] + 65)) : null; 
				
				GraphVertex<String> gv = map.getOrDefault(col[e], new GraphVertex<String>(v));
				map.put(col[e], gv);
			}
		}
	}
	
	private static GraphVertex<String> getGraphVertex(int v) {
		
		return map.get(v);
	}
	
	private static void printGraph(Set<VertexWithDistance<String>> graph) {
		
		for(VertexWithDistance<String> v : graph)
			System.out.println(v);
	}
}
