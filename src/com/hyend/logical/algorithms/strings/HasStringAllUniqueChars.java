package com.hyend.logical.algorithms.strings;

/**
 * @author gopi_karmakar
 */
public class HasStringAllUniqueChars {
	
	public static void main(String[] args) {
		
		String s = "education";
		//String s = "a man, a plan, a canal: Panama.";
		System.out.println(areAllCharsUnique(s));
	}
	
	public static boolean areAllCharsUnique(String s) {
	
		boolean char_set[] = new boolean[256];
		
		for (char ch : s.toCharArray()) {
			
			int val = ch;
			if(char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
}

