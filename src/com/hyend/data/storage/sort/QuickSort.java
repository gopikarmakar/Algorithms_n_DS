package com.hyend.data.storage.sort;

/**
 * QuickSort best case time-complexity is O(nlogn)
 * and worst case time-complexity is quadratic O(n^2) 
 * but since, pivot can vary from low-median-high,
 * The worst case scenario appearing rate is very very rare.
 * Due to random shuffling of values from pivot compares.
 * The QuickSort is not stable, but it's a very efficient 
 * sorting algorithm for primitive type of data. Since,
 * It's an in-place sorting algorithm unlike MergeSort,
 * It doesn't use any extra space for an auxiliary array.
 * 
 * @author gopi_karmakar
 */
public class QuickSort {
	
	public static void main(String[] args) {
		
		int[] arr = {3,1,5,2,7,4,8,6,9,0};
		QuickSort qs = new QuickSort();
		qs.sort(arr, 0, arr.length-1);
		
		for(int x : arr)
			System.out.println(x);
	}

	/**
	 * O(n log n) time complexity
	 */
	public void sort(int[] arr, int low, int high) {
		
		if(low < high) {
		
			int partitionIndex = partition(arr, low, high);
			
			sort(arr, low, partitionIndex - 1);
			sort(arr, partitionIndex + 1, high);
		}
	}
	
	public int partition(int[] arr, int low, int high) {
		
		int i = low - 1, pivot = arr[high];
		
		for(int j = low; j < high; j++) {
			
			if(arr[j] <= pivot) {
				i+=1;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;		
	}
}
