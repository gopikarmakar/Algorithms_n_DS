package com.hyend.logical.algorithms.dp;

import java.util.Arrays;

/**
 * Find the maximum sum over all sub arrays of a given array of integer.
 * 
 * Solution : Kadane's Algorithm
 * 
 * @author gopi_karmakar
 *
 */
public class FindMaximumSubArraySum {

	public static void main(String[] args) {
		//int[] arr = {};
		
		//int[] arr = {904, 40, 523, 12, -335, -385, -124, 481, -31};
		
		int[] arr = {-904, -40, -523, -12, -335, -385, -124, -481, -31};
		
		//int[] arr = {-904, -40, -523, -12, -335, -385, -124, -481, -31, 1};
		
		//int[] arr = {904, 40, 523, 12, 335, 385, 124, 481, 31, 1};
		
		System.out.println("Maximum Sum = " + findMSS(arr));
	}
	
	/**
	 * Kadane's Algorithm Solution
	 * A very efficient O(n) solution with constant space	 
	 * The algorithm handles all -ve values and an empty array too! 
	 * 
	 * @param arr
	 * @return
	 */
	private static int findMSS(int...arr) {
		
		int sum = 0, minSum = 0, maxSum = 0, startIndex = 0, endIndex = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			sum += arr[i];
						
			if(sum < minSum) {
				minSum = sum;				
			}
			if((sum - minSum) > maxSum) {
				if(maxSum == 0)
					startIndex = i;				
				
				endIndex = i;				
				maxSum = sum - minSum;				
			}
		}		
		System.out.println("Start Index = " + startIndex);
		System.out.println("End Index = " + endIndex);
		
		if(maxSum > 0) {
			System.out.print("\nSub Array = ");		
			for(int x : Arrays.copyOfRange(arr, startIndex, endIndex+1))
				System.out.print(x + ",");
		}
		
		System.out.print("\n");
		return maxSum;
	}
}
