package com.hyend.data.storage.structures.graphs.directed;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

/**
 * Search for a path in a maze if exist any.
 * 
 * @author gopi_karmakar
 */
public class SeachPathInAMaze {
	
	private enum Color {W, B, S, E, X};

	public static void main(String[] args) {		
		
		Color[][] maze = createSmapleMaze();
		printMaze(maze);
		
		List<Coordinate> path = searchMaze(maze, new Coordinate(9, 0), new Coordinate(0, 9));
		
		Color[][] mazeCopy = createSmapleMaze();
				
		System.out.println("Path Size = " + path.size());		
		for(Coordinate c : path) {
			mazeCopy[c.x][c.y] = Color.X;
			//System.out.print("x = " + c.x + " y = " + c.y + "\n");
		}		
		
		System.out.println("\nPath In Maze Showed With 'X'\n");
		mazeCopy[9][0] = Color.S;
		mazeCopy[0][9] = Color.E;
		printMaze(mazeCopy);
	}
	
	private static class Coordinate {		
		int x, y;		
		public Coordinate(int x, int y) {
			this.x = x; this.y = y;			
		}		
		@Override
		public boolean equals(Object obj) {						
		
			if(this == obj) return true;						
			if(obj == null || !(obj instanceof Coordinate)) return false; 		
			Coordinate that = (Coordinate) obj;
			return (this.x == that.x && this.y == that.y);
		}		
		
		@Override
		public int hashCode() {	
			return Objects.hash(x, y);
		}
	}
	
	private static List<Coordinate> searchMaze(Color[][] maze, Coordinate start, Coordinate end) {
		
		// Path from different directions.
		//final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Longest Route
		//final int[][] directions = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}}; // Shortest Route
		final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		//final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};		
		
		List<Coordinate> path = new ArrayList<>();		
		maze[start.x][start.y] = Color.B;
		path.add(start);
		if(!searchMazeHelper(maze, directions, start, end, path))
			path.remove(path.size()-1);
		
		return path;
	}
	
	/**
	 * The time complexity is the same as that for DFS, namely O(|V| + |E|).
	 */
	private static boolean searchMazeHelper(Color[][] maze, int[][] directions, 
				Coordinate current, Coordinate end, List<Coordinate> path) {
		
		if(current.equals(end)) 
			return true;
	
		for(int[] d : directions) {
			
			// For better performance if it's valid then only create object.
			//Coordinate next = new Coordinate(current.x + d[0], current.y + d[1]);
			if(isFeasable(maze, current.x + d[0], current.y + d[1])) {
				
				Coordinate next = new Coordinate(current.x + d[0], current.y + d[1]);
				maze[next.x][next.y] = Color.B;
				path.add(next);
				if(searchMazeHelper(maze, directions, next, end, path)) {
					return true;
				}
				path.remove(path.size() -  1);				
			}
		}
		return false;
	}
	
	private static boolean isFeasable(Color[][] maze, Coordinate current) {
		
		return 	(current.x >= 0 && current.x < maze.length) &&
				(current.y >= 0 && current.y < maze[current.x].length) &&
				(maze[current.x][current.y] == Color.W); 
	}
	
	private static boolean isFeasable(Color[][] maze, int x, int y) {
		
		return 	(x >= 0 && x < maze.length) &&
				(y >= 0 && y < maze[x].length) &&
				(maze[x][y] == Color.W); 
	}
	
	//##########################################################//	
	// 					Sample Maze Creation					//
	//##########################################################//
	private static Color[][] createSmapleMaze() {
		
		Color[][] maze = new Color[10][10];
		
		for(int i = 0; i < maze.length;) {
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 0) maze[i][j] = 		Color.B;
				else if(j == 6) maze[i][j] = 	Color.B;
				else if(j == 7) maze[i][j] = 	Color.B;
				else maze[i][j] = 				Color.W;			
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 2) maze[i][j] = 		Color.B;
				else maze[i][j] = 				Color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 0) maze[i][j] = 		Color.B;
				else if(j == 2) maze[i][j] = 	Color.B;
				else if(j == 5) maze[i][j] = 	Color.B;
				else if(j == 6) maze[i][j] = 	Color.B;
				else if(j == 8) maze[i][j] = 	Color.B;
				else if(j == 9) maze[i][j] = 	Color.B;
				else maze[i][j] = 				Color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 3) maze[i][j] = 		Color.B;
				else if(j == 4) maze[i][j] = 	Color.B;
				else if(j == 5) maze[i][j] = 	Color.B;				
				else if(j == 8) maze[i][j] = 	Color.B;
				else maze[i][j] = 				Color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 1) maze[i][j] = 		Color.B;
				else if(j == 2) maze[i][j] = 	Color.B;
				else maze[i][j] = 				Color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 1) maze[i][j] = 		Color.B;
				else if(j == 2) maze[i][j] = 	Color.B;
				else if(j == 5) maze[i][j] = 	Color.B;
				else if(j == 7) maze[i][j] = 	Color.B;
				else if(j == 8) maze[i][j] = 	Color.B;
				else maze[i][j] = 				Color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 4) maze[i][j] = 		Color.B;
				else maze[i][j] = 				Color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 2) maze[i][j] = 		Color.B;
				else if(j == 2) maze[i][j] = 	Color.B;
				else if(j == 4) maze[i][j] = 	Color.B;				
				else if(j == 6) maze[i][j] = 	Color.B;
				else maze[i][j] = 				Color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 0) maze[i][j] = 		Color.B;
				else if(j == 2) maze[i][j] = 	Color.B;
				else if(j == 3) maze[i][j] = 	Color.B;
				else if(j == 7) maze[i][j] = 	Color.B;
				else if(j == 8) maze[i][j] = 	Color.B;
				else if(j == 9) maze[i][j] = 	Color.B;
				else maze[i][j] = 				Color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 7) maze[i][j] = 		Color.B;
				else if(j == 8) maze[i][j] = 	Color.B;
				else maze[i][j] = 				Color.W;
			}
			
			++i;
		}
		return maze;
 	}
	
	private static void printMaze(Color[][] maze) {
		
		for(int i = 0; i < maze.length; ++i) {
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				System.out.print(maze[i][j] + "  ");
			}
			System.out.println();
		}
	}
}