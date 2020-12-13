package com.hyend.logical.algorithms.dp.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Compute all Palindromic decompositions of a given string.
 * For e.g: "0204451881" Then some decompositions are,
 * {020", "44", "5", "1881"}, {"020", "44", "5", "1", "88", "1"} etc.
 * However, {"02044, "5", "1881"} is not a palindromic decomposition.
 * 
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * @author gopi_karmakar
 */
public class PalindromicDecompositions {

	public static void main(String[] args) {
		
		String s = "0204451881";
		
		String s2 = "aabbc";
		
		String s3 = "aaa";
		
		List<List<String>> result = new ArrayList<List<String>>();
		decompositions(0, s3, new ArrayList<>(), result);
		
		for(List<String> list : result) {
			System.out.println(list);
		}
	}
	
	/**
	 * Solution accepted with the 100% runtime in LeetCode.
	 * The worst-case time complexity is still O(n ^ 2), 
	 * e.g., if the input string consists of n repetitions of a single character. 
	 * However, the program has much better best-case time complexity than the
	 * brute-force approach, e.g., when there are very few palindromic decompositions.
	 */
	private static void decompositions(int index, String s, 
			List<String> current, List<List<String>> result) {
		
		if(index == s.length()) {
			result.add(new ArrayList<>(current));
			return;
		}
		
		for(int i = index; i < s.length(); ++i) {			
			
			if(isPalindrome(s, index, i)) {
				
				String prefix = s.substring(index, i+1);
				current.add(prefix);
				decompositions(i+1, s, current, result);
				current.remove(current.size()-1);
			}
		}
	}
	
	private static boolean isPalindrome(String s, int start, int end) {	
		
		for(; start < end; ++start, --end) {
			
			if(s.charAt(start) != s.charAt(end)) 
				return false;
		}
		return true;
	}
}