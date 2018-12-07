package com.hyend.logical.algorithms.matrix;

public class MinimumPathSum {

	int sum = 0, min = 0;
	int[][] cache;

	public int minimumPathSum(int[][] grid) {
		
		int row = grid.length;
		int col = grid[0].length;
		
		/*cache = new int[grid.length];
		
		for(int i = 0; i < grid.length; i++) {
			
			for(int j = 0; j < grid[i].length; j++) {
				
				if(j == grid[i].length-1) {
					sum += Math.min(grid[i][j], (grid[i][j] + 
							((i < grid.length-1) ? grid[i+1][j] : 0)));
				}
				else if(i == grid.length-1) {
					sum += Math.min(grid[i][j], (grid[i][j] + 
							((j < grid[i].length-1) ? grid[i][j+1] : 0)));
				}
				else {
					sum += Math.min((grid[i][j] + grid[i][j+1]), (grid[i][j+1] + grid[i+1][j+1]));
				}
			}
			cache[i] = sum;
			if(i == 0)
				min  = cache[i];			
			sum = 0;
			min = Math.min(min, cache[i]);
		}*/
		
		cache = new int[row][col];
		
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
