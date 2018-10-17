package com.hyend.data.storage.structures;

public class LinkedListQueue {

	private Node rear = null;
	private Node front = null;
	
	class Node {
		
		Object item;
		Node next;
		public Node(Object item) {
			this.item = item;
		}
	}
	
	public boolean isEmpty() {
		return front == null && rear == null;
	}
	
	public void enqueue(Object item) {
		Node node = new Node(item);
		node.next = null;
		if(front == null && rear == null) {
			front = rear = node;
			return;
		}
		rear.next = node;
		rear = node;
	}
	
	public Object dequeue() {
		
		if(isEmpty()) return null;
		Object item = front.item;
		front = front.next;
		return item;
	}
}
