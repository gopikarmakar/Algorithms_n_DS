package com.hyend.logical.interview.questions.SalesForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
		
	private List<String> keys;
	private List<String> logging;
	private List<LinkedList<Integer>> adjList;
	private LinkedHashMap<String, Integer> map;
	
	public Solution() {
		keys = new ArrayList<>();
		logging  = new ArrayList<>();
		adjList = new ArrayList<>();
		map = new LinkedHashMap<>();
	}
	
	public void readInput(String line) {
		logging.add(line);
		if(line.equals("LIST")) {								
		}
		else {
			String[] cmds = line.split(" ");
			switch(cmds[0]) {			
				case "DEPEND":					
					String[] items = Arrays.copyOfRange(cmds, 1, cmds.length);
					for(String cmd : items) {
						assignNumber(cmd);
						indexToKeys(cmd);
					}														
					int v = map.get(items[0]);
					for(int i = 1; i < items.length; i++) {
						int w = map.get(items[i]);
						addEdge(v, w);
					}
					
					break;
				case "INSTALL":
					
					break;
				case "REMOVE":

					break;
			}
		}	
	}
	
	private void assignNumber(String key) {
		if(!map.containsKey(key)) {
			map.put(key, map.size());
		}
	}
	
	private void indexToKeys(String key) {
		keys.add(map.get(key), key);
	}

	private void addEdge(int v, int w) {		
		LinkedList<Integer> list = adjList.get(v);
		if(list == null) {
			list = new LinkedList<Integer>();
		}
		list.add(w);
		adjList.add(v, list);
	}
	
	public void printGraph() {		
		for(int i = 0; i < adjList.size(); i++) {
			LinkedList<Integer> nodes = adjList.get(i);
			for(int x : nodes) {
				System.out.print(x + "->");
			}
			System.out.println();
		}
	}
}
