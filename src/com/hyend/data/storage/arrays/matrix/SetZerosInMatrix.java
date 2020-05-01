package com.hyend.data.storage.arrays.matrix;

/**
 * if an element in an MxN matrix is 0, 
 * Then set it's entire row and column to 0.
 * 
 * @author gopi_karmakar
 */
public class SetZerosInMatrix {
	
	public static void main(String[] args) {
	
		int[][] matrix = {{1, 2, 3, 4, 5},
						  {5, 7, 8, 9, 1},
						  {5, 8, 0, 7, 4},
						  {3, 2, 6, 9, 8},
						  {8, 1, 3, 5, 2}};

		System.out.print("Befor Evaluation \n");
		printMatrix(matrix);
		
		setZeros(matrix);
		
		System.out.print("After Evaluation \n");
		printMatrix(matrix);
	}

	
	/**
	 * The idea is to first mark the row and column
	 * which has 0 value. Then in second iteration make
	 * that whole row and column to 0 whose cell is marked.
	 */
	public static void setZeros(int[][] matrix) {
		
		int[] rows = new int[matrix.length];
		int[] columns = new int[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == 0) {
					rows[i] = 1;
					columns[j] = 1;
					break;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(rows[i] == 1 || columns[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}		
	}
	
	public static void printMatrix(int[][] matrix) {
		
		for(int i = 0; i < matrix.length; ++i) {			
			for(int j = 0; j < matrix[i].length; ++j) {
				System.out.print(matrix[i][j] + " ");				
			}
			System.out.print("\n");
		}
	}
}
