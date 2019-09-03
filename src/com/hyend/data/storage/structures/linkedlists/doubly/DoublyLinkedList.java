package com.hyend.data.storage.structures.linkedlists.doubly;

import java.util.Iterator;

/**
 * Concrete Doubly LinkedList Implementation.
 *
 * @author gopi_karmakar
 */
public class DoublyLinkedList<K> {	
	
	public static final int FORWARD = 1;
	public static final int REVERSE = 2;
	
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> dll = createDefault();		
		dll.printAllNodes(FORWARD);
	}
	
	public static DoublyLinkedList<Integer> createDefault() {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		for(Integer i = 1; i <= 15; i++)
			dll.add(i);
		
		return dll;
	}
	
	public int size = 0;
	public Node head = null;
	public Node tail = null;	
	
	public class Node {		
		K k;
		Node next;
		Node prev;
		public Node(K k) {
			this.k = k;			
		}
	}

	private void addNode(Node node) {
		size += 1;
		Node temp = tail;
		tail = node;
		if(head == null) {
			head = tail;
			return;
		}
		temp.next = tail;
		tail.prev = temp;
	}
	
	public void add(K k) {		
		Node node = new Node(k);
		addNode(node);
	}
	
	public int size() {		
		return size;
	}
	
	public void printAllNodes(int order) {
		Iterator<K> itr = getIterator(order); 
		while(itr.hasNext()) {
			K k = itr.next();
			System.out.println("Key = " + k);
		}
	}
	
	public Iterator<K> getIterator(int order) {		
		
		Iterator<K> itr = new Iterator<K>() {
			
			Node current = (order == REVERSE) ? tail : head;
			
			@Override
			public boolean hasNext() {				
				return (current != null);
			}
			
			@Override
			public K next() {
				K k = current.k;
				current = (order == REVERSE) ? current.prev : current.next;
				return k;
			}
			
			@Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
		};
		return itr;
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
		int length = size()/2;
		Node tempTail, current;		
		current = head;
		while(length > 0) {
			tempTail = tail;
			tail = tail.prev;
			tail.next = null;
			tempTail.next = current.next;
			current.next = tempTail;
			current = tempTail.next;
			length -= 1;
		}
	}
}