package com.hyend.logical.algorithms.dp.recursive;

public class Combinations {

	private static String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static void main(String[] args) {
		
		int n = 3;
		String elements = alphabets.substring(0, n);
		stringCombinations("", elements);
	}	
	
	private static void stringCombinations(String prefix, String s) {
		
		if(s.length() > 0) {
			System.out.println(prefix + s.charAt(0));
		
			stringCombinations(prefix + s.charAt(0), s.substring(1));
			stringCombinations(prefix,               s.substring(1));
		}
	}
}
