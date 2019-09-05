package com.hyend.data.storage.search;

/**
 * A O(log n) Binary Search Solution
 * 
 * @author gopi_karmakar
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 3, 5, 8, 11, 13, 15, 19, 25};
		
		System.out.println("Found At Index = " + searchWithLessCompares(arr, 0, arr.length, 19));
	}

	private static int nonRecursiveSearch(int[] arr, int start, int end, int value) {
		
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
	
	private static int recursiveSearch(int[] arr, int start, int end, int value) {
		
		int mid = start + (end - start)/2;
		
		if(arr[mid] == value)		return mid;
		
		else if(arr[mid] < value)	start = mid;
		
		else 						end = mid;
		
		return recursiveSearch(arr, start, end, value);
	}
	
	private static int searchWithLessCompares(int[] arr, int start, int end, int value) {
		
		while((end - start) > 1) {
			
			int mid = start + (end - start)/2;
			if(arr[mid] <= value) 	start = mid;
			else 					end = mid;
		}
		return (arr[start] == value) ? start : -1;
	}
}
