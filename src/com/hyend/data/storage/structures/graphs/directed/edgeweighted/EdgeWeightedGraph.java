package com.hyend.data.storage.structures.graphs.directed.edgeweighted;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Edge Weighted Di and UnDi Graph Implementation.
 * 
 * @author gopi_karmakar
 */
public class EdgeWeightedGraph<V extends Comparable<V>> {
	
	private Set<VertexWithDistance<V>> graph = null;
	
	public EdgeWeightedGraph() {
		
		graph = new LinkedHashSet<>();
	}
	
	public void addDirectedEdge(V v, V e, Integer weight) {
		
		convertToGraphVertex(v, e);
		
		VertexWithDistance<V> v1 = new VertexWithDistance<>(getGraphVertex(v));
		VertexWithDistance<V> v2 = new VertexWithDistance<>(getGraphVertex(e), weight);
				
		v1.vertex.edges.add(v2);
		
		graph.add(v1);
	}
	
	public void addUnDirectedEdge(V v, V e, Integer weight) {
		
		convertToGraphVertex(v, e);
		
		VertexWithDistance<V> v1 = new VertexWithDistance<>(getGraphVertex(v));
		VertexWithDistance<V> v2 = new VertexWithDistance<>(getGraphVertex(e), weight);
				
		v1.vertex.edges.add(v2);
		v2.vertex.edges.add(v1);
		
		graph.add(v1);
		graph.add(v2);
	}
	
	public Set<VertexWithDistance<V>> getGraph() {
		return graph;
	}
	
	public void printGraph() {
		
		for(VertexWithDistance<V> v : graph)
			System.out.println(v);
	}
	
	
	////////////////////////////// Helper Methods //////////////////////////////////////
	
	private Map<V, GraphVertex<V>> map = new HashMap<>();
	
	private void convertToGraphVertex(V v, V e) {

		map.putIfAbsent(v, new GraphVertex<V>(v));
		map.putIfAbsent(e, new GraphVertex<V>(e));		
	}
	
	public GraphVertex<V> getGraphVertex(V key) {
		return map.get(key);
	}
}