package com.hyend.data.storage.search;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Find the first greater than k element
 * e.g: {108, -14, 2, 285, 108, 401, 285, 243, -10, 285} 
 * k = 108 return 243
 * k = -13 return -10
 * k = 10 return 108
 * 
 * @author gopi_karmakar
 */
public class FindFirstGreaterThanKElement {

	public static void main(String[] args) {
		int[] keys = {108, -14, 2, 285, 108, 401, 285, 243, -10, 285};
		System.out.println(find(keys, -13));
	}
	
	/**
	 * Time taken for sort is O(n log n) 
	 * Time taken to find first greater than k in Sorted Array is O(log n)
	 * i.e the total time complexity taken is dominated by sort O(n Log n)
	 * but if the array is already sorted then the time complexity only be O(log n).
	 */
	private static int find(int[] keys, int k) {
		Arrays.sort(keys);
		if(k <= keys[0]) return keys[0];
		else if(k >= keys[keys.length-1]) throw new NoSuchElementException();
		else {
			int index = find(keys, k, 0, keys.length);
			return keys[index+1];
		}
	}
	
	//{-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
	private static int find(int[] arr, int k, int l, int r) {
		
		while(l <= r) {				
			
			int mid = l + (r - l) / 2;			
			
			// If it equals then nothing to the left of mid can be the last right occurrence of k.
			if(arr[mid] <= k) l = mid + 1; 
				
			else r = mid - 1;			
		}		
		return r;
	}
}
