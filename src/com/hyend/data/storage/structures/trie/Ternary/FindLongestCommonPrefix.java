package com.hyend.data.storage.structures.trie.Ternary;

/**
 * Longest common prefix
 * 
 * @author gopi_karmakar
 */
public class FindLongestCommonPrefix {

	public static void main(String[] args) {
		
		String[] dict = {"abc", "abcc", "abcd", "abcccd", "abccccccddddddd", "abccccccccccddd"};
		
		Node<Character, String> trie = null;
				
		for(String key : dict)
			trie = TernaryTrieDictionary.createPrefixTrie(key);
				
		LCP(trie, "abccccdddd");
	}
	
	/**
	 * O(log n) time complexity.
	 */
	private static void LCP(Node<Character, String> node, String query) {
		
		int length = TrieDictionaryTraversals.crawl(TernaryTrieDictionary.PREFIX, node, query);
		 
		System.out.println(query.substring(0, length));
	}
}
