package com.hyend.data.storage.sort;

/**
 * @author karmakargopi
 *
 * MergerSort guarantees O(nlogn) time complexity in any case scenario.
 * Merge Sort is quite stable for all types of data.
 * The biggest disadvantage of merge sort is that, 
 * it is not an in-place sorting algorithm. 
 * it uses an auxiliary array to store the 
 * copy of the actual array for compares after split.
 */
public class MergeSort {
	
	public void sort(int[] arr) {
		split(arr, 0, arr.length-1);		
	}
	
	public void split(int[] arr, int low, int high) {		
		if(high <= low) return;
		int mid = low + (high - low)/2;
		split(arr, low, mid);
		split(arr, mid+1, high);
		sortAndMerge(arr, low, mid, high);
	}
	
	public void sortAndMerge(int[] arr, int low, int mid, int high) {
		
		int aux[] = new int[arr.length];
		for(int k = 0; k < arr.length; k++) {
			aux[k] = arr[k];
		}
		int i = low, j = mid+1;
		for(int k = low; k <= high; k++) {	
			if(i > mid) 				arr[k] = aux[j++];
			else if(j > high) 			arr[k] = aux[i++];
			else if(aux[j] < aux[i]) 	arr[k] = aux[j++];
			else 						arr[k] = aux[i++];
		}
	}
}
