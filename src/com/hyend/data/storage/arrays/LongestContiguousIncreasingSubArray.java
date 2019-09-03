package com.hyend.data.storage.arrays;

import java.util.Arrays;

/**
 * Find longest contiguous increasing sub array
 * for e.g: {2,11,3,5,13,7,19,17,23} return indices {2,4} 
 * 
 * @author gopi_karmakar
 */
public class LongestContiguousIncreasingSubArray {

	public static void main(String[] args) {
						
		int[] arr = {2,11,3,5,13,7,19,17,23};
		SubArray sa = find(arr);
		
		System.out.print("{");
		for(int x : Arrays.copyOfRange(arr, sa.start, sa.end+1))			
			System.out.print(x + ", ");
		System.out.print("}");
	}	
	
	private static class SubArray {
		
		int start;
		int end;
		public SubArray(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {			
			return "{"+start + ", "+end+"}";
		}
	}
	
	/**
	 * An efficient O(n) time complexity solution.
	 * 
	 * @param arr
	 * @return
	 */
	private static SubArray find(int...arr) {
	
		int i = 0, maxLength = 1;
		SubArray indices = new SubArray(0, 0);
		
		while(i < arr.length-maxLength) {
			
			boolean skippable = false;
			
			for(int j = i+maxLength; j > i; --j) {
				
				if(arr[j-1] > arr[j]) {
					i = j;
					skippable = true;
					break;
				}
			}
			
			if(!skippable) {
				i += maxLength;
				while(i < arr.length && arr[i-1] < arr[i]) {
					++i;
					++maxLength;
				}
				indices = new SubArray(i-maxLength, i-1);
			}
		}
		return indices;
	}
}
