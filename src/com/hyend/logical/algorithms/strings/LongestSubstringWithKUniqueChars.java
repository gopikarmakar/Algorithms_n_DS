package com.hyend.logical.algorithms.strings;

import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;

public class LongestSubstringWithKUniqueChars {
	
	public static void main(String...args) {
		
		longestSubString("aabacbebebe", 3);
	}
	
	/**
	 * ToDo: FIX last character
	 * aabbcc
	 * @param text
	 * @param k
	 */
	private static void longestSubString(String text, int k) {
	
		Queue<String> queue = new LinkedList<String>();
		
		for(int x = 0; x < text.length()-k; x++) {
			int offset = x + k;
			for(int i = offset; i < text.length(); i++) {				
				String s = text.substring(x, i);
				if(getTotalDistinctChars(s) == k) {	
					if(text.charAt(i) == text.charAt(i-1)) continue;					
					queue.add(s);
				}				
			}
		}
		Iterator<String> itr = queue.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}		
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
}
