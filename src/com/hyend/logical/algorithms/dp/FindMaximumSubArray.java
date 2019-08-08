package com.hyend.logical.algorithms.dp;

/**
 * Find the maximum sum of a sub array among 
 * all sub arrays of a given array.  
 * 
 * @author gopi_karmakar
 *
 */
public class FindMaximumSubArray {

	public static void main(String[] args) {
		int[] arr = {904, 40, 523, 12, -335, -385, -124, 481, -31};
		System.out.println("Maximum Sum = " + findMaximum(arr));
	}
	
	/**
	 * A very efficient O(n) solution
	 * with constant space
	 * 
	 * @param arr
	 * @return
	 */
	private static int findMaximum(int...arr) {
		
		int minSum = 0, sum = 0, maxSum = 0;
		
		for(int i = 0; i < arr.length; ++i) {
			
			sum += arr[i];
			
			if(sum < minSum) {
				minSum = sum;				
			}
			if(sum > maxSum) {
				maxSum = sum - minSum;
			}
		}
		
		return maxSum;
	}
}
