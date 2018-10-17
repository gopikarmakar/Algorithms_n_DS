package com.hyend.logical.algorithms;

public class HasStringAllUniqueChars {
	
	public boolean areAllCharsUnique(String str) {
	
		boolean char_set[] = new boolean[256];
		char word[] = str.toCharArray();
		for (char ch : word) {
			int val = ch;
			if(char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
}
