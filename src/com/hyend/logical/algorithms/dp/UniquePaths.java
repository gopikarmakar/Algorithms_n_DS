package com.hyend.logical.algorithms.dp;

/**
 * https://leetcode.com/problems/unique-paths/
 * 
 * Variant: Compute the total number of ways to traverse a matrix 
 * from top left to bottom right.
 * 
 * @author gopi_karmakar
 */
public class UniquePaths {

	public static void main(String[] args) {
		
		int m = 3, n = 7;
		int[][] dp = new int[m][n];
		
		System.out.println("Total Ways = " + totalWays(m, n, dp));
	}
	
	/**
	 * Time and Space Complexity O(mXn)
	 */
	private static int totalWays(int m, int n, int[][] dp) {
		
		for(int i = 0; i < m; i++) {
			
			for(int j = 0; j < n; j++) {
				
				if(i == 0 || j == 0) {
					dp[i][j] = 1;
				}
				else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
	}
}
