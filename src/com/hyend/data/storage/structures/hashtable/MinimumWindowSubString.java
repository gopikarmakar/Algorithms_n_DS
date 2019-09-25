package com.hyend.data.storage.structures.hashtable;

import java.util.Map;
import java.util.LinkedHashMap;

/*
 * 
 */
public class MinimumWindowSubString {
	
	public static void main(String[] args) {
		
		String[] test = {"ADOBECODEBANC", "AAAAABCCCD"};
		String[] query = {"BD", "CAB", "ACCCB"};
		String s = test[1];
		String q = query[1];		
		
		SubArray subArray = findWindow(s, q);		
		System.out.println("Min Window Substring = " + s.substring(subArray.start, subArray.end+1));
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
		
		int result = 0;
		for(Map.Entry<String, Integer> entry : m.entrySet()) {
			result = entry.getValue();
			break;
		}
		return result;
	}
	
	private static SubArray findWindow(String s, String query) {
		
		int seenSoFar = 0, idx = 0;
		SubArray subArray = new SubArray(-1, -1);
		
		Map<String, Integer> dict = new LinkedHashMap<>();		
		for(char c : query.toCharArray()) {
			dict.put(""+c, null);
		}
		
		for(char c : s.toCharArray()) {
			
			String ch = ""+c; 
			if(dict.containsKey(ch)) {
				Integer v = dict.get(ch);
				
				if(v == null) seenSoFar += 1;
				
				dict.remove(ch);
				dict.put(ch, idx);
			}
			
			if(seenSoFar == dict.size()) {
				
				if((subArray.start == -1 && subArray.end == -1) || 
						idx - getValueForFirstEntry(dict) < subArray.end - subArray.start) {
					
					subArray.start = getValueForFirstEntry(dict);
					subArray.end = idx;
				}					
			}
			++idx;
		}		
		return subArray;
	}
}