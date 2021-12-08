package day03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Day03B {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/Day03Input.txt"));
		ArrayList<String> oxygen = new ArrayList<String>();
		ArrayList<String> co2 = new ArrayList<String>();

		String line;

		while ((line = in.readLine()) != null) {
			oxygen.add(line);
			co2.add(line);
		}
		in.close();

		Iterator<String> it;
		int zeroCounter, oneCounter;

		char removeChar;
		String testValue;

		// Oxygen
		int indexCounter = 0;

		while (oxygen.size() > 1) {
			it = oxygen.iterator();
			zeroCounter = 0;
			oneCounter = 0;

			for (int i = 0; i < oxygen.size(); i++) {
				if (oxygen.get(i).charAt(indexCounter) == '0') {
					zeroCounter++;
				} else {
					oneCounter++;
				}
			}

			if (zeroCounter > oneCounter) {
				removeChar = '1';
			} else {
				removeChar = '0';
			}

			while (it.hasNext() && oxygen.size() > 1) {
				testValue = it.next();

				if (testValue.charAt(indexCounter) == removeChar && oxygen.size() > 1) {
					it.remove();
				}
			}
			indexCounter++;
		}

		// CO2
		indexCounter = 0;

		while (co2.size() > 1) {
			it = co2.iterator();
			zeroCounter = 0;
			oneCounter = 0;

			for (int i = 0; i < co2.size(); i++) {
				if (co2.get(i).charAt(indexCounter) == '0') {
					zeroCounter++;
				} else {
					oneCounter++;
				}
			}

			if (oneCounter < zeroCounter) {
				removeChar = '0';
			} else {
				removeChar = '1';
			}

			while (it.hasNext() && co2.size() > 1) {
				testValue = it.next();

				if (testValue.charAt(indexCounter) == removeChar && co2.size() > 1) {
					it.remove();
				}
			}
			indexCounter++;
		}
		
		System.out.println(Integer.parseInt(oxygen.get(0), 2) * Integer.parseInt(co2.get(0), 2));
	}
}
