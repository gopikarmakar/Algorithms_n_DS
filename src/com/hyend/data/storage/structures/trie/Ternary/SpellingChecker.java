package com.hyend.data.storage.structures.trie.Ternary;

/**
 * A Google Interview Question:
 * 
 * Build a basic spelling checker from dictionary of words:
 * 
 * For e.g: Take a set of English words and a query string as an input 
 * and point out the correct spelling if any word misspelled.   
 * 
 * @author gopi_karmakar
 */
public class SpellingChecker {

	public static void main(String[] args) {
		
		String[] dict = {"how", "where", "who", "find", "country", "near", "restaurants", "me", "shop",
						 "good", "music", "bar", "show", "why", "when", "capital", "india", "japan",
						 "food", "prime", "minister", "is", "the", "what", "of", "eat"}; 	
							
		//String query = "what is the capta of endia";
		
		String query = "find fod shoe nar me";
		
		Node<Character, String> trie = null;		
		
		for(String key : dict) {
			trie = TernaryTrieDictionary.createPrefixTrie(key, false);			
		}
		
		check(trie, dict, query);
	}
	
	/**
	 * Time complexity will be O(n) log(n)
	 */
	private static void check(Node<Character, String> trie, String[] dict, String query) {
						
		String[] queryParts = query.split(" ");
		
		System.out.println("\nRecommendations Are : ");
		
		for(String part : queryParts) {
			
			Node<Character, String> node = longestCommonPrefix(trie, null, part, 0);			
			
			if(node != null) {
				
				System.out.println(part + " should be:");
				TrieDictionaryTraversals.printAllNodes(node.mid);
			}
			System.out.print("\n");
		}
	}
	
	public static Node<Character, String> longestCommonPrefix(Node<Character, String> trie, 
					Node<Character, String> parent, String query, int d) {
		
		Character ch = query.charAt(d);
		
		if(trie == null)				return parent;
		
		if(ch.equals(trie.k))			parent = trie;
		
		if(ch < trie.k)					return longestCommonPrefix(trie.left, parent, query, d);						
							
		else if(ch > trie.k)			return longestCommonPrefix(trie.right, parent, query, d);		
			
		else if(d < query.length()-1) 	return longestCommonPrefix(trie.mid, parent, query, d+1);
			
		else							return null;		
	}
}