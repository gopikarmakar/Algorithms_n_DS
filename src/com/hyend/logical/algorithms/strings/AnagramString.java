package com.hyend.logical.algorithms.strings;

import java.util.Arrays;

/**  
 * @author gopi_karmakar
 */
public class AnagramString {
	
	public static void main(String[] args) {		
		boolean val = isItAnagramString2("debitcard", "badcredit");
		if(val)
			System.out.println("It's An Anagram!");
		else
			System.out.println("It's Not An Anagram!");
	}
	
	/**
	 * It's a O(n) solution. 
	 * Where n is the length of both the strings. 
	 */
	public static boolean isItAnagramString(String str1, String str2) {
		
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
	
	/**
	 * A more simple and full proof O(n log(n)) solution. 
	 */
	public static boolean isItAnagramString2(String str1, String str2) {
		
		char[] s1 = str1.toCharArray();
		Arrays.sort(s1);
		String sortedStr1 = new String(s1);
		
		char[] s2 = str1.toCharArray();
		Arrays.sort(s2);
		String sortedStr2 = new String(s2);
		
		return sortedStr1.equals(sortedStr2);
	}
}
