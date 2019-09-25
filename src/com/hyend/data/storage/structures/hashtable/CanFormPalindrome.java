package com.hyend.data.storage.structures.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Palindromic Permutation: 
 * Find out can a non palindrome string formed to be palindrome.
 * For e.g: "edified" can be permuted to form a palindrome string "deified"
 * 
 * @author gopi_karmakar
 */
public class CanFormPalindrome {
	
	public static void main(String[] args) {
		//String s = "geeksogeeks";
		//String s = "abcabcd";
		//String s = "abcabcde";
		String s = "edifiedd";
		System.out.println("Can it be formed = " + canFormPalindrome(s));
	}
	
	/**
	 * O(n) time complexity
	 */
	public static boolean canFormPalindrome(String s) {		
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char c : s.toCharArray()) {	
			
			int x = map.getOrDefault(c, 0);
			map.put(c, x+1);			
		}
		
		int odd = 0;
		for(int x : map.values()) {
			if(x % 2 != 0 && ++odd > 1)
				return false;
		}
		return true;
	}		
}
