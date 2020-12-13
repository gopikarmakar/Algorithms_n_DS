package com.hyend.data.storage.structures.graphs.directed;

/**
 * https://leetcode.com/problems/number-of-islands/
 * 
 * Given an m x n 2d grid map of '1's (land) and '0's (water), 
 * return the number of islands.
 * An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all 
 * four edges of the grid are all surrounded by water.
 * 
 * @author gopi_karmakar
 */
public class CountNumberOfIslands {

	public static void main(String[] args) {
		
		/*int[][] grid = {{1, 1, 1, 1, 0},
						{1, 1, 0, 1, 0},
						{1, 1, 0, 0, 0},
						{0, 0, 0, 0, 0}};*/
		
		int[][] grid = {{1, 1, 0, 0, 0},
						{1, 1, 0, 0, 0},
						{0, 0, 1, 0, 0},
						{0, 0, 0, 1, 1}};		             
				
		System.out.println("The Total No. Islands = " + totalIslands(grid));
	}
	
	/**
	 * Solution accepted in Leetcode with 1ms 99.96% runtime.
	 */
	private static int totalIslands(int[][] grid) {
		
		int result = 0;

        for(int i=0;i<grid.length;i++) {
            
            for(int j=0;j<grid[i].length;j++) {
                
                if(grid[i][j] == 1) {
                    
                	checkNeighbors(grid, i, j);
                    result++;
                }
            }
        }
        return result;
	}
	
	private static void checkNeighbors(int[][] grid, int i, int j) {
		
		if(i<0 || i > grid.length-1 || j<0 || j > grid[i].length-1 || grid[i][j] != 1) {
            return;
        }
        
        grid[i][j] = 2;
        
        checkNeighbors(grid, i-1, j);
        checkNeighbors(grid, i+1, j);
        checkNeighbors(grid, i, j-1);
        checkNeighbors(grid, i, j+1);
	}
}
