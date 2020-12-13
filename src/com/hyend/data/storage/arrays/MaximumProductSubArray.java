package com.hyend.data.storage.arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * 
 * @author gopi_karmakar
 */
public class MaximumProductSubArray {

	public static void main(String[] args) {
		
		int[] nums = {2, 3, -2, 4};
		
		System.out.println("Max Product : " + maxProduct(nums));
	}
	
	/**
	 * Solution : Kadane's Algorithm
	 * 
	 * Accepted in Leetcode with 1ms 93.26% runtime
	 */
	private static int maxProduct(int[] nums) {
		
		int max = nums[0];
		int prevMax = nums[0];
		int prevMin = nums[0];
		
		for(int i = 1; i < nums.length; i++) {
			
			int current = nums[i];
			int temp = prevMax;
			
			prevMax = Math.max(current, Math.max(current * prevMax, current * prevMin));
			prevMin = Math.min(current, Math.min(current * temp, current * prevMin));
			max = Math.max(max, Math.max(prevMax, prevMin));
		}
		return max;
	}
}
