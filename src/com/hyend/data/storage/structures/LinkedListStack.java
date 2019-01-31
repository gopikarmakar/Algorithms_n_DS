package com.hyend.data.storage.structures;

/**
 * A stack with linked list
 * 
 * @author gopi_karmakar
 *
 */
public class LinkedListStack {
	
	private Node top = null;
	class Node {
		
		Object item;
		Node next;
		Node(Object item) {
			this.item = item;
		}
	}
	
	// 2->1
	public void push(Object item) {
		Node node = new Node(item);
		node.next = top;
		top = node;
	}
	
	public Object pop() {
		
		if(isEmpty()) return null;
		Object item = top.item;
		top = top.next;
		return item;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
