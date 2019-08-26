package com.hyend.logical.algorithms.dp.recursive;

public class Combinations {

	String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Combinations() {}
	
	public Combinations(int n) {
		String elements = alphabets.substring(0, n);
		stringCombinations("", elements);
	}
	
	private void stringCombinations(String prefix, String s) {
		
		if(s.length() > 0) {
			System.out.println(prefix + s.charAt(0));
		
			stringCombinations(prefix + s.charAt(0), s.substring(1));
			stringCombinations(prefix,               s.substring(1));
		}
	}
}
