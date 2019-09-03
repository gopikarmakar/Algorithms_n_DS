package com.hyend.logical.algorithms.strings;

import java.util.Set;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * A Google interview question
 * Minimum and Maximum substring window with K distinct characters.
 * 
 * @author gopi_karmakar
 */
public class MinMaxtSubstringWindowWithKDistinctChars {
	
	public static void main(String...args) {
		//String s = "aabbcc";
		//String s = "aabacbebebe";
		String s = "abcxaabbcyabcz";
		minMaxSubStringWindow(s, 4);		
	}
	
	/** 
	 * An almost O(n^2) time complexity solution.
	 * @param text
	 * @param k
	 */
	private static void minMaxSubStringWindow(String text, int k) {
		
		if(text == null || text.isEmpty())
			return;			
					
		/**
		 * LinkedHashSet because to retrieve the values in insertion order.
		 */
		Set<String> words = new LinkedHashSet<String>();		
		text += "\0";
		for(int x = 0; x < text.length()-k; x++) {
			int offset = x + (k-1);
			for(int i = offset; i < text.length(); i++) {	
				String s = text.substring(x, i);				
				if(getTotalDistinctChars(s) == k) {									
					words.add(s);					
				}
			}
		}
		print(words);
	}	
	
	private static int getTotalDistinctChars(String text) {
 		int count = 0;
 		boolean[] chars = new boolean[26];
 		for(char c : text.toCharArray()) {
 			if(!chars[c - 'a']) {
 				count += 1;
 				chars[c - 'a'] = true;
 			} 
 		}
 		return count;
 	}
	
	private static void print(Set<String> words) {
		
		String minSubString = "";
		String maxSubString = "";
		int max = 0, min = Integer.MAX_VALUE;
		Iterator<String> itr = words.iterator();
		while(itr.hasNext()) {
			String s = itr.next();
			System.out.println(s);
			if(max < s.length()) {				
				max = s.length();
				maxSubString = s;
			}
			if(min > s.length()) {
				min = s.length();
				minSubString = s;
			}
		}
		System.out.println("Minimum Substring Window = " + minSubString + " Of Length = "+ (min == Integer.MAX_VALUE ? 0 : min) );
		System.out.println("Maximum Substring Window = " + maxSubString + " Of Length = "+ max);
	}
}
