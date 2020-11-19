package com.hyend.logical.algorithms.dp.recursive;

/**
 * https://leetcode.com/problems/unique-paths/
 * 
 * Compute the total number of ways to traverse a matrix 
 * 
 * Variant: Unique Paths 
 * 
 * @author gopi_karmakar
 */
public class WaysToTraverseAMatrix {

	public static void main(String[] args) {
		
		int n = 3, m = 7; 
		int[][] matrix = new int[n][m];
		
		System.out.println(totalWays(n, m, matrix));
		
		int totalWays = numberOfWays(n - 1, m - 1, matrix);
		
		System.out.println("Total Ways to Traverse A " + n + " X " + m + " Matrix = " + totalWays);
	}
	
	/**
	 * The time complexity is O(n * m)
	 * the space complexity is O(n * m)
	 */
	private static int numberOfWays(int n, int m, int[][] matrix) {
		
		if(n == 0 || m == 0)
			return 1;
		
		if(matrix[n][m] == 0) {
			
			int rows = numberOfWays(n - 1, m, matrix);
			int columns = numberOfWays(n, m - 1, matrix);
			
			matrix[n][m] = rows + columns;
		}
		return matrix[n][m];
	}
	
	private static int totalWays(int m, int n, int[][] matrix) {
		
		for(int i = 0; i < m; i++) {
			
			for(int j = 0; j < n; j++) {
				
				if(i == 0 || j == 0) {
					matrix[i][j] = 1;					
				}
				else {
					matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
				}
			}
		}
		return matrix[m-1][n-1];
	}
}
