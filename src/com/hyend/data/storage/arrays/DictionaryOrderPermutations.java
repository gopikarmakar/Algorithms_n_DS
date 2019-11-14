package com.hyend.data.storage.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DictionaryOrderPermutations {
	public static void main(String[] args) {	
		
		Integer[] arr = {2, 3, 1, 4};
		for(List<Integer> perm : permutation(Arrays.asList(arr))) {
			System.out.println(perm);
		}
	}
	
	/**
	 * The time complexity is O(n X n!), since there are n! 
	 * permutations and we spend O(n) time to store each one.
	 */
	private static List<List<Integer>> permutation(List<Integer> perm) {
		List<List<Integer>> perms = new ArrayList<>();		
		Collections.sort(perm);		
		do {
			//Adding first dictionary order permutation.
			perms.add(new ArrayList<>(perm));
			perm = ComputeNextPermutaion.nextPermutation(perm);
			
		} while(!perm.isEmpty());
		return perms;
	}
}