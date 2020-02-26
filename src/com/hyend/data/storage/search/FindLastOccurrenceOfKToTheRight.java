package com.hyend.data.storage.search;

/**
 * Find last occurrence of K to the right in an ascending order sorted array.
 * e.g: {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401} k = 285
 * return 8 (since the last occurrence of 285 is at index 8)
 * 
 * @author gopi_karmakar
 */
public class FindLastOccurrenceOfKToTheRight {

	public static void main(String[] args) {
		
		int[] arr = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		System.out.println(find(arr, 285));
	}
	
	public static int find(int[] arr, int k) {
		
		return find(arr, k, 0, arr.length);
	}
	
	/**
	 * An O(log n) time complexity solution.
	 */
	public static int find(int[] arr, int k, int l, int r) {
		
		int index = -1;
		
		while(l <= r) {
			
			int mid = l + (r - l) / 2;
			
			if(arr[mid] < k) {
				l = mid + 1;
			}
			else if(arr[mid] == k) {
				
				index = mid;
				// Nothing to the left of mid can be the last right occurrence of k.
				l = mid + 1;
			}
			else {
				r = mid - 1;
			}
		}		
		return index;
	}
}
