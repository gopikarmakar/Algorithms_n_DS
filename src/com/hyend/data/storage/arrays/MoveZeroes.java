package com.hyend.data.storage.arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 * 
 * @author gopi_karmakar
 */
public class MoveZeroes {

	public static void main(String[] args) {
		
		int[] nums = {0, 1, 0, 3, 12};

		move(nums);
		
		for(int e : nums)
			System.out.println(e);
	}
	
	// {0, 1, 0, 3, 12}
	private static void move(int[] nums) {
		
		int left = 0;
		for(int i = 0; i < nums.length && left < nums.length; i++) {
			
			if(nums[i] != 0) {
			
				swap(nums, left++, i);
			}			
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
	
		int x = nums[i];
		nums[i] = nums[j];
		nums[j] = x;
	}
}
