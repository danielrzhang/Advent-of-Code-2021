package day04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day04A {
	
	// Solution: 44736
	
	public static int[] stringToIntegerArray(String[] array) {
		int[] newArray = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			newArray[i] = Integer.parseInt(array[i]);
		}
				
		return newArray;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("src/day04/Day04Input.txt"));
		ArrayList<Board> boardList = new ArrayList<Board>();
		int[] markedNumbers = stringToIntegerArray(in.readLine().split(","));
				
		Board board = null;
		String line;
		String[] row;
		int counter = 0;
		
		boolean foundBingo = false;
		Board bingoBoard = null;
		int calledNumber = 0;
		
		// Reading Input
		while ((line = in.readLine()) != null) {
			if (counter == 0) {
				board = new Board();
			} else {
				row = line.trim().split("\\s+");
				board.addRow(stringToIntegerArray(row));
			}
			counter++;
			
			if (counter == 6) {
				boardList.add(board);
				counter = 0;
			}
		}
		in.close();
		
		
		// Iterate through Bingo number selection
		for (int i = 0; i < markedNumbers.length; i++) {			
			// Iterate through list of boards
			for (Board b: boardList) {
				b.findNum(markedNumbers[i]);
								
//				b.printNumBoard();
//				b.printBoolBoard();
				
				b.checkBingo();

				if (b.isBingo) {
					foundBingo = true;
					bingoBoard = b;
					calledNumber = markedNumbers[i];
					break;
				}
			}
			
			if (foundBingo) {
				break;
			}
		}
		
		int sumOfUnmarked = 0;
		
		for (int i = 0; i < bingoBoard.numBoard.length; i++) {
			for (int j = 0; j < bingoBoard.numBoard[i].length; j++) {
				if (!bingoBoard.boolBoard[i][j]) {
					sumOfUnmarked += bingoBoard.numBoard[i][j];
				}
			}
		}
		System.out.println(sumOfUnmarked * calledNumber);
	}
}

//class Board {
//	int[][] numBoard;
//	boolean[][] boolBoard;
//	int rowCounter;
//	boolean isBingo;
//	
//	public Board() {
//		rowCounter = 0;
//		numBoard = new int[5][5];
//		boolBoard = new boolean[5][5];
//		isBingo = false;
//	}
//	
//	public void addRow(int[] row) {
//		numBoard[rowCounter] = row;
//		rowCounter++;
//	}
//	
//	public void findNum(int num) {
//		boolean found = false;
//		for (int i = 0; i < numBoard.length; i++) {
//			for (int j = 0; j < numBoard[i].length; j++) {
//				if (numBoard[i][j] == num) {
//					boolBoard[i][j] = true;
//					found = true;
//					break;
//				}
//			}
//			if (found) {
//				break;
//			}
//		}
//	}
//	
//	public void checkBingo() {
//		boolean bingoRow = true;
//		boolean bingoColumn = true;
//		
//		for (int i = 0; i < boolBoard.length; i++) {
//			bingoRow = true;
//			
//			for (int j = 0; j < boolBoard[i].length; j++) {
//				if (!boolBoard[i][j]) {
//					bingoRow = false;
//					break;
//				}
//			}
//			
//			if (bingoRow) {
//				isBingo = true;
//				return;
//			}
//		}
//		
//		for (int i = 0; i < boolBoard.length; i++) {
//			bingoColumn = true;
//			
//			for (int j = 0; j < boolBoard[i].length; j++) {
//				if (!boolBoard[j][i]) {
//					bingoColumn = false;
//					break;
//				}
//			}
//			
//			if (bingoColumn) {
//				isBingo = true;
//				return;
//			}
//		}
//	}
//	
//	public void printNumBoard() {
//		String tempRow;
//		for (int i = 0; i < numBoard.length; i++) {
//			tempRow = "[";
//			for (int j = 0; j < numBoard[i].length; j++) {
//				tempRow += numBoard[i][j] + " ";
//			}
//			tempRow = tempRow.trim();
//			tempRow += "]";
//			System.out.println(tempRow);
//		}
//		System.out.println();
//	}
//	
//	public void printBoolBoard() {
//		String tempRow;
//		for (int i = 0; i < boolBoard.length; i++) {
//			tempRow = "[";
//			for (int j = 0; j < boolBoard[i].length; j++) {
//				if (boolBoard[i][j]) {
//					tempRow += "O ";
//				} else {
//					tempRow += ". ";
//				}
//			}
//			tempRow = tempRow.trim();
//			tempRow += "]";
//			System.out.println(tempRow);
//		}
//		System.out.println();
//	}
//}
