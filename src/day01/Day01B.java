package day01;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day01B {
	
	// Solution: 1761
		
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int counter = 0;

		BufferedReader in = new BufferedReader(new FileReader("src/day01/Day01Input.txt"));
		
		String line;
		
		while ((line = in.readLine()) != null) {
			list.add(Integer.parseInt(line));
		}
		in.close();
		
		int tempSum;
		int prevSum = list.get(0) + list.get(1) + list.get(2);
		for (int i = 1; i < list.size() - 2; i++) {
			tempSum = list.get(i) + list.get(i + 1) + list.get(i + 2);
			if (tempSum > prevSum) {
				counter++;
			}
			prevSum = tempSum;
		}
		System.out.println(counter);
	}
}
