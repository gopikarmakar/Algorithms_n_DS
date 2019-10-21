package com.hyend.data.storage.sort;

import java.util.Arrays;

public class ComputeSalaryThreshold {

	public static void main(String[] args) {
		
		int[] salaries = {90, 30, 100, 40, 20};
		System.out.println(compute(salaries, 3700));
	}
	
	/**
	 * The most expensive operation for this entire solution is sorting A, 
	 * hence the run time is 0(n log n).
	 */
	private static double compute(int[] salaries, double targetPayroll) {
		
		Arrays.sort(salaries);
		
		int n = salaries.length;
		double unadjustedSalarySum = 0; 
		
		for(int i = 0; i < salaries.length; ++i) {
			
			final double adjustedSalarySum = salaries[i] * (salaries[n-1]);
			
			if (unadjustedSalarySum + adjustedSalarySum >= targetPayroll) {
				
				return (targetPayroll - unadjustedSalarySum) / (n - i);
			}
			
			unadjustedSalarySum += salaries[i];
		}
			
		return -1.0;
	}
}
