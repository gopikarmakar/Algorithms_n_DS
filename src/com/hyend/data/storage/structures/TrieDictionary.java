package com.hyend.data.storage.structures;

import java.util.LinkedList;
import java.util.Queue;

public class TrieDictionary<E> {

	private int alphabets = 26;
	private Node<E> root;
	
	@SuppressWarnings("hiding")
	public class Node<E> {
		E value;
		String prefix;
		@SuppressWarnings("unchecked")
		Node<E>[] next = new Node[alphabets];
	}
	
	public void put(String key, E value) {		
		root = put(root, key.toLowerCase(), value, 0);
	}
	
	private Node<E> put(Node<E> x, String key, E value, int d) {
		if(x == null) x = new Node<E>();
		if(d == key.length()) { x.value = value; x.prefix = key; return x; }
		char c = key.charAt(d);		
		x.next[(c - 'a')] = put(x.next[(c - 'a')], key, value, d+1);
		return x;
	}

	public E get(String key) {
		Node<E> x = get(root, key.toLowerCase(), 0);
		if(x == null) return null;
		else return x.value;
	}
	
	private Node<E> get(Node<E> x, String key, int d) {
		if(x == null) return null;	
		if(d == key.length()) return x;
		char c = key.charAt(d);
		return get(x.next[(c - 'a')], key, d+1);
	}
		
	private int get(Node<E> x) {
		
		if(x == null) return 0;
		
		int count = 0;
		for(int i = 0; i < alphabets; i++) {
			if(x.next[i] != null) {
				count += get(x.next[i]);
			}
		}
		// Return count of nodes of subtrie and plus 1 because of root node's own count. 
		return 1+count;
	}
	
	public Iterable<Node<E>> keysWithPrefix(String prefix) {
		
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		collect(get(root, prefix.toLowerCase(), 0), prefix.toLowerCase(), queue);
		return queue;
	}
	
	private void collect(Node<E> x, String prefix, Queue<Node<E>> queue) {
		
		if(x == null) return;
		if(x.value != null) queue.add(x);
		for(char c = 0; c < alphabets; c++) {
			collect(x.next[c], prefix + c, queue);
		}
	}
	
	public String longestCommonPrefixOf(String str) {
		int length = longestCommonPrefixOf(root, str.toLowerCase(), 0, 0);
		System.out.println("Length = " + length);
		return str.substring(0, length);
	}
	
	private int longestCommonPrefixOf(Node<E> x, String str, int d, int length) {
		
		if(x == null) return length;
		if(x.value != null) length = d;
		if(d == str.length()) return length;
		
		char c = str.charAt(d);
		return longestCommonPrefixOf(x.next[(c - 'a')], str, d+1, length);
	}
	
	/**
	 * Suffix Trie Creation.
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int allDistinctSubstrings(String key) {		
		int index = 0, cnt = 0;
		int length = key.length();
		while(index < length) {
			String suffix = key.substring(index++);
			put(suffix, (E)suffix);
		}
		index = 0;
		while(index < length) {
			cnt = get(root);
			index += 1;
		}
		return cnt;
	}
}