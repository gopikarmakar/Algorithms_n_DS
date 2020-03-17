package com.hyend.data.storage.arrays;

/**
 * Google Interview Question
 * 
 * Given an array of 0s and 1s, find the longest 1s  
 * after changing 0s to 1s up to K.
 * 
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 * 
 * @author gopi_karmakar
 */
public class MaxConsecutiveOnesByFlippingKZeroes {

	public static void main(String[] args) {
		
		int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
		//int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		
		System.out.println(find(arr, 2));
	}
	
	private static int find(int[] arr, int k) {
		
		int maxLength = 0, zeroCount = 0, start = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] == 0) zeroCount++;
			
			while(zeroCount > k) {
				
				if(arr[start++] == 0) zeroCount--;
			}
			
			maxLength = Math.max(maxLength, i - start + 1);
		}
		return maxLength;
	}
}
