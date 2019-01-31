package com.hyend.logical.algorithms.matrix;

/**
 * if an element in an MxN matrix is 0, 
 * Then set it's entire row and column to 0.
 * 
 * @author gopi_karmakar
 *
 */
public class SetZerosInMatrix {
	
	private int[][] matrix = null;
	
	public SetZerosInMatrix(int[][] matrix) {
		this.matrix = matrix;
		System.out.print("Befor Evaluation \n");
		printMatrix();
	}

	
	public void setZeros() {
		int[] rows = new int[matrix.length];
		int[] columns = new int[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					rows[i] = 1;
					columns[j] = 1;					
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(rows[i] == 1 || columns[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
		System.out.print("After Evaluation \n");
		printMatrix();
	}
	
	public void printMatrix() {
		for(int i = 0; i < matrix.length; ++i) {			
			for(int j = 0; j < matrix[i].length; ++j) {
				System.out.print(matrix[i][j] + " ");				
			}
			System.out.print("\n");
		}
	}
}
