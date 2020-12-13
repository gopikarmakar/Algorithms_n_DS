package com.hyend.data.storage.arrays;

/**
 * A Google interview question
 * 
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * @author gopi_karmakar
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 4};
		
		for(int n : product(nums)) {
			System.out.print(n + " ");
		}
	}
	
	/**
	 * Accepted in Leetcode.
	 * O(n) runtime and O(1) space complexity.
	 */
	private static int[] product(int[] nums) {
		
		int[] result = new int[nums.length];
		
		for(int i = 0, temp = 1; i < nums.length; i++) {
			
			result[i] += temp;
			temp *= nums[i]; 
		}
		
		for(int i = nums.length-1, temp = 1; i >= 0; i--) {
			
			result[i] *= temp;
			temp *= nums[i];
		}
		
		return result;
	}
}
