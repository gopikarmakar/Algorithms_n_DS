package com.hyend.data.storage.arrays;

import java.util.List;
import java.util.ArrayList;

/**
 * A Google interview question:
 * Compute the Kth Row of Pascal Triangle
 * 
 * @author gopi_karmakar
 */
public class ComputeKRowsOfPascalTriangle {

	public static void main(String[] args) {
	
		for(List<Integer> row : pascalTriangle(5)) {
			System.out.println(row);			
		}
	}
		
	/**
	 * Since each element takes O(1) time to compute, the time complexity is 
	 * O(n^2), Similarly, the space complexity is O(n^2)
	 * 
	 * @param numRows
	 * @return
	 */
	private static List<List<Integer>> pascalTriangle(int numRows) {
		
		List<List<Integer>> pascalTrialgle = new ArrayList<>();
		
		for(int i = 0; i <= numRows; ++i) {
			
			List<Integer> currentRow = new ArrayList<>();
			
			for(int j = 0; j <= i; ++j) {
				
				int val = (0 < j && j < i) ? 
					pascalTrialgle.get(i-1).get(j-1) + pascalTrialgle.get(i-1).get(j) : 1;
				
				currentRow.add(val);
			}
			pascalTrialgle.add(currentRow);
		}
		return pascalTrialgle;
	}
}
