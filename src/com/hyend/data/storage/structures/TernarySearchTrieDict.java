package com.hyend.data.storage.structures;

import com.hyend.data.storage.structures.TrieDictionary.Node;

public class TernarySearchTrieDict<E> {

	private Node<E> root;
		
	@SuppressWarnings("hiding")
	public class Node<E> {		
		char c;
		E value;
		Node<E> left, mid, right;
	}
	
	public void put(String key, E value) {
		root = put(root, key, value, 0);
	}
	
	/**
	 * 
	 * @param x
	 * @param key
	 * @param value
	 * @param d
	 * @return
	 */
	private Node<E> put(Node<E> x, String key, E value, int d) {
		
		char c = key.charAt(d);		
		if(x == null) {
			x = new Node<E>(); 
			x.c = c; 
		}		
		if(c < x.c) 				x.left = put(x.left, key, value, d);
		else if(c > x.c) 			x.right = put(x.right, key, value, d);
		else if(d < key.length()-1) x.mid = put(x.mid, key, value, d+1);
		else						x.value = value;
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
	
	public String findLongestPrefix(String str) {
		int length = findLongestPrefix(root, str, 0, 0);
		return str.substring(0, length);
	}
	
	private int findLongestPrefix(Node<E> x, String str, int d, int length) {
								
		if(x == null) return length;
		//if(d == str.length()) return length;
		if(x.value != null) length = d;
		
		char c = str.charAt(d);		
		if(c < x.c) return findLongestPrefix(x.left, str, d, length);
		else if(c > x.c) return findLongestPrefix(x.right, str, d, length);
		else if(d < str.length()-1) return findLongestPrefix(x.mid, str, d+1, length);
		else 
			return length;
	}
}
