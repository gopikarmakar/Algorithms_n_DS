package com.hyend.data.storage.structures.graphs.directed;

import java.util.Set;
import java.util.LinkedHashSet;

/**
 * Given a list of the 2019 cricket world cup matches outcomes between pairs of teams, 
 * with each outcome being a win or loss. 
 * Given teams A and B, is there a sequence of teams starting with team A and 
 * ending with team B such that each team in the sequence has beaten the next team in the sequence.
 * 
 * @author gopi_karmakar
 */
public class ReachablePathBetweenTwoVertices<V> {

	public static void main(String[] args) {
		
		DirectedGraph<String> diGraph = new BuildDirectedGraph<String>().buildGraph(createSampleData());
		
		diGraph.printGraph();
		
		Set<String> visited = new LinkedHashSet<>();
		
		String teamA = "India";
		String teamB = "England";		
		System.out.println(new ReachablePathBetweenTwoVertices<String>().dfs(diGraph, teamA, teamB, visited));
		System.out.println(visited);
	}
	
	/**
	 * The time complexity and space complexity are both O(E), 
	 * where E is the number of outcomes.
	 */
	private boolean dfs(DirectedGraph<V> diGraph, V teamA, V teamB, Set<V> visited) {
	
		if(visited.contains(teamA) || diGraph.getAdjacencyList(teamA).isEmpty())
			return false;
		
		visited.add(teamA);
		
		if(teamA.equals(teamB)) {
			return true;
		}
		
		for(V team : diGraph.getAdjacencyList(teamA)) {
			
			if(dfs(diGraph, team, teamB, visited))
				return true;
		}		
		return false;
	}
	
	/**
	 * Cricket World Cup 2019 matches outcomes,
	 * Such that, first team defeated second team. 
	 */
	private static String[][] createSampleData() {
		
		String[][] cwcResult = {{"England", "South Africa"}, {"West Indies", "Pakistan"}, {"New Zealand", "Sri Lanka"},
							    {"Australia", "Afghanistan"}, {"Bangladesh", "South Africa"}, {"Pakistan", "England"},
							    {"Sri Lanka", "Afghanistan"}, {"India", "South Africa"}, {"New Zealand", "Bangladesh"},
							    {"Australia", "West Indies"}, {"England", "Bangladesh"}, {"India", "Australia"}, 
							    {"Australia", "Pakistan"}, {"India", "Pakistan"}, {"Pakistan", "Afghanistan"},
							    {"England", "India"}, {"India", "Bangladesh"}, {"South Africa", "Australia"},
							    {"India", "Sri Lanka"}, {"Australia", "New Zealand"}, {"Pakistan", "New Zealand"}, 
							    {"India", "Afghanistan"}, {"South Africa", "Sri Lanka"}, {"Pakistan", "Bangladesh"},
							    {"New Zealand", "India"},{"England", "Australia"}, {"England", "New Zealand"}};
		
		return cwcResult;
	}
}
