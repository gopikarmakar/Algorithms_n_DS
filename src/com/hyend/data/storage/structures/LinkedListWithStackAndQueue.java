package com.hyend.data.storage.structures;
/**
 * @author karmakargopi
 * 
 * Amazon Interview Question.
 * 
 * Implement a DataStructure Which Can  
 * Have Functionalities of a Stack & a Queue Both.
 * Which means, functionalities like 
 * Push and Enqueue or Pop and Dequeue 
 * all the from the same data structure parallely.
 *
 */
public class LinkedListWithStackAndQueue<E> {
	
	Node head, tail;
	class Node {
		E item;
		Node next;
		Node previous;
		Node(E item) {
			this.item = item;
		}
	}
	
	public void pushOrEnqueue(E item) {
		Node node = new Node(item);
		node.next = head;
		if(tail == null && node.next == null) {
			tail = node;
			node.previous = null;
		}
		else {
			node.next.previous = node;
		}
		head = node;
	}
	
	public E dequeue() {
		
		if(isEmpty()) return null;
		E item = tail.item;
		Node node = tail;
		tail = tail.previous;
		return item;
	}
	
	public Object pop() {
		
		if(isEmpty()) return null;
		E item = head.item;
		head = head.next;
		return item;
	}
	
	public boolean isEmpty() {
		return (head == null) && (tail == null);
	}
}
