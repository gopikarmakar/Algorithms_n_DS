package com.hyend.logical.algorithms.strings;

/**
 * A Facebook Interview Question
 * 
 * Validate, whether a given sentence is palindromic.
 * Sentence can contain alpha-numerics, spaces and special chars.   
 * 
 * @author gopi_karmakar
 */
public class SentencePalindromicity {
	
	public static void main(String[] args) {
		
		String s = "A man, a plan, a canal: Panama.";
		//String s = "Able was I, ere I saw Elba!";
		//String s = "Ray a Ray";
		
		System.out.println(isPalindrome(s));
		
		System.out.println(isItPalindrome(s));
	}

	/**
	 * O(n) Time complexity	
	 * Accepted in LeetCode with 3ms Runtime.
	 */
	private static boolean isItPalindrome(String s) {
		
		s = s.toLowerCase();
		
		int i = 0, j = s.length()-1;
		
		while(i < j) {						
			
			// Both i and j skips the non-alphanumerics.
			while(!Character.isLetterOrDigit(s.charAt(i)) && i < j) { ++i; }
			
			while(!Character.isLetterOrDigit(s.charAt(j)) && j > i) { --j; }
			
			if(s.charAt(i++) != s.charAt(j--))
				return false;						
		}
		return true;
	}
	
	/**
	 * O(n) Time complexity	
	 * Accepted in LeetCode with 25ms Runtime.
	 */
	private static boolean isPalindrome(String s) {
		
		String newS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(newS);
		
		return new StringBuilder(newS).reverse().toString().equals(newS);
	}
}
