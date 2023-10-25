package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//starter code for MazeSolver
//CST-201

public class Driver {

	/**
	 * 
	 * @param start
	 * @param end
	 * find a path through the maze
	 * if found, output the path from start to end
	 * if not path exists, output a message stating so
	 * 
	 */
	
	
	public static void main(String[] args) throws FileNotFoundException {		
			
			//create the Maze from the file
			Scanner fin = new Scanner(new File("maze.in"));
			//read in the rows and cols
			int rows = fin.nextInt();
			int cols = fin.nextInt();
			
			//create the maze
			int [][] grid = new int[rows][cols];
			
			//read in the data from the file to populate
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					grid[i][j] = fin.nextInt();
				}
			}

			//look at it 
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (grid[i][j] == 3)
						System.out.print("S ");	
					else if (grid[i][j] == 4)
						System.out.print("E ");	
					else
						System.out.print(grid[i][j] + " ");
				}
				System.out.println();
			}

			//make a 2-d array of cells
			MazeCell[][] cells = new MazeCell[rows][cols];
			
			//populate with MazeCell obj - default obj for walls

			MazeCell start = new MazeCell(), end = new MazeCell();
			
			//iterate over the grid, make cells and set coordinates
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					//make a new cell
					cells[i][j] = new MazeCell();
					//if it isn't a wall, set the coordinates
					if (grid[i][j] != 0) {
						cells[i][j].setCoordinates(i, j);
						//look for the start and end cells
						if (grid[i][j] == 3)
							start = cells[i][j];
						if (grid[i][j] == 4) 
							end = cells[i][j];
						
					}

				}
			}
			
			//testing
			System.out.println("start:"+start+" end:"+end);
			
			//solve it!
			//depthFirst(start, end);
			depthFirst(start, end, grid);

			
		}
	
	
	// implement this method
	/**
	 * Creates a 2D boolean array visited to keep track of visited cells.
	 * Calls the DFS method, passing the start cell, end cell, the visited array, and the grid.
	 * If DFS returns true, it means a path is found and it prints “Path found from start to end.” Otherwise, it prints “No path exists from start to end.”
	 * @param start : The starting cell of the maze.
	 * @param end : The destination cell of the maze
	 * @param grid : A 2D array representing the maze, where 0 indicates a wall, 1 indicates a path, 3 is the starting point, and 4 is the ending point.
	 */
	public static void depthFirst(MazeCell start, MazeCell end, int[][] grid) {
	    int rows = grid.length;
	    int cols = grid[0].length;
	    boolean[][] visited = new boolean[rows][cols];

	    if (DFS(start, end, visited, grid)) {  // <-- Notice the added grid parameter
	        System.out.println("Path found from start to end.");
	    } else {
	        System.out.println("No path exists from start to end.");
	    }
	}

	/**
	 *  It checks if the current cell is out of bounds, already visited, or a wall. 
	 *  It marks the current cell as visited.
	 *  If the current cell is the end cell, it returns true, indicating that the path is found.
	 *  It attempts to move to adjacent, unvisited cells.
	 *  If none of the adjacent cells lead to a solution, it returns false, indicating no path is found from the current cell.
	 * @param current : The current cell being visited.
	 * @param end : The destination cell.
	 * @param visited : A 2D boolean array to keep track of visited cells.
	 * @param grid : The 2D array representing the maze.
	 * @return
	 */
	public static boolean DFS(MazeCell current, MazeCell end, boolean[][] visited, int[][] grid) {
		    int row = current.getRow();
		    int col = current.getCol();

		    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
		        return false;
		    }

		    visited[row][col] = true;

		    if (current.equals(end)) {
		        return true;
		    }

		 // North
		    if (row > 0 && grid[row - 1][col] != 0 && !visited[row - 1][col]) {
		        if (DFS(new MazeCell(row - 1, col), end, visited, grid)) return true;
		    }
		    // East
		    if (col < grid[0].length - 1 && grid[row][col + 1] != 0 && !visited[row][col + 1]) {
		        if (DFS(new MazeCell(row, col + 1), end, visited, grid)) return true;
		    }
		    // South
		    if (row < grid.length - 1 && grid[row + 1][col] != 0 && !visited[row + 1][col]) {
		        if (DFS(new MazeCell(row + 1, col), end, visited, grid)) return true;
		    }
		    // West
		    if (col > 0 && grid[row][col - 1] != 0 && !visited[row][col - 1]) {
		        if (DFS(new MazeCell(row, col - 1), end, visited, grid)) return true;
		    }

		    return false;

		}
}


