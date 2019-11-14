package com.hyend.data.storage.structures.graphs.undirected;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Flip the color of all adjacent(Left, Right, Up, Down) vertices 
 * which are in same color of a given vertex.  
 * 
 * @author gopi_karmakar
 */
public class PaintMatrix {
	
	private enum Color {W, B, X};

	public static void main(String[] args) {
		
		Color[][] matrix = createSmapleMatrix();
		
		System.out.println("Before");
		printMatrix(matrix);
		
		flipColors(matrix, 5, 4);
		
		System.out.println("\nAfter");
		printMatrix(matrix);
	}
	
	private static class Coordinate {		
		public int x, y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;	
		}
	}
	
	/**
	 * The time complexity is the same as that of BFS, i.e. O(m X n)
	 * The space complexity is a little better than the worst-case for BFS, 
	 * since there are at most O{m + n) vertices that are at the same distance from a given entry.	 
	 */
	private static void flipColors(Color[][] matrix, int x, int y) {
		
		Queue<Coordinate> queue = new LinkedList<>();
		
		final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		
		Color color = matrix[x][y];				
		//matrix[x][y] = flipColor(matrix, x, y);
		matrix[x][y] = Color.X;
				
		queue.add(new Coordinate(x, y));
		
		while(!queue.isEmpty()) {
			
			Coordinate current = queue.peek();
			
			for(int[] dir : directions) {
				
				Coordinate next = new Coordinate(current.x + dir[0], current.y + dir[1]);
				
				if(isFeasible(matrix, color, next.x, next.y)) {
					
					matrix[next.x][next.y] = flipColor(matrix, next.x, next.y);
					queue.add(next);
				}
			}
			queue.remove();
		}
	}
	
	private static boolean isFeasible(Color[][] matrix, Color color, int x, int y) {

		if((x >= 0 && x < matrix.length) && (y >= 0 && y < matrix[x].length) && matrix[x][y] == color)
			return true;
		
		return false;
	}
	
	private static Color flipColor(Color[][] matrix, int x, int y) {
		
		return (matrix[x][y] == Color.B) ? Color.W : Color.B;
	}	
	
	 
	//##########################################################//	
	// 					Sample Matrix Creation					//
	//##########################################################//
	private static Color[][] createSmapleMatrix() {
		
		Color[][] matrix = new Color[10][10];
		
		for(int i = 0; i < matrix.length;) {
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				if(j == 0 || j == 2 || j == 6 || j == 7 || j == 8 || j == 9)
					matrix[i][j] 	= 	Color.B;				
				else matrix[i][j] 	= Color.W;			
			}
			
			++i;
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				if(j == 2 || j == 5 || j == 8 || j == 9)
					matrix[i][j] 	= 	Color.B;			
				else matrix[i][j]	= Color.W;
			}
			
			++i;
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				if(j == 0 || j == 1 || j == 2 || j == 5 || j == 6 || j == 8 || j==9) 
					matrix[i][j] 	= 	Color.B;
				else matrix[i][j] 	= Color.W;
			}
			
			++i;
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				if(j == 1 || j == 3 || j == 4 || j == 5 || j == 6 || j == 8)
					matrix[i][j] 	= 	Color.B;
				else matrix[i][j] 	= Color.W;
			}
			
			++i;
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				if(j == 0 || j == 2 || j == 7)
					matrix[i][j] 	= 	Color.B;
				else matrix[i][j] 	= Color.W;
			}
			
			++i;
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				if(j == 0 || j == 2 || j == 5 || j == 7 || j == 8 || j == 9)
					matrix[i][j] 	= 	Color.B;
				else matrix[i][j] 	= Color.W;
			}
			
			++i;
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				if(j == 4 || j == 6 || j == 9)
					matrix[i][j] 	= 	Color.B;
				else matrix[i][j] 	= Color.W;
			}
			
			++i;
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				if(j == 0 || j == 2 || j == 4 || j == 6)
					matrix[i][j] 	= 	Color.B;
				else matrix[i][j] 	= Color.W;
			}
			
			++i;
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				if(j == 0 || j == 2 || j == 3 || j == 7 || j == 8 || j == 9)
					matrix[i][j] 	= 	Color.B;
				else matrix[i][j] 	= Color.W;
			}
			
			++i;
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				if(j == 7 || j == 8)
					matrix[i][j] 	= 	Color.B;
				else matrix[i][j] 	= Color.W;
			}
			
			++i;
		}
		return matrix;
 	}
	
	private static void printMatrix(Color[][] matrix) {
		
		for(int i = 0; i < matrix.length; ++i) {
			
			for(int j = 0; j < matrix[i].length; ++j) {
				
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
