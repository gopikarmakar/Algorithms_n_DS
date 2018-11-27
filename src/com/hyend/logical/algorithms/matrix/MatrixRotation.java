package com.hyend.logical.algorithms.matrix;

/**
 * Rotate a Matrix by 90 degree clockwise.
 * 
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * After rotate by 90 degree clockwise. It should be.
 * 7 4 1
 * 8 5 2
 * 9 6 3
 * 
 * @author gopi_karmakar
 *
 */
public class MatrixRotation {
	
	int[][] matrix = null;
	public MatrixRotation(int[][] matrix) {
		this.matrix = matrix;
		System.out.print("Befor Rotation \n");
		printMatrix();
	}

	/**
	 * We rotate the matrix in layers. Which means 
	 * rotate all the elements from the most outer layer first.
	 * After rotating a layer completely we should reduce the size
	 * of the matrix by 1 and keep track of the offset.
	 * Since we're rotating the matrix from first and reducing the 
	 * size from last so we just need to go till the half of the matrix.    
	 */
	public void rotate() {
		
		int n = matrix.length;
		for(int layer = 0; layer < n/2; ++layer) {

			int first = layer;
			int last = n - 1 - layer;
			
			for(int i = first; i < last; ++i) {
				
				int offset = i - first;
				
				int topLeft = matrix[layer][i];
				
				//Top Left
				matrix[layer][i] = matrix[last - offset][first];
				
				//Bottom Left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				//Bottom Right
				matrix[last][last - offset] = matrix[offset][last];
				
				//Top Right
				matrix[offset][last] = topLeft;
			}
		}
		System.out.print("After Rotation \n");
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
