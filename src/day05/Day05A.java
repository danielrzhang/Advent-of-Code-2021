package day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day05A {
	
	// Solution: 6005

	public static int[] stringToIntegerArray(String[] array) {
		int[] newArray = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			newArray[i] = Integer.parseInt(array[i]);
		}
				
		return newArray;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("src/day05/Day05Input.txt"));
		
		String line;
		int[] command;
		int[][] floor = new int[1000][1000];
		int largestRow = -1;
		int largestColumn = -1;
		
		while ((line = in.readLine()) != null) {
			command = stringToIntegerArray(line.replaceAll(" -> ", ",").split(","));
			
			// Efficient row checking
			if (command[1] > largestRow) {
				largestRow = command[1];
			} else if (command[3] > largestRow) {
				largestRow = command[3];
			}
			
			// Efficient column checking
			if (command[0] > largestColumn) {
				largestColumn = command[0];
			} else if (command[2] > largestColumn) {
				largestColumn = command[2];
			}
			
			// Check if line is a row or column
			if (command[0] == command[2] || command[1] == command[3]) {
				
				// Right to left
				if (command[0] > command[2]) {
					for (int i = command[2]; i <= command[0]; i++) {
						floor[i][command[1]] += 1;
					}
					
				// Left to right
				} else if (command[0] < command[2]) {
					for (int i = command[0]; i <= command[2]; i++) {
						floor[i][command[1]] += 1;
					}
					
				// Bottom to top
				} else if (command[1] > command[3]) {
					for (int i = command[3]; i <= command[1]; i++) {
						floor[command[0]][i] += 1;
					}
					
				// Top to bottom
				} else if (command[1] < command[3]) {
					for (int i = command[1]; i <= command[3]; i++) {
						floor[command[0]][i] += 1;
					}
				}
			}
		}
		in.close();
		
		int counter = 0;
		
		for (int i = 0; i <= largestRow; i++) {
			for (int j = 0; j <= largestColumn; j++) {
				if (floor[i][j] >= 2) {
					counter++;
				}
			}
		}
		
		System.out.println(counter);
		
	}
}