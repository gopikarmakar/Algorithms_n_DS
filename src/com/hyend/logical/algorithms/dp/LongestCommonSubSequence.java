package com.hyend.logical.algorithms.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 * 
 * Find longest sub sequence between two strings
 * For e.g: s1 = "AGGTAB"  s2 = "GXTXAYB"
 * lss = "GTAB" length = 4;
 * 
 * @author gopi_karmakar
 */
public class LongestCommonSubSequence {

	public static void main(String[] args) {
		
		//String a = "AGGTAB";
		//String a = "abcde";
		//String a = "abac";
		String a = "abc";
		
		//String b = "GXTXAYB";
		//String b = "ace";
		//String b = "cab";
		//String b = "abc";
		String b = "def"; 
				
		System.out.println(lss(a, b));
		
		int a_Idx = a.length();
		int b_idx = b.length();
		
		int[][] cache = new int[a_Idx][b_idx];

		int result = lss(a, a_Idx - 1, b, b_idx - 1, cache);
		
		System.out.println(result);
	}
	
	/**
	 * Easy to understand bottom up approach.
	 * Runtime faster than 88.14% and Memory usage less than 32.06%
	 * of Java LeetCodesubmissions.
	 * 
	 * Time and space complexity is O(a * b)
	 */
	private static int lss(String a, String b) {
		
		int l1 = a.length(), l2 = b.length();
		
		int[][] dp = new int[l1+1][l2+1];			
		
		for(int i = 1; i <= l1; i++) {
			
			for(int j = 1; j <= l2; j++) {
				
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {					
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[l1][l2];
	}
	
	/**
	 * Much complicated recursive solution.
	 * Both Time and space complexity is O(a * b)
	 */
	private static int lss(String a, int a_Idx, String b, int b_Idx, int[][] cache) {
		
		if(a_Idx < 0 || b_Idx < 0) 
			return 0;
		
		if(cache[a_Idx][b_Idx] == 0) {
			
			if(a.charAt(a_Idx) == b.charAt(b_Idx)) {
				
				cache[a_Idx][b_Idx] = 1 + lss(a, a_Idx - 1, b, b_Idx - 1, cache);
				
				//System.out.println("a_Idx = " + a_Idx + " b_Idx = " + b_Idx);				
				//System.out.println("a = " + a.charAt(a_Idx) + " b = " + b.charAt(b_Idx));
			}
			else {
				
				int A = lss(a, a_Idx - 1, b, b_Idx, cache);
				
				int B = lss(a, a_Idx, b, b_Idx - 1, cache);
				
				cache[a_Idx][b_Idx] = Math.max(A, B);
			}
		}
		return cache[a_Idx][b_Idx];
	}
}
