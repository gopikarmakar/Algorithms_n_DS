package com.hyend.logical.algorithms;

public class TestAlgorithms {
	
	public static void main(String[] args) {
		
		int[] arr = {8, 9, 7, 12, 11, 10, 1};
		FindFirstMissingPositive findMinPositive = 
				new FindFirstMissingPositive();
		
		int result = findMinPositive.findFirstMinPositive(arr);
		
		System.out.println("First Minimum Positive = " + result);
	}
}
