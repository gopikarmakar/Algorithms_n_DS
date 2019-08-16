package com.hyend.logical.algorithms.dp;

import java.util.Arrays;

/**
 * Find if there're two values in the given array
 * which adds up to a given sum!  
 * 
 * @author gopi_karmakar
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		
		int[] arr = {3, -1, -2, 5, 7, 4};
		Arrays.sort(arr);
		
		System.out.println(hasTwoSum(13, arr));
	}
	
	/**
	 * A very efficient algorithm:
	 * Time taken for sort is O(n)Log(n)
	 * Time complexity for algorithm is O(n)
	 * Total time complexity is O(n) with O(1) extra space.
	 * 
	 * @param sum
	 * @param arr
	 * @return
	 */
	public static boolean hasTwoSum(int sum, int...arr) {				
		
		int i = 0, j = arr.length-1;
		
		while(i <= j) {
			
			if((arr[i] + arr[j]) == sum) 		return true;						
			else if((arr[i] + arr[j]) < sum) 	i++;
			else 								j--;
		}
				
		return false;
	}
}
