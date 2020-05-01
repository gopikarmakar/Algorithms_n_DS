package com.hyend.data.storage.structures.graphs.directed;

/**
 * https://leetcode.com/problems/count-servers-that-communicate/
 * 
 * @author gopi_karmakar
 */
public class ConnectedServers {

	public static void main(String[] args) {
		
		int[][] grid = {{1, 1, 0, 0}, 
						{0, 0, 1, 0}, 
						{0, 0, 1, 0}, 
						{0, 0, 0, 1}};
		
		System.out.println(connectedServers(grid));		
	}
	
	/**
	 * Time complexity O(mXn)
	 * Space complexity O(m) + O(n)
	 */
	private static int connectedServers(int[][] grid) {
		
		int count = 0;
		
		int r = grid.length;
		int c = grid[0].length;
		
		int[] rows = new int[r];
		int[] cols = new int[c];
		
		for(int i = 0; i < r; ++i) {
			
			for(int j = 0; j < c; ++j) {
				
				if(grid[i][j] == 1) {
					rows[i]++;
					cols[j]++;
				}
			}
		}

		for(int x : rows)
			System.out.print(x + "  ");
		
		System.out.println();
		
		for(int y : cols)
			System.out.print(y + "  ");
		
		System.out.println();
		
		for(int i = 0; i < r; ++i) {
			
			for(int j = 0; j < c; ++j) {
				
				if(grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1))
					count += 1;
			}
		}		
		return count;
	}	
}
