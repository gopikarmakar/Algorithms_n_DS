package com.hyend.data.storage.structures.trie.Ternary;

/**
 * A Google Interview Question
 * 
 * Find Longest common substring from a list of strings.
 * For e.g: {"disgrace", "graceful", "disgraceful", "ungracefully", "gracefully"};
 * return "grace"
 *  
 * @author gopi_karmakar
 */
public class FindLongestCommonSubStringFromListOfStrings {

	public static void main(String[] args) {
		
		//String[] keys = {"disadvantage", "sysadmin", "omsadhu", "crusade", "misadvice"};
		
		String[] keys = {"disgrace", "graceful", "disgraceful", "ungracefully", "gracefully"};
		
		longestCommonSubString(keys);
	}
	
	/**
	 * Max time and space complexity will be O(n^2) 
	 */
	private static void longestCommonSubString(String[] keys) {

		Node<Character, String> trie = null;
		
		for(String s : keys) {
			
			int n = s.length();
			
			for(int i = 0; i < n; ++i) {
				
				String key = s.substring(i, n);
				
				trie = TernaryTrieDictionary.createPrefixTrie(key, true);
			}
		}		
		
		find(trie, keys.length);
		System.out.println("Longest Common Sub String = " + result);
	}
	
	private static String result = "";
	private static void find(Node<Character, String> trie, int totalKeys) {
		
		if(trie == null)	return;
		
		if(trie.frequency >= totalKeys) {						
			
			if(trie.v.length() >= result.length()) {
				
				System.out.println(trie.v + "  Occurrence = " + trie.frequency);
				result = trie.v;
			}										
		}
		
		find(trie.left, totalKeys);
		find(trie.mid, totalKeys);
		find(trie.right, totalKeys);
	}
}