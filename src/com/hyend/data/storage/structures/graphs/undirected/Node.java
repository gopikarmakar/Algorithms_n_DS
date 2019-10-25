package com.hyend.data.storage.structures.graphs.undirected;

import java.util.List;
import java.util.Set;

/**
 * A Graph node containing a vertex and list of edges to vertices
 * 
 * @author gopi_karmakar
 */
public class Node<V> {

	V v;
	List<V> e; 
	
	public Node(V v, List<V> e) {
		this.v = v;
		this.e = e;
	}
}
