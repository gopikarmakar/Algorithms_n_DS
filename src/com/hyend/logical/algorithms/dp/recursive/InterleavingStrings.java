package com.hyend.logical.algorithms.dp.recursive;

import java.util.Set;
import java.util.LinkedHashSet;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For e.g: "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" = true
 * 			"aabcc", s2 = "dbbca", s3 = "aadbbbaccc" = false
 * 
 * Leetcode Problem : https://leetcode.com/problems/interleaving-string/
 * 
 * @author gopi_karmakar
 */
public class InterleavingStrings {

	public static void main(String[] args) {
		
		String a = "aabcc";
		
		String b = "dbbca";
		
		String c = "aadbbbaccc";
		
		boolean result = compute(a, c, new LinkedHashSet<Character>()) && compute(b, c, new LinkedHashSet<Character>());
		
		System.out.println(result);
	}
	
	private static boolean compute(String a, String b, Set<Character> order) {
		
		for(char c : a.toCharArray()) {
			order.remove(c);
			order.add(c);
		}
		
		int aIdx = a.length();
		int bIdx = b.length();
		
		int[][] cache = new int[aIdx][bIdx];
		
		Set<Character> aOrder = new LinkedHashSet<>();
		
		int length = interleavingString(a, aIdx - 1, b, bIdx - 1, cache, aOrder);
		
		System.out.println(aOrder.toString());
		
		return order.toString().equals(aOrder.toString()) && (length == a.length());
	}
	
	/**
	 * Max time and space complexity is O(n * m)
	 * 
	 */
	private static int interleavingString(String a, int aIdx, String b, int bIdx, int[][] cache, Set<Character> order) {
		
		if(aIdx < 0 || bIdx < 0)
			return 0;
		
		if(cache[aIdx][bIdx] == 0) {
			
			if(a.charAt(aIdx) == b.charAt(bIdx)) {
									
				cache[aIdx][bIdx] = 1 + interleavingString(a, aIdx - 1, b, bIdx - 1, cache, order);
				order.remove(b.charAt(bIdx));
				order.add(b.charAt(bIdx));
			}
			else {
				
				int A = interleavingString(a, aIdx - 1, b, bIdx, cache, order);
				
				int B = interleavingString(a, aIdx, b, bIdx - 1, cache, order);
				
				cache[aIdx][bIdx] = Math.max(A, B);
			}				
		}		
		return cache[aIdx][bIdx];
	}
}
