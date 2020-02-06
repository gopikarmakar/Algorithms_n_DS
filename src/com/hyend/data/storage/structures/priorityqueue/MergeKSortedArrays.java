package com.hyend.data.storage.structures.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * It is the solution for Merge K Sorted Files.
 * But instead of files here it has been solved 
 * with K sorted arrays.
 * 
 * So the problem becomes Merge K Sorted Arrays in to one.
 * 
 * @author gopi_karmakar
 */
public class MergeKSortedArrays {
	
	public static void main(String[] args) {
		
		Integer[][] files = {{3, 5, 7}, {0, 6}, {0, 6, 8}};		
		
		for(int x: mergeSortedArray(files)) {
			System.out.println(x);
		}
	}

	private static class Entry {		
		public int key;
		public int ri = 0;
		public int ci = 0;
		public Entry(int key, int rIndex, int cIndex) {					
			this.key = key;
			this.ri = rIndex;
			this.ci = cIndex;
		}
		
		public int getKey() {
			return key;
		}
	}
	
	/**
	 * Merge Sorted Arrays
	 * An O(n log k) time complexity solution.
	 */
	public static List<Integer> mergeSortedArray(Integer[][] files) {
		
		List<List<Integer>> lists = new ArrayList<>();
		
		for(Integer[] list : files) {
			lists.add(Arrays.asList(list));
		}
		
		List<Integer> merged = mergeSortedLists(lists);

		return merged;
	}
	
	/**
	 * Merge Sorted Lists
	 * An O(n log k) time complexity solution
	 */
	public static List<Integer> mergeSortedLists(List<List<Integer>> lists) {
		
		List<Integer> merged = new ArrayList<>();
		
		/*PriorityQueue<Entry> minPQ = new PriorityQueue<>(lists.size(), new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				return Integer.compare(e1.key, e2.key);
			}
		});*/
		
		PriorityQueue<Entry> minPQ = new PriorityQueue<>(lists.size(), Comparator.comparing(Entry::getKey));
		
		for(int i = 0; i < lists.size(); ++i) {
			minPQ.add(new Entry(lists.get(i).get(0), i, 0));
		}
		
		while(!minPQ.isEmpty()) {
			Entry entry = minPQ.remove();
			merged.add(entry.key);
			
			if(entry.ci < lists.get(entry.ri).size()-1) {
				minPQ.add(new Entry(lists.get(entry.ri).get(++entry.ci), entry.ri, entry.ci));
			}
		}		
		return merged;
	}
}
