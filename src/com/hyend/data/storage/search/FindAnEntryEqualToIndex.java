package com.hyend.data.storage.search;

import java.util.Arrays;

/**
 * Find an entry equals to it's index.
 * 
 * @author gopi_karmakar
 */
public class FindAnEntryEqualToIndex {

	public static void main(String[] args) {
		
		//int[] arr = {-2, 0, 2, 3, 6, 7, 9};
		int[] arr = {3, 2, -2, 6, 9, 7, 0};
		//int[] arr = {-2, -1, 0, 0, 2, 2, 3};
		
		System.out.println(find(arr));
	}
	
	/**
	 * Time taken for sort is O(n log n) 
	 * Time taken to find first less than k in Sorted Array is O(log n)
	 * i.e the total time complexity taken is dominated by sort O(n Log n)
	 * but if the array is already sorted then the time complexity only be O(log n).
	 */
	private static int find(int...arr) {
		
		Arrays.sort(arr);		
		int l = 0, r = arr.length;
		
		while(l < r) {
			
			int mid = l + (r - l) / 2;			
			int distance = arr[mid] - mid;
			
			if(distance == 0)		return arr[mid];
			
			else if(distance > 0) 	r = mid - 1;
			
			else 					l = mid + 1;
		}		
		return -1;
	}
}
