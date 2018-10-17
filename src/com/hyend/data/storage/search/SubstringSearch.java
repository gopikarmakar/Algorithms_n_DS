package com.hyend.data.storage.search;

public class SubstringSearch {
	
	public SubstringSearch(char[] str, char[] pattern) {
		recursiveSearch(str, pattern, 0, 0);
	}
	
	public boolean recursiveSearch(char[] str, char[] pattern, int i, int j) {
		
		if(j == pattern.length)		return true;
		
		if(i >= str.length)			return false;
		
		if(str[i] == pattern[j]) 	return (recursiveSearch(str, pattern, i+1, j+1));
		
		else						return (recursiveSearch(str, pattern, i-j+1, 0));
	}
}
