package com.hyend.data.storage.structures;

import java.util.LinkedList;
import java.util.Queue;

public class TrieDictionary<E> {

	private int alphabets = 256;
	private Node<E> root;
	
	@SuppressWarnings("hiding")
	public class Node<E> {
		E value;
		String prefix;
		@SuppressWarnings("unchecked")
		Node<E>[] next = new Node[alphabets];
	}
	
	public void put(String key, E value) {		
		root = put(root, key, value, 0);
	}
	
	private Node<E> put(Node<E> x, String key, E value, int d) {
		if(x == null) x = new Node<E>();
		if(d == key.length()) { x.value = value; x.prefix = key; return x; }
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, value, d+1);
		return x;
	}
	
	private Node<E> get(Node<E> x, String key, int d) {
		if(x == null) return null;
		if(d == key.length()) return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}
	
	public E get(String key) {
		Node<E> x = get(root, key, 0);
		if(x == null) return null;
		else return x.value;
	}
	
	public Iterable<Node<E>> keysWithPrefix(String prefix) {
		
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		collect(get(root, prefix, 0), prefix, queue);
		return queue;
	}
	
	private void collect(Node<E> x, String prefix, Queue<Node<E>> queue) {
		
		if(x == null) return;
		if(x.value != null) queue.add(x);
		for(char c = 0; c < alphabets; c++) {
			collect(x.next[c], prefix + c, queue);
		}
	}
}
