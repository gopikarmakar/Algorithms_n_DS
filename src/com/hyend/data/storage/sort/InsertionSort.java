package com.hyend.data.storage.sort;

/**
 * 
 * @author karmakargopi
 *
 * InsertionSort time complexity is quadratic O(n^2) 
 * for any case, Since it's always compares and  
 * exchanges with it's previous value.
 * But for the already sorted arrays 
 * the complexity is linear O(n).  
 */
public class InsertionSort {

	public void sort(int[] arr) {
		
		int x = 0;
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = i; j > 0; j--) {
				
				if(arr[j] < arr[j-1]) {
					x = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = x;
				}
				else
					break;
			}
		}
	}
}
