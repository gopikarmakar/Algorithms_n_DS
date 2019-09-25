package com.hyend.data.storage.structures.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO: Complete the incomplete solution 
 * 
 * @author gopi_karmakar
 */
public class LongestSubStringContainsKDistinctCharacters {

	public static void main(String[] args) {
	
		int k = 2;
		String s = "aabbcc";
		
		SubArray subArray = findSubString(s, k);		
		System.out.println("Longest SubString With " + k + " Distinct Entries = " + s.substring(subArray.start, subArray.end));
	}
	
	static class SubArray {
		int start;
		int end;
		public SubArray(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	private static int getValueForFirstEntry(Map<String, Integer> m) {
		
		int v = 0;
		for(Map.Entry<String, Integer> entry : m.entrySet()) {
			v = entry.getValue();
			break;
		}
		return v;
	}
	
	private static SubArray findSubString(String s, int k) {
		
		int seenSoFar = 0, idx = 0, result = 0;
		SubArray subArray = new SubArray(-1, -1);
		
		Map<String, Integer> map = new LinkedHashMap<>();
		
		for(int i = 0; i < s.length(); ++i) {
			
			String ch = "" + s.charAt(i);
			
			Integer dupIdx = map.put(ch, i);
					
		}
		return subArray;
	}
}
