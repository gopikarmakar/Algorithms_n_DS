package com.hyend.data.storage.arrays;

import java.util.Arrays;

/**
 * Given an array of integers, we need to find the maximum possible 
 * sum of elements of the array such that it is divisible by three.
 * 
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/
 * 
 * @author gopi_karmakar
 */
public class GreatestSumDivisibleByThree {

	public static void main(String[] args) {
		
		//int[] arr = {4};
		
		int[] arr = {3, 6, 5, 1, 8};
		
		//int[] arr = {1, 2, 3, 4, 4};
		
		System.out.println(find(arr));
		
		//System.out.println(find(arr));
	}
	
	/**
	 * An O(n ^ 2) time complexity solution.
	 */
	private static int find(int...arr) {
		
		int sum = sum(arr);
		
		if(sum % 3 == 0)
			return sum;
		
		int max = 0;
		
		for(int i = 0; i < arr.length; ++i) {
			
			sum = 0;
			
			for(int j = 0; j < arr.length; ++j) {
				
				if(j == i)
					continue;
				
				sum += arr[j];
			}
			
			if(sum > max && (sum % 3) == 0) {
				
				max = sum;				
			}			
		}		
		return max;
	}
	
	/**
	 * Same O(n ^ 2) time complexity solution but inefficient in terms of space complexity. 
	 */
	private static int find2(int...arr) {
		
		int sum = sum(arr);
		
		if(sum % 3 == 0)
			return sum;
		
		int max = 0;
		
		for(int i = 0; i < arr.length; ++i) {
			
			int sum1 = sum(Arrays.copyOfRange(arr, 0, i));
			int sum2 = sum(Arrays.copyOfRange(arr, i+1, arr.length));
			
			if((sum1 + sum2) > max && (sum1 + sum2) % 3 == 0) {
				
				max = sum1 + sum2;
			}
		}		
		return max;
	}
	
	private static int sum(int...subArray) {
		
		int sum = 0;
		
		for(int x : subArray) {
			
			sum += x; 
		}
		return sum;
	}
}
