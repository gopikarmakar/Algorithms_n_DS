package com.hyend.logical.algorithms.dp.recursive;

import java.util.Set;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * A Rakuten Interview Question
 * 
 * Find out all the perfect anagram permutations.
 * 
 * A perfect anagram word should follow below conditions:
 * 1: A word should not start with any vowel.
 * 2: Two vowels shouldn't be next to each other.
 * 3: Two consonants shouldn't be next to each other. 
 * 
 * For e.g: ABC = {BAC, CAB}
 * APPLE = {PAPEL, PALEP, PEPAL, PELAP, LAPEP, LEPAP}
 *  
 * @author gopi_karmakar
 */
public class AnagramStringPermutations {

	private static Set<Character> vowels;
	
	public static void main(String[] args) {
					
		 vowels = new LinkedHashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
		 
		 Set<String> words = new LinkedHashSet<>();		 
		 anagramWordsSet("", "APPLE", words);
		 
		 for(String w : words)
			 System.out.println(w);
	}
	
	/**
	 * The time complexity still will be O(n X n!)
	 * Using HashSet to store only unique words
	 * Since during back track there'll be duplicates.	  
	 */
	private static void anagramWordsSet(String prefix, String word, Set<String> set) {
		
		int n = word.length();
		if(n == 0) {
			set.add(prefix);
		}
		else {
			for(int i = 0; i < n; ++i) {
				
				String s1 = word.substring(0, i);
				String s2 = word.substring(i+1, word.length());
				
				char ch = word.charAt(i);
								
				if(prefix.length() == 0) {
					if(!isVowel(ch)) {
												
						anagramWordsSet(prefix + ch, s1 + s2, set);					
					}
				}
				else if(prefix.length() > 0) {
					
					if((!isVowel(ch) && isVowel(prefix.charAt(prefix.length()-1))) ||
					(isVowel(ch) && !isVowel(prefix.charAt(prefix.length()-1)))) {
												
						anagramWordsSet(prefix + ch, s1 + s2, set);					
					}
				}			
			}
		}	
	}
	
	private static boolean isVowel(Character c) {
		return vowels.contains(c);
	}
}
