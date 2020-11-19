package com.hyend.logical.algorithms.dp.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 * 
 * Given n and k, return the kth permutation sequence
 * 
 * @author gopi_karmakar
 */
public class PermutationSequence {

	public static void main(String[] args) {
		
		List<Integer> nums = new ArrayList<>();
		
		int n = 4, k = 9;
		for(int i = 1; i <= n; i++) {
			nums.add(i);
		}
		
		while(--k > 0) {
			permutation(nums);
		}		

		System.out.println(nums.toString());
	}
	
	private static void permutation(List<Integer> nums) {
	
		if(nums.size() < 2) return;
		
		 int k = nums.size() - 2;
		 
		 while(k >= 0 && nums.get(k) >= nums.get(k+1)) k--;
		 
		 if(k >= 0) {
			 
			 for(int i = nums.size()-1; i > k; --i) {
				 
				 if(nums.get(i) > nums.get(k)) {
					 Collections.swap(nums, i, k);
					 break;
				 }
			 }
			 Collections.reverse(nums.subList(k+1, nums.size()));
		 }
	}
}
