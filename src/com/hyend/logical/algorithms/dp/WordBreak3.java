package com.hyend.logical.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word. 
 * Return all such possible sentences.
 * 
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * https://leetcode.com/problems/word-break-ii/
 * 
 * @author gopi_karmakar
 */
public class WordBreak3 {

	public static void main(String[] args) {
		
		String s1 = "catsanddog";
		String[] words1 = {"cat", "cats", "and", "sand", "dog"};
		
		String s2 = "catsandog";
		String[] words2 = {"cats", "dog", "sand", "and", "cat"};
		
		String s3 = "pineapplepenapple";
		String[] words3 = {"apple", "pen", "applepen", "pine", "pineapple"};				
				
		Set<String> wordsDict = new HashSet<>(Arrays.asList(words1));
		
		Map<Integer, List<String>> map = new HashMap<>();
		
		map.put(0, Arrays.asList(""));
		
		wordBreak(s1, s1.length(), map, wordsDict);
		
		System.out.println(map.get(s1.length()));
						
		List<List<String>> result = new ArrayList<>();
		
		compute(0, s1, wordsDict, new ArrayList<>(), result);
		
		System.out.println(result);
		
		List<String> sentences = new ArrayList<>();
		
		compute(0, s1, wordsDict, "", sentences);	
		
		System.out.println(sentences);			
	}
	
	/**
	 * Leetcode accepted code.
	 */
	private static void wordBreak(String s, int right, 
			Map<Integer, List<String>> map, Set<String> dict) {
		
		map.putIfAbsent(right, new ArrayList<>());
		
		for(int left = 0; left < right; left++) {
			
			String suffix = s.substring(left, right);
			
			if(dict.contains(suffix)) {
				
				if(!map.containsKey(left)) {
					wordBreak(s, left, map, dict);
				}
				
				for(String w: map.get(left)) {
					
					if(w.equals(""))
						map.get(right).add(suffix);
					else
						map.get(right).add(w + " " + suffix);
				}
			}
		}		
	}
	
	/**
	 * The worst-case time complexity is still O(n ^ 2), 
	 * e.g., if the input string consists of n repetitions of a single character. 
	 * However, the program has much better best-case time complexity than the
	 * brute-force approach, e.g., when there are very few words.
	 */
	private static void compute(int offset, String s, Set<String> words, List<String> partial, List<List<String>> result) {

		if(offset == s.length()) {

			result.add(new ArrayList<>(partial));
			return;
		}		

		for(int i = offset + 1; i <= s.length(); ++i) {

			String prefix = s.substring(offset, i);

			if(words.contains(prefix)) {

				partial.add(prefix);

				compute(i, s, words, partial, result);

				partial.remove(partial.size() - 1);
			}
		}
	}
	
	// Result as a sentence
	private static void compute(int offset, String s, Set<String> words, String partial, List<String> sentences) {

		if(offset == s.length()) {

			sentences.add(partial.trim());
			return;
		}		

		for(int i = offset + 1; i <= s.length(); ++i) {

			String prefix = s.substring(offset, i);

			if(words.contains(prefix)) {

				partial += prefix + " ";

				compute(i, s, words, partial, sentences);

				partial = partial.substring(0, partial.length() - (prefix.length() + 1));
			}
		}
	}	
}
