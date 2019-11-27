package com.hyend.data.storage.structures.graphs.directed;

import java.util.Deque;
import java.util.ArrayDeque;
import com.hyend.data.storage.structures.graphs.Vertex;

/**
 * Given a list of academic programs sort the list in precedence order.
 * Such that a student should be qualified in all the programs appeared   
 * before selecting a program to learn from the list.
 * 
 * For e.g: A Student should be qualified in "Introduction to CS" -> "Advanced Programming" -> 
 * "Algorithms" before choosing to learn "Databases"
 * 
 * Variant: Given a directed acyclic graph, print the topological order of this graph.
 * 
 * @author gopi_karmakar
 */
public class TopologicalSort {
	
	public static void main(String[] args) {
		
		String[][] courses = {{"Algorithms", "Theoretical CS", "Databases", "Scientific Computing"},
							  {"Introduction to CS", "Advanced Programming", "Algorithms"},
							  {"Advanced Programming", "Scientific Computing"},
							  {"Scientific Computing", "Computational Biology"},
							  {"Theoretical CS", "Computational Biology", "Artificial Intelligence"},
							  {"Linear Algebra", "Theoretical CS"},
							  {"Calculus", "Linear Algebra"},
							  {"Artificial Intelligence", "Neural Networks", "Robotics", "Machine Learning"},
							  {"Machine Learning", "Neural Networks"}};		
		
		DirectedGraph<String> diGraph = BuildDirectedGraph.buildVertexGraph(courses);
		
		diGraph.printVertexGraph();
						
		Deque<Vertex<String>> stack = new ArrayDeque<>();
		
		for(Vertex<String> v : diGraph.getVertexGraph()) {						
				
			if(!v.visited)
				topologicalSort(diGraph, v, stack);
		}		
		
		System.out.println();
		
		stack.forEach(e -> {
			
			System.out.println(e.v);
		});
	}

	/**
	 * The topological ordering computation is O(V + E) and dominates the computation time.
	 */
	public static void topologicalSort(DirectedGraph<String> diGraph, Vertex<String> v, Deque<Vertex<String>> stack) {

		v.visited = true;
		
		for(Vertex<String> e: v.edges) {					
			
			if(!e.visited) {
				
				topologicalSort(diGraph, e, stack);
			}
		}		
		stack.addFirst(v);
	}	
}