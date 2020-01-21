package com.hyend.data.storage.structures.trie.Ternary;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedHashMap;

/**
 * Iterating through the Ternary Trie Dictionary.
 * @author gopi_karmakar
 */
public class TrieDictionaryTraversals {
	
	public static void main(String[] args) {
		
		Node<Character, String> tree = TernaryTrieDictionary.createDefault();
		printAllNodes(tree);
	}
	
	public static List<String> getList(Node<Character, String> trie) {
		
		List<String> queue = new LinkedList<>();
		crawlTrie(trie, queue);
		
		return queue;
	}
	
	public static Map<String, Integer> getMap(Node<Character, String> trie) {
		
		Map<String, Integer> map = new LinkedHashMap<>(10, 0.75f, false);
		crawlTrie(trie, map);
		
		return map;
	}	
	
	public static void printAllNodes(Node<Character, String> trie) {
		
		Iterator<String> itr = getList(trie).iterator();		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	public static void printAllDistinctNodes(Node<Character, String> trie) {		
		
		Iterator<Map.Entry<String, Integer>> itr = getMap(trie).entrySet().iterator();		
		while(itr.hasNext()) {			
			Map.Entry<String, Integer> entry = itr.next();
			System.out.println(entry.getKey());			
		}
	}
		
	/**
	 * Crawling all nodes of Trie.
	 * O(n) time complexity DFS algorithm.
	 */
	public static void crawlTrie(Node<Character, String> trie, List<String> queue) {
		
		if(trie == null)
			return;
		
		if(trie.v != null) queue.add(trie.v);
		
		crawlTrie(trie.left, queue);
		crawlTrie(trie.mid, queue);
		crawlTrie(trie.right, queue);
	}
	
	/**
	 * Crawling all nodes of Trie for unique keys.
	 * O(n) time complexity DFS algorithm.
	 */
	public static void crawlTrie(Node<Character, String> trie, Map<String, Integer> map) {
		
		if(trie == null)
			return;
		
		if(trie.v != null) {
			
			map.put(trie.v, trie.v.length());	
		}
		
		crawlTrie(trie.left, map);
		crawlTrie(trie.mid, map);
		crawlTrie(trie.right, map);
	}
	
	/**
	 * Takes O(log n) time complexity for searching.	 
	 */
	public static Node<Character, String> getPrefixStartingPoint(Node<Character, String> trie, String prefix, int d) {				
		
		if(trie == null) 					return null;		
		
		Character ch = prefix.charAt(d);
		
		if(ch < trie.k)						return getPrefixStartingPoint(trie.left, prefix, d);
			
		else if(ch > trie.k)				return getPrefixStartingPoint(trie.right, prefix, d);
			
		else if(d < prefix.length()-1)		return getPrefixStartingPoint(trie.mid, prefix, d+1);
			
		else								return trie;			
	}
	
	/**
	 * Prefix Trie Traversal 
	 * O(log n) time complexity
	 */
	public static int longestPrefixLength(Node<Character, String> trie, String query, int d, int length) {
		
		Character ch = query.charAt(d);
		
		if(trie == null)				return length;
		
		if(ch.equals(trie.k))			length = d;
		
		if(ch < trie.k)					return longestPrefixLength(trie.left, query, d, length);						
							
		else if(ch > trie.k)			return longestPrefixLength(trie.right, query, d, length);		
			
		else if(d < query.length()-1) 	return longestPrefixLength(trie.mid, query, d+1, length);
			
		else							return length;					
	}
	
	/**
	 * Suffix Trie Traversal 
	 * O(log n) time complexity
	 */
	public static int longestSuffixLength(Node<Character, String> trie, String query, int d, int length) {
		
		Character ch = query.charAt(d);
		
		if(trie == null)				return length;
		if(ch.equals(trie.k))			length = d;
		
		if(ch < trie.k)					return longestSuffixLength(trie.left, query, d, length);					
							
		else if(ch > trie.k)			return longestSuffixLength(trie.right, query, d, length);
			
		else if(d > 0)					return longestSuffixLength(trie.mid, query, d-1, length); 
			
		else 							return length;		
	}
}