package com.hyend.data.storage.structures.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A Google Interview Question
 * Find the longest substring with K distinct entries in a given string s 
 * 
 * For e.g: S = "aadbbccd" k = 3 
 * return "dbbccd" since it's the longest substring with 2 distinct entries
 * 
 * S = "aadbbccd" k = 3
 * return "dbbccd" since it's the longest substring with 3 distinct entries
 * 
 * @author gopi_karmakar
 */
public class MaximumSubStringWithKDistinctEntries {

	public static void main(String[] args) {
	
		int k = 3;

		//String s = "aadbbccd";
		
		String s = "aabacbebebe";
		
		SubArray subArray = findSubString(s, k);
		//System.out.println("Start = " + subArray.start + " End = " + subArray.end);
		//System.out.println("Longest SubString With " + k + " Distinct Entries = " + s.substring(subArray.start, subArray.end+1));
		System.out.println("" + s.substring(subArray.start, subArray.end+1));
	}
	
	static class SubArray {
		int start;
		int end;
		public SubArray(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "Start = " + start + " End = " + end;			
		}
	}	
	
	/**
	 * An efficient O(n) time with O(k) extra space complexity solution. 
	 */
	private static SubArray findSubString(String s, int k) {
		
		int idx = 0, startIdx = 0;
		
		SubArray subArray = new SubArray(-1, -1);
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();			
		
		for(char c : s.toCharArray()) {
			
			String ch = "" + c;
			
			map.remove(ch);
			map.put(ch, idx);
			
			if(map.size() > k) {
				
				removeEldestEntry(map);
				startIdx = getValueForFirstEntry(map);
			}
			
			if(map.size() == k) {																			
				
				//For minimum window change the condition
				if(subArray.start == -1 && subArray.end == -1 || 
						idx - startIdx > subArray.end - subArray.start) {
									
					subArray.start = startIdx;
					subArray.end = idx;							
				}
			}			
			idx += 1;
		}		
		return subArray;
	}
	
	private static int getValueForFirstEntry(Map<String, Integer> m) {
		
		int v = 0;
		
		System.out.println(m);
		
		for(Map.Entry<String, Integer> entry : m.entrySet()) {
			v = entry.getValue();
			break;
		}
		return v;
	}
	
	private static void removeEldestEntry(Map<String, Integer> m) {		
			
		System.out.println(m);
		
		for(Map.Entry<String, Integer> entry : m.entrySet()) {
			m.remove(entry.getKey());
			break;
		}
	}
}
