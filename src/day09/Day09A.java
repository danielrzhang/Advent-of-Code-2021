package day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day09A {
	
	public static int[] stringToIntegerArray(String[] array) {
		int[] newArray = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			newArray[i] = Integer.parseInt(array[i]);
		}
				
		return newArray;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/Day09Input.txt"));
		
		String line;
		int[][] grid = new int[100][100];
		
		int lineCounter = 0;
		while ((line = in.readLine()) != null) {
			grid[lineCounter] = stringToIntegerArray(line.split(""));
			lineCounter++;
		}
		in.close();
		
		int counter = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				
				// Check 4 corners
				if (i == 0 && j == 0) {
					if (grid[i + 1][j] > grid[i][j] && grid[i][j + 1] > grid[i][j]) {
						counter += grid[i][j] + 1;
					}
				} else if (i == grid.length - 1 && j == 0) {
					if (grid[i - 1][j] > grid[i][j] && grid[i][j + 1] > grid[i][j]) {
						counter += grid[i][j] + 1;
					}
				} else if (i == 0 && j == grid[i].length - 1) {
					if (grid[i][j - 1] > grid[i][j] && grid[i + 1][j] > grid[i][j]) {
						counter += grid[i][j] + 1;
					}
				} else if (i == grid.length - 1 && j == grid[i].length - 1) {
					if (grid[i][j - 1] > grid[i][j] && grid[i - 1][j] > grid[i][j]) {
						counter += grid[i][j] + 1;
					}
				} 
				
				// Check top edge
				else if (i == 0) {
					if (grid[i][j - 1] > grid[i][j] && grid[i][j + 1] > grid[i][j] && grid[i + 1][j] > grid[i][j]) {
						counter += grid[i][j] + 1;
					}
				} 
				
				// Check bottom edge
				else if (i == grid.length - 1) {
					if (grid[i][j - 1] > grid[i][j] && grid[i][j + 1] > grid[i][j] && grid[i - 1][j] > grid[i][j]) {
						counter += grid[i][j] + 1;
					}
				}
				
				// Check left edge
				else if (j == 0) {
					if (grid[i][j + 1] > grid[i][j] && grid[i - 1][j] > grid[i][j] && grid[i + 1][j] > grid[i][j]) {
						counter += grid[i][j] + 1;
					}
				}
				
				// Check right edge
				else if (j == grid[i].length - 1) {
					if (grid[i][j - 1] > grid[i][j] && grid[i - 1][j] > grid[i][j] && grid[i + 1][j] > grid[i][j]) {
						counter += grid[i][j] + 1;
					}
				}
				// Check others
				else {
					if (grid[i - 1][j] > grid[i][j] && grid[i + 1][j] > grid[i][j] && grid[i][j - 1] > grid[i][j] && grid[i][j + 1] > grid[i][j]) {
						counter += grid[i][j] + 1;
					}
				}
			}
		}
		System.out.println(counter);
	}
}