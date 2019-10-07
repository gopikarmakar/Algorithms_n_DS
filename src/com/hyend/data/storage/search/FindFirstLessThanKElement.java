package com.hyend.data.storage.search;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Find first less than K element
 * e.g: {108, -14, 2, 285, 108, 401, 285, 243, -10, 285}
 * K = 108 return 2
 * K = 260 return 243
 * K = -3 return -10
 * 
 * @author gopi_karmakar
 */
public class FindFirstLessThanKElement {

	public static void main(String[] args) {
		
		int[] keys = {108, -14, 2, 285, 108, 401, 285, 243, -10, 285};
		
		System.out.println(find(keys, -3));
	}
	
	/**
	 * Time taken for sort is O(n log n) 
	 * Time taken to find first less than k in Sorted Array is O(log n)
	 * i.e the total time complexity taken is dominated by sort O(n Log n)
	 * but if the array is already sorted then the time complexity only be O(log n).
	 */
	private static int find(int[] keys, int k) {
		
		Arrays.sort(keys);
		
		if(k <= keys[0]) throw new NoSuchElementException();
		else if(k >= keys[keys.length-1]) return keys[keys.length-1];
		else {
			int index = find(keys, k, 0, keys.length);
			return keys[index-1];
		}
	}
	
	private static int find(int[] keys, int k, int l, int r) {			
		
		while(l <= r) {
			
			int mid = l + (r - l) / 2;
			
			// If it equals then nothing to the right of mid can be the first left occurrence of k.
			if(keys[mid] >= k) r = mid - 1;								
			
			else l = mid + 1; 						

		}
		return l;
	}
}
