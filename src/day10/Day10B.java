package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Day10B {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/Day10Input.txt"));
		
		String line;
		
		Stack<Character> stack;
		char ch;
		boolean isCorrupted;
		ArrayList<Long> counterList = new ArrayList<Long>();
		
		while ((line = in.readLine()) != null) {
			stack = new Stack<Character>();
			isCorrupted = false;
			
			for (int i = 0; i < line.length(); i++) {
				ch = line.charAt(i);
				
				if (stack.size() != 0) {
					if (ch == ')' && stack.peek() == '(') {
						stack.pop();
					} else if (ch == ']' && stack.peek() == '[') {
						stack.pop();
					} else if (ch == '}' && stack.peek() == '{') {
						stack.pop();
					} else if (ch == '>' && stack.peek() == '<') {
						stack.pop();
					} else if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
						stack.push(ch);
					} else {
						isCorrupted = true;
						break;
					}
				} else {
					stack.push(ch);
				}
			}
				
			long counter;
			char tempCh;
			if (!isCorrupted) {
				counter = 0L;
				while (stack.size() != 0) {
					tempCh = stack.peek();
					
					counter *= 5;
					if (tempCh == '(') {
						counter += 1;
					} else if (tempCh == '[') {
						counter += 2;
					} else if (tempCh == '{') {
						counter += 3;
					} else if (tempCh == '<') {
						counter += 4;
					}
					stack.pop();
				}
				counterList.add(counter);
			}
		}
		in.close();
		
		Collections.sort(counterList);
		
		System.out.println(counterList.get(counterList.size()/2));
				
	}
}