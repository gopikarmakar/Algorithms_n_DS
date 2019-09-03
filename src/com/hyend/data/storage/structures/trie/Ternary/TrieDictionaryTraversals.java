package com.hyend.data.storage.structures.trie.Ternary;

import java.util.Set;

import com.hyend.data.storage.structures.linkedlists.singly.SinglyLinkedList;

/**
 * Iterating through the Ternary Trie Dictionary.
 * @author gopi_karmakar
 */
public class TrieDictionaryTraversals {
	
	public static void main(String[] args) {	
		Node<Character, String> tree = TernaryTrieDictionary.createDefault();
		print(tree);
	}
	
	public static void print(Node<Character, String> trie) {
		SinglyLinkedList<String> queue = new SinglyLinkedList<>();
		crawl(trie, queue);		
		queue.print(queue);
	}
	
	/**
	 * Prefix / Suffix Trie Traversal
	 */
	public static int crawl(int order, Node<Character, String> trie, String query) {
		
		int length = 0;		
		
		switch(order) {
		
			case TernaryTrieDictionary.PREFIX:
				length = crawlPrefixTrie(trie, query, 0, length);
				break;
			case TernaryTrieDictionary.SUFFIX:
				length = crawlSuffixTrie(trie, query, query.length()-1, length);
				break;
		}
		return length;
	}
		
	/**
	 * Crawling all nodes of Trie.
	 * O(n) time complexity DFS algorithm.
	 */
	public static void crawl(Node<Character, String> node, SinglyLinkedList<String> queue) {
		
		if(node == null)
			return;
		
		if(node.v != null) queue.add(node.v);
		
		crawl(node.left, queue);
		crawl(node.mid, queue);
		crawl(node.right, queue);
	}
	
	/**
	 * Crawling all nodes of Trie for unique keys.
	 * 
	 * O(n) time complexity DFS algorithm.
	 * 
	 */
	public static void crawl(Node<Character, String> node, Set<String> uniqueSet) {
		
		if(node == null)
			return;
		
		if(node.v != null) uniqueSet.add(node.v);
		
		crawl(node.left, uniqueSet);
		crawl(node.mid, uniqueSet);
		crawl(node.right, uniqueSet);
	}
	
	/**
	 * Prefix Trie Traversal 
	 * O(log n) time complexity
	 */
	public static int crawlPrefixTrie(Node<Character, String> node, String query, int d, int length) {
		
		Character ch = query.charAt(d);
		
		if(node == null)		return length;
		if(ch.equals(node.k))	length = d;
		if(d == query.length()) return length;
		
		if(ch < node.k)					
			return crawlPrefixTrie(node.left, query, d, length);				
		else if(ch > node.k)			
			return crawlPrefixTrie(node.right, query, d, length);
		else if(d < query.length()-1)
			return crawlPrefixTrie(node.mid, query, d+1, length);
		else {
			return length;
		}
	}
	
	/**
	 * Suffix Trie Traversal
	 * O(log n) time complexity 
	 */
	public static int crawlSuffixTrie(Node<Character, String> node, String query, int d, int length) {
		
		Character ch = query.charAt(d);
		
		if(node == null)		return length;
		if(ch.equals(node.k)) 	length = d;	
		if(d == query.length()) return length;
		
		if(ch < node.k)					
			return crawlPrefixTrie(node.left, query, d, length);				
		else if(ch > node.k)			
			return crawlPrefixTrie(node.right, query, d, length);
		else if(d > 0)
			return crawlPrefixTrie(node.mid, query, d-1, length);
		else {
			return length;
		}
	}
}