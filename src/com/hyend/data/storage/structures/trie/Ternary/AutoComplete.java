package com.hyend.data.storage.structures.trie.Ternary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Google Interview Question
 * 
 * Suggest names for auto completion from a dictionary of names 
 * for an ongoing typing name. Suggest the correct names if exists 
 * even if the typing name may or may not start with prefix or suffix.
 * 
 * @author gopi_karmakar
 */
public class AutoComplete {

	public static void main(String[] args) {
		
		String[] keys = {"Asuka", "Kiaan", "Keshav", "Kia", "Tulsi", "Karan", "Kunal", "Kiran", "Kabir", "Krisha"};
						
		//autoCompleteByPrefix(tree, "K");
		//autoCompleteByPrefix(tree, "Ki");
		//autoCompleteByPrefix("Ka");
		
		autoComplete(keys, "u");
	}
	
	public static void autoComplete(String[] names, String query) {
		
		List<String> finalNames = new ArrayList<>();
		Set<String> nameSet = new HashSet<>(Arrays.asList(names));
		
		Node<Character, String> trie = null;
		
		for(String s : names) {
			
			int n = s.length();
			
			for(int i = 0; i < n/2; i++) {
				
				String key = s.substring(i, n-i);
				trie = TernaryTrieDictionary.createPrefixTrie(key);
				trie = TernaryTrieDictionary.createSuffixTrie(key);
			}
		}
		
		Iterator<Map.Entry<String, Integer>> itr = TrieDictionaryTraversals.getMap(trie).entrySet().iterator();
		
		while(itr.hasNext()) {
			
			Entry<String, Integer> entry = itr.next();
			
			if(entry.getKey().contains(query)) {
				if(nameSet.contains(entry.getKey()))
					finalNames.add(entry.getKey());
			}
		}
		
		System.out.println(finalNames);
		//TrieDictionaryTraversals.printAllDistinctNodes(trie);
	}
	
	/**
	 * Prefix match auto complete 
	 */
	public static void autoCompleteByPrefix(String query) {			
		
		Node<Character, String> trie = TernaryTrieDictionary.createDefault();
		
		trie = getStartingPoint(trie, query, 0);
		
		TrieDictionaryTraversals.printAllNodes(trie.mid);
	}
	
	/**
	 * O(log n) time complexity for searching.	 
	 */
	private static Node<Character, String> getStartingPoint(Node<Character, String> node, String prefix, int d) {				
		
		if(node == null) 					return null;
		
		Character ch = prefix.charAt(d);		
		
		if(ch < node.k)						return getStartingPoint(node.left, prefix, d);
			
		else if(ch > node.k)				return getStartingPoint(node.right, prefix, d);
			
		else if(d < prefix.length()-1)		return getStartingPoint(node.mid, prefix, d+1);
			
		else								return node;			
	}
}
