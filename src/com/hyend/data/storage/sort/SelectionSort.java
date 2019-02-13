package com.hyend.data.storage.sort;

/**
 * 
 * @author karmakargopi
 *
 * Looping time will be always linear O(n) 
 * either for sorted or unsorted array.
 * Exchanges time complexity will be quadratic O(n^2)
 * as it always compare and exchange with it's previous one. 
 */
public class SelectionSort {

	public void sort(int[] arr) {	
		int n = arr.length, temp = 0;		
		for(int i = 0; i < n; i++) {
			int min = i;
			for(int j = i; j < n; j++) {				
				if(arr[j] < arr[min]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = min;
					min = j;
				}
			}
		}
	}
}
