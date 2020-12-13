package com.hyend.data.storage.search;

import java.util.NoSuchElementException;

/**
 * Find smallest entry in a cyclic sorted array.
 * An array is said to be cyclically sorted if it is possible to 
 * cyclically shift its entries so that it becomes sorted. 
 * For e.g, the below array is cyclically sorted—acyclic 
 * left shift by 4 leads to a sorted array.
 * 
 * NOTE: Assume all the entries are distinct
 * 
 * e.g: {378, 478, 550, 631, 103, 203, 220, 234, 279, 368}
 * return 103
 * 
 * @author gopi_karmakar
 */
public class FindSmallestKeyInCyclicSortedArray {

	public static void main(String[] args) {
	
		int[] arr = {378, 478, 550, 631, 103, 203, 220, 234, 279, 368};
		System.out.println(find(arr));
	}
	
	/**
	 * O(log n) time complexity
	 */
	private static int find(int...arr) {
		
		int l = 0, r = arr.length-1;
		
		while(l <= r) {
			
			int mid = l + (r - l + 1) / 2;
				
			if(arr[mid] < arr[r]) {
				r = mid - 1;
			}
			else if(arr[mid] > arr[r]) {
				l = mid + 1;
			}
			else {
				return arr[mid];
			}
		}
		throw new NoSuchElementException();
	}
}
