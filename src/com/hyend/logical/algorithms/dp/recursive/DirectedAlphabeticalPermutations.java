package com.hyend.logical.algorithms.dp.recursive;

import java.util.List;
import java.util.ArrayList;

/**
 * Compute all the permutations of a given word in dictionary order.
 * For e.g: ABC = {ABC, ACB, BAC, BCA, CAB, CBA} 
 * 
 * @author gopi_karmakar
 */
public class DirectedAlphabeticalPermutations {

	public static void main(String[] args) {
		
		List<String> permutations = new ArrayList<>();
		permutation("", "ABC", permutations);
		
		permutations.forEach(s -> {
			System.out.println(s);
		});
	}
	
	/**
	 * The time complexity is determined by the number of recursive calls.
	 * since within each function the time spent is 0(1),
	 * 
	 * So, the time complexity is O(n X n!), since we do O(n) 
	 * computation per call outside of the recursive calls and
	 * permutations of any n takes n! time.
	 */
	public static void permutation(String prefix, String word, List<String> perms) {
		
		int n = word.length();
		if(n == 0) {
			perms.add(prefix);
			return;
		}
		
		for(int i = 0; i < n; ++i) {
			
			String s1 = word.substring(0, i);
			String s2 = word.substring(i+1, n);
			char ch = word.charAt(i);
			
			permutation(prefix + ch, s1 + s2, perms);
		}
	}
}
