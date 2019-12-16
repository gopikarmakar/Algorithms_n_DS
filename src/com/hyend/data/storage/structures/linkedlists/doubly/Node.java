package com.hyend.data.storage.structures.linkedlists.doubly;

public class Node<K> {
	
	public K k;
	
	public Node<K> next;
	
	public Node<K> prev;
	
	public Node(K k) {
		
		this(k, null, null);
	}
	
	public Node(K k, Node<K> prev, Node<K> next) {
	
		this.k = k;
		this.prev = prev;
		this.next = next;			
	}
}
