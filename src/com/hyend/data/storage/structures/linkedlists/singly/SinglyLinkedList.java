package com.hyend.data.storage.structures.linkedlists.singly;

import java.util.Iterator;

public class SinglyLinkedList<K, V> {
	
	public static void main(String[] args) {		
		SinglyLinkedList<?, ?> linkedList = createDefault();
		linkedList.print(linkedList);
	}
	
	public static SinglyLinkedList<Integer, Integer> createDefault() {
		SinglyLinkedList<Integer, Integer> linkedList = new SinglyLinkedList<>();
		for(Integer i = 1; i <= 10; i++)
			linkedList.addNode(i, i);
		
		return linkedList;
	}

	private Node head; 
	private Node tail;
	
	public class Node {		
		public K k;
		public V v;
		public Node next;
		public Node(K k, V v) {
			this.k = k;
			this.v = v;
		}
	}		
	
	public void addNode(K k, V v) {		
		Node node = tail;
		tail = new Node(k,v);
		
		if(head == null) {
			head = tail;
			return;
		}
		node.next = tail;
	}
	
	@SuppressWarnings("unchecked")
	private void print(SinglyLinkedList<?, ?> linkedList) {
		
		Iterator<?> itr = linkedList.getIterator();
		while(itr.hasNext()) {			
			Node node = (SinglyLinkedList<K, V>.Node) itr.next(); 
			System.out.println("Key = " + node.k + " Value = " + node.v);
		}
	}
	
	public Iterator<Node> getIterator() {
		
		Iterator<Node> itr = new Iterator<Node>() {

			Node current = head;
			
			@Override
			public boolean hasNext() {				
				return (current != null);
			}

			@Override
			public Node next() {
				Node node = current;
				current = current.next;				
				return node;
			}
			
			@Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
		};		
		return itr;
	}
}
