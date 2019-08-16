package com.hyend.logical.algorithms.dp;

import java.util.Random;

public class UniformRandom {
	
	public int uniformRandom(int lowerBound, int upperBound) { 
		
		int numberOfOutcomes = upperBound - lowerBound + 1, result; 
		
		do{
			result = 0;
			for (int i = 0; (1 << i) < numberOfOutcomes; ++i) {
			//zeroOneRandom() is the provided random number generator.
				result = (result << 1)| zeroOneRandom();
			}
		} while (result >= numberOfOutcomes); 
		return result + lowerBound;
	}
	
	private int zeroOneRandom() {
		
		Random rand = new Random();		
		return rand.nextInt(1);
	}
}
