package com.hyend.data.storage.structures.linkedlists.singly;

public class Node<K> {

	public K k;
	
	public Node<K> next;
	
	public Node<K> jump;
	
	public Node(K k) {
		this(k, null);
	}
	
	public Node(Node<K> node) {
		this(node.k, node.next, node.jump);
	}
	
	public Node(K k, Node<K> next) {
		this(k, next, null);
	}
	
	public Node(K k, Node<K> next, Node<K> jump) {
		this.k = k;
		this.next = next;
		this.jump = jump;
	}
}
