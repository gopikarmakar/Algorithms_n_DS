package com.hyend.data.storage.structures.trie.Ternary;

/**
 * Longest common prefix
 * 
 * @author gopi_karmakar
 */
public class FindLongestCommonPrefix {

	public static void main(String[] args) {
		
		String[] dict = {"abc", "abcccccd", "abcd", "abcccd", "abccccccddddddd", "abccccccccccddd"};
		
		Node<Character, String> trie = null;
				
		for(String key : dict)
			trie = TernaryTrieDictionary.createPrefixTrie(key);
		
		TrieDictionaryTraversals.printAllNodes(trie);
				
		longestCommonPrefix(trie, "abccccdddd");
	}
	
	/**
	 * O(log n) time complexity.
	 */
	private static void longestCommonPrefix(Node<Character, String> node, String query) {
		
		int length = TrieDictionaryTraversals.crawlPrefixTrie(node, query, 0, 0);
		 
		System.out.println(query.substring(0, length));
	}
}
