package com.hyend.data.storage.search;

public class LinearSearch {

	public int search(int[] arr, int l, int r, int key) {
		
		if(r < l) return -1;
		if(arr[l] == key) return l;
		return search(arr, l+1, r, key);
	}
}
