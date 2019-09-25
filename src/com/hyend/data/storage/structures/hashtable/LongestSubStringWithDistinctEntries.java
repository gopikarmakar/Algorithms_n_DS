package com.hyend.data.storage.structures.hashtable;

import java.util.Map;
import java.util.LinkedHashMap;

public class LongestSubStringWithDistinctEntries {

	public static void main(String[] args) {
		
		String s = "ADOBECODEBANC";
		//String s = "ADOBECODEBANK";
		find(s);
	}
	
	public static void find(String s) {
		
		String longestDistinctSubStr = "";
		int longestDupFreeStartIdx = 0, result = 0 , n = s.length();
		Map<Character, Integer> mostRecentOccurrence = new LinkedHashMap<>(10, 0.75f, false);
		
		for(int i = 0; i < n; ++i) {
			
			Integer dupIdx = mostRecentOccurrence.put(s.charAt(i), i);
			
			if(dupIdx != null) {
				
				if(dupIdx >= longestDupFreeStartIdx) {
					
					int diff = Math.max(result, i - longestDupFreeStartIdx);
					if(diff > result) {
						result = diff;
						longestDistinctSubStr = fetchSubStr(s, longestDupFreeStartIdx, longestDupFreeStartIdx+result);
					}
					longestDupFreeStartIdx = dupIdx + 1;					
				}
			}
		}
		
		// This case is for, ADOBECODEBANK 
		// When the last character is also unique, then		
		int diff = Math.max(result, n - longestDupFreeStartIdx); 				
		       
		if(diff > result) {
			result = diff;
			longestDistinctSubStr = fetchSubStr(s, longestDupFreeStartIdx, longestDupFreeStartIdx+result);
		}
				
		System.out.println(longestDistinctSubStr);
	}
	
	private static String fetchSubStr(String s, int begin, int end) {
		return s.substring(begin, end);
	}
}
