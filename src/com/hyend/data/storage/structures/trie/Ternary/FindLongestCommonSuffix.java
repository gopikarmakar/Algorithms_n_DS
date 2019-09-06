package com.hyend.data.storage.structures.trie.Ternary;

/**
 * @author gopi_karmakar
 */
public class FindLongestCommonSuffix {

	public static void main(String[] args) {
		
		String[] dict = {"abccc", "abcc", "abcd", "abcccd", "abccccccdddd"};
		
		Node<Character, String> trie = null;
				
		for(String key : dict)
			trie = TernaryTrieDictionary.createSuffixTrie(key);
		
		TrieDictionaryTraversals.printAllNodes(trie);
				
		longestCommonSuffix(trie, "ccccddd");
	}
	
	/**
	 * O(log n) time complexity.
	 */
	private static void longestCommonSuffix(Node<Character, String> node, String query) {
		
		int length = TrieDictionaryTraversals.crawlSuffixTrie(node, query, query.length()-1, 0);
		 
		System.out.println(query.substring(0, length));
	}
}
