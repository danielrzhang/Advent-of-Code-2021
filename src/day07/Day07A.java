package day07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day07A {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/Day07Input.txt"));
		
		String line;
		String[] crabArray = {};
		int[] crabs;
		
		while ((line = in.readLine()) != null) {
			crabArray = line.split(",");
		}
		crabs = new int[crabArray.length];
		
		for (int i = 0; i < crabArray.length; i++) {
			crabs[i] = Integer.parseInt(crabArray[i]);
		}
		in.close();
		
		int maxPos = -1;
		int minPos = Integer.MAX_VALUE;
		
		for (int i = 0; i < crabs.length; i++) {
			if (crabs[i] > maxPos) {
				maxPos = crabs[i];
			}
			
			if (crabs[i] < minPos) {
				minPos = crabs[i];
			}
		}
		
		int smallestSum = Integer.MAX_VALUE;
		int tempSum;
		
		for (int i = minPos; i <= maxPos; i++) {
			tempSum = 0;
			
			for (int j = 0; j < crabs.length; j++) {
				tempSum += Math.abs(i - crabs[j]);
			}
			
			if (tempSum < smallestSum) {
				smallestSum = tempSum;
			}
		}
		System.out.println(smallestSum);
	}
}