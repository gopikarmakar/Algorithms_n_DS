package com.hyend.data.storage.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Given an integer array nums, find the contiguous subarray 
 * (containing at least one number) which has the largest sum 
 * and return its sum.
 * 
 * @author gopi_karmakar
 */
public class MaximumSubArraySum {

	public static void main(String[] args) {
		
		//int[] nums = {-1};
		//int[] nums = {-2, -3, -6, -5, -4};
		//int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int[] nums = {-2, -5, 6, -2, -3, 1, 5, -6};
		
		System.out.println(maxSum(nums));
	}
	
	/**
	 * Solution: Kadane's Algorithm
	 * A very efficient O(n) solution with constant space	 
	 * The algorithm handles all -ve values and an empty array too!
	 * Accepted in leetcode
	 */
	private static int maxSum(int[] nums) {
		
		int max = Integer.MIN_VALUE, sum = 0;
		
		for(int n : nums) {
			
			sum += n;			
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);			
		}
		return max;
	}
	
	/**
	 * Solution-2: Kadane's Algorithm Solution
	 * This solution will show sub array elements too.
	 */
	private static int findMSS(int...arr) {
		
		int sum = 0, minSum = 0, maxSum = 0, startIndex = 0, endIndex = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			sum += arr[i];
						
			if(sum < minSum) {
				minSum = sum;				
			}
			int x = sum - minSum;
			if(x > maxSum) {
				if(maxSum == 0)
					startIndex = i;				
				
				endIndex = i;
				maxSum = x;
			}
		}		
		//System.out.println("Start Index = " + startIndex);
		//System.out.println("End Index = " + endIndex);
		
		if(maxSum > 0) {
			System.out.print("\nSub Array = ");		
			for(int x : Arrays.copyOfRange(arr, startIndex, endIndex+1))
				System.out.print(x + ",");
		}
		
		System.out.print("\n");
		return maxSum;
	}
}
