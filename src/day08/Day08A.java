package day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day08A {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/Day08Input.txt"));
		
		String line;
		String[] command = {};
		
		int counter = 0;
		while ((line = in.readLine()) != null) {
			command = line.split(" ");
			
			for (int i = command.length - 4; i < command.length; i++) {
				if (command[i].length() == 2 || command[i].length() == 3 || command[i].length() == 4 || command[i].length() == 7) {
					counter++;
				}
			}
		}
		in.close();
	
		System.out.println(counter);
	}
}