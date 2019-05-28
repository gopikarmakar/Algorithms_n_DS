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
public class MinMaxtSubstringWithKUniqueChars {
	
	public static void main(String...args) {
		try {
			String s = "aabbcc";
			//String s = "aabacbebebe";
			minMaxSubStringWindow(s, 3);	
		} catch(NullPointerException npe) {
			System.out.println(npe.getMessage());
		}		
	}
	
	/** 
	 * @param text
	 * @param k
	 */
	private static void minMaxSubStringWindow(String text, int k) {
		
		if(text == null)
			throw new NullPointerException("Value can't be null");
					
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
					//System.out.println("SubString = " + s);									
					words.add(s);
					
				}
			}
		}
				
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
	
	private static boolean[] chars = new boolean[26];
	private static void TotalAADistinctChars(String text) {
		for(char c : text.toCharArray()) {
 			if(!chars[c - 'a']) {
 				chars[c - 'a'] = true;
 			} 			
 		}
	}
}
