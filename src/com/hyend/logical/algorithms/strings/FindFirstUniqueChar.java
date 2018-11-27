package com.hyend.logical.algorithms.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstUniqueChar {	
	Map<Character, Integer> uniqueChars =
			new LinkedHashMap<Character, Integer>();	
 	
	public char findFirstUniqueChar(String str) {
		str = str.toLowerCase();
	   for(int i = 0; i < str.length(); i++) {
		   char ch = str.charAt(i);
		   uniqueChars.put(ch, uniqueChars.containsKey(ch) ? 
				   uniqueChars.get(ch) + 1 : 1);
	   }
	   char uniqueChar = 0;
	   for(Character c: uniqueChars.keySet()) {
	 		if(uniqueChars.get(c) == 1) {
	 			uniqueChar = c;
	 			break;
	 		}
	   }
	   return uniqueChar;
	} 	
}
