package com.hyend.logical.algorithms.dp;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 
 * Find the longest palindromic subsequence's length.
 * 
 * e.g: s = "bbbab" return len = 4 
 * since the longest palindromic subsequence is "bbbb"
 * 
 * s = "cbbd" return len = 2
 * since the longest palindromic subsequence is "bb"
 * 
 * @author gopi_karmakar
 */
public class LongestPalindromicSubSequence {

	public static void main(String[] args) {
		
		String s = "bbbab";
		//String s = "cbbd";
		
		System.out.println(maxLen2(s));
	}
	
	/**
	 * 1st easiest to understand bottom up approach.
	 * Runtime faster than 46.56% and Memory usage less than 50.85%
	 * of Java LeetCodesubmissions.
	 * 
	 * Time and space complexity O(n * n) where n = s.length()
	 */
	private static int maxLen1(String s) {
		
		String rev = new StringBuilder(s).reverse().toString();
		
		int l = s.length();		
		
		int[][] dp = new int[l + 1][l + 1];
		
		for(int i = 1; i <= l; i++) {
			
			for(int j = 1; j <= l; j++) {
				
				if(s.charAt(i-1) == rev.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}		
		return dp[l][l];
	}
	
	/**
	 * 2nd  bottom up approach with a li'l better runtime.
	 * Runtime faster than 50.56% and Memory usage less than 50.85%
	 * of Java LeetCodesubmissions.
	 * 
	 * Time and space complexity O(n * n) where n = s.length()
	 */
	private static int maxLen2(String s) {
		
		int n = s.length() + 1;
		
		int[][] dp = new int[n][n];
		
		for(int i = 1; i < n; i++) {
			
			for(int j = 1; j < n; j++) {
				
				if(s.charAt(i - 1) == s.charAt(n - j - 1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[n-1][n-1];
	}
}
