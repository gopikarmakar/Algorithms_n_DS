package com.hyend.logical.algorithms;

import java.util.Arrays;

/**
 * Google Bangalore interview question
 * 
 * Solution: Minimum number of swaps required for arranging pairs adjacent to each other.
 * 
 * @author gopi_karmakar
 */
public class MinimumSwaps {

	void adjacentPaisArray(int[] arr, int[] pairs) {
	    int minSwaps = 0;
	    for(int i=0; i<arr.length/2; i=i+2) {
	        
	        int pair = pairs[arr[i]-1];
	        
	        if(arr[i+1] != pair) {
	            
	            System.out.println("Searching for item " + pair );
	            //we have to find index of pair & swap it with i+1
	            int index = findIndexOf(pair, i+1, arr);
	            
	            if(index != -1) {
	                //swap
	                System.out.println("Swapping " + arr[i+1] + "  with  " + arr[index]);
	                int temp = arr[i+1];
	                arr[i+1] = arr[index];
	                arr[index] = temp;
	                minSwaps++;
	            }
	        }	        	        
	    }	    
	    System.out.println(Arrays.toString(arr));
	    System.out.println("Min swaps required are " + minSwaps);
	}
	
	private int findIndexOf(int searchItem, int start, int[] arr) {
	    for(int i=start; i<arr.length; i++) {
	        if(arr[i] == searchItem) {
	            System.out.println("Index of " + searchItem + "  is " + i);
	            return i;
	        }
	    }
	    return -1;
	}
}
