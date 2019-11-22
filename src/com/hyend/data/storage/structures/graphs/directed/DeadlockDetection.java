package com.hyend.data.storage.structures.graphs.directed;

import java.util.Set;

import com.hyend.data.storage.structures.graphs.Vertex;
import com.hyend.data.storage.structures.graphs.Vertex.Color;

/**
 * High performance database systems use multiple processes and resource locking.
 * These systems may not provide mechanisms to avoid or prevent deadlock.
 * A situation in which two or more competing actions are each waiting for
 * the other to finish, which precludes all these actions from progressing.
 * Such systems must support a mechanism to detect deadlocks.
 * 
 * Given a state of processes like P1->P2 implies P1 is waiting for P2 to finish. 
 * Detect if there any deadlock situation occurred in the given processes.
 * 
 * Variant: Detect if there any two or more processes trying to access the same resource at the same time.
 * 
 * Variant: Detect if there any process is waiting on another process to finish and release the acquired lock. 
 * 
 * Variant: Detect if there a process is trying to access a resource which is already in use by another process.
 * 
 * Watch: https://www.youtube.com/watch?v=2St4eKZ_VVQ for detailed explanation.
 * 
 * @author gopi_karmakar
 */
public class DeadlockDetection {

	public static void main(String[] args) {
		
		/**
		 * Resource allocation graph: 
		 * {{"R1", "P1"}, {"P1", "R2"}, {"R2", "P2"}{, "P2", "R3", "R4", "R5"},
		 * {"R3", "P5"}, {"R4", "P3"}, {"P3", "R5"}, {"R5", "P4"}, {"P4", "R1"}}
		 * 
		 * In resource allocation graph above P1 got R1 and waiting for R2 but P2 got R2.
		 * Which means P1 is waiting for P2 to release R2. Which is finally 
		 * depicted in wait for graph .
		 */		
		
		/*DirectedGraph<String> diGraph = new BuildDirectedGraph<String>().buildWithGraphVertex(
				BuildDirectedGraph.convertInToList(createSampleData()));*/
		
		DirectedGraph<String> diGraph = BuildDirectedGraph.buildWithGraphVertex(createSampleData());				
		
		Set<Vertex<String>> graph = diGraph.getAllGraphVertexes();		
		
		for(Vertex<String> v: graph)
			System.out.println(v);	
		
		System.out.println("\nIs There Any Deadlock = " + detectDeadlock(graph));
	}
	
	/**
	 * If a graph has a cycle then it's deadlocked
	 * The time complexity of DFS is O(V + E): we iterate over all vertices, 
	 * and spend a constant amount of time per edge.
	 * 
	 * The space complexity is O(V), which is the maximum stack depth—if we go deeper than |V| calls, 
	 * some vertex must repeat, implying a cycle in the graph, which leads to early termination.	 
	 */
	private static boolean detectDeadlock(Set<Vertex<String>> set) {
		
		for(Vertex<String> v : set) {
			
			if(v.color == Color.WHITE && hasCycle(v))
				return true;						
		}
		return false;
	}
	
	private static boolean hasCycle(Vertex<String> v) {
		
		if(v.color == Vertex.Color.GRAY)
			return true;
							
		v.color = Vertex.Color.GRAY;
		for(Vertex<String> e : v.edges) {
			
			if(e.color != Vertex.Color.BLACK)
				if(hasCycle(e))
					return true;
		}
		
		v.color = Vertex.Color.BLACK;
		return false;
	}

	/**
	 * Every process will be a Graph Vertex with default white color. 	 
	 */
	public static class GraphVertex<V> extends Vertex<V> {
				
		public GraphVertex(V v) {
			super(v);
			this.color = Color.WHITE;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static Vertex<String>[][] createSampleData() {
		
		Vertex<String> p1 = new GraphVertex<>("P1");
		Vertex<String> p2 = new GraphVertex<>("P2");
		Vertex<String> p3 = new GraphVertex<>("P3");
		Vertex<String> p4 = new GraphVertex<>("P4");
		Vertex<String> p5 = new GraphVertex<>("P5");	
		
		@SuppressWarnings("rawtypes")
		Vertex[][] waitForGraph = {{p1, p2}, {p2, p3, p4, p5}, {p4, p1}};				
		
		// Or we can do below thing too!
		/*DirectedGraph<String> diGraph = new DirectedGraph<>();
		diGraph.addEdge(p1, p2);
		diGraph.addEdge(p2, p3);
		diGraph.addEdge(p2, p4);
		diGraph.addEdge(p2, p5);
		diGraph.addEdge(p4, p1);		
		Set<Vertex<String>> set = diGraph.getAllGraphVertexes();*/
				
		return waitForGraph;
	}
}
