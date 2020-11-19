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
public class MergeKSortedArrays<K extends Comparable<K>> { 
	
	public static void main(String[] args) {
		
		Integer[][] files = {{3, 5, 7}, {0, 6}, {0, 6, 8}};	
		
		MergeKSortedArrays<Integer> merge = new MergeKSortedArrays<>();
		
		System.out.println(merge.mergeKSortedArray(files));			
	}

	private class Entry {	
		public K k;
		public int ri = 0;
		public int ci = 0;
		
		public Entry(K key, int rIndex, int cIndex) {					
			this.k = key;
			this.ri = rIndex;
			this.ci = cIndex;
		}
		
		public K getKey() {
			return k;
		}	
	}

	/**
	 * Merge Sorted Arrays
	 * An O(n log k) time complexity solution.
	 */
	public List<K> mergeKSortedArray(K[][] files) {
		
		List<List<K>> lists = new ArrayList<>();
		
		for(K[] list : files) {
			lists.add(Arrays.asList(list));
		}
		
		List<K> merged = mergeKSortedLists(lists);

		return merged;
	}
	
	/**
	 * Merge Sorted Lists
	 * An O(n log k) time complexity solution
	 */
	public List<K> mergeKSortedLists(List<List<K>> lists) {
		
		List<K> merged = new ArrayList<>();
		
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
			merged.add(entry.k);
			
			if(entry.ci < lists.get(entry.ri).size()-1) {
				minPQ.add(new Entry(lists.get(entry.ri).get(++entry.ci), entry.ri, entry.ci));
			}
		}		
		return merged;
	}
}
