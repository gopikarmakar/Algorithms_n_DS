package com.hyend.data.storage.structures.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * 
 * @author gopi_karmakar
 */
public class TwoSum {

	public static void main(String[] args) {
		
		//int[] nums = {2, 7, 11, 15};
		//int target = 9;
		
		int[] nums = {3, 2, 4};
		int target = 6;
		
		for(int x : twoSum(6, nums)) {
			System.out.println(x);
		}
	}
	
	/**
	 * Single pass O(n) time complexity;
	 */
	private static int[] twoSum(int target, int...nums) {

		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			
			if(!map.containsKey(target - nums[i]))
				map.put(nums[i], i);
			else 
				return new int[] {map.get(target - nums[i]), i};
		}
		return new int[] {}; 
	}
	
	/**
	 * O(n^2) solution
	 */
	private static int[] twoSum2(int target, int[] nums) {
		
		for(int i = 0; i < nums.length; i++) {
			
            for(int j = i+1; j < nums.length; j++) {
                
            	int sum = nums[i]+nums[j];
                
                if(sum == target) {

                    return new int[] {i, j};
                }
            }
        }
		// In case, no sum matches with target value
        return new int[] {};
	}
}
