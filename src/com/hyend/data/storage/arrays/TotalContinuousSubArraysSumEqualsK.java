package com.hyend.data.storage.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * Given an array of integers. Count total no. of subarrays
 * whose sum equals K
 * 
 * For e.g: arr = {1, 2, 3} k = 3 then return 2
 * Sum of {1, 2} and {3} are equals k.
 * 
 * @author gopi_karmakar
 */
public class TotalContinuousSubArraysSumEqualsK {

	public static void main(String[] args) {
		
		//int[] arr = {1, 1, 1};
		//int k = 2
		
		int[] arr = {1, 2, 3};
		int k = 3;
		
		System.out.println("Total = " + totalSubArrays(arr, k) + " Sub Arrays");
	}
	
	/**
	 * Accepted in Leetcode
	 */
	private static int totalSubArrays(int[] arr, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		
		int count = 0, sum = 0;
		
		for(int n : arr) {
			
			sum += n;
			
			if(map.containsKey(sum - k))
				count += map.get(sum - k);
			
			int x = map.getOrDefault(sum, 0) + 1;
			map.put(sum, x);
		}
		return count;
	}
}
