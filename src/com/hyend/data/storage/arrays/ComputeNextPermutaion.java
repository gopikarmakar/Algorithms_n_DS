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
		
		Integer[] arr = {1, 0, 3, 2};
		System.out.println("Next Permutation  = " + nextPermutation(Arrays.asList(arr)));
	}
	
	/**	 
	 * Each step is an iteration through an array, 
	 * so the time complexity is O(n)
	 * We used few local variables, so the additional space complexity is O(1).
	 * 
	 * @param perm
	 * @return
	 */
	public static List<Integer> nextPermutation(List<Integer> perm) {
		
		int k = perm.size()-2;			
		while(k >= 0 && (perm.get(k) >= perm.get(k+1))) {
			k--;
		}
		if(k < 0) {
			return Collections.emptyList();
		}
		for(int i = perm.size()-1; i > k; --i) {
			
			if(perm.get(i) > perm.get(k)) {
				Collections.swap(perm, i, k);
				break;
			}
		}		
		Collections.reverse(perm.subList(k+1, perm.size()));
		return perm;
	}
}