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
		
		TrieDictionaryCreation pTrie = new TrieDictionaryCreation();
		
		Node<Character, String> pRoot = pTrie.createPrefixTrie("String");
		
		TrieDictionaryCreation sTrie = new TrieDictionaryCreation();
		
		Node<Character, String> sRoot = sTrie.createSuffixTrie("String");		
		
		TrieDictionaryTraversals.printAllNodes(pRoot);
		TrieDictionaryTraversals.printAllNodes(sRoot);
	}
	
	public static Node<Character, String> createDefault() {
		
		String[] keys = {"Asuka", "Kiaan", "Keshav", "Kia", "Tulsi", "Karan", "Kunal", "Kiran", "Kabir", "Krisha"};
		
		Node<Character, String> tree = null;
		TrieDictionaryCreation trie = new TrieDictionaryCreation();		
		for(String key : keys)
			tree = trie.createDefault(key);
		
		return tree;
	}	
	
	private static TrieDictionaryCreation trie = new TrieDictionaryCreation();
	
	public static Node<Character, String> createDefault(String key) {
		return trie.createDefault(key);
	}
	
	public static Node<Character, String> createPrefixTrie(String key) {
		return trie.createPrefixTrie(key);
	}
	
	public static Node<Character, String> createSuffixTrie(String key) {
		return trie.createSuffixTrie(key);
	}
}
