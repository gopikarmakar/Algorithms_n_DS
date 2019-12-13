package com.hyend.logical.algorithms.dp.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Compute all the permutations of a given integer array in dictionary order.
 * For e.g: {1,2,3} = {{1,2,3}, {1,3,2}, {2,1,3}, {2,3,1}, {3,1,2}, {3,2,1}} 
 * 
 * @author gopi_karmakar
 */
public class DirectedNumericalPermutations {

	public static void main(String[] args) {
		
		Integer[] arr = {1, 2, 3, 4};
		List<List<Integer>> perms = new ArrayList<>();
		permutations(0, Arrays.asList(arr), perms);
		
		for(List<Integer> perm : perms) {
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
	public static void permutations(int i, List<Integer> perm, 
			List<List<Integer>> perms) {
		
		if(i == perm.size()-1) {
			perms.add(new ArrayList<>(perm));
			return;
		}
		
		//Try every possibility for A[i].
		for(int j = i; j < perm.size(); ++j) {
			
			Collections.swap(perm, i, j);
			
			permutations(i+1, perm, perms);
			
			Collections.swap(perm, i, j);
		}
	}
}
