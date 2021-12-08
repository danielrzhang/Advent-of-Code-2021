package day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day07B {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/Day07Input.txt"));
		
		String line;
		String[] crabArray = {};
		long[] crabs;
		
		while ((line = in.readLine()) != null) {
			crabArray = line.split(",");
		}
		crabs = new long[crabArray.length];
		
		for (int i = 0; i < crabArray.length; i++) {
			crabs[i] = Long.parseLong(crabArray[i]);
		}
		in.close();
		
		long maxPos = -1;
		long minPos = Long.MAX_VALUE;
		
		for (int i = 0; i < crabs.length; i++) {
			if (crabs[i] > maxPos) {
				maxPos = crabs[i];
			}
			
			if (crabs[i] < minPos) {
				minPos = crabs[i];
			}
		}
		
		long smallestSum = Integer.MAX_VALUE;
		long tempSum;
		long n;
		
		for (long i = minPos; i <= maxPos; i++) {
			tempSum = 0L;
			
			for (int j = 0; j < crabs.length; j++) {
				n = Math.abs(i - crabs[j]);
				tempSum += (n * (n + 1)) / 2;
			}
			
			if (tempSum < smallestSum) {
				smallestSum = tempSum;
			}
		}
		System.out.println(smallestSum);
	}
}