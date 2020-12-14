package com.hyend.data.storage.structures.linkedlists.singly;

import java.util.Objects;

public class Node<K> {

	public K k;
	
	public Node<K> next;
	
	public Node<K> jump;
	
	public Node() {}
	
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
	
	@Override	
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof Node))
			return false;
		
		if(obj == this)
			return true;
		
		@SuppressWarnings("unchecked")
		Node<K> that = (Node<K>) obj;		
					
		return this.k.equals(that.k) && this.next.equals(that.next);
	}
	
	@Override
	public int hashCode() {		
		return Objects.hash(this.k);
	}
	
	@Override
	public String toString() {		
		return "Key = " + k;
	}
}
