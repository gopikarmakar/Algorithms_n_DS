package com.hyend.logical.algorithms.dp.geometry;

/**
 * @author karmakargopi
 * 
 * 1 1 0 1 0
 *  |-----|
 * 0|1 1 1|0
 * 1|1 1 1|0
 * 0|1 1 1|1
 *  |-----|
 *  Problem: Find the largest square of 1's
 *  Solution: Take the minimal neighbor between
 *  matrix[i][j-1], matrix[i-1][j] & matrix[i-1][j-1] positions
 *  and add that with 1 and store to cache array. At the end of
 *  addition will return largest number of square of 1's.
 */
public class FindLargestSquareInMatrix {
	
	public static void main(String[] args) {
		
		int matrix[][] = {{1,1,0,1,0}, {0,1,1,1,0}, {1,1,1,1,0}, {0,1,1,1,1}};
		
		System.out.println(findLargestSquare(matrix));
	}
	
	public static int findLargestSquare(int[][] matrix) {
		
		int cache[][] = matrix.clone();
		
		int i = 0, j = 0, largestSquare = 0;
		
		for (i = 1; i < matrix.length; i++) {
			
			for(j = 1; j < matrix[i].length; j++) {

				if(matrix[i][j] > 0) {
					
					cache[i][j] = 1 + (Math.min((Math.min(matrix[i][j-1], matrix[i-1][j])), matrix[i-1][j-1]));					
				}
				if(cache[i][j] > largestSquare)
					largestSquare = cache[i][j];				
			}
		}		
		return largestSquare;
	}
}
