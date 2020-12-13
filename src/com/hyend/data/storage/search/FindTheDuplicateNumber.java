package com.hyend.data.storage.search;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Given an array of integers find the duplicate number within the array.
 * Assume that there is only one duplicate number. 
 * 
 * Note: 
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n^2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * 
 * @author gopi_karmakar
 */
public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		
		int[] arr = {1, 3, 4, 2, 2};
		//int[] arr = {3, 1, 3, 4, 2};
		//int[] arr = {1, 2, 2};
		
		System.out.println(findDuplicate(arr));
		
		//System.out.println(find(arr));
	}	
	
	/**
	 * An efficient O(n) solution 
	 */
	public static int findDuplicate(int[] nums) {
    
	 	for(int i = 0; i < nums.length; i++) {
	 		
	 		int index = Math.abs(nums[i]);
	 		
	 		nums[index] = -nums[index];
	 		
	 		if(nums[index] > 0) return index;
	 	}
	 	return 0;
    }
	 
	 /**
	 * Time complexity is O(n/2) ^ 2 
	 */
	private static int find(int[] nums) {		
		
		int res = 0, m = nums.length-1, n = m/2;		
		
		if(nums[0] == nums[n] || nums[0] == nums[m] || nums[m] == nums[n])
			return nums[n];
			
		for(int i = 0; i < n; ++i) {
			
			for(int j = 0; j < n; ++j) {
				
				if(nums[i] == nums[j] && i != j) { 	
					return nums[i];
				}
				else if(nums[m-i] == nums[m-j] && m-i != m-j) {
					return nums[m-i];
				}
				else if(nums[i] == nums[m-j]) {
					return nums[i];
				}
				else if(nums[m-i] == nums[j]) {
					return nums[m-i];
				}
			}
		}		
		return res;
	}
}
