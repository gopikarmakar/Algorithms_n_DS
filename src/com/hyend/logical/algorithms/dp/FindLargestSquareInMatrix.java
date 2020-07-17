package com.hyend.logical.algorithms.dp;

/**
 * 1 1 0 1 0
 *  |-----|
 * 0|1 1 1|0
 * 1|1 1 1|0
 * 0|1 1 1|1
 *  |-----|
 * 
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest square containing only 1's and return its area.
 * 
 * Solution Accepted with 90%
 * 
 * https://leetcode.com/problems/maximal-square/
 * 
 * @author gopi_karmakar
 */
public class FindLargestSquareInMatrix {
	
	public static void main(String[] args) {
		
		//int matrix[][] = {{1}};
		//int matrix[][] = {{0}};
		int matrix[][] = {{1,1,0,1,0}, {0,1,1,1,0}, {1,1,1,1,0}, {0,1,1,1,1}};
		
		System.out.println(maximalSquare(matrix));
	}	
	
	public static int maximalSquare(int[][] matrix) {
		
		if(matrix.length == 0)
			return 0;								
		
		int n = matrix.length + 1;
		int m = matrix[0].length + 1;
		int i = 0, j = 0, max = 0;
		
		int[][] dp = new int[n][m];
		
		for (i = 1; i < n; i++) {
			
			for(j = 1; j < m; j++) {

				if(matrix[i-1][j-1] == 1) {
															
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
					max = Math.max(max, dp[i][j]);
				}				
			}
		}				
		return max*max;
	}
}
