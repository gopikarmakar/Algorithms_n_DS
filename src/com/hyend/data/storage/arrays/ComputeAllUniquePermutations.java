package com.hyend.data.storage.arrays;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
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
		//Integer[] arr = {2,2,3,0};
		Integer[] arr = {1,1,2};
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
			perm = ComputeTheNextPermutaion.nextPermutation(perm);
			
		} while(!perm.isEmpty());
		return perms;
	}
}
