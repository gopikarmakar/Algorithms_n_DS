package com.hyend.data.storage.structures.trie.Ternary;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedHashMap;

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
						 "food", "prime", "minister", "is", "the", "what", "of", " "}; 	
							
		//String query = "what is the capta of endia";
		
		String query = "find fod shoe nar me";
		
		check(dict, query);
	}
	
	/**
	 * Time complexity very close to O(n^2)
	 */
	private static void check(String[] dict, String query) {
		
		Node<Character, String> trie = null;		
		
		for(String key : dict)
			trie = TernaryTrieDictionary.createPrefixTrie(key, false);
		
		String[] queryParts = query.split(" ");
		
		Map<String, List<String>> rectifiesWords = new LinkedHashMap<>();
		
		for(String q : queryParts) {
			
			int length = LongestCommonPrefix.find(trie, q);
			if(q.length() != length+1) {								
				
				Node<Character, String> node = getCommonPrefix(trie, q, length);
				
				List<String> queue = TrieDictionaryTraversals.getList(node.mid);
																
				rectifiesWords.put(q, queue);
			}			
		}		
		print(rectifiesWords);
	}
	
	private static Node<Character, String> getCommonPrefix(Node<Character, String> trie, String query, int length) {
				
		String prefix = query.substring(0, length+1);
		Node<Character, String> node = getStartingPointFromPrefix(trie, prefix, 0);;		
		
		String nextPrefix = "";				
		if(node == null) {			
			do {				
				
				int i = 1;
				nextPrefix = query.substring(i, length+i+1);
				System.out.println("No word starts with " + prefix);
				
				node = getStartingPointFromPrefix(trie, nextPrefix, 0);
				
				i++;
				
			} while(node == null);
			
			System.out.println("But starts with " + nextPrefix + " so finally:");
		}				
		
		return node;
	}
	
	private static void print(Map<String, List<String>> rectifiesWords) {
		
		Iterator<Map.Entry<String, List<String>>> itr = rectifiesWords.entrySet().iterator();
		
		System.out.println();
		
		while(itr.hasNext()) {
		
			Map.Entry<String, List<String>> entry = itr.next();
			
			System.out.print(entry.getKey() + " should be ");
			for(String v : entry.getValue()) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
	
	private static Node<Character, String> getStartingPointFromPrefix(Node<Character, String> node, String prefix, int d) {				
		
		if(node == null) 					return null;		
		
		Character ch = prefix.charAt(d);
		
		if(ch < node.k)						return getStartingPointFromPrefix(node.left, prefix, d);
			
		else if(ch > node.k)				return getStartingPointFromPrefix(node.right, prefix, d);
			
		else if(d < prefix.length()-1)		return getStartingPointFromPrefix(node.mid, prefix, d+1);
			
		else								return node;			
	}
}