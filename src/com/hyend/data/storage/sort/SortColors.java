package com.hyend.data.storage.sort;

/**
 * A Facebook Interview Question
 * 
 * https://leetcode.com/problems/sort-colors/
 * 
 * Given an array nums with n objects colored 
 * red, white, and blue, sort them in-place so that 
 * objects of the same color are adjacent, with the colors 
 * in the order red, white, and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to 
 * represent the color red, white, and blue respectively.
 * 
 * Follow up:
 * Could you solve this problem without using the library's sort function?
 * Could you come up with a one-pass algorithm using only O(1) constant space?
 * 
 * @author gopi_karmakar
 */
public class SortColors {

	public static void main(String[] args) {
			
		int[] nums = {2,0,2,1,0,1};
		//int[] nums = {2,0,1};
		//int[] nums = {1};
		//int[] nums = {0};
		
		sort(nums);
		
		for(int e : nums)
			System.out.println(e);
	}
	
	private static void sort(int[] nums) {
		
		int l = 0, r = nums.length-1;
		
		for(int i = 0; i <= r; i++) {
			
			if(nums[i] == 0) {
				
				nums[i] = nums[l];
				nums[l++] = 0;
			}
			else if(nums[i] == 2) {
				
				nums[i--] = nums[r];
				nums[r--] = 2;
			}
		}
	}
}
