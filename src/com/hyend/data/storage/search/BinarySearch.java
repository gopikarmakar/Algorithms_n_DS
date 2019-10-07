package com.hyend.data.storage.search;

/**
 * A O(log n) Binary Search Solution
 * 
 * @author gopi_karmakar
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 3, 5, 8, 11, 13, 15, 19, 25};
		
		System.out.println("Found At Index = " + iterativeSearch(19, arr));
		System.out.println("Found At Index = " + searchWithLessCompares(19, arr));
	}

	public static int iterativeSearch(int k, int...arr) {
		
		int start = 0;
		int end = arr.length;
		
		while(start <= end) {
			
			int mid = start + (end - start) / 2;
			
			if(arr[mid] == k) 	return mid;
			
			if(arr[mid] < k)	start = mid+1;				
			
			else					end = mid-1;
		}
		return -1;
	}
	
	public static int recursiveSearch(int[] arr, int start, int end, int k) {
		
		int mid = start + (end - start) / 2;
		
		if(arr[mid] == k)		return mid;
		
		else if(arr[mid] < k)	start = mid;
		
		else 						end = mid;
		
		return recursiveSearch(arr, start, end, k);
	}
	
	public static int searchWithLessCompares(int k, int...arr) {
		
		int start = 0;
		int end = arr.length;
		
		while((end - start) > 1) {
			
			int mid = start + (end - start)/2;
			
			if(arr[mid] <= k) 	start = mid;
			
			else 					end = mid;
		}
		return (arr[start] == k) ? start : -1;
	}
}
