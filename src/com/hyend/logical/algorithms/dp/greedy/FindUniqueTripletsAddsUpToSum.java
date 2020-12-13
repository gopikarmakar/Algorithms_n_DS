package com.hyend.logical.algorithms.dp.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * Given an array and a sum value, find all possible unique triplets 
 * in that array which adds up to the given sum value.
 * 
 * NOTE: The triplets shouldn't repeat
 * 
 * @author gopi_karmakar
 */
public class FindUniqueTripletsAddsUpToSum {

	public static void main(String[] args) {
		
		int sum = 0;
		//int[] arr = {12, 3, 6, 1, 6, 9};
		//int[] arr = {-2, 0, 1, 1, 2};
		//int[] arr = {0, -1, 2, -3, 1};
		
		//int[] arr = {-1, 0, 1, 2, -1, -4};
		
		int[] arr = {0, 0, 0};
		
		List<List<Integer>> list = triplets(sum, arr);
		
		if(!list.isEmpty()) {
			System.out.println(list);
		}
		else {
			System.out.println("No Triplets Found for " + sum);
		}
	}
	
	/**
	 * Time taken to sort is 0(n Log n),
	 * Total time complexity is 0(n^2) with O(1) extra space.
	 */
	public static List<List<Integer>> triplets(int target, int...arr) {
		
		Arrays.sort(arr);
		
		Set<List<Integer>> triplets  = new HashSet<>();
				
		int l, r, n = arr.length;
		for(int i = 0; i <= n-3; i++) {
			
			l = i+1;
			r = n-1;
			while(l < r) {
				
				int sum = arr[i] + arr[l] + arr[r];
				if(sum == target) {
					
					triplets.add(Arrays.asList(arr[i], arr[l++], arr[r--]));																

				}
				else if(sum < target) 	l++;
				else					r--;
			}
		}
		return new ArrayList<>(triplets);
	}
}
