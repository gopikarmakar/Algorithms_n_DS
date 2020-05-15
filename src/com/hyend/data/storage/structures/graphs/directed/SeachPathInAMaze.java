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
	
	private enum color {W, B, S, E, X};

	public static void main(String[] args) {		
		
		color[][] maze = createSmapleMaze();
		printMaze(maze);
		
		List<Coordinate> path = searchMaze(maze, new Coordinate(9, 0), new Coordinate(0, 9));
		
		color[][] mazeCopy = createSmapleMaze();
				
		System.out.println("Path Size = " + path.size());		
		for(Coordinate c : path) {
			mazeCopy[c.x][c.y] = color.X;
			//System.out.print("x = " + c.x + " y = " + c.y + "\n");
		}		
		
		System.out.println("\nPath In Maze Showed With 'X'\n");
		mazeCopy[9][0] = color.S;
		mazeCopy[0][9] = color.E;
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
			if(this.x != that.x || this.y != that.y) return false;
			return true;			
		}		
		@Override
		public int hashCode() {	
			return Objects.hash(x, y);
		}
	}
	
	private static List<Coordinate> searchMaze(color[][] maze, Coordinate start, Coordinate end) {
		
		// Path from different directions.
		//final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Longest Route
		final int[][] directions = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}}; // Shortest Route
		//final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		//final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};		
		
		List<Coordinate> path = new ArrayList<>();		
		maze[start.x][start.y] = color.B;
		path.add(start);
		if(!searchMazeHelper(maze, directions, start, end, path))
			path.remove(path.size()-1);
		
		return path;
	}
	
	/**
	 * The time complexity is the same as that for DFS, namely O(|V| + |E|).
	 */
	private static boolean searchMazeHelper(color[][] maze, int[][] directions, 
				Coordinate current, Coordinate end, List<Coordinate> path) {
		
		if(current.equals(end)) 
			return true;
	
		for(int[] d : directions) {
			
			Coordinate next = new Coordinate(current.x + d[0], current.y + d[1]);
			if(isFeasable(maze, next)) {
				maze[next.x][next.y] = color.B;
				path.add(next);
				if(searchMazeHelper(maze, directions, next, end, path)) {
					return true;
				}
				path.remove(path.size() -  1);				
			}
		}
		return false;
	}
	
	private static boolean isFeasable(color[][] maze, Coordinate current) {
		
		return 	(current.x >= 0 && current.x < maze.length) &&
				(current.y >= 0 && current.y < maze[current.x].length) &&
				(maze[current.x][current.y] == color.W); 
	}
	
	//##########################################################//	
	// 					Sample Maze Creation					//
	//##########################################################//
	private static color[][] createSmapleMaze() {
		
		color[][] maze = new color[10][10];
		
		for(int i = 0; i < maze.length;) {
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 0) maze[i][j] = 		color.B;
				else if(j == 6) maze[i][j] = 	color.B;
				else if(j == 7) maze[i][j] = 	color.B;
				else maze[i][j] = 				color.W;			
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 2) maze[i][j] = 		color.B;
				else maze[i][j] = 				color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 0) maze[i][j] = 		color.B;
				else if(j == 2) maze[i][j] = 	color.B;
				else if(j == 5) maze[i][j] = 	color.B;
				else if(j == 6) maze[i][j] = 	color.B;
				else if(j == 8) maze[i][j] = 	color.B;
				else if(j == 9) maze[i][j] = 	color.B;
				else maze[i][j] = 				color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 3) maze[i][j] = 		color.B;
				else if(j == 4) maze[i][j] = 	color.B;
				else if(j == 5) maze[i][j] = 	color.B;				
				else if(j == 8) maze[i][j] = 	color.B;
				else maze[i][j] = 				color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 1) maze[i][j] = 		color.B;
				else if(j == 2) maze[i][j] = 	color.B;
				else maze[i][j] = 				color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 1) maze[i][j] = 		color.B;
				else if(j == 2) maze[i][j] = 	color.B;
				else if(j == 5) maze[i][j] = 	color.B;
				else if(j == 7) maze[i][j] = 	color.B;
				else if(j == 8) maze[i][j] = 	color.B;
				else maze[i][j] = 				color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 4) maze[i][j] = 		color.B;
				else maze[i][j] = 				color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 2) maze[i][j] = 		color.B;
				else if(j == 2) maze[i][j] = 	color.B;
				else if(j == 4) maze[i][j] = 	color.B;				
				else if(j == 6) maze[i][j] = 	color.B;
				else maze[i][j] = 				color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 0) maze[i][j] = 		color.B;
				else if(j == 2) maze[i][j] = 	color.B;
				else if(j == 3) maze[i][j] = 	color.B;
				else if(j == 7) maze[i][j] = 	color.B;
				else if(j == 8) maze[i][j] = 	color.B;
				else if(j == 9) maze[i][j] = 	color.B;
				else maze[i][j] = 				color.W;
			}
			
			++i;
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				if(j == 7) maze[i][j] = 		color.B;
				else if(j == 8) maze[i][j] = 	color.B;
				else maze[i][j] = 				color.W;
			}
			
			++i;
		}
		return maze;
 	}
	
	private static void printMaze(color[][] maze) {
		
		for(int i = 0; i < maze.length; ++i) {
			
			for(int j = 0; j < maze[i].length; ++j) {
				
				System.out.print(maze[i][j] + "  ");
			}
			System.out.println();
		}
	}
}