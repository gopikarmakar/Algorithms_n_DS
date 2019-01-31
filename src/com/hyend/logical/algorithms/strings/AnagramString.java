package com.hyend.logical.algorithms.strings;

import java.lang.reflect.Array;

/**
 * 
 * It's a O(n) solution. 
 * Where n is the length of both the strings. 
 *  
 * @author gopi_karmakar
 *
 */
public class AnagramString {
	
	public boolean isItAnagramString(String str1, String str2) {
		
		boolean isAnagram = true;
		int str1length = str1.length();
		
		if(str1length != str2.length())
			return !isAnagram;
						
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
				 
		boolean letters[] = new boolean[str1length];
		
		int index = 0;
		char[] str1chars = str1.toCharArray();
		char[] str2chars = str2.toCharArray();
		
		for(int i = 0; i < str1length; i++) {
			
			index = str1chars[i] % str1length;
			letters[index] = !letters[index];
			
			index = str2chars[i] % str1length;
			letters[index] = !letters[index];
		}			
					
		for(int i = 0; i < str1length; i++) {
			if(letters[i]) {
				isAnagram = false;
				break;	
			}
		}
				
		return isAnagram;
	}
}
