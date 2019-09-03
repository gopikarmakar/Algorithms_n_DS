package com.hyend.data.storage.structures.trie.Ternary;

/**
 * TODO: FIX
 * 
 * @author gopi_karmakar
 */
public class FindLongestCommonSuffix {

	public static void main(String[] args) {
		
		String[] dict = {"abc", "abcc", "abcd", "abcccd", "abccccccddddddd", "abccccccccccddd"};
		
		Node<Character, String> trie = null;
				
		for(String key : dict)
			trie = TernaryTrieDictionary.createSuffixTrie(key);
		
		TrieDictionaryTraversals.print(trie);
				
		LCP(trie, "ccccdddd");
	}
	
	/**
	 * O(log n) time complexity.
	 */
	private static void LCP(Node<Character, String> node, String query) {
		
		int length = TrieDictionaryTraversals.crawl(TernaryTrieDictionary.SUFFIX, node, query);
		 
		System.out.println(query.substring(0, length));
	}
}
