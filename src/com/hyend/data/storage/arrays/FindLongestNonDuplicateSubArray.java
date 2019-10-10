package com.hyend.data.storage.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Find longest sub array containing all unique entries.
 *   
 * @author gopi_karmakar
 */
public class FindLongestNonDuplicateSubArray {

	public static void main(String[] args) {
		int[] arr = {5, 3, 1, 5, 4, 2, 6, 3, 7, 8, 4, 1};
		
		SubArray subArray = find(arr);
		
		for(int x : Arrays.copyOfRange(arr, subArray.start, subArray.end-1))
			System.out.println(x);
	}	
	
	private static class SubArray {
		
		int start = 0;
		int end = 0;
		public SubArray(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	/**
	 * The time complexity is O(n), 
	 * since we perform a constant number of operations per element.
	 */
	private static SubArray find(int...arr) {
		
		int longestDupFreeIdx = 0, maxLength = 0, n = arr.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < n; ++i) {
			
			Integer dupIdx = map.put(arr[i], i);
			if(dupIdx != null) {				
				if(dupIdx >= longestDupFreeIdx) {					
					maxLength = Math.max(maxLength, i - longestDupFreeIdx);
					longestDupFreeIdx = dupIdx + 1;
				}
			}				
		}
		
		maxLength = Math.max(maxLength, n - longestDupFreeIdx);
		
		return new SubArray(longestDupFreeIdx, longestDupFreeIdx + maxLength);
	}
}
