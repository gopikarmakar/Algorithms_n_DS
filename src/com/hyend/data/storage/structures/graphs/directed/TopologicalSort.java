package com.hyend.data.storage.structures.graphs.directed;

import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.ArrayList;

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
		
		Stack<Vertex<String>> stack = new Stack<>();
		
		for(Vertex<String> v : diGraph.getVertexGraph()) {						
				
			if(!v.visited)
				topologicalSort(v, stack);
		}		
		
		System.out.println();
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().v);
		}
	}

	/**
	 * The topological ordering computation is O(V + E) and dominates the computation time.
	 */
	public static void topologicalSort(Vertex<String> v, Stack<Vertex<String>> stack) {

		v.visited = true;
		
		for(Vertex<String> e: v.edges) {					
			
			if(!e.visited) {
				
				topologicalSort(e, stack);
			}
		}		
		stack.push(v);
	}	
}