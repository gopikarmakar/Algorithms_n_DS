package com.hyend.data.storage.search;

/**
 * Search a given key from an unsorted array
 * in O(n)log(n) time.
 * 
 * @author gopi_karmakar
 */
public class SearchFromUnsortedArray {

	public int recursiveSearch(int[] arr, int l, int r, int key) {
		
		if(r <= l) return -1;
		int mid = l + (r - l)/2;
		recursiveSearch(arr, l, mid, key);
		recursiveSearch(arr, mid+1, r, key);
		return match(arr, l, mid, r, key); 
	}
	
	private int match(int[] arr, int l, int mid, int r, int key) {
		
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
