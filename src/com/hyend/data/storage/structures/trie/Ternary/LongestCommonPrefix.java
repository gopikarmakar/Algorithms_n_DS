package com.hyend.data.storage.structures.trie.Ternary;

/**
 * Google Interview Question:
 * 
 * Find the longest common prefix for a given query from a dictionary of words.
 * 
 * @author gopi_karmakar
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		
		String[] dict = {"abc", "abcccccd", "abcd", "abcccd", "abccccccddddddd", "abccccccccccddd"};
		
		Node<Character, String> trie = null;
				
		for(String key : dict)
			trie = TernaryTrieDictionary.createPrefixTrie(key, true);
				
		String query = "abccccdddd";
		
		int length = find(trie, query);
		
		System.out.println("Longest common Prefix = " + query.substring(0, length+1));
	}
	
	/**
	 * O(log n) time complexity.
	 */
	public static int find(Node<Character, String> node, String query) {
		
		int length = TrieDictionaryTraversals.longestPrefixLength(node, query, 0, 0);
		 
		return length;		
	}
}
