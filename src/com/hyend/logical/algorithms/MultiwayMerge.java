package com.hyend.logical.algorithms;

import com.hyend.data.storage.structures.IndexMinPQ;
import com.hyend.data.storage.structures.MaxPriorityQueue;

public class MultiwayMerge {
	
	public MultiwayMerge() {}	
	
	/**
	 * Incomplete Solution.
	 * @param keys
	 */
	public void merge(int[][] keys) {				
	
		int n = keys.length;
		IndexMinPQ<Integer> pq = new IndexMinPQ<Integer>(n);
		//MaxPriorityQueue<Integer> mpq = new MaxPriorityQueue<>(keys.length);
		
		for(int i = 0; i < n; i++) {			
			pq.insert(i, keys[i][0]);			
		}
		
		int k = 0;
		while(!pq.isEmpty()) {
			System.out.println(pq.minKey());
			int index = pq.deleteMin();
			
			pq.insert(index, keys[index][k]);
			
		}			
	}
}
