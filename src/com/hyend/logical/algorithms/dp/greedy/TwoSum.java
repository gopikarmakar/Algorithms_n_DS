package com.hyend.logical.algorithms.dp.greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * Find if there're two values in the given array
 * which adds up to a given sum!  
 * 
 * @author gopi_karmakar
 */
public class TwoSum {

	public static void main(String[] args) {
				
		int[] arr = {3, -1, -2, 5, 7, 4};
		
		// In case if array is not sorted.
		Arrays.sort(arr);
		
		System.out.println(hasTwoSum(13, arr));
	}
	
	/**
	 * A very efficient algorithm:
	 * Time taken for sort is O(n)Log(n)
	 * Time complexity for algorithm is O(n)
	 * Total time complexity is O(n) with O(1) extra space.
	 * 
	 * @param sum
	 * @param arr
	 * @return
	 */
	public static boolean hasTwoSum(int sum, int...arr) {				
		
		int i = 0, j = arr.length-1;
		
		while(i <= j) {
			
			if((arr[i] + arr[j]) == sum) 		return true;						
			else if((arr[i] + arr[j]) < sum) 	i++;
			else 								j--;
		}
				
		return false;
	}
}
