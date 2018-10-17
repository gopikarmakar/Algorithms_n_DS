package com.hyend.data.storage.sort;

/**
 * 
 * @author karmakargopi
 *
 * Shell Sort is an another form of Insertion Sort.
 * But in shell sort the comparison and exchanges 
 * are just not b/w adjacent values but in b/w some gap.
 * the gap is normally starts with arr.length/2;
 * Shell Sort takes Sub-quadratic T(n) = O(n2). time but it is not the case always.
 * As It depends upon the gap of comparisons & no. of exchanges.
 */
public class ShellSort {
	
	public void sort(int[] arr) {
	
		int j;
	    for(int gap = arr.length/2; gap > 0; gap /= 2) {
	    	
	    	for(int i = gap; i < arr.length; i++) {
	         
	    		int tmp = arr[i];
	    		for(j = i; j >= gap && (tmp < arr[j - gap]); j -= gap) {
	    			arr[ j ] = arr[ j - gap ];
	    		}
	    		arr[j] = tmp;
	        }
	    }
	}
}
