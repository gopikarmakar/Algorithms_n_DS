package com.hyend.data.storage.arrays.matrix;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 * @author gopi_karmakar
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		
		int[][] grid = {{1, 3, 1},
						{1, 5, 1},
						{4, 2, 1}};
		
		System.out.println(minimumPathSum(grid));
	}

	/**
	 * Time and Space Complexity is O(nXm) 
	 */
	private static int minimumPathSum(int[][] grid) {
		
		int row = grid.length;
		int col = grid[0].length;
				
		int[][] cache = new int[row][col];		
		
		for(int i = 0; i < row; i++) {
			
			for(int j = 0; j < grid[i].length; j++) {
				
				if(i == 0 && j == 0) {
					cache[i][j] = grid[i][j];
				}
				else if(i == 0) {
					
					cache[i][j] = cache[i][j-1] + grid[i][j];
				}
				else if(j == 0) {
					cache[i][j] = grid[i][j] + cache[i-1][j];
					
				}
				else {
					cache[i][j] = Math.min(cache[i][j-1], cache[i-1][j]) + grid[i][j];
				}				
			}
		}
			
		return cache[row-1][col-1];
	}	
}
