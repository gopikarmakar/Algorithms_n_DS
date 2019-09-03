package com.hyend.data.storage.structures.trie.Ternary;

/**
 * Ternary Trie Dictionary Insertion.
 * 
 * Takes O(log n) time for search and insertion.
 * 
 * @author gopi_karmakar
 */
public class TrieDictionaryCreation {
	
	private Node<Character, String> root = null;
	
	public Node<Character, String> createDefault(String key) {
		root = createDefault(root, key, 0);
		return root;
	}
	
	public Node<Character, String> createPrefixTrie(String key) {
		root = createPrefixTrie(root, "", key, 0);
		return root;
	}
	
	public Node<Character, String> createSuffixTrie(String key) {
		root = createSuffixTrie(root, "", key, key.length()-1);
		return root;
	}
	
	/**
	 * Default Trie Creation
	 */
	private Node<Character, String> createDefault(Node<Character, String> node, String key, int d) {
		
		Character ch = key.charAt(d);
		if(node == null) {			
			node = new Node<>(ch, null);
		}
	
		if(ch < node.k) 
			node.left = createDefault(node.left, key, d);
		else if(ch > node.k)			
			node.right = createDefault(node.right, key, d);
		else if(d < key.length()-1)
			node.mid = createDefault(node.mid, key, d+1);
		else {
			node.v = key;
		}
		
		return node;
	}
	
	/**
	 * Prefix Trie Creation
	 */
	private Node<Character, String> createPrefixTrie(Node<Character, String> node, 
			String prefix, String key, int d) {
		
		Character ch = key.charAt(d);			
		
		if(node == null)
			node = new Node<>(ch, prefix+ch);
		
		if(ch < node.k) 
			node.left = createPrefixTrie(node.left, prefix, key, d);
		else if(ch > node.k)			
			node.right = createPrefixTrie(node.right, prefix, key, d);
		else if(d < key.length()-1)
			node.mid = createPrefixTrie(node.mid, ""+ch, key, d+1);
		else {		
			node.v = key;
		}			
		return node;		
	}
	
	/**
	 * TODO: FIX
	 * Suffix Trie Creation
	 */
	private Node<Character, String> createSuffixTrie(Node<Character, String> node, 
			String prefix, String key, int d) {
		
		Character ch = key.charAt(d);			
		
		if(node == null)
			node = new Node<>(ch, ch+prefix);
		
		if(ch < node.k) 
			node.left = createPrefixTrie(node.left, prefix, key, d);
		else if(ch > node.k)			
			node.right = createPrefixTrie(node.right, prefix, key, d);
		else if(d > 0)
			node.mid = createPrefixTrie(node.mid, ""+ch, key, d-1);
		else {		
			node.v = key;
		}			
		return node;		
	}
}
