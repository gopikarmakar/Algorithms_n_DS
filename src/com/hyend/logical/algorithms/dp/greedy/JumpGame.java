package com.hyend.logical.algorithms.dp.greedy;

/**
 * https://leetcode.com/problems/jump-game/
 * 
 * Given an array of non-negative integers, you are 
 * initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump 
 * length at that position. Determine if you are able to 
 * reach the last index.
 * 
 * @author gopi_karmakar
 */
public class JumpGame {

	public static void main(String[] args) {
		
		int[] nums = {2, 3, 1, 1, 4};
		//int[] nums = {3, 2, 1, 0, 4};
		
		System.out.println(canJump(nums));
	}
	
	
	/**
	 * Accepted in Leetcode with 0ms 100% runtime.
	 */
	private static boolean canJump(int[] nums) {
		
		int lastIndex = nums.length-1;
		
		for(int i = nums.length-1; i >=0; i--) {
			
			if(i + nums[i] >= lastIndex)
				lastIndex = i;
		}
		
		return lastIndex == 0;
	}
}
