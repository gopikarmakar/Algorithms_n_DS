package com.hyend.data.storage.arrays;

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
public class FindUniqueTripletsAddsUpToSum {

	public static void main(String[] args) {
		
		int sum = 0;
		//int[] arr = {12, 3, 6, 1, 6, 9};
		//int[] arr = {-2, 0, 1, 1, 2};
		int[] arr = {0, -1, 2, -3, 1};
		List<LinkedList<Integer>> list = uniqueTriplets(sum, arr);
		
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
	public static List<LinkedList<Integer>> uniqueTriplets(int sum, int...arr) {
		
		Arrays.sort(arr);
		List<LinkedList<Integer>> list = new ArrayList<>();
				
		int l, r, n = arr.length;
		for(int i = 0; i < n-2; i++) {
			
			l = i+1;
			r = n-1;
			while(l < r) {
				
				int v = arr[i] + arr[l] + arr[r];
				if(v == sum) {
					LinkedList<Integer> ll = new LinkedList<>();
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
