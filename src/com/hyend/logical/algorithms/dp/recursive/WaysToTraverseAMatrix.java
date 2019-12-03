package com.hyend.logical.algorithms.dp.recursive;

/**
 * Compute the total number of ways to traverse a matrix 
 * 
 * @author gopi_karmakar
 */
public class WaysToTraverseAMatrix {

	public static void main(String[] args) {
		
		int n = 5, m = 5; 
		int[][] matrix = new int[n][m];
		int totalWays = numberOfWays(n - 1, m - 1, matrix);
		
		System.out.println("Total Ways to Traverse A " + n + " X " + m + " Matrix = " + totalWays);
	}
	
	private static int numberOfWays(int row, int column, int[][] matrix) {
		
		if(row == 0 || column == 0)
			return 1;
		
		if(matrix[row][column] == 0) {
			
			int waysTop = numberOfWays(row - 1, column, matrix);
			int waysLeft = numberOfWays(row, column - 1, matrix);
			
			matrix[row][column] = waysTop + waysLeft;
		}
		return matrix[row][column];
	}
}
