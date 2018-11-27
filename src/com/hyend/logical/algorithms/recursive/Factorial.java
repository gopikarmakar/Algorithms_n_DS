package com.hyend.logical.algorithms.recursive;

public class Factorial {
	
	public int recursiveFactorial(int n) {
		
		if(n == 0) return 1;
		
		return n * recursiveFactorial(n-1);
	}
}
