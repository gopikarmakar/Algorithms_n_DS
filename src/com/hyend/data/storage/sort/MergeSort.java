package com.hyend.data.storage.sort;

import java.util.Arrays;

/**
 * MergerSort guarantees O(nlogn) time complexity in any case scenario.
 * Merge Sort is quite stable for all types of data.
 * The biggest disadvantage of merge sort is that, 
 * it is not an in-place sorting algorithm. 
 * it uses an auxiliary array to store the 
 * copy of the actual array for compares after split.
 * 
 * @author gopi_karmakar
 */
public class MergeSort {
	
	public static void main(String[] args) {
		
		int[] arr = {1,3,4,2};
		//int[] arr = {2,6,4,5,1,3};
		//int[] arr = {3,1,5,2,7,4,8,6,9,0};
		
		MergeSort mSort = new MergeSort();	
		mSort.sort(arr);

		for(int x : arr)
			System.out.println(x);
		
		System.out.println(count);
	}	
	
	/**
	 * O(n log n) time complexity
	 */
	public void sort(int[] arr) {
		sortAndMerge(arr, 0, arr.length-1);
	}
	
	public void sortAndMerge(int[] arr, int low, int high) {
		
		if(high <= low) return;
		int mid = low + (high - low)/2;
		sortAndMerge(arr, low, mid);
		sortAndMerge(arr, mid+1, high);
		
		/**
		 * Arrays.copyOf(arr, arr.length) is an auxiliary array of the original to compare with.
		 */	
		merge(arr, Arrays.copyOf(arr, arr.length), low, mid, high);
	}
	
	static int count = 0;
	public void merge(int[] arr, int[] aux, int low, int mid, int high) {

		int i = low, j = mid+1;
		for(int k = low; k <= high; k++) {	
			if(i > mid) 				arr[k] = aux[j++];
			else if(j > high) 			arr[k] = aux[i++];
			else if(aux[j] < aux[i]) 	arr[k] = aux[j++]; 
			else 						arr[k] = aux[i++];
		}
	}
}
