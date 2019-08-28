package com.hyend.logical.algorithms.strings;

public class Palindromicity {
	
	public static void main(String[] args) {				
		
		//String s = "MALAYALAM";
		String s = "MALYALAM";
		System.out.println(isPalindrome(s));
	}

	/**
	 * O(n) time complexity where n = s.length()/2
	 *  
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		
		int i = 0, j = s.length()-1;
		
		while(i < j) {
			
			if(s.toLowerCase().charAt(i++) != s.toLowerCase().charAt(j--)) 
				return false;
		}
		return true;
	}	
}