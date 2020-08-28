package com.hyend.logical.algorithms.dp;

/**
 * https://leetcode.com/problems/interleaving-string/
 * 
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * e.g: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" then output = true
 * s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" then output - false
 * 
 * @author gopi_karmakar
 */
public class InterleavingString {

	public static void main(String[] args) {
		
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		//String s3 = "aadbbbaccc";
		
		System.out.println(isInterleave(s1, s2, s3));
	}
	
	/**
	 * Easy to understand bottom-up approach.
	 * 
	 * Runtime faster than 73.41% and Memory usage less than 51.83%
	 * of Java LeetCode submissions.
	 * 
	 * Time and space complexity is O(s1 * s2)
	 */
	private static boolean isInterleave(String s1, String s2, String s3) {
		
		if(s1 == null || s2 == null || s3 == null)
			return false;			
		
		/**
		 * Converting toCharArray() increases runtime
		 * since s.charAt(i) every time costs time. 
		 */		
		char[] S1 = s1.toCharArray();
		char[] S2 = s2.toCharArray();
		char[] S3 = s3.toCharArray();
		
		int l1 = S1.length, l2 = S2.length, l3 = S3.length;
		
		if(l3 != l1 + l2)
			return false;
		
		boolean[][] dp = new boolean[l1+1][l2+1];
		dp[0][0] = true;
		
		for(int i = 1; i <= l1; i++) {
			
			if(S1[i-1] != S3[i-1])
				break;
			else 
				dp[i][0] = true;
		}
		
		for(int j = 1; j <= l2; j++) {
			
			if(S2[j-1] != S3[j-1])
				break;
			else
				dp[0][j] = true; 
		}
		
		for(int i = 1; i <= l1; i++) {
			
			for(int j = 1; j <= l2; j++) {
				
				dp[i][j] = (S1[i-1] == S3[i+j-1] && dp[i-1][j]) ||
							(S2[j-1] == S3[i+j-1] && dp[i][j-1]);
			}
		}
		return dp[l1][l2];
	}
}