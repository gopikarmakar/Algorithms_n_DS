package com.hyend.data.storage.arrays;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
 * https://leetcode.com/problems/permutations-ii/
 * 
 * Asked by Google, Microsoft and FaceBook
 * 
 * Compute all unique permutations, when the given array 
 * may have duplicates but the Permutations shouldn't repeat.
 * For e.g: [2,2,3,0] = {0,2,2,3}, {0,2,3,2}, {0,3,2,2}, {2,0,2,3},
 * {2,0,3,2}, {2,2,0,3}, {2,2,3,0}, {2,3,0,2}, {2,3,2,0}, {3,0,2,2},
 * {3,2,0,2}, {3,2,2,0}
 * 
 * @author gopi_karmakar
 */
public class ComputeAllUniquePermutations {

	public static void main(String[] args) {
		
		//Integer[] arr = {1, 1};
		Integer[] arr = {1, 1, 2};
		//Integer[] arr = {2,2,3,0};		
		
		for(List<Integer> perm : uniquePermutations(Arrays.asList(arr))) {
			System.out.println(perm);
		}		
	}
	
	/**
	 * The time complexity is O(n X n!), since there are n! 
	 * permutations and we spend O(n) time to store each one.
	 * 
	 * @param perm
	 * @return
	 */
	private static List<List<Integer>> uniquePermutations(List<Integer> perm) {
		
		List<List<Integer>> perms = new ArrayList<List<Integer>>();		
		
		Collections.sort(perm);
		do {
			//Adding first permutation
			perms.add(new ArrayList<>(perm));
			perm = nextPermutation(perm);
			
		} while(!perm.isEmpty());
		return perms;
	}
	
	public static List<Integer> nextPermutation(List<Integer> nums) {
		
		int k = nums.size()-2;			
		while(k >= 0 && (nums.get(k) >= nums.get(k+1))) {
			k--;
		}
		if(k < 0) {
			return Collections.emptyList();
		}
		for(int i = nums.size()-1; i > k; --i) {
			
			if(nums.get(i) > nums.get(k)) {
				Collections.swap(nums, i, k);
				break;
			}
		}		
		Collections.reverse(nums.subList(k+1, nums.size()));
		return nums;
	}
}
