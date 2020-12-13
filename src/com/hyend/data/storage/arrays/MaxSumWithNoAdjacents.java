package com.hyend.data.storage.arrays;

/**
 * Amazon interview question
 * 
 * Below Leetcode problem is a variant of the same problem.
 * 
 * https://leetcode.com/problems/house-robber/
 * 
 * Find maximum sum such that no two elements are adjacent
 * For e.g: 
 * {3, 2, 7, 10} = 3 + 10 = return 13
 * {3, 2, 5, 10, 7} = 3 + 5 + 7 = return 15
 * {1, 20, 3} = return 20
 * 
 * @author gopi_karmakar
 */
public class MaxSumWithNoAdjacents {

	public static void main(String[] args) {
		
		//int[] arr = {5, 5, 10, 100, 10, 5};
		//int[] arr = {3, 2, 7, 10};
		//int[] arr = {3, 2, 5, 10, 7};
		//int[] arr = {1, 2, 3, 1};
		int[] arr = {2, 7, 9, 3, 1};
		
		System.out.println("Max Sum With No Two Adjacent = " + findMax(arr));
	}
	
	/**
	 * Accepted in Leetcode with 0ms 100% runtime
	 * 
	 * O(n) Time complexity.
	 */
	private static int findMax(int...arr) {
		
		if(arr.length == 0) return 0;
		if(arr.length == 1) return arr[0];
		
		int pre1 = -1, pre2 = arr[0], pre3 = arr[1];
		
		for(int i = 2; i < arr.length; i++) {
			
			int max = 0;
			
			if(pre1 >= 0) {
				max = Math.max(pre1, pre2);
			}
			else {
				max = pre2;
			}
			
			pre1 = pre2;
			pre2 = pre3;
			pre3 = max + arr[i];
		}
		
		return Math.max(pre3, pre2); 
	}
}