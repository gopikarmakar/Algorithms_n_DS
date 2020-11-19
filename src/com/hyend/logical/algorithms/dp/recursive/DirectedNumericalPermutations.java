package com.hyend.logical.algorithms.dp.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * 
 * Compute all the permutations of a given integer array in dictionary order.
 * For e.g: {1,2,3} = {{1,2,3}, {1,3,2}, {2,1,3}, {2,3,1}, {3,1,2}, {3,2,1}} 
 * 
 * @author gopi_karmakar
 */
public class DirectedNumericalPermutations {

	public static void main(String[] args) {
		
		Integer[] nums = {1, 2, 3};
		
		List<List<Integer>> result = new ArrayList<>();
		permutations(0, Arrays.asList( nums), result);
		
		for(List<Integer> perm : result) {
			System.out.println(perm);
		}
	}
	
	/**
	 * The time complexity is determined by the number of recursive calls.
	 * since within each function the time spent is 0(1),
	 * 
	 * So, the time complexity is O(n X n!), since we do O(n) 
	 * computation per call outside of the recursive calls and
	 * permutations of any n takes n! time.
	 */
	public static void permutations(int offset, List<Integer> nums, 
			List<List<Integer>> result) {
		
		if(offset == nums.size()-1) {
			result.add(new ArrayList<>(nums));			
			return;
		}
		
		//Try every possibility for A[i].
		for(int i = offset; i < nums.size(); ++i) {
			
			Collections.swap(nums, offset, i);
			
			permutations(offset+1, nums, result);
			
			Collections.swap(nums, offset, i);
		}
	}
}
