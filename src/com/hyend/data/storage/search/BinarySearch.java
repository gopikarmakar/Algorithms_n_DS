package com.hyend.data.storage.search;

public class BinarySearch {

	public int nonRecursiveSearch(int[] arr, int start, int end, int value) {
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			if(arr[mid] == value) return mid+1; // To give the real 
			
			if(arr[mid] <= value)
				start = mid+1;				
			else
				end = mid-1;
		}
		return -1;
	}
	
	public int searchWithLessCompares(int[] arr, int start, int end, int value) {
		
		while((end - start) > 1) {
			
			int mid = start + (end - start)/2;
			if(arr[mid] <= value) 	start = mid;
			else 					end = mid;
		}
		return (arr[start] == value) ? start : -1;
	}
	
	public int recursiveSearch(int[] arr, int start, int end, int value) {
		
		int mid = start + (end - start)/2;
		
		if(arr[mid] == value)		return mid;
		
		else if(arr[mid] < value)	start = mid;
		
		else 						end = mid;
		
		return recursiveSearch(arr, start, end, value);
	}
}
