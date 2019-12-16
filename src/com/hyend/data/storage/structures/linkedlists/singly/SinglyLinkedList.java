package com.hyend.data.storage.structures.linkedlists.singly;

import java.util.Iterator;

/**
 * Concrete Single Linked List Implementation
 *   
 * @author gopi_karmakar
 */
public class SinglyLinkedList<K> {
	
	public int size = 0;
	public Node<K> head; 
	public Node<K> tail;
	
	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> linkedList = createDefault();
		
		linkedList.print(linkedList);
	}
	
	public static SinglyLinkedList<Integer> createDefault() {
		
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		
		for(Integer i = 1; i <= 15; i++)
			linkedList.add(i);
		
		return linkedList;
	}
						
	public void add(K k) {		
		size += 1;
		Node<K> node = tail;
		tail = new Node<>(k);		
		if(head == null) {
			head = tail;
			return;
		}
		node.next = tail;
	}
	
	public int size() {		
		return size;
	}
	
	public void print(SinglyLinkedList<K> linkedList) {
		
		Iterator<K> itr = linkedList.getIterator();
		while(itr.hasNext()) {			
			K k = itr.next(); 
			System.out.println("Key = " + k );
		}
	}
	
	public Iterator<K> getIterator() {
		
		Iterator<K> itr = new Iterator<K>() {

			Node<K> current = head;
			
			@Override
			public boolean hasNext() {				
				return (current != null);
			}

			@Override
			public K next() {
				K k = current.k;
				current = current.next;				
				return k;
			}
			
			@Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
		};		
		return itr;
	}
}
