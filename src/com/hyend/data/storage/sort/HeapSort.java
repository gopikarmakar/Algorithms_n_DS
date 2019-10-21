package com.hyend.data.storage.sort;

/**
 * Time complexity of heapify is O(Logn). 
 * Time complexity of createAndBuildHeap() is O(n)
 * Overall time complexity of Heap Sort is O(nLogn).
 * HeapSort is usually slowest among Merge & Quick sort.
 * 
 *  @author gopi_karmakar
 */
public class HeapSort {
	
	public void sort(int[] arr) {
	
		int n = arr.length;
		for(int i = n/2 -1; i >= 0; i--) {
			heapify(arr, i, n);
		}
		
		for(int i = n-1; i >= 0; i--) {
			
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, 0, i);
		}
	}
	
	public void heapify(int[] arr, int i, int n) {
		
		int root = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < n && arr[left] > arr[root]) root = left;
		
		if(right < n && arr[right] > arr[root]) root = right;
		
		if(root != i) {
			
			int temp = arr[i];
			arr[i] = arr[root];
			arr[root] = temp;
			
			heapify(arr, root, n);
		}
	}
}
