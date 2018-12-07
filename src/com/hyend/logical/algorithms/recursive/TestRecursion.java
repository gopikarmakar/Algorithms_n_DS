package com.hyend.logical.algorithms.recursive;

public class TestRecursion {
	
	public static void main(String[] args) {
		Factorial fact = new Factorial();		
		PrintMSG(fact.recursiveFactorial(4));
	}
	
	private static void PrintMSG(Object msg) {
		System.out.println(msg);
	}
}
