package com.hyend.data.storage.arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * Solution: Find the longest nondecreasing subsequence
 * from a given array 
 * 
 * @author gopi_karmakar
 */
public class LongestNonDecreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {0,8,4,12,2,10,6,14,1,9};
		System.out.println("Maximum Length = " + findSubSequence(arr));		
	}
	
	/**
	 * There are some longest non decreasing sub sequences are
	 * {0,8,12,14} {0,8,10,14} {0,4,12,14} {0,4,10,14} 
	 * {0,4,6,9} {0,2,10,14} {0,2,6,9} {0,12,14} {0,10,14} {0,6,9} etc.
	 * 
	 * therefore the longest subsequence length is 4 so should return 4.
	 * 
	 * The time complexity is O(n)^2 time complexity with O(n) extra space.
	 * 
	 * The time complexity can be reduced to O(n)Log(n) with Binary Search 
	 *  
	 * @param arr
	 */
	private static int findSubSequence(int...arr) {
		
		Integer[] lss = new Integer[arr.length];
		
		Arrays.fill(lss, 1);
		
		for(int i = 1; i < arr.length; ++i) {
			
			for(int j = 0; j < i; ++j) {
				
				if(arr[i] >= arr[j]) {
					lss[i] = Math.max(lss[i], lss[j]+1);
				}				
			}
		}
		return Collections.max(Arrays.asList(lss));
	}
}
