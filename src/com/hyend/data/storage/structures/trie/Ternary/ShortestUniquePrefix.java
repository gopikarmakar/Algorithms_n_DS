package com.hyend.data.storage.structures.trie.Ternary;

/**
 * Return the shortest prefix of the query string which is not 
 * a prefix of any string in the dictionary.
 * 
 * for e.g: 
 * 1: dictionary = {"dog", "be", "cut"} query = "cat"
 * return "ca" since "c" of cat is a prefix in dictionary but not "ca"
 * 
 * 2: dictionary = {"dog", "be", "cut", "car"} query = "cat"
 * return "cat" since "ca" of cat is a prefix in dictionary but not "cat"
 * 
 * 3: dictionary = {"dog", "be", "cut", "car", "cattle", "category"} query = "cat"
 * return "" since "cat" of cat is a prefix in dictionary
 * 
 * @author gopi_karmakar
 */
public class ShortestUniquePrefix {

	public static void main(String[] args) {
		
		String[] dict = {"dog", "be", "cut"};
		//String[] dict = {"dog", "be", "cut", "car"};
		//String[] dict = {"dog", "be", "cut", "car", "cattle", "category"};
		
		Node<Character, String> trie = null;
		for(String key : dict)
			trie = TernaryTrieDictionary.createPrefixTrie(key);
		
		//TrieDictionaryTraversals.printAllNodes(trie);		
		 
		System.out.println("Shortest Prefix  = " + shortesUniquetPrefix(trie, "cat"));
	}
	
	/**
	 * O(log n) time complexity solution
	 */
	private static String shortesUniquetPrefix(Node<Character, String> trie, String query) {
							
		int length = crawlTrie(trie, query, 0, 0);
		
		return (length == query.length()) ? "" : query.substring(0, length+1);
	}
	
	private static int crawlTrie(Node<Character, String> node, String query, int d, int length) {
		
		Character ch = query.charAt(d);
		
		if(node == null)		return length;
		
		if(ch < node.k)					
			return crawlTrie(node.left, query, d, length);				
		else if(ch > node.k)			
			return crawlTrie(node.right, query, d, length);
		else if(d < query.length()-1)
			return crawlTrie(node.mid, query, d+1, length+1);
		else {
			//For the (n-1)th character.
			if(ch.equals(node.k)) length += 1;
			return length;
		}
	}
}