package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Day10A {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/Day10Input.txt"));
		
		String line;
		
		long counter = 0L;
		Stack<Character> stack;
		char ch;
		char errorCh;
		
		while ((line = in.readLine()) != null) {
			stack = new Stack<Character>();
			errorCh = ' ';
			
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
						errorCh = ch;
						break;
					}
				} else {
					stack.push(ch);
				}
			}
			
			if (errorCh == ')') {
				counter += 3;
			} else if (errorCh == ']') {
				counter += 57;
			} else if (errorCh == '}') {
				counter += 1197;
			} else if (errorCh == '>') {
				counter += 25137;
			}
		}
		in.close();
		
		System.out.println(counter);
		
	}
}