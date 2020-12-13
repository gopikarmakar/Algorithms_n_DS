package com.hyend.logical.algorithms.strings;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 * 
 * Count Total no. of palindromic substrings
 * For e.g: s = "aaa" = {"a", "a", "a", "aa", "aa", "aaa"}
 * Total 6 palindromic substrings i.e return 6
 * 
 * @author gopi_karmakar
 */
public class TotalPalindromicSubStrings {

	public static void main(String[] args) {
		
		//String s = "abc";
		String s = "aaa";
		
		System.out.println(countSubStrings(s));
	}
	
	/**
	 * Accepted in Leetcode with 2ms 94.63% runtime.
	 * Solution: Expand from center approach 
	 */
	private static int countSubStrings(String s) {
		
		int count = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			count += getPalindromeLen(s, i, i) / 2;
			count += getPalindromeLen(s, i, i + 1) / 2 + 1;
		}
		
		return count;
	}
	
	private static int getPalindromeLen(String s, int start, int end) {
		
		while(start >= 0 && end < s.length() && 
				s.charAt(start) == s.charAt(end)) {
			
			start--;
			end++;
		}
			
		return end - start - 1;
	}	
}
