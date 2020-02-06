package com.hyend.logical.algorithms.strings;

/**
 * Find Longest Palindromic SubString
 *  
 * @author gopi_karmakar
 */
public class LongestPalindromeSubString {
	
	public static void main(String[] args) {
		
		String s = "babad";
		//String s = "forgeeksskeegfor";
		System.out.println(palindromicSubString(s));
	}
	
	public static String palindromicSubString(String s) {
				
		int length = s.length();
		if(length == 0)
			return "";					
		if(length == 1)
			return s;		
			
		
		int start = 0;
		int totalLength = 1;			
		int low, high;
		
		for(int i = 1; i < length; i++) {
					
			
			/**
			 * Find the longest even length palindrome with
			 * center points as i-1 and i.
			 */
			low = i-1;
			high = i;
			while(low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
				
				if((high-low)+1 > totalLength) {
					start = low;
					totalLength = high-low+1; 
				}
				--low;
				++high;
			}
			
			low = i-1;
			high = i+1;
			while(low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
				
				if((high-low)+1 > totalLength) {
					start = low;
					totalLength = high-low+1;
				}
				--low;
				++high;
			}
		}
		return s.substring(start, start+totalLength);
	}
}
