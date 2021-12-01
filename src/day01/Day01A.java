package day01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day01A {
	
	// Solution: 1709
	
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int counter = 0;

		BufferedReader in = new BufferedReader(new FileReader("src/day01/Day01Input.txt"));
		
		String line;
		
		while ((line = in.readLine()) != null) {
			list.add(Integer.parseInt(line));
		}
		in.close();
		
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) < list.get(i + 1)) {
				counter++;
			}
		}
		System.out.println(counter);	
	}
}
