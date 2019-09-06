package com.hyend.data.storage.structures.trie.Ternary;

/**
 * A Google interview Question:
 * 
 * Find all distinct substrings of a given string of any length
 * 
 * @author gopi_karmakar
 */
public class FindAllDistinctSubStringsOfAnyLength {

	public static void main(String[] args) {
		
		String key = "aabbcc";
		findAllDistinctSubStrings(key);
	}
	
	/**
	 * A very efficient solution:
	 * Prefix and Suffix Trie creation of n*(n/2) nodes takes O((n log n) time and 
	 * traversal of all nodes takes O(n) time. In total it takes O(n log n) time. 
	 */
	private static void findAllDistinctSubStrings(String key) {
		
		int n = key.length();
		Node<Character, String> trie = null;				
		
		for(int i = 0; i < n/2; i++) {
			
			String s = key.substring(i, n-i);
			trie = TernaryTrieDictionary.createPrefixTrie(s);
			trie = TernaryTrieDictionary.createSuffixTrie(s);
		}
		
		TrieDictionaryTraversals.printAllDistinctNodes(trie);
		TrieDictionaryTraversals.printAllNodes(trie);
	}
}
