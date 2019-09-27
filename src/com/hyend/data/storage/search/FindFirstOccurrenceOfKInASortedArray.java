package com.hyend.data.storage.search;

/**
 * Find first occurrence of K in a sorted array.
 * For e.g: 
 * {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401} k = 108
 * return 3 (since the first occurrence of 108 is at index 3)
 * 
 * @author gopi_karmakar
 */
public class FindFirstOccurrenceOfKInASortedArray {

	public static void main(String[] args) {
		
		int[] keys = {-14,-10,2,108,108,243,285,285,285,401};
		System.out.println("First Occurrence At = " + findFirstOfK(108, keys));
	}
	
	/**
	 * O(log n) time complexity
	 */
	private static int findFirstOfK(int k, int...keys) {
		
		int left = 0, right = keys.length-1, result = 0;
		
		while(left <= right) {
			
			int mid = left + ((right - left)/2);
			
			if(keys[mid] > k)	
				right = mid - 1;			
			else if(keys[mid] == k) {
				result = mid;
				right = mid - 1;
			}
			else
				left = mid + 1;
		}		
		return result;
	}
}
