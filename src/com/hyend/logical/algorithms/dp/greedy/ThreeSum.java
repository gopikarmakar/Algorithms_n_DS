package com.hyend.logical.algorithms.dp.greedy;

import java.util.Arrays;

/**
 * Find if there're three values in the given array
 * which adds up to a given sum (not necessarily be unique/distinct)
 * 
 * Variant: Find all unique/distinct triplets which adds up to a sum. 
 * 
 * @author gopi_karmakar
 */
public class ThreeSum {
	
	public static void main(String[] args) {
		
		int[] arr = {11, 2, 5, 7, 3};
		System.out.println(hasThreeSum(22, arr));
	}

	/**
	 * Time taken to sort is 0(n Log n),
	 * and then to run the 0(n) algorithm to find a pair 
	 * in a sorted array that sums to a specified value, 
	 * 
	 * Total time complexity is 0(n^2) with O(1) extra space. 
	 */
	public static boolean hasThreeSum(int sum, int...arr) {
		
		Arrays.sort(arr);
		
		for(int x : arr) {
			
			if(TwoSum.hasTwoSum(sum-x, arr))
				return true;
		}
		return false;
	}
}