package com.hyend.logical.algorithms.dp.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array and a sum value, find all possible unique triplets 
 * in that array which adds up to the given sum value.
 * 
 * @author gopi_karmakar
 */
public class FindTripletsAddsUpToSum {

	public static void main(String[] args) {
		
		int sum = 0;
		//int[] arr = {12, 3, 6, 1, 6, 9};
		//int[] arr = {-2, 0, 1, 1, 2};
		int[] arr = {0, -1, 2, -3, 1};
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
	public static List<List<Integer>> triplets(int sum, int...arr) {
		
		Arrays.sort(arr);
		List<List<Integer>> list = new ArrayList<>();
				
		int l, r, n = arr.length;
		for(int i = 0; i < n-3; i++) {
			
			l = i+1;
			r = n-1;
			while(l < r) {
				
				int v = arr[i] + arr[l] + arr[r];
				if(v == sum) {
					
					List<Integer> ll = new ArrayList<>();
					
					ll.add(arr[i]); ll.add(arr[l]); ll.add(arr[r]);
					
					list.add(ll);
					
					l++;
					r--;
				}
				else if(v < sum) 	l++;
				else				r--;
			}
		}
		return list;
	}
}
