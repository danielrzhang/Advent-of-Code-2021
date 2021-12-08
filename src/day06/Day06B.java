package day06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day06B {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("res/Day06Input.txt"));
		
		String line;
		String[] initialFish = {};
		HashMap<Integer, Long> fishMap = new HashMap<Integer, Long>();
		
		for (int i = 0; i <= 8; i++) {
			fishMap.put(i, 0L);
		}
		
		while ((line = in.readLine()) != null) {
			initialFish = line.split(",");
		}
		in.close();

		int tempInitialFish;
		for (int i = 0; i < initialFish.length; i++) {
			tempInitialFish = Integer.parseInt(initialFish[i]);
			fishMap.put(tempInitialFish, fishMap.getOrDefault(tempInitialFish, 0L) + 1);
		}	
		
		
		for (int i = 0; i < 256; i++) {
			HashMap<Integer, Long> copyMap = new HashMap<Integer, Long>();
			
			for (int fish: fishMap.keySet()) {
				
				if (fish > 0) {
					copyMap.put(fish - 1, copyMap.getOrDefault(fish - 1, 0L) + fishMap.get(fish));
				} else if (fish == 0) {
					copyMap.put(6, copyMap.getOrDefault(fish, 0L) + fishMap.get(fish));
					copyMap.put(8, fishMap.get(fish));
				}
			}
			
			fishMap = copyMap;
		}
		
		long fishCounter = 0;
		
		for (long fish: fishMap.values()) {
			fishCounter += fish;
		}
		System.out.println(fishCounter);
	}
}
