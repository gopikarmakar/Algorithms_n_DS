package com.hyend.logical.algorithms.strings;

/**
 * Validate, whether a given sentence is palindromic.
 * Sentence can contain alpha-numerics, spaces and special chars.   
 * 
 * @author gopi_karmakar
 */
public class SentencePalindromicity {
	
	public static void main(String[] args) {
		
		//String s = "A man, a plan, a canal, Panama.";
		//String s = "Able was I, ere I saw Elba!";
		String s = "Ray a Ray";
		System.out.println(isItPalindrome(s));
	}

	/**
	 * O(n) Time complexity
	 * 
	 * @param sentence
	 * @return
	 */
	private static boolean isItPalindrome(String sentence) {
		
		int i = 0, j = sentence.length()-1;
		
		while(i < j) {
			
			// Both i and j skips the non-alphanumerics.
			while(!Character.isLetterOrDigit(sentence.charAt(i)) && i < j) { ++i; }
			
			while(!Character.isLetterOrDigit(sentence.charAt(j)) && j > i) { --j; }
			
			if(sentence.toLowerCase().charAt(i++) != sentence.toLowerCase().charAt(j--))
				return false;						
		}
		return true;
	}
}
