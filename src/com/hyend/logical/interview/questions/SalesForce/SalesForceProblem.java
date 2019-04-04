package com.hyend.logical.interview.questions.SalesForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SalesForceProblem {
	
	private List<String> logs;
	private Stack<String> installing;	
	private LinkedHashSet<String> installed;	
	private LinkedHashMap<String, LinkedList<String>> map;
	private LinkedHashMap<String, LinkedList<String>> reverseMap;
	
	public SalesForceProblem() {				
		logs = new ArrayList<>();
		installing = new Stack<>();	
		map = new LinkedHashMap<>();		
		installed = new LinkedHashSet<>();
		reverseMap = new LinkedHashMap<>();
	}
	
	public void readInput(String[] input) {		
		for(String line : input) {						
			if(line.equals("LIST\n")) {
				logs.add(line);
				listInstalled();
			}
			else {
				String mLine = line.replace("\n", "");
				String[] cmds = mLine.split(" ");
				switch(cmds[0]) {			
					case "DEPEND":
						logs.add(line);
						createMapping(Arrays.copyOfRange(cmds, 1, cmds.length));
						createmapping(Arrays.copyOfRange(cmds, 1, cmds.length));
						break;
					case "INSTALL":
						logs.add(line);
						installComponent(cmds[1]);
						break;
					case "REMOVE":
						logs.add(line);
						removeComponent(cmds[1]);
						break;
				}
			}
		}
	}
	
	public void printMappings() {
		Iterator<Map.Entry<String, LinkedList<String>>> itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<String, LinkedList<String>> e = itr.next();
			System.out.print(e.getKey());
			for(String s : e.getValue()) {
				System.out.print(" -> " + s);
			}
			System.out.println();
		}
		System.out.println();		
		Iterator<Map.Entry<String, LinkedList<String>>> ritr = reverseMap.entrySet().iterator();
		while(ritr.hasNext()) {
			Map.Entry<String, LinkedList<String>> e = ritr.next();
			System.out.print(e.getKey());
			for(String s : e.getValue()) {
				System.out.print(" -> " + s);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void printLogs() {
		for(String log : logs) {
			System.out.print(log);
		}
	}
	
	private void createMapping(String...components) {
		String log = "";
		boolean isValid = false;
		LinkedList<String> adjList = new LinkedList<>();
		for(int i = 1; i < components.length; i++) {			
			if(!map.containsKey(components[i])) {
				isValid = true;
				adjList.add(components[i]);
			}
			else {
				for(String s : map.get(components[i])) {
					if(s.equals(components[i-1])) {
						log = components[i] + " depends on " + components[i-1] + " ignoring command\n";
						isValid = false;
						logs.add(log);						
					}
					else {
						isValid = true;
						adjList.add(components[i]);
					}
				}
			}
		}
		if(isValid) map.put(components[0], adjList);
	}

	private void installComponent(String component) {
		String log = "";
		if(installed.contains(component)) {
			log = component + " is already installed\n";
			logs.add(log);
			return;
		}
		crawlMap(component);		
		while(!installing.isEmpty()) {
			String item = installing.pop();
			if(installed.add(item)) {
				log = "Installing " + item + "\n";
				logs.add(log);
			}
		}
	}
	
	private void crawlMap(String item) {
		if(!installed.contains(item)) {			
			installing.push(item);
		}
		LinkedList<String> adjList = map.get(item);
		if(adjList == null) return;
				
		for(String s : adjList) {			
			crawlMap(s);
		}
	}
	
	private void removeComponent(String component) {
		String log = "";
		if(!installed.contains(component)) {
			log = component + " is not installed\n";
			logs.add(log);
			return;
		}
		remove(component);
		if(installing.isEmpty()) {
			log = component + " is still needed\n";
			logs.add(log);
		}
		else {
			while(!installing.isEmpty()) {
				String s = installing.pop();				
				installed.remove(s);
				log = "Removing " + component + "\n";
				logs.add(log);
				System.out.println("### " + s + " ###");				
			}
		}
	}
	
	private void remove(String component) {		
		installing.push(component);
		LinkedList<String> adjList = map.get(component);
		if(adjList == null) {
			installing.pop();
			return;
		}			
		for(String s : adjList) {
			crawlMap(s);
		}
	}
	
	private boolean hasDependency(String item) {
		boolean any = false;
		return any;
	}

	private void listInstalled() {		
		for(String s : installed) {
			String log = s + "\n";
			logs.add(log);
		}
	}
	
	private void createmapping(String...items) {		
		for(int i = 0; i < items.length-1; i++) {			
			if(!reverseMap.containsKey(items[i+1])) {
				LinkedList<String> adjList;
				if(reverseMap.get(items[i]) == null) { 
					adjList = new LinkedList<>();
				}
				else {
					adjList = reverseMap.get(items[i]);
					if(adjList.contains(items[i+1])) 
						continue;					
				}
				adjList.add(items[i+1]);
				reverseMap.put(items[i], adjList);
			}
			else {
				for(String s : reverseMap.get(items[i+1])) {
					if(!s.equals(items[i])) {
						LinkedList<String> adjList = new LinkedList<>();
						adjList.add(items[i+1]);
						reverseMap.put(items[i], adjList);
					}
					else {
						
					}
				}
			}
		}
	}
}