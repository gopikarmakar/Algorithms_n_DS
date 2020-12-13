package com.hyend.data.storage.search;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number/
 * 
 * Every element appears twice except for one. Find that single one.
 * 
 * Follow up: Could you implement a solution with a linear 
 * runtime complexity and without using extra memory?
 * 
 * @author gopi_karmakar
 */
public class FindSingleNumber {

	public static void main(String[] args) {
		
		int[] nums = {2, 2, 1};
		
		//int[] nums = {4, 1, 2, 1, 2};
		
		System.out.println("Single Number = " + find(nums));
		
		System.out.println("Single Number = " + find2(nums));
	}
	
	/**
	 * Accepted in Leetcode with memory usage
	 * less than 87% of all submissions
	 */
	private static int find(int[] nums) {
		
		Set<Integer> set = new HashSet<>();
		
		int sum = 0;
		
		for(int n : nums) {
			
			if(!set.contains(n)) {
				sum += n;
				set.add(n);
			}
			else sum -= n;
		}
		return sum;
	}
	
	/**
	 * Accepted in Leetcode with 1ms 95.06% runtime
	 * Doing the exact same thing as the above solution
	 * without any extra memory.
	 */
	private static int find2(int[] nums) {
		
		int num = 0;
		
		for(int n : nums) {
			
			num = num ^ n;			
		}
		
		return num;
	}
}