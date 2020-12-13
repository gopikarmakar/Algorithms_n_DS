package com.hyend.logical.algorithms.strings;

public class CanBeMadePalindrome {

	public static void main(String[] args) {
		
		//String s = "aba";
		String s = "abcabde";
		
		System.out.println(isValid(s));
	}
	
	private static boolean isValid(String s) {
		
		boolean[] chars = new boolean[26];
		
		for(char c : s.toCharArray()) {
			
			chars[c - 'a'] = !chars[c - 'a'];
		}
		
		int count = 0;
		for(boolean v : chars) {
			
			if(v) {
				
				count++;
				if(count > 2)
					return false; 					
			}				
		}
		return true;
	}
}
