package com.hyend.data.storage.structures.priorityqueue;

import java.util.ArrayList;
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
		
		int[][] files = {{3, 5, 7}, {0, 6}, {0, 6, 8}};		
		
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
	}
	
	/**
	 * Merge Sorted Arrays
	 * An O(n log k) time complexity solution.
	 */
	public static List<Integer> mergeSortedArray(int[][] files) {
		
		List<Integer> merged = new ArrayList<>();
		
		PriorityQueue<Entry> heap = new PriorityQueue<Entry>(files.length, new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				return Integer.compare(e1.key, e2.key);
			}
		});
		
		for(int i = 0; i < files.length; i++) {
			heap.add(new Entry(files[i][0], i, 0));
		}
				
		while(!heap.isEmpty()) {
			Entry entry = heap.remove();
			merged.add(entry.key);
			
			if(entry.ci < files[entry.ri].length-1) {
				heap.add(new Entry(files[entry.ri][++entry.ci], entry.ri, entry.ci));
			}
		}
		return merged;
	}
	
	/**
	 * Merge Sorted Lists
	 * An O(n log k) time complexity solution
	 */
	public static List<Integer> mergeSortedLists(List<List<Integer>> lists) {
		
		List<Integer> merged = new ArrayList<>();
		
		PriorityQueue<Entry> heap = new PriorityQueue<>(lists.size(), new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				return Integer.compare(e1.key, e2.key);
			}
		});
		
		for(int i = 0; i < lists.size(); ++i) {
			heap.add(new Entry(lists.get(i).get(0), i, 0));
		}
		
		while(!heap.isEmpty()) {
			Entry entry = heap.remove();
			merged.add(entry.key);
			
			if(entry.ci < lists.get(entry.ri).size()-1) {
				heap.add(new Entry(lists.get(entry.ri).get(++entry.ci), entry.ri, entry.ci));
			}
		}		
		return merged;
	}
}
