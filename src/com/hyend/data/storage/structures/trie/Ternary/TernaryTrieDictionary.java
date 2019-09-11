package com.hyend.data.storage.structures.trie.Ternary;

/**
 * Ternary Trie Dictionary
 * 
 * @author gopi_karmakar
 */
public class TernaryTrieDictionary {
	
	public final static int PREFIX = 1;
	public final static int SUFFIX = 2;
	

	public static void main(String[] args) {			
		
		//Node<Character, String> tree = createDefault();				
		
		Node<Character, String> pRoot = createPrefixTrie("String", true);		
		
		Node<Character, String> sRoot = createSuffixTrie("String", true);		
		
		TrieDictionaryTraversals.printAllNodes(pRoot);
		TrieDictionaryTraversals.printAllNodes(sRoot);
	}
	
	public static Node<Character, String> createDefault() {
		
		String[] dict = {"asuka", "kiaan", "keshav", "kia", "tulsi", "karan", "kunal", "kiran", "kabir", "krisha"};
		
		Node<Character, String> root = createDefault(dict);
		
		return root;
	}	
	
	public static Node<Character, String> createDefault(String[] keys) {		
		
		TrieDictionaryCreation trie = new TrieDictionaryCreation();
		Node<Character, String> root = trie.create(keys);
		
		return root;
	}
	
	private static TrieDictionaryCreation trie = new TrieDictionaryCreation();
	
	public static Node<Character, String> createDefault(String key) {
		return trie.create(key);
	}
	
	public static Node<Character, String> createPrefixTrie(String key, boolean saveEveryValue) {
		return trie.createPrefixTrie(key, saveEveryValue);
	}
	
	public static Node<Character, String> createSuffixTrie(String key, boolean saveEveryValue) {
		return trie.createSuffixTrie(key, saveEveryValue);
	}
}
