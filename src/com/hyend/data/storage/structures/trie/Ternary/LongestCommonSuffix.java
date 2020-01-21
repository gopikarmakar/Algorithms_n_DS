package com.hyend.data.storage.structures.trie.Ternary;

/**
 * Google Interview Question:
 * 
 * Find the longest common suffix of a given query from a dictionary of words.
 * 
 * @author gopi_karmakar
 */
public class LongestCommonSuffix {

	public static void main(String[] args) {
		
		String[] dict = {"abccc", "abcc", "abcd", "abcccd", "abccccccdddd"};
		
		Node<Character, String> trie = null;
				
		for(String key : dict)
			trie = TernaryTrieDictionary.createSuffixTrie(key, true);
		
		String query = "ccccddd";
		
		int length = find(trie, query);
		
		System.out.println("Longest common Suffix = " + query.substring(0, length+1));
	}
	
	/**
	 * O(log n) time complexity.
	 */
	public static int find(Node<Character, String> node, String query) {
		
		int length = TrieDictionaryTraversals.longestSuffixLength(node, query, query.length()-1, 0);
		 
		return length;
	}
}
