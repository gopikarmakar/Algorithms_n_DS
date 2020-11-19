package com.hyend.data.storage.structures.trie.Ternary;

/**
 * A Google interview Question:
 * 
 * Given two strings A and B, what's the longest prefix of A which is suffix of B.
 * 
 * @author gopi_karmakar
 */
public class LongestCommonPrefixAndSuffixOfTwoStrings {

	public static void main(String[] args) {
		String A = "aaaazzzdd";
		String B = "ccbaaaaaaa";		
		
		System.out.println("Longest Common Prefix and Suffix = " + A.substring(0, match(A, B)+1));		
	}
	
	/**
	 * O(log n) time complexity
	 */
	private static int match(String A, String B) {
		
		Node<Character, String> trie = TernaryTrieDictionary.createSuffixTrie(B, false); 
		
		int length = TrieDictionaryTraversals.longestPrefixLength(trie, A, 0, 0);
		//System.out.println(length);
		
		return length;
	}
}