package com.hyend.data.storage.structures.linkedlists.doubly;
/**
 * Amazon Interview Question.
 * 
 * Implement a DataStructure Which Can  
 * Have Functionalities of a Stack & a Queue Both.
 * Which means, functionalities like 
 * Push and Enqueue or Pop and Dequeue 
 * all the from the same data structure parallely.
 * 
 * @author gopi_karmakar
 */
public class LinkedListWithStackAndQueue<K> {
	
	private Node<K> head;
	private Node<K> tail;
	
	public static void main(String[] args) {
		
		LinkedListWithStackAndQueue<Integer> deque = new LinkedListWithStackAndQueue<>();
		deque.pushOrEnqueue(1);
		deque.pushOrEnqueue(2);
		deque.pushOrEnqueue(3);
		deque.pushOrEnqueue(4);
		deque.pushOrEnqueue(5);		
		System.out.println(deque.pop());
		System.out.println(deque.pop());
		System.out.println(deque.pop());
		deque.pushOrEnqueue(6);
		deque.pushOrEnqueue(7);
		System.out.println(deque.pop());
		System.out.println(deque.pop());
		System.out.println(deque.pop());
	}
	
	public void pushOrEnqueue(K item) {
		
		Node<K> node = new Node<>(item);
		node.next = head;
		if(tail == null && node.next == null) {
			tail = node;
			node.prev = null;
		}
		else {
			node.next.prev = node;
		}
		head = node;
	}
	
	public K dequeue() {
		
		if(isEmpty()) return null;
		K item = tail.key;
		tail = tail.prev;
		tail.next = null;
		return item;
	}
	
	public K pop() {
		
		if(isEmpty()) return null;
		K item = head.key;
		head = head.next;
		return item;
	}
	
	public boolean isEmpty() {
		return (head == null) && (tail == null);
	}
}
