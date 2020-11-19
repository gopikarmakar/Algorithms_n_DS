package com.hyend.logical.algorithms.strings;

import java.util.Map;
import java.util.HashMap;

/**
 * @author gopi_karmakar
 */
public class FindFirstUniqueChar {	
	
	public static void main(String[] args) {
		
		String s = "gcccxyxygcxyyxxgzgycxy";
		System.out.println("Unique Char = " + find(s));
	}	
 	
	public static char find(String str) {
		
		Map<Character, Integer> uniqueChars = new HashMap<>();
		
		str = str.toLowerCase();
		
		for(char c : str.toCharArray()) {
		   		   
			int v = uniqueChars.getOrDefault(c, 0);
			uniqueChars.put(c, v + 1);
		}
	   
	   char uniqueChar = '0';
	   for(Character c: uniqueChars.keySet()) {
		   
	 		if(uniqueChars.get(c) == 1) {
	 			uniqueChar = c;
	 			break;
	 		}
	   }
	   return uniqueChar;
	} 	
}
