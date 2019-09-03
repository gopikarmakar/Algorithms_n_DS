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
		
		for(int x: merge(files)) {
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
	
	private static List<Integer> merge(int[][] files) {
		
		PriorityQueue<Entry> pq = new PriorityQueue<Entry>(files.length, new Comparator<Entry>() {
			@Override
			public int compare(Entry l, Entry r) {
				return Integer.compare(l.key, r.key);
			}
		});
		
		for(int i = 0; i < files.length; i++) {
			pq.add(new Entry(files[i][0], i, 0));
		}
		
		List<Integer> merged = new ArrayList<>();
		while(!pq.isEmpty()) {
			Entry entry = pq.remove();
			merged.add(entry.key);
			
			if(entry.ci < files[entry.ri].length-1) {
				pq.add(new Entry(files[entry.ri][++entry.ci], entry.ri, entry.ci));
			}
		}
		return merged;
	}
}
