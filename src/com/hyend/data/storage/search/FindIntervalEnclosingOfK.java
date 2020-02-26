package com.hyend.data.storage.search;

import java.util.Arrays;

/**
 * Find interval enclosing of K in a sorted list such that 
 * l is starting left and r is the ending right index of k.
 * For e.g: {1,2,2,4,4,4,7,11,11,11,11,11,13,14,15,15} k = 11  
 * return [7, 11] 
 * 
 * @author gopi_karmakar
 */
public class FindIntervalEnclosingOfK {

	public static void main(String[] args) {
		
		 int[] arr = {1,2,2,4,4,4,7,11,11,11,11,11,13,14,15,15};
		 findEnclosing(11, arr);
	}
	
	/**
	 * Finding the starting, left and right points all take O(log n) time.
	 * i.e the total time complexity is O(log n)
	 */
	private static void findEnclosing(int k, int...arr) {
		
		int start = Arrays.binarySearch(arr, k);
		
		int l = FindFirstOccurrenceOfKToTheLeft.find(arr, k, 0, start);
		
		int r = FindLastOccurrenceOfKToTheRight.find(arr, k, start, arr.length);
		
		System.out.println("l = " + l + " r = " + r);
	}
}
