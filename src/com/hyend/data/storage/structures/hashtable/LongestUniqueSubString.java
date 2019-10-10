package com.hyend.data.storage.structures.hashtable;

import java.util.Map;
import java.util.HashMap;

/**
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
		
		for(int i = 0; i < n; ++i) {
			
			Integer dupIdx = mostRecentOccurrence.put(s.charAt(i), i);			
			if(dupIdx != null) {				
				if(dupIdx >= longestDupFreeStartIdx) {
					result = Math.max(result, i - longestDupFreeStartIdx);					
					longestDupFreeStartIdx = dupIdx + 1;					
				}
			}
		}
		// Updating the final result in case of (dupIdx == null & dupIdx < longestDupFreeStartIdx)
		result = Math.max(result, n - longestDupFreeStartIdx);				
		return new SubArray(longestDupFreeStartIdx, longestDupFreeStartIdx + result);
	}
	
	private static String fetchSubStr(String s, int begin, int end) {
		return s.substring(begin, end);
	}
}
