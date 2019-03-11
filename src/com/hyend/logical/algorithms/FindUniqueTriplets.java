package com.hyend.logical.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all unique triplets that sums up to zero.
 * 
 * @author gopi_karmakar
 *
 */
public class FindUniqueTriplets {
	
	/**
	 * Time complexity will be O(n)(nLogn) 
	 * where n of O(n) will be from i=0 to length of the array
	 * n(log(n)) will be i+1 to n-2 for each i++ < n
	 * @param arr
	 * @return
	 */
	public List<List<Integer>> getUniqueTriplets(int[] arr) {
		
		int n = arr.length;
		
		if(n < 3) return null;

		List<List<Integer>> triplets = new ArrayList<List<Integer>>();

		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {

			for(int j = n-1; j > i; j--) {
				
				int find = arr[i]+arr[j];
				if(find < 0)
					find = -(find);
				else find = -(find);
				
				int index = find(arr, i+1, j, find);
				
				if(index != -1) {					
					if((arr[j] != arr[i]) && (arr[index] != arr[i]) && (arr[index] != arr[j])) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[index]);
						triplets.add(list);
					}
				}				
			}
		}
		return triplets;
	}
	
	private int find(int[] arr, int l, int r, int x) {
		while (l <= r) { 
	        int m = l + (r - l) / 2; 
	  
	        // Check if x is present at mid 
	        if (arr[m] == x) 
	            return m; 
	  
	        // If x greater, ignore left half 
	        if (arr[m] < x) 
	            l = m + 1; 
	  
	        // If x is smaller, ignore right half 
	        else
	            r = m - 1; 
	    } 
	  
	    // if we reach here, then element was 
	    // not present 
	    return -1; 
	}
	
	/**
	 * This solution will take O(n^2) time complexity.
	 * @param arr
	 * @return
	 */
	public List<List<Integer>> getTriplets(int[] arr) {
		
		int n = arr.length;
		
		if(n < 3) return null;
		
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();		  	    	 	   
	    
	    // sort array elements 
	    Arrays.sort(arr); 
	    
	    for (int i=0; i < n-1; i++) 
	    { 
	        // initialize left and right 
	        int l = i + 1; 
	        int r = n - 1; 
	        int x = arr[i]; 
	        while (l < r) 
	        { 
	            if (x + arr[l] + arr[r] == 0) 
	            { 
	                // print elements if it's sum is zero
	            	List<Integer> list = new ArrayList<Integer>();
	            	list.add(x);
	            	list.add(arr[l]);
	            	list.add(arr[r]);
	            	triplets.add(list);
	                l++; 
	                r--;  
	            } 
	  
	            // If sum of three elements is less 
	            // than zero then increment in left 
	            else if (x + arr[l] + arr[r] < 0) l++; 
	  
	            // if sum is greater than zero than 
	            // decrement in right side 
	            else r--; 
	        } 
	    } 
	    return triplets;
	}
}
