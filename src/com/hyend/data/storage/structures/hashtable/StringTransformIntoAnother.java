package com.hyend.data.storage.structures.hashtable;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

/**
 * A Google Onsite Interview Question
 * 
 * Can a string transform into another
 * for e.g: s1 = "aabcc" s2 = "ccdee" = true
 * since here, both a can map to c, b can map to d both c can map to e
 * 
 * s1 = "aabcc" s2 = "cedec" = false
 * Since here both a's maps different chars to c and e, so it's not possible.
 * 
 * https://leetcode.com/problems/string-transforms-into-another-string/
 * 
 * @author gopi_karmakar
 */
public class StringTransformIntoAnother {

	public static void main(String[] args) {
		
		String s1 = "aabcc";
		String s2 = "ccdee";
		
		//String s1 = "aabcc";
		//String s2 = "cedec";
				
		//String s1 = "abcdefghijklmnopqrstuvwxyz";
		//String s2 = "bbcdefghijklmnopqrstuvwxyz";

		//String s1 = "abcdefghijklmnopqrstuvwxyz";
		//String s2 = "bcdefghijklmnopqrstuvwxyza";
		
		System.out.println(canTransform(s1, s2));					
	}
	
	/**
	 * O(n) Time and space complexity.
	 * Where n is size of Strings 
	 */
	private static boolean canTransform(String s1, String s2) {	
		
		Set<Character> str2 = new HashSet<>();
		Map<Character, Character> map = new HashMap<>();
		
		for(int i = 0; i < s1.length(); ++i) {
			
			str2.add(s2.charAt(i));
			
			if(map.containsKey(s1.charAt(i)) && map.get(s1.charAt(i)) != s2.charAt(i))
				return false;
			
			map.put(s1.charAt(i), s2.charAt(i));
		}
		/** 
		 * For Such cases:
		 * String s1 = "abcdefghijklmnopqrstuvwxyz";
		 * String s2 = "bcdefghijklmnopqrstuvwxyza";
		 */
		if(!s1.equals(s2) && map.size() == 26 && str2.size() == 26)
			return false;
		
		return true;
	}
}
