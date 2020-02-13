package com.hyend.data.storage.structures.linkedlists.doubly;

public class Node<K> {
	
	public K key;
	
	public Node<K> next;
	
	public Node<K> prev;	
	
	public Node(K k) {
		
		this(k, null, null);
	}
	
	public Node(K item, Node<K> prev, Node<K> next) {
	
		this.key = item;
		this.prev = prev;
		this.next = next;			
	}
	
	@Override
	public String toString() {
		
		return "Key = " + key;
	}
}
