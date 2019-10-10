package com.hyend.data.storage.structures.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string S and an integer K, find the longest window in S 
 * which should contain all the K distinct entries.
 * 
 * For e.g: S = "aadbbccd" k = 2 
 * return "bbcc" since it's the longest substring with 2 distinct entries
 * 
 * S = "aadbbccd" k = 3
 * return "dbbccd" since it's the longest substring with 3 distinct entries
 * 
 * @author gopi_karmakar
 */
public class LongestSubStringWindowOfKDistinctEntries {

	public static void main(String[] args) {
	
		int k = 3;
		String s = "aadbbccd";
		
		SubArray subArray = findSubString(s, k);
		//System.out.println("Start = " + subArray.start + " End = " + subArray.end);
		System.out.println("Longest SubString With " + k + " Distinct Entries = " + s.substring(subArray.start, subArray.end+1));
	}
	
	static class SubArray {
		int start;
		int end;
		public SubArray(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}	
	
	/**
	 * An efficient O(n) time with O(k) extra space complexity solution. 
	 */
	private static SubArray findSubString(String s, int k) {
		
		int idx = 0;
		SubArray subArray = new SubArray(-1, -1);
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>() {
						
			private static final long serialVersionUID = 1L;

			@Override
			public boolean removeEldestEntry(Map.Entry<String, Integer> e) {				
				return (this.size() > k);
			}
		};
		
		for(char c : s.toCharArray()) {
			
			String ch = "" + c;
			
			map.putIfAbsent(ch, idx);
					
			if(map.size() == k) {
				
				if(subArray.start == -1 && subArray.end == -1 || 
						idx - getValueForFirstEntry(map) > subArray.end - subArray.start) {
					
					subArray.start = getValueForFirstEntry(map);
					subArray.end = idx;
				}
			}			
			idx += 1;
		}
		return subArray;
	}
	
	private static int getValueForFirstEntry(Map<String, Integer> m) {
		
		int v = 0;
		for(Map.Entry<String, Integer> entry : m.entrySet()) {
			v = entry.getValue();
			break;
		}
		return v;
	}
}
