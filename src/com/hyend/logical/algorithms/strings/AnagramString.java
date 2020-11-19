package com.hyend.logical.algorithms.strings;

import java.util.Arrays;

/**  
 * @author gopi_karmakar
 */
public class AnagramString {
	
	public static void main(String[] args) {	
		
//		String s1 = "debitcard";
//		String s2 = "badcredit";
		
		String s1 = "INTEGRAL";
		String s2 = "TRIANGLE";
		
		boolean val = isItAnagramString(s1, s2);
		
		if(val)
			System.out.println("It's An Anagram!");
		else
			System.out.println("It's Not An Anagram!");
	}
	
	/**
	 * A more simpler and full proof solution with O(n log n) time and space complexity.
	 * Where n is the number of characters of str1.
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
	
	/**
	 * It's a O(n) solution with O(n) extra space
	 * Where n is the length of both the strings. 
	 */
	public static boolean isItAnagramString(String str1, String str2) {
		
		boolean isAnagram = true;
		int str1length = str1.length();
		
		if(str1length != str2.length())
			return !isAnagram;
		
		boolean letters[] = new boolean[str1length];
		
		int index = 0;
		char[] str1chars = str1.toLowerCase().toCharArray();
		char[] str2chars = str2.toLowerCase().toCharArray();
		
		for(int i = 0; i < str1length; i++) {
			
			index = str1chars[i] % str1length;
			System.out.println("" + (int)str1chars[i] + " = " + index);
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
