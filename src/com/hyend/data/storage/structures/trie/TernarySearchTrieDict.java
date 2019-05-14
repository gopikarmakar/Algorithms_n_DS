package com.hyend.data.storage.structures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TernarySearchTrieDict<E> {
	
	public TernarySearchTrieDict() {}

	private Node<E> root;
		
	@SuppressWarnings("hiding")
	public class Node<E> {		
		char c;
		String prefix;
		E value;
		Node<E> left, mid, right;
	}
	
	public void put(String key, E value) {		
		root = put(root, key, key, value, 0);
	}
	
	public void put(String chunk, String prefix, E value) {		
		root = put(root, chunk, prefix, value, 0);
	}
	
	public void putChunks(String key, E value) {
		int index = 0, length = key.length();		
		while(index < length) {
			String chunk = key.substring(index++, length);
			System.out.println("Chunk = " + chunk);
			put(chunk, key, value);
		}
	}
	
	/**
	 * 
	 * @param x
	 * @param key
	 * @param value
	 * @param d
	 * @return
	 */
	private Node<E> put(Node<E> x, String key, String prefix, E value, int d) {
		
		char c = key.charAt(d);
		if(x == null) {
			x = new Node<E>(); 
			x.c = c; 
		}		
		if(c < x.c) 				x.left = put(x.left, key, prefix, value, d);
		else if(c > x.c) 			x.right = put(x.right, key, prefix, value, d);
		else if(d < key.length()-1) x.mid = put(x.mid, key, prefix, value, d+1);
		else {			
			x.value = value;
			x.prefix = prefix;
			System.out.println("Put x.value = " + x.value + " and x.prefix = " + x.prefix);
		}
		return x;
	}
	
	public E get(String key) {
		Node<E> x = get(root, key, 0);
		if(x == null) return null;
		else return x.value;
	}
	
	private Node<E> get(Node<E> x, String key, int d) {
		
		if(x == null) return null;
		
		char c = key.charAt(d);
		if(c < x.c) 				return get(x.left, key, d);
		else if(c > x.c) 			return get(x.right, key, d);
		else if(d < key.length()-1) return get(x.mid, key, d+1);
		else return x;
	}	
		
	public Iterable<Node<E>> keysWithPrefix(String prefix) {
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		keysWithPrefix(get(root, prefix, 0).mid, queue);
		return queue;
	}
		
	private void keysWithPrefix(Node<E> x, Queue<Node<E>> queue) {
						
		if(x == null) return;
				
		if(x.value != null) queue.add(x);
						
		keysWithPrefix(x.mid, queue);
		keysWithPrefix(x.left, queue);		
		keysWithPrefix(x.right, queue);		
	}
	
	public String longestCommonPrefixOf(String str) {
		
		int length = longestCommonPrefixOf(root, str, 0, 0);
		System.out.println("Length = " + length);
		return str.substring(0, length+1);
	}
	
	private int longestCommonPrefixOf(Node<E> x, String str, int d, int length) {
		
		char c = str.charAt(d);
		if(x == null) return length;		
		if(x.value != null && x.c == c) length = d;			
		if(d == str.length()) return length;						
		
		if(c < x.c) 				return longestCommonPrefixOf(x.left, str, d, length);
		else if(c > x.c) 			return longestCommonPrefixOf(x.right, str, d, length);
		else if(d < str.length()-1) return longestCommonPrefixOf(x.mid, str, d+1, length);
		else 						return length;
	}
		
	public Iterable<String> substringMatch(String key) {
		List<String> matches = new ArrayList<String>();
		substringMatch(root, key, 0, 0, matches);
		return matches;		
	}
	
	private int substringMatch(Node<E> x, String str, int d, int length, List<String> list) {
		
		char c = str.charAt(d);
		if(x == null) return length;		
		if(x.value != null) { 
			length = d;
			list.add(x.prefix);
			System.out.println("List Length = " + list.size());
		}		
		if(d == str.length()) return length;						
						
		if(c < x.c) 				return longestCommonPrefixOf(x.left, str, d, length);
		else if(c > x.c) 			return longestCommonPrefixOf(x.right, str, d, length);
		else if(d < str.length()-1) return longestCommonPrefixOf(x.mid, str, d+1, length);
		else 						return length;
	}
	
	int count = 0;
	@SuppressWarnings("unchecked")
	public int uniqueNSubstrings(String key, int n) {		
		int index = 0;
		int length = key.length()-n;
		while(index < length) {
			String suffix = key.substring(index, index+n);
			root = put(root, suffix, suffix, (E)suffix, 0);
			index += 1;
		}
		index = 0;
		HashMap<E, String> uniqueStrings = new HashMap<>();
		while(index < length) {
			count = getUniqueNSubstrings(root, key.substring(index, index+n), 0, uniqueStrings);
			index += 1;
		}
		return count;
	}
		
	private int getUniqueNSubstrings(Node<E> x, String key, int d, HashMap<E, String> uniqueStrings) {
				
		if(x == null) return uniqueStrings.size();
		if(x.value != null) {			
			uniqueStrings.put(x.value, x.prefix);
			System.out.println("x = " + x.value);
		}
		if(d == key.length()) return uniqueStrings.size();
		
		char c = key.charAt(d);
		if(c < x.c ) 				getUniqueNSubstrings(x.left, key, d, uniqueStrings);
		else if (c > x.c) 			getUniqueNSubstrings(x.right, key, d, uniqueStrings);		
		else if(d < key.length()-1) getUniqueNSubstrings(x.mid, key, d+1, uniqueStrings);
		
		return uniqueStrings.size();		
	}
}
