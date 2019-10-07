package com.hyend.data.storage.search;

/**
 * Find first occurrence of K to the left in an ascending order sorted array.
 * For e.g: 
 * {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401} k = 108
 * return 3 (since the first occurrence of 108 is at index 3)
 * 
 * @author gopi_karmakar
 */
public class FindFirstOccurrenceOfKToTheLeft {

	public static void main(String[] args) {
		
		int[] keys = {-14,-10,2,108,108,243,285,285,285,401};
		System.out.println("First Occurrence At = " + find(keys, 108));
	}
		
	public static int find(int[] keys, int k) {
		
		return find(keys, k, 0, keys.length);
	}
	
	/**
	 * An O(log n) time complexity solution.
	 */
	public static int find(int[] arr, int k, int l, int r) {
		
		int index = -1;
		
		while(l <= r) {
			
			int mid = l + (r - l) / 2;
			
			if(arr[mid] > k) {
				r = mid - 1;
			}
			else if(arr[mid] == k) {
				index = mid;
				// Nothing to the right of mid can be the first left occurrence of k.
				r = mid - 1;
			}
			else {
				l = mid + 1;
			}
		}
		return index;
	}
}
