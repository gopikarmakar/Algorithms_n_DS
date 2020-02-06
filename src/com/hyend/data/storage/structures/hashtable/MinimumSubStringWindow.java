package com.hyend.data.storage.structures.hashtable;

import java.util.Map;
import java.util.LinkedHashMap;

/*
 * Given a string S and a string T, find the minimum window in S 
 * which should contain all the characters of T
 * 
 * e.g: S = "ADOBECODEBANC" T = "BCA"
 * return "BANC" since it's the minimum length substring 
 * which covers all the entries from queried window. 
 */
public class MinimumSubStringWindow {
	
	public static void main(String[] args) {
		
		String[] test = {"ADOBECODEBANC", "AAAAABCCCD", "AABACBEBEBE"};
		String[] query = {"BCA", "CAB", "ACCCB", "ABE"};
		String s = test[0];
		String q = query[0];		
		
		MinimumSubStringWindow minWindow = new MinimumSubStringWindow();		
		SubArray subArray = minWindow.findWindow(s, q);		
		
		System.out.println("Min Window Substring = " + s.substring(subArray.start, subArray.end+1));
	}
	
	class SubArray {
		int start;
		int end;
		public SubArray(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	/**
	 * An efficient O(n) time with O(k) extra space complexity solution
	 * where k = query.length
	 */
	private SubArray findWindow(String s, String query) {
		
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
				
				// For maximum window change the condition
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
	
	private static int getValueForFirstEntry(Map<String, Integer> m) {
		
		int result = 0;
		for(Map.Entry<String, Integer> entry : m.entrySet()) {
			//System.out.println("First Entry = " + entry.getKey() + " Index = " + entry.getValue());
			result = entry.getValue();
			break;
		}
		return result;
	}
}