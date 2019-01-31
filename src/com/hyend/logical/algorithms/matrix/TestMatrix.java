package com.hyend.logical.algorithms.matrix;

public class TestMatrix {
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1, 2, 3, 4, 5},
						  {5, 7, 8, 9, 1},
						  {5, 8, 0, 7, 4},
						  {3, 2, 6, 9, 8},
						  {8, 1, 3, 5, 2}};
		
		int[][] grid = {{1, 3, 1},
						{1, 5, 1},
						{4, 2, 1}}; 
		
		int[][] grid2 = {{1, 2},
						 {1, 1}};
		
		/*MatrixRotation rotate = new MatrixRotation(matrix);
		rotate.rotate();*/
		
		SetZerosInMatrix zeros = new SetZerosInMatrix(matrix);
		zeros.setZeros();
		
		/*MinimumPathSum minSum = new MinimumPathSum();
		int min_Sum = minSum.minimumPathSum(grid2);
		System.out.println(min_Sum);*/
		
		//SpiralMatrixTraversal spiral = new SpiralMatrixTraversal(matrix);
		//spiral.traverseSpiral();
	}
	
}
