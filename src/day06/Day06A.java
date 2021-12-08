package day06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day06A {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/Day06Input.txt"));
		
		String line;
		String[] initialFish = {};
		ArrayList<Integer> fishList = new ArrayList<Integer>();
		
		while ((line = in.readLine()) != null) {
			initialFish = line.split(",");
		}
		
		for (int i = 0; i < initialFish.length; i++) {
			fishList.add(Integer.parseInt(initialFish[i]));
		}		
		in.close();
		
		int tempFish;
		
		for (int i = 0; i < 80; i++) {
			for (int j = 0; j < fishList.size(); j++) {
				tempFish = fishList.get(j);
				if (tempFish == 0) {
					fishList.set(j, 6);
					fishList.add(9);
				} else {
					fishList.set(j, tempFish - 1);
				}
			}
		}
		
		System.out.println(fishList.size());
		
	}
}