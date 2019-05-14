package com.hyend.logical.algorithms;

import com.hyend.data.storage.structures.priorityqueue.IndexMinPQ;

/**
 * Solution: A very efficient solution for Merging K Sorted Arrays.
 * 
 * Also, It could be a very efficient solution to find the Kth element 
 * from K sorted arrays as well.
 * 
 * Also, it could be a very efficient solution for finding the median from
 * K sorted arrays as well.
 * 
 * A very efficient solution for all such kind of problems and a lot others.
 * 
 * The time complexity of this solution can be O(n)Log(K)
 * where K will be the total number of sorted arrays and 
 * n will be sum of total number of keys from all arrays.
 * 
 * The space complexity can be O(K) for the keys to be stored in heap.
 * Where K will total number sorted arrays.
 *  
 * @author gopi_karmakar
 *
 */
public class MultiwayMerge {
	
	public MultiwayMerge() {}
	
	class items {
		private int pos = 1; //Current position of each array. 
		private int[] arr;
		public items(int[] arr) {
			this.arr = arr;
		}
		
		public void setCurPos(int pos) {
			this.pos = pos;
		}
		
		public int getNext() {
			if(pos < this.arr.length)
				return arr[pos++];
			else return -1;
		}
	}
	
	/**
	 * K Sorted arrays.
	 * 
	 * @param keys
	 */
	public void merge(int[][] keys) {				
	
		int k = keys.length;
		items[] item = new items[k];
		IndexMinPQ<Integer> pq = new IndexMinPQ<Integer>(k);
		
		/**
		 * While inserting the keys from each array to a min heap.
		 * We're inserting that array's index as well, for that only we've 
		 * created a index based minimum priority queue.
		 */
		for(int i = 0; i < k; i++) {
			item[i] = new items(keys[i]);
			pq.insert(i, keys[i][0]);			
		}
		
		while(!pq.isEmpty()) {
			
			System.out.println(pq.minKey());
			/**
			 * Since while insertion we've inserted array's index as well.
			 * So now while Delete min will always return the index of the 
			 * deleted element's array and then we again insert keys from that array.   
			 */
			int index = pq.deleteMin();
			
			int val = item[index].getNext();
			if(val != -1)
				pq.insert(index, val);			
		}			
	}
}
