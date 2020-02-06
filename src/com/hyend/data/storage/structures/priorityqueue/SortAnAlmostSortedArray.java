package com.hyend.data.storage.structures.priorityqueue;

import java.util.PriorityQueue;

/**
 * Sort an almost sorted array. 
 * Such an array is sometimes referred to as being K sorted array.
 *  
 * For e.g : {3, 1, 2, 6, 4, 5, 7, 8, 9}
 * In The above array no element is more than 2 step away from its final sorted position.
 * 
 * @author gopi_karmakar
 */
public class SortAnAlmostSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {3, 1, 2, 6, 4, 5, 7, 8, 9};	
		//int[] arr = {3, 2, 1, 6, 5, 4, 7, 9, 8};
		
		sort(2, arr);
	}
	
	/**
	 * An O(n log k) time complexity solution 
	 */
	private static void sort(int k, int...arr) {
		
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		
		for(int i = 0; i < k; ++i) {
			minPQ.add(arr[i]);
		}
		
		for(int i = k; i < arr.length; ++i) {
			minPQ.add(arr[i]);
			System.out.println(minPQ.remove());
		}
		
		//When array is exhausted, remove all the remaining items from heap.
		for(int x : minPQ) {
			System.out.println(x);
		}
	}
}
