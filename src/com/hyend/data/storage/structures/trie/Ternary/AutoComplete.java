package com.hyend.data.storage.structures.trie.Ternary;

import java.util.List;
import java.util.ArrayList;

/**
 * Google Interview Question
 * 
 * Suggest names for auto completion from a dictionary of names 
 * for an ongoing typing name. Suggest the correct names or part of names 
 * if exists even if the typing name may or may not start with prefix or suffix.
 * 
 * @author gopi_karmakar
 */
public class AutoComplete {

	public static void main(String[] args) {
		
		String[] keys = {"kiaan", "asuka", "keshav", "kia", "tulsi", "karan", "kunal", "kiran", "kabir", "krisha"};;					
		
		fullAutoComplete(keys, "u");
		//fullAutoComplete(keys, "ki");
		//fullAutoComplete(keys, "an");
		
		//autoCompleteByPrefix("k");
		//autoCompleteByPrefix("ki");
		//autoCompleteByPrefix("u");
	}
	
	/**
	 * Only prefix match auto complete	 
	 * Suggest names to complete for any prefix match for an ongoing typing name.
	 */
	public static void autoCompleteByPrefix(String[] names, String query) {						
		
		Node<Character, String> trie = TernaryTrieDictionary.createDefault(names);	
		
		trie = getStartingPoint(trie, query, 0);
		System.out.println(trie);
		
		TrieDictionaryTraversals.printAllNodes(trie);
	}
	
	/**
	 * O(log n) time complexity for searching.	 
	 */
	private static Node<Character, String> getStartingPoint(Node<Character, String> node, String prefix, int d) {				
		
		Character ch = prefix.charAt(d);
		
		if(node == null) 					return null;			
		
		if(ch < node.k)						return getStartingPoint(node.left, prefix, d);
			
		else if(ch > node.k)				return getStartingPoint(node.right, prefix, d);
			
		else if(d < prefix.length()-1)		return getStartingPoint(node.mid, prefix, d+1);
			
		else								return node;			
	}
	
	/**
	 * Suggest names to complete for any character match for an ongoing typing name.
	 */
	public static void fullAutoComplete(String[] names, String query) {
		
		List<String> finalNames = new ArrayList<>();
		
		Node<Character, String> trie = null;
		
		for(String s : names) {
			// false, only for existing names in the dictionary
			//trie = TernaryTrieDictionary.createSuffixTrie(s, false);

			// true, for all combinations of names in the dictionary from the typing letter.
			trie = TernaryTrieDictionary.createSuffixTrie(s, true);	
		}
		
		crawlTrie(trie, finalNames, query);
		System.out.println(finalNames);
	}
	
	/**
	 * O(n) time complexity
	 */
	public static void crawlTrie(Node<Character, String> trie, List<String> queue, String query) {
		
		if(trie == null)
			return;
		
		if(trie.v != null && trie.v.contains(query)) queue.add(trie.v);
		
		crawlTrie(trie.left, queue, query);
		crawlTrie(trie.mid, queue, query);
		crawlTrie(trie.right, queue, query);
	}
}
