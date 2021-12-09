package day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day08B {

	public static boolean checkAnagram(String str1, String str2) {
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/Day08Input.txt"));

		String line;
		String[] allParts;
		String[] part1 = null;
		String[] part2 = null;
		String[] digits = new String[10];
		int sum = 0;

		while ((line = in.readLine()) != null) {
			allParts = line.split("\\|");
			part1 = allParts[0].trim().split(" ");
			part2 = allParts[1].trim().split(" ");
			
			for (String str: part1) {
				if (str.length() == 2) {
					digits[1] = str;
				} else if (str.length() == 3) {
					digits[7] = str;
				} else if (str.length() == 4) {
					digits[4] = str;				
				} else if (str.length() == 7) {
					digits[8] = str;
				}
			}
			
			for (String str: part1) {
				if (str.length() == 6) {
					if (isNine(digits, str)) {
						digits[9] = str;
					} else if (isZero(digits, str)) {
						digits[0] = str;
					} else {
						digits[6] = str;
					}
				}
			}

			for (String str: part1) {
				if (str.length() == 5) {
					if (isThree(digits, str)) {
						digits[3] = str;
					} else if (isFive(digits, str)) {
						digits[5] = str;
					} else {
						digits[2] = str;
					}
				}
			}
					
			for (int i = 0; i < 10; i++) {
				digits[i] = sortString(digits[i]);
			}
			
			int counter = 0;
			
			for (String str: part2) {
				String sortString = sortString(str);
				
				for (int i = 0; i < 10; i++) {
					if (digits[i].equals(sortString)) {
						counter = (counter * 10) + i;
					}
				}
			}
			sum += counter;
		}
		in.close();

		
		System.out.println(sum);
	}

	public static String sortString(String toOrder) {
		String newString;
		char[] charArray = toOrder.toCharArray();
		
		Arrays.sort(charArray);
		newString = new String(charArray);
		
		return newString;
	}
	
	public static boolean isNine(String[] digits, String str) {
		boolean nine = true;

		for (char ch: digits[4].toCharArray()) {
			if (!str.contains(String.valueOf(ch))) {
				nine = false;
				break;
			}
		}
		return nine;
	}
	
	public static boolean isZero(String[] digits, String str) {
		boolean one = true;

		for (char ch: digits[1].toCharArray()) {
			if (!str.contains(String.valueOf(ch))) {
				one = false;
				break;
			}
		}
		return one;
	}
	

	public static boolean isThree(String[] digits, String str) {
		boolean three = true;

		for (char ch: digits[1].toCharArray()) {
			if (!str.contains(String.valueOf(ch))) {
				three = false;
				break;
			}
		}
		return three;
	}

	public static boolean isFive(String[] digits, String str) {
		int missing = 0;

		for (char ch: digits[6].toCharArray()) {
			if (!str.contains(String.valueOf(ch))) {
				missing++;
			}
		}
		
		if (missing == 1) {
			return true;
		}
		return false;
	}
}