package com.hyend.logical.algorithms.dp.recursive;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * 
 * @author gopi_karmakar
 */
public class PalindromePartitioning {

	public static void main(String[] args) {
		
		String s = "aab";
		String s2 = "aabbc";
		
		Map<String, Integer> map = new HashMap<>();

		partition(0, s2, new ArrayList<>(), map);
		
		System.out.println(map);
		
		System.out.println("Minimum Cuts Required = " + Collections.min(map.values()));
	}
	
	/**
	 * The worst-case time complexity is still O(n ^ 2), 
	 * e.g., if the input string consists of n repetitions of a single character. 
	 * However, the program has much better best-case time complexity than the
	 * brute-force approach, e.g., when there are very few palindromic decompositions.
	 */
	private static void partition(int offset, String s, List<String> partial, Map<String, Integer> map) {
		
		if(offset == s.length()) {
						
			map.putIfAbsent(partial.toString(), partial.size());
			return;
		}
		
		for(int i = offset + 1; i <= s.length(); ++i) {
			
			String prefix = s.substring(offset, i);	
			
			if(isPalindrome(prefix)) {
				
				partial.add(prefix);
				partition(i, s, partial, map);
				partial.remove(partial.size()-1);
			}
		}
		return;
	}
	
	private static boolean isPalindrome(String s) {
		
		for(int i = 0, j = s.length() - 1; i < j; ++i, --j) {
			
			if(s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}
}