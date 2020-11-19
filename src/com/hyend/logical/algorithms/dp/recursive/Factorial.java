package com.hyend.logical.algorithms.dp.recursive;

public class Factorial {
	
	public static void main(String[] args) {
		System.out.println(recursiveFactorial(5));
	}
	
	public static int recursiveFactorial(int n) {
		
		if(n == 0) return 1;
		return n * recursiveFactorial(n-1);
	}	
}
