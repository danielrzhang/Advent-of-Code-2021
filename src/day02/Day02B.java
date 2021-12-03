package day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day02B {
	
	// Solution: 1963088820

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("src/day02/Day02Input.txt"));
		
		String line;
		String[] command;
		
		long totalX = 0;
		long totalY = 0;
		long aim = 0;
		
		long tempX, tempY;
		
		while ((line = in.readLine()) != null) {
			command = line.split(" ");
			tempX = 0;
			tempY = 0;
			
			if (command[0].equals("forward")) {
				tempX = Long.parseLong(command[1]);
				tempY = Long.parseLong(command[1]) * aim;
			} else if (command[0].equals("down")) {
				aim += Long.parseLong(command[1]);
			} else if (command[0].equals("up")) {
				aim -= Long.parseLong(command[1]);
			}
			
			totalX += tempX;
			totalY += tempY;
		}
		
		System.out.println(totalX * Math.abs(totalY));
		
		in.close();
	}
}
