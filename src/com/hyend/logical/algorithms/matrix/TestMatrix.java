package com.hyend.logical.algorithms.matrix;

public class TestMatrix {	
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1, 2, 3, 4, 5},
						  {5, 7, 8, 9, 1},
						  {5, 8, 0, 7, 4},
						  {3, 2, 6, 9, 8},
						  {8, 1, 3, 5, 2}};
		
		MatrixRotation rotate = new MatrixRotation(matrix);
		rotate.rotate();
		
		SetZerosInMatrix zeros = new SetZerosInMatrix(matrix);
		zeros.setZeros();
	}
}
