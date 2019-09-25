package com.hyend.data.storage.structures.hashtable;

import java.util.HashMap;
import java.util.Map;


/*
 * It passes for below case but It'll fail for some cases.
 * Not a full fledged solution still need to improve.
 */
public class MinimumWindowString {
	
	public static void main(String[] args) {
		System.out.println("Min Window Substring = " + minWindow("ADOBECODEBANC", "CAB"));
		//System.out.println("Min Window Substring = " + minWindow("ADOBECODEBANC", "BD"));
		//System.out.println("Min Window Substring = " + minWindow("AAAAABCCCD", "ACCCB"));
	}
	
	private static class MinWindow {
		
		private int tIndex = 0;
		private int startIndex = 0;
		private int minEndIndex = 0;
		private int minStartIndex = 0;
		private int minWindow = Integer.MAX_VALUE;
		
		public MinWindow() {}
		
		public void setMinWindow(int si, int ei) {
			int v = ei-si;			
			if(v < minWindow) {				
				minWindow = v;
				minEndIndex = ei;
				minStartIndex = si;
			}
		}
	}

	private static String minWindow(String s, String t) {
		
		MinWindow mw = new MinWindow();
		Map<String, Integer> toSearch = new HashMap<>();		
		Map<String, Integer> fromSearch = new HashMap<>();	
		
		for(char c : t.toCharArray())
			mapFrequency(""+c, toSearch);
		
		for(int i = 0; i < s.length(); i++) {
			mapSubString(i, ""+s.charAt(i), s, t.length(), mw, toSearch, fromSearch);			
		}
		
		return s.substring(mw.minStartIndex, mw.minEndIndex);
	}
		
	private static void mapSubString(int index, String w, String s, int tLen, MinWindow mw,
			Map<String, Integer> toSearch, Map<String, Integer> fromSearch) {
		
		Integer freq = toSearch.get(w);
		if(freq == null)	
			return;
		
		mapFrequency(w, fromSearch);
		
		if(mw.tIndex == 0) {			
			mw.startIndex = index;
		}
		
		if(fromSearch.get(w) > freq) {
			mw.startIndex = index-1;
			return;
		}
		
		mw.tIndex++;
		if(mw.tIndex == tLen) {
			mw.tIndex = 0;			
			mw.setMinWindow(mw.startIndex, index+1);
			String sub = s.substring(mw.startIndex, index+1);
			System.out.println("Substring = " + sub);
			fromSearch.clear();
			return;
		}
		return;
	}
	
	private static void mapFrequency(String w, Map<String, Integer> map) {	
		Integer v =  map.get(w);
		if(v == null) {
			map.put(w, 1);
		}
		else map.put(w, map.get(w)+1);
	}
}
