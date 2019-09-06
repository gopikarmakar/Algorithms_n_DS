package com.hyend.data.storage.structures.trie.Ternary;

/**
 * Find unique substrings of K length from a give String
 * 
 * @author gopi_karmakar
 */
public class FindAllDisctinctSubStringsOfLengthK {

	public static void main(String[] args) {
		
		String key = "cgcgggcgcg";
		findDistinctSubStrings(key, 3);
	}
	
	/**
	 * A very efficient solution:
	 * Trie creation of (n-k) nodes takes O((n-k) log n) time and traversal
	 * of all nodes takes O(n) time. In total it takes O(n log n) time.
	 */
	private static void findDistinctSubStrings(String key, int k) {
		
		Node<Character, String> trie = null;
		
		for(int i = 0; i <= key.length()-k; i++) {
			
			trie = TernaryTrieDictionary.createDefault(key.substring(i, i+k));
		}
		
		TrieDictionaryTraversals.printAllDistinctNodes(trie);
	}
}
