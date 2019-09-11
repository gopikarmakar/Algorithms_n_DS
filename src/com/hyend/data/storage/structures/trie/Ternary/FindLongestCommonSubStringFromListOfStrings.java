package com.hyend.data.storage.structures.trie.Ternary;

import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Longest common substrings from a list of strings.
 *  
 * @author gopi_karmakar
 */
public class FindLongestCommonSubStringFromListOfStrings {

	public static void main(String[] args) {
		
		String[] keys = {"disadvantage", "sysadmin", "omsadhu", "crusade", "misadvice"};
		
		//String[] keys = {"disgrace", "graceful", "disgraceful", "ungracefully", "gracefully"};
		
		longestCommonSubString(keys);			
	}
	
	/**
	 * Trie creation will take O(n log n) time
	 * Matching of all possible sub strings with the list of Strings
	 * will take O(n^2) time.
	 */
	private static void longestCommonSubString(String[] keys) {

		Node<Character, String> trie = null;
		
		for(String s : keys) {
			
			int n = s.length();
			
			for(int i = 0; i < n/2; i++) {
				
				String key = s.substring(i, n-i);
				trie = TernaryTrieDictionary.createPrefixTrie(key, true);
				trie = TernaryTrieDictionary.createSuffixTrie(key, true);
			}
		}		
		
		System.out.println("Longest Common Sub String = " + find(trie, keys));

		//System.out.println(lcss);
	}
	
	private static String find(Node<Character, String> trie, String[] keys) {
		
		Iterator<Map.Entry<String, Integer>> itr = TrieDictionaryTraversals.getMap(trie).entrySet().iterator();
		
		String lcss = "";		
		int maxLength = 0;
		int frequency = 0;		
		int totalKeys = keys.length;
		
		while(itr.hasNext()) {			
			
			Entry<String, Integer> entry = itr.next();
			
			String s = entry.getKey();
			
			for(String k : keys) {
									
				if(k.contains(s)) {
					frequency += 1;			
				}								
			}			
			
			int length = entry.getValue(); 
			if(frequency == totalKeys && length > maxLength) {
				maxLength = length;
				lcss = s;  
			}
			frequency = 0;
		}
		return lcss;
	}
	
	/**
	 * A little inefficient since it check the duplicates too.
	 */
	private static String lcss = "";		
	private static int maxLength = 0;
	private static int frequency = 0;
	public static void findRecursively(Node<Character, String> trie, String[] keys) {
	
		if(trie == null)
			return;
		
		if(trie.v != null) {
			
			for(String k : keys) {
				
				if(k.contains(trie.v)) {
					frequency += 1;			
				}								
			}
			
			if(frequency == keys.length && trie.v.length() > maxLength) {
				maxLength = trie.v.length();
				lcss = trie.v;  
			}
			frequency = 0;
		}
		
		findRecursively(trie.left, keys);
		findRecursively(trie.mid, keys);
		findRecursively(trie.right, keys);
	}
}