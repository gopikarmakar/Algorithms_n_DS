package com.hyend.data.storage.structures.hashtable;

import java.util.Map;
import java.util.HashMap;

/**
 * Find the nearest repeated entry in a paragraph.
 * For e.g: For below paragraph the 2nd and 3rd "no" are the nearest 
 * 
 * @author gopi_karmakar
 */
public class FindNearestRepeatedEntry {

	public static void main(String[] args) {
		
		String[] paragraph = {"All", "work", "and", "no", "play", "makes", "for", "no", "work", "no", "fun", "and", "no", "results"};
		
		NearestRepeated nrw = findNearestRepetetion(paragraph);
		System.out.println(nrw.word + " Is the nearest Repeated Distance = " + nrw.distance);
	}
	
	public static class NearestRepeated {
		
		int distance;
		String word = "";	
		
		public NearestRepeated(int distance, String word) {
			this.word = word;
			this.distance = distance;			
		}
	}
	
	/**
	 * The time complexity is O(n) since we perform a constant amount of work per entry. 
	 * The space complexity is O(d), where d is the number of distinct entries in the array.
	 */
	public static NearestRepeated findNearestRepetetion(String...paragraph) {
		
		String nrw = "";
		int nrd = Integer.MAX_VALUE;		
		Map<String, Integer> latestIdx = new HashMap<>();
		
		for(int i = 0; i < paragraph.length; i++) {
			
			if(latestIdx.containsKey(paragraph[i])) {
								
				int diff = Math.min(nrd, i - latestIdx.get(paragraph[i]));				
				if(diff < nrd) {
					nrd = diff;
					nrw = paragraph[i];
				}				
			}
			latestIdx.put(paragraph[i], i);
		}
		return new NearestRepeated(nrd, nrw);
	}
}
