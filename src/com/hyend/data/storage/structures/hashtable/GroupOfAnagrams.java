package com.hyend.data.storage.structures.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Find group of Anagrams from a paragraph
 * e.g: {"algorithmic" "logarithmic"} {"elvis" "lives" "levis"} are anagrams
 * 		since all the words in those sets contains same letters to each other.
 * 
 * @author gopi_karmakar
 */
public class GroupOfAnagrams {

	public static void main(String[] args) {
		
		String[] paragraph = {"debitcard", "elvis", "silent", "badcredit", "lives", "freedom", "listen", "levis",
								"money", "eleven plus two", "algorithmic", "twelve plus one", "logarithmic"};
		
		find(paragraph);
	}
	
	/**
	 * Iterating over and sorting takes O(nm log m) time complexity
	 * Printing takes O(nm) time complexity. 
	 * Total time complexity is O(nm log m)
	 */
	private static void find(String[] words) {
		
		Map<String, List<String>> anagrams = new HashMap<>();
		
		for(String word : words) {
			
			char[] wordInChars = word.toCharArray();
			Arrays.sort(wordInChars);
			String sortedWord = new String(wordInChars);
			
			List<String> list = anagrams.getOrDefault(sortedWord, new ArrayList<>());
			list.add(word);
			anagrams.put(sortedWord, list);
		}			
		
		anagrams.values().forEach(e -> {
			System.out.println(e);
		});		
	}
}
