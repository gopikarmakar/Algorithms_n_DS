package com.hyend.data.storage.search;

/**
 * Search for a value in a sorted 2D matrix.
 * A matrix is said to be sorted when it's every rows and columns are sorted. 
 *  
 * @author gopi_karmakar
 */
public class FindKeyInASortedMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = {{-1, 2, 4, 4, 6}, 
						  {1, 5, 5, 9, 21}, 
						  {3, 6, 6, 9, 22}, 
						  {3, 6, 8, 10, 24}, 
						  {6, 8, 9, 12, 25}, 
						  {8, 10, 12, 13, 40}};
		
		System.out.println(search(matrix, 8));
	}
	
	/**
	 * In each iteration, we remove a row or a column, which means we inspect 
	 * at most m + n - 1 elements, yielding an O(m + n) time complexity.
	 */
	private static boolean search(int[][] matrix, int k) {
		
		int row = 0, col = matrix[0].length-1;
		
		while(row < matrix.length && col > 0) {
			
			if(matrix[row][col] == k) {
				return true;
			}
			else if(k > matrix[row][col])
				++row;
			else 
				--col;
		}		
		return false;
	}
}
