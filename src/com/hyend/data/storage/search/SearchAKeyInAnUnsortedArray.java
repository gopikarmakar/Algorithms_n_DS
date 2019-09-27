package com.hyend.data.storage.search;

/**
 * Search a given key from an unsorted array
 * 
 * @author gopi_karmakar
 */
public class SearchAKeyInAnUnsortedArray {
	
	public static void main(String[] args) {
		int[] arr = {3, 1, -1, 2, 7, 10, 4, 9, -3, -5};	
		System.out.println(linearSearch(arr, 0, arr.length, 7));
		System.out.println(recursiveSearch(arr, 0, arr.length-1, 7));
	}
	
	/**
	 * Recursive linear search
	 * O(n) time complexity
	 */
	private static int linearSearch(int[] arr, int l, int r, int key) {
		
		if(r < l) return -1;
		if(arr[l] == key) return l;
		return linearSearch(arr, l+1, r, key);
	}

	/**
	 * Using Merge Sort Algorithm to search a key.
	 * O(n)log(n) time complexity.
	 */
	private static int recursiveSearch(int[] arr, int l, int r, int key) {
		
		if(r <= l) return -1;
		int mid = l + (r - l)/2;
		recursiveSearch(arr, l, mid, key);
		recursiveSearch(arr, mid+1, r, key);
		return match(arr, l, mid, r, key); 
	}
	
	private static int match(int[] arr, int l, int mid, int r, int key) {
		
		int i = l, j = mid;
		for(int k = l; k <= r; k++) {
			if(i > mid) 		return -1;
			if(j > r)			return -1;
			if(arr[i++] == key) return i;
			if(arr[j++] == key) return j;
		}
		return -1;
	}
}
