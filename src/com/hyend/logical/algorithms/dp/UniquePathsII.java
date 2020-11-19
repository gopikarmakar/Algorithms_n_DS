package com.hyend.logical.algorithms.dp;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * Variant: Compute the total number of ways to traverse a matrix 
 * from top left to bottom right when there's a obstacle in between.
 * 
 * @author gopi_karmakar
 */
public class UniquePathsII {

	public static void main(String[] args) {
		
		int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		System.out.println(totalWays(obstacleGrid));
	}
	
	private static int totalWays(int[][] obstacleGrid) {
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[] dp = new int[n];
		
		dp[n-1] = obstacleGrid[m-1][n-1] ^ 1;
		
		for(int i = m-1; i >= 0; i--) {
			
			for(int j = n-1; j >= 0; j--) {
				
				if(obstacleGrid[i][j] == 1) {
					dp[j] = 0;					
				}
				else if(j < n-1){
					dp[j] += dp[j+1];
				}
			}
		}
		return dp[0];
	}
}
