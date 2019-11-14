package com.hyend.logical.algorithms.dp.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Compute all Palindromic decompositions of a given string.
 * For e.g: "0204451881" Then some decompositions are,
 * {020", "44", "5", "1881"}, {"020", "44", "5", "1", "88", "1"} etc.
 * However, {"02044, "5", "1881"} is not a palindromic decomposition.
 * 
 * @author gopi_karmakar
 */
public class PalindromicDecompositions {

	public static void main(String[] args) {
		
		List<List<String>> result = new ArrayList<List<String>>();
		decompositions(0, "0204451881", new ArrayList<>(), result);
		
		for(List<String> list : result) {
			System.out.println(list);
		}
	}
	
	/**
	 * The worst-case time complexity is still O(n ^ 2), 
	 * e.g., if the input string consists of n repetitions of a single character. 
	 * However, the program has much better best-case time complexity than the
	 * brute-force approach, e.g., when there are very few palindromic decompositions.
	 */
	private static void decompositions(int offset, String input, 
			List<String> partialPartition, List<List<String>> result) {
		
		if(offset == input.length()) {
			result.add(new ArrayList<>(partialPartition));
			return;
		}
		
		for(int i = offset+1; i <= input.length(); ++i) {
			
			String prefix = input.substring(offset, i);
			
			if(isPalindrome(prefix)) {
				
				partialPartition.add(prefix);
				decompositions(i, input, partialPartition, result);
				partialPartition.remove(partialPartition.size()-1);
			}
		}
	}
	
	private static boolean isPalindrome(String prefix) {		
		for(int i = 0, j = prefix.length()-1; i < j; ++i, --j) {			
			if(prefix.charAt(i) != prefix.charAt(j)) 
				return false;
		}
		return true;
	}
}