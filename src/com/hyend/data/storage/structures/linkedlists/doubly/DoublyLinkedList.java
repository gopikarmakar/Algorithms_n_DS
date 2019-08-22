package com.hyend.data.storage.structures.linkedlists.doubly;

/**
 * Doubly LinkedList Implementation.
 *
 * @author gopi_karmakar
 */
public class DoublyLinkedList<K, V> {
	
	private Node head = null;
	private Node tail = null;	
	
	class Node {		
		K k;		
		Node next;
		Node previous;
		Object item;
		public Node(K k) {
			this.k = k;
		}
	}

	private void addNode(Node node) {		
		if(head == null && tail == null) {
			head = tail = node;
			return;
		}
		node.previous = tail;
		tail.next = node;
		tail = tail.next;
	}
	
	public void put(K k) {		
		Node node = new Node(k);
		//node.next = null;
		addNode(node);
	}

	/**
	 * Solution: Amazon Coding Interview Question.
	 * 
	 * Given x1 -> x2 -> x3… -> y3 -> y2 -> y1
	 * Reorder it to x1 -> y1 -> x2 -> y2 -> x3 -> y3
	 * e.g.
	 * Given 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
	 * Return 1 -> 10 -> 2 -> 9 -> 3 -> 8 -> 4 -> 7 -> 5 -> 6
	 */
	public void reorderLinkedList() {
		int length = getLength()/2;
		Node tempTail, current;		
		current = head;
		while(length > 0) {
			tempTail = tail;
			tail = tail.previous;
			tail.next = null;
			tempTail.next = current.next;
			current.next = tempTail;
			current = tempTail.next;
			length -= 1;
		}
	}
	
	public int getLength() {
		int length = 0;
		Node node = head;
		while(node != null) {
			length += 1;
			node = node.next;
		}
		return length;
	}
	
	public void printAllNodes() {		
		Node node = head;
		while(node != null) {
			System.out.println(node.item);
			node = node.next;		
		}
	}
	
	public void printAllNodesInReverse() {		
		while(tail != null) {
			System.out.println(tail.item);
			tail = tail.previous;			
		}
	}
}