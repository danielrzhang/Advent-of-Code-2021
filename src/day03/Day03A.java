package day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day03A {
	
	// Solution: 3895776

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("src/day03/Day03Input.txt"));
		ArrayList<String> list = new ArrayList<String>();
		
		String line;
		
		while ((line = in.readLine()) != null) {
			list.add(line);
		}
		
		String gammaRate = "";
		String epsilonRate = "";
		long zeroCounter, oneCounter;
		
		int length = list.get(0).length();
		
		for (int i = 0; i < length; i++) {
			zeroCounter = 0;
			oneCounter = 0;
			
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).charAt(i) == '0') {
					zeroCounter++;
				} else {
					oneCounter++;
				}
			}
			
			if (zeroCounter > oneCounter) {
				gammaRate += "0";
				epsilonRate += "1";
			} else {
				gammaRate += "1";
				epsilonRate += "0";
			}
		}
		
		System.out.println(Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2));
		
		in.close();
	}
}
