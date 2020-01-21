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
		
		String[] names = {"kiaan", "asuka", "keshav", "kia", "tulsi", "karan", "kunal", "kiran", "kabir", "krisha"};				
		
		//autoCompleteByPrefix(names, "ka");
		//autoCompleteByPrefix(names, "ki");
		
		Node<Character, String> trie = createTrie(names);
		
		fullAutoComplete(trie, "ul");
		fullAutoComplete(trie, "ka");
		fullAutoComplete(trie, "ia");
	}
	
	/**
	 * Only prefix match auto complete	 
	 * Suggest names to complete for any prefix match for an ongoing typing name.
	 */
	public static void prefixAutoComplete(String[] names, String query) {						
		
		Node<Character, String> trie = TernaryTrieDictionary.createDefault(names);	
		
		trie = TrieDictionaryTraversals.getPrefixStartingPoint(trie, query, 0);
		
		TrieDictionaryTraversals.printAllNodes(trie.mid);
	}
	
	/**
	 * Prefix, Infix or Suffix match auto complete
	 * Suggest names to auto complete for any character match for an ongoing typing name.
	 * 
	 * The max time complexity will be something around O(n ^ 2) 
	 * 
	 * Just for the testing currently saving all the names repeatedly to the list. Instead we can 
	 * create the pool of objects once and save just the reference for the space efficiency.  
	 */
	public static void fullAutoComplete(Node<Character, String> trie, String query) {
		
		trie = TrieDictionaryTraversals.getPrefixStartingPoint(trie, query, 0);
		
		List<String> list = new ArrayList<String>();
		
		if(!trie.values.isEmpty()) {
			list.addAll(trie.values);
		}
		
		crawlTrie(trie.mid, list);
		
		list.forEach(e -> {
			
			System.out.println(e);
		});
	}
	
	////////////////////////////////////////////// Helper Methods ////////////////////////////////////////////
	/**
	 * Trie creation for all the names will take a around O(n ^ 2) time
	 */
	private static Node<Character, String> createTrie(String[] names) {
		
		Node<Character, String> trie = null;
		
		for(String name : names) {
			
			int n = name.length();
			for(int i = 0; i < n; ++i) {
				
				String s = name.substring(i, n);
				trie = TernaryTrieDictionary.createDefault(s, name);
			}
		}		
		return trie;
	}
	
	/**
	 * Crawling of Trie takes O(n) time complexity
	 */
	public static void crawlTrie(Node<Character, String> trie, List<String> list) {
		
		if(trie == null)
			return;
		
		if(!trie.values.isEmpty()) {
			
			list.addAll(trie.values);
		}
		
		crawlTrie(trie.left, list);
		crawlTrie(trie.mid, list);
		crawlTrie(trie.right, list);
	}
}
