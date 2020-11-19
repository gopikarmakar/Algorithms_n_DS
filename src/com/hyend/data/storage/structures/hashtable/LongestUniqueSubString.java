package com.hyend.data.storage.structures.hashtable;

import java.util.Map;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Find Longest substring containing all distinct entries.
 * For e.g: s = ADOBECODEBANC return "CODEBAN" or "ODEBANC" 
 * s = "ADOBECODEBANK" return "CODEBANK"
 * Since both SubStrings are the longest and unique. 
 * 
 * @author gopi_karmakar
 */
public class LongestUniqueSubString {

	public static void main(String[] args) {
		
		//String s = "ADOBECODEBANC";
		String s = "ADOBECODEBANK";
		//String s = "abcabcbb";
		//String s = "bbbbb";
		//String s = "pwwkew";
		//String s = "abba";
				
		SubArray subArray = find(s);
		System.out.println(fetchSubStr(s, subArray.start, subArray.end));
	}
	
	static class SubArray {	
		int start = 0;
		int end = 0;
		public SubArray(int start, int end) {
			this.start = start;
			this.end = end;
		}		
	}
	
	/**
	 * The time complexity is O(n), 
	 * since we perform a constant number of operations per element.
	 */
	public static SubArray find(String s) {	
		
		int longestDupFreeStartIdx = 0, result = 0 , n = s.length();
		Map<Character, Integer> mostRecentOccurrence = new HashMap<>();
		
		SubArray subArray = new SubArray(0, 0);
		
		for(int i = 0; i < n; ++i) {
			
			Integer dupIdx = mostRecentOccurrence.put(s.charAt(i), i);			
			if(dupIdx != null) {	
				
				if(dupIdx >= longestDupFreeStartIdx) {
										
					//result = Math.max(result, i - longestDupFreeStartIdx);	
					
					if((i - longestDupFreeStartIdx) > result) {
						
						subArray.start = longestDupFreeStartIdx;
						subArray.end = i;
						result = i - longestDupFreeStartIdx;
					}
					longestDupFreeStartIdx = dupIdx + 1;
				}
			}
		}

		// For the case like "ADOBECODEBANK" when last char is all new and not present in the hashtable.
		// In that dupIdx will be null and loop will end too.
		
		//result = Math.max(result, n - longestDupFreeStartIdx);		
		if((n - longestDupFreeStartIdx) > result) {
			
			subArray.start = longestDupFreeStartIdx;
			subArray.end = n;
			result = n - longestDupFreeStartIdx;
		}
		
		System.out.println("SubString Length = " + result);
		
		return subArray;
	}
	
	private static String fetchSubStr(String s, int begin, int end) {
		return s.substring(begin, end);
	}
}
