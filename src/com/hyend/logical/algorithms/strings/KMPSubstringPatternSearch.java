package com.hyend.logical.algorithms.strings;


/*
 * Knuth-Morris-Pratt(KMP) algorithm for substring pattern matching.
 * Time complexity is O(m + n) where m is the length of pattern
 * and n is the length of text string.
 * 
 * Regular brute-force algorithm takes O(m*n) time complexity
 * which is slow and naive solution. Where KMP improves the algorithm 
 * by keeping track of substring's suffix and prefix sizes.    
 */
public class KMPSubstringPatternSearch {
	
	/**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(n) where n = size of pattern.     
     * "abcdabcy"
     */
	private int[] createSuffixArray(String pattern) {
	
		int[] lps = new int[pattern.length()];
		int index = 0;
		for(int i = 1; i < pattern.length();) {
		
			if(pattern.charAt(i) == pattern.charAt(index)) {
				lps[i] = index + 1;
				index++;
				i++;
			}
			else {
				if(index != 0) {
					index = lps[index-1];
				}
				else {
					lps[i] = 0;
					i+=1;
				}
			}
		}
		return lps;
	}
	
	/**
	 * "abcxabcdabcdabcy"
	 * @param text
	 * @param pattern
	 * @return
	 */
	public boolean isKMPPatternFound(String text, String pattern) {
		
		boolean status = false;		
		int[] lps = createSuffixArray(pattern);
		
		int i = 0, j = 0;
		while((i < text.length() && j< pattern.length())) {
			
			if(text.charAt(i) == pattern.charAt(j)) {
				i+=1; j+=1;
			}
			else {
				if(j != 0) j = lps[j-1];
				else i+=1;			
			}
		}
		if(j == pattern.length())
			status = true;
		
		return status;
	}
}
