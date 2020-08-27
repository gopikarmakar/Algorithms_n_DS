package com.hyend.logical.algorithms.dp;

/**
 * Compute Levenshtein distance between two Strings.
 * 
 * https://leetcode.com/problems/edit-distance/
 * 
 * @author gopi_karmakar
 */
public class LevenshteinDistance {

	public static void main(String[] args) {
		
		// Consider case sensitivity as one action too.
		String a = "Carthorse";
		String b = "Orchestra";
		
		String a1 = "intention";
		String b1 = "execution";		
		
		String a2 = "AABC";
		String b2 = "ABCA";
		
		int a_Idx = a1.length();
		int b_Idx = b1.length();
		
		int[][] distanceBtwnPrefixes = new int[a_Idx][b_Idx];
		
		int distance = computeDistance(a1, a_Idx - 1, b1, b_Idx - 1, distanceBtwnPrefixes);
		
		System.out.println("Levenshtein Distance-1 = " +  minDistance(a1, b1));
		
		System.out.println("Levenshtein Distance-2 = " +  distance);
	}
	
	/**
	 * Easy to understand bottom up approach.
	 * Runtime faster than 80.57% and Memory usage less than 77.01%
	 * of Java LeetCode submissions.
	 * 
	 * Time and space complexity is O(a * b)
	 */
	private static int minDistance(String a, String b) {
		
		int l1 = a.length(), l2 = b.length();
		
		int[][] dp = new int[l1 + 1][l2 + 1];
		
		for(int i = 0; i <= l1; i++) {
			
			dp[i][0] = i;
		}
		
		for(int j = 0; j <= l2; j++) {
			
			dp[0][j] = j;
		}
		
		for(int i = 1; i <= l1; i++) {
			
			for(int j = 1; j <= l2; j++) {
				
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
				}
			}
		}
		return dp[l1][l2];
	}
	
	/**
	 * Much complicated recursive solution.
	 * Time and Space complexity is O(a * b)
	 */
	private static int computeDistance(String a, int a_Idx, String b, int b_Idx, int[][] distanceBtwnPrefixes) {
		
		if(a_Idx < 0) {			
			// A is empty so add all of B's characters.
			return b_Idx + 1;			
		}
		else if(b_Idx < 0) {
			
			// B is empty so remove all of A's characters.
			return a_Idx + 1;
		}
		
		if(distanceBtwnPrefixes[a_Idx][b_Idx] == 0) {
			
			if(a.charAt(a_Idx) == b.charAt(b_Idx)) {
				
				distanceBtwnPrefixes[a_Idx][b_Idx] = computeDistance(a, a_Idx - 1, b, b_Idx - 1, distanceBtwnPrefixes);
			}
			else {
				
				int subtituteLast = computeDistance(a, a_Idx - 1, b, b_Idx - 1, distanceBtwnPrefixes);
				
				int addLast = computeDistance(a, a_Idx, b, b_Idx - 1, distanceBtwnPrefixes);
				
				int removeLast = computeDistance(a, a_Idx - 1, b, b_Idx, distanceBtwnPrefixes);
				
				distanceBtwnPrefixes[a_Idx][b_Idx] = 1 + Math.min(subtituteLast, Math.min(addLast, removeLast));			
			}			
		}
		return distanceBtwnPrefixes[a_Idx][b_Idx];
	}
}
