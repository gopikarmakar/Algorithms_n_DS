package com.hyend.data.storage.arrays;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * Return the next permutation for a given
 * permutation under dictionary ordering.
 * 
 * For e.g: if the input is [1,0,3,2] 
 * function should return [1,2,0,3]. 
 * If the permutation is the last permutation, return 
 * the empty list for e.g: (3,2,1,0), return []
 * 
 * Variant: Compute the next permutation when given array may contain
 * Duplicates, for e.g: the next permutation for {2,2,3,0} = {2,3,0,2}
 * 
 * NOTE: This solution works for unique and duplicate entries both.
 * 
 * @author gopi_karmakar
 */
public class ComputeNextPermutaion {

	public static void main(String[] args) {
		
		Integer[] nums = {3, 2, 1};
		//Integer[] nums = {5, 1, 1};
		//Integer[] nums = {1, 0, 3, 2};
		System.out.println("Next Permutation  = " + nextPermutation(Arrays.asList(nums)));
	}
	
	/**	 
	 * Each step is an iteration through an array, 
	 * so the time complexity is O(n)
	 * We used few local variables, so the additional space complexity is O(1).
	 * 
	 * @param nums
	 * @return
	 */
	public static List<Integer> nextPermutation(List<Integer> nums) {
		
		if(nums.size() < 2) return nums;
		
		int k = nums.size()-2;			
		while(k >= 0 && (nums.get(k) >= nums.get(k+1))) {
			k--;
		}
		
		if(k >= 0) {
			for(int i = nums.size()-1; i > k; --i) {
				
				if(nums.get(i) > nums.get(k)) {
					Collections.swap(nums, i, k);
					break;
				}
			}		
			Collections.reverse(nums.subList(k+1, nums.size()));
		}
		else {
			Collections.reverse(nums);
		}
		return nums;			
	}
}