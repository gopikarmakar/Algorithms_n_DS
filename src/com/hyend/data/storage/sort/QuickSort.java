package com.hyend.data.storage.sort;

import java.util.Random;

/**
 * QuickSort best case time-complexity is O(n log n)
 * and worst case time-complexity is quadratic O(n^2) 
 * but choosing pivot randomly makes the worst case
 * appearing rate is very very rare.
 * 
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
		
		int[] arr = {3, 1, 5, 2, 7, 4, 8, 6, 9, 0};		
		
		Random random = new Random(0);
		
		//QuickSort qs = new QuickSort();
		sort(arr, 0, arr.length-1, random);
		
		for(int x : arr)
			System.out.println(x);
	}

	/**
	 * Random pivot selection guarantees for an
	 * O(n log n) time complexity.
	 */
	public static void sort(int[] arr, int low, int high, Random random) {
		
		if(low < high) {
		
			int partitionIndex = partition(arr, low, high, random);						
			
			sort(arr, low, partitionIndex - 1, random);
			sort(arr, partitionIndex + 1, high, random);
		}
	}
	
	private static int partition(int[] arr, int l, int r, Random random) {
				
		int rand = random.nextInt(r - l + 1);
		
		int pivot = rand + l;
		
		int newPivotIdx = l;
		int pivotvalue = arr[pivot];		
		
		swap(arr, pivot, r);
		for(int i = l; i < r; ++i) {
			
			if(arr[i] < pivotvalue) {

				swap(arr, i, newPivotIdx++);
			}
		}
		swap(arr, r, newPivotIdx);
		
		return newPivotIdx;
	}
	
	private static void swap(int[] arr, int a, int b) {
		
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	// OLD Solution
	/*public int partition(int[] arr, int low, int high) {
	
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
	}*/
}
