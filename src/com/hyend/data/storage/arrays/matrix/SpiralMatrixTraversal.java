package com.hyend.data.storage.arrays.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraversal {
	
	int[][] matrix;
	List<Integer> values;
	
	public SpiralMatrixTraversal(int[][] matrix) {
		this.matrix = matrix;
		values = new ArrayList<>();
	}

	public List<Integer> traverseSpiral() {
		
		int row = this.matrix.length;
		int col = this.matrix[0].length;
		
		/**
		 * Let's assume 
		 * Direction 0 -> Top left to right row.
		 * Direction 1 -> Right top to down column.
		 * Direction 2 -> Bottom right to left row.
		 * Direction 3 -> Left down to top column. 
		 */
		int direction = 0;
		/**
		 * Four markings.
		 */
		int topRow = 0, bottomRow = row-1; 
		int leftCol = 0, rightCol = col-1;
		
		while(topRow <= bottomRow && leftCol <= rightCol) {
			if(direction == 0) {				
				for(int i = leftCol; i <= rightCol; i++) {
					values.add(this.matrix[topRow][i]);					
				}
				topRow += 1;				
			}
			else if(direction == 1) {
				for(int i = topRow; i <= bottomRow; i++) {
					values.add(this.matrix[i][rightCol]);					
				}
				rightCol -= 1;				
			}
			else if(direction == 2) {
				for(int i = rightCol; i >= leftCol; i--) {
					values.add(this.matrix[bottomRow][i]);					
				}
				bottomRow -= 1;							
			}
			else if(direction == 3) {
				for(int i = bottomRow; i >= topRow; i--) {
					values.add(this.matrix[i][leftCol]);					
				}
				leftCol += 1;				
			}
			direction = (direction+1)%4;
		}
		for(int val : values) {
			System.out.print(" " + val);
		}
		return values;
	}	
}
