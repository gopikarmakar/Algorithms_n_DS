package com.hyend.logical.interview.questions.SalesForce;

import java.util.Map;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * An efficient solution
 * Max complexity will be O(V + E) for finding dependents 
 * and non dependents, else mostly it is O(n). 
 * 
 * @author gopi_karmakar
 */
public class SalesForceProblem {
	
	private List<String> logs;		
	private Map<String, List<String>> graph;
	private Map<String, GraphVertex<String>> pool;	
	
	private class GraphVertex<V> {
		
		V component;
		boolean isInstalled;
		
		public GraphVertex(V component) {
			this.component = component;			
			isInstalled = false;
		}
	}
	
	public SalesForceProblem() {
		
		logs = new ArrayList<>();		
		pool = new LinkedHashMap<>();
		graph = new LinkedHashMap<>();
	}
	
	public void readInput(String[] input) {
		
		for(String line : input) {	
			
			if(line.equals("END\n")) {
				logs.add(line);
			}
			else if(line.equals("LIST\n")) {
				
				logs.add(line);
				listAllInstalledComponent();
			}			
			else {
				
				String mLine = line.replace("\n", "");
				String[] cmds = mLine.split(" ");
				
				switch(cmds[0]) {		
				
					case "DEPEND":						
						String[] cmpnts = Arrays.copyOfRange(cmds, 1, cmds.length); 
						createObjectPool(cmpnts);												
						
						if(createDiGraph(Arrays.asList(cmpnts)))	{					
							logs.add(line);
						}																
						break;
					case "INSTALL":
						installComponent(cmds[1]);
						break;
					case "REMOVE":
						removeComponent(cmds[1]);
						break;
				}
			}
		}
	}
	
	private void createObjectPool(String...components) {
		
		for(String c:  components) {
			GraphVertex<String> gv = pool.getOrDefault(c, new GraphVertex<String>(c));
			pool.put(c, gv);
		}
	}	
	
	private boolean createDiGraph(List<String> vertices) {
		
		if(isValid(vertices)) {
			
			if(vertices.size() < 1) {
				graph.put(vertices.get(0), new ArrayList<>());
			}
			graph.put(vertices.get(0), vertices.subList(1, vertices.size())); 
				
			return true;
		}			
		return false;
	}
	
	private boolean isValid(List<String> vertices) {				
		
		for(int i = 0; i < vertices.size()-1; ++i) {			

			int j = i + 1;
			List<String> e = graph.get(vertices.get(j));
			
			if(e != null) {
				
				if(e.contains(vertices.get(i))) {
					
					String log = vertices.get(i) + " depends on " + vertices.get(j) + " ignoring command\n";
					logs.add(log);
					return false;
				}						
			}
		}		
		return true;
	}
	
	private void installComponent(String component) {
		
		Stack<String> path = new Stack<>();
		
		if(pool.containsKey(component)) {
			
			if(pool.get(component).isInstalled)	{
				logs.add(component + " Already Installed\n");
				return;
			}
			else if(graph.containsKey(component)) {
				// Dependents Case			
				findDependents(component, path);
			}
			else {
				// Non Dependents Case
				String root = graph.entrySet().iterator().next().getKey();
				findNonDependents(root, component, path);							
			}
		}
		else {
			// New component installation case
			path.push(component);
			createObjectPool(component);
			createDiGraph(new ArrayList<>(path));				
		}
		
		String e;
		do {
		
			e = path.pop();
			if(!pool.get(e).isInstalled) {
				
				pool.get(e).isInstalled = true;
				logs.add("INSTALL " + e + "\n");
			}
			
		} while(!e.equals(component));
	}
	
	private void removeComponent(String component) {
		
		if(!pool.containsKey(component))	{
			logs.add(component + " Doesn't Exist Already Removed\n");
			return;
		}
		else {

			if(graph.containsKey(component)) {
				
				// Non Dependent Case
				graph.remove(component);
				pool.remove(component);
				logs.add("REMOVE " + component + "\n");
			}
			else {
				
				// Dependent Case
				logs.add("Can't Remove " + component + " Still Required\n");
			}
		}		
	}
	
	private void listAllInstalledComponent() {
		pool.values().forEach(e -> {			
			if(e.isInstalled)
				logs.add(e.component + "\n");
		});
	}
	
	private void findDependents(String vertex, Collection<String> path) {			
		
		if(!path.contains(vertex)) {
			path.add(vertex);
		}				
		
		for(String e : graph.getOrDefault(vertex, new ArrayList<>())) {			
			findDependents(e, path);
		}
	}

	private boolean findNonDependents(String vertex, String searchingFor, Collection<String> path) {
		
		if(!path.contains(vertex)) 
			path.add(vertex);
		
		if(vertex.equals(searchingFor)) {
			return true;
		}				
		
		for(String e : graph.getOrDefault(vertex, new ArrayList<>())) {					
			if(findNonDependents(e, searchingFor, path))
				return true;
		}
		return false;
	}
	
	public void printLogs() {
		
		logs.forEach( log -> {
			System.out.print(log);
		});
	}
	
	public void printGraph() {
		
		Iterator<Map.Entry<String, List<String>>> itr = graph.entrySet().iterator();
		
		while(itr.hasNext()) {
			
			Map.Entry<String, List<String>> entry = itr.next();
			
			System.out.print(entry.getKey() + " -> ");
			
			entry.getValue().forEach(e -> {
				
				System.out.print(e + "  ");
			});
			System.out.println();
		}		
	}
}