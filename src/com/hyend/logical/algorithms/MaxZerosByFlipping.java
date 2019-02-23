package com.hyend.logical.algorithms;

public class MaxZerosByFlipping {

	public int getMaxZeroes(int[] arr) {
		
		int max = 0;
		int countOnes = 0;
		int countZeros = 0;
		
		for(int i=0; i < arr.length; i++) {
							
			if(arr[i] == 1)
				countOnes += 1;
			else {				
				if(countOnes > max) {
					max = countOnes;
				}
				countOnes = 0;
				countZeros += 1;
			}
		}
		return max + countZeros;
	}	
}
