package com.hyend.data.storage.structures.graphs.undirected;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Given a file containing airport codes and their routes, 
 * Each line in file describes the route between two airports.
 * Return a list of air ports you can travel for a given air port code. 
 * 
 * @author gopi_karmakar
 */
public class AirConnectivity {

	/**
	 * O(v + e) time complexity
	 */
	public static void main(String[] args) throws IOException {
		
		String fileName = "routes.txt";
		String delimeter = " ";
		
		List<List<String>> nodes = new AirConnectivity().parseFile(fileName, delimeter);				
		UndirectedGraph<String> uGraph = new BuildUndirectedGraph<String>().buildGraph(nodes);
		
		Scanner scanner = new Scanner(System.in);

		while(scanner.hasNext()) {
			
			String city = scanner.next();
			System.out.print(city + " -> " );
			System.out.println(uGraph.getAdjacencySet(city));
		}		
		scanner.close();			
	}
	
	private List<List<String>> parseFile(String fileName, String delimeter) throws IOException {
	
		InputStream in = getClass().getResourceAsStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		List<List<String>> nodes = new ArrayList<>();
		
		String line = null;
		while((line = reader.readLine()) != null ) {
						
			String[] cities = line.split(" ");						
			nodes.add(Arrays.asList(cities));
		}
		return nodes;
	}
}