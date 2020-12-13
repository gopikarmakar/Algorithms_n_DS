package com.hyend.data.storage.arrays;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * 
 * Variant: Given an integer array nums, you need to  
 * find one continuous subarray that if you only sort 
 * this subarray in ascending order, then the whole
 * array will be sorted in ascending order.
 * 
 * @param args
 */
public class ShortestUnsortedContinuousSubArray {

	public static void main(String[] args) {
		
		int[] nums = {2};
		//int[] nums = {2, 6, 4, 8, 10, 9, 15};
		
		System.out.println("Total Length = " + find(nums));
	}
	
	/**
	 * Accepted in Leetcode with 1ms 100% runtime.
	 */
	private static int find(int[] nums) {
		
		int n = nums.length;
		
		/**
		 * start = -1 and end = -2
		 * for the cases like 
		 * nums = [] or nums = [1] return 0;
		 * then -2 - (-1) + 1 = -1 + 1 = 0;
		 */
		int start = -1, end = -2;
		
		int min = nums[n-1];
		int max = nums[0];
		
		for(int i = 1; i < n; i++) {
			
			max = Math.max(max,  nums[i]);
			
			if(nums[i] < max) end = i;
		}
		
		for(int i = n-2; i >= 0; i--) {
			
			min = Math.min(min,  nums[i]);
			
			if(nums[i] > min) start = i;
		}
		
		return end - start + 1;
	}
}
