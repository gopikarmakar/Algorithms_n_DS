package com.hyend.data.storage.structures;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author gopi_karmakar
 *
 * A concrete Single LinkedList Implementation.
 * @param <E>
 */
public class MyLinkedList<E> implements Iterable<E> {

	private int totalSize = 0;
	private Node<E> head = null;
	private Node<E> tail = null;
	
	static class Node<E> {		
		E item;
		Node<E> next;		
		Node(E item) {
			this.item = item;
		}
	}
	
	public void add(E item) {
		totalSize += 1;
		Node<E> node = tail;
		tail = new Node<E>(item);							
		if(head == null) {
			head = tail;
			return;
		}
		node.next = tail;		
	}
	
	public Node<E> find(E item) {
		Node<E> node = head;
		if(item == null)
			return null;
		
		while(node != null) {
			if(node.item == item && node.item.equals(item)) break;
			node = node.next;
		}		
		return node;		
	}
	
	public boolean contains(E item) {
		boolean status = false;
		if(item == null || head == null)
			return status;
		
		Iterator<E> itr = iterator();
		while(itr.hasNext()) {
			E value = itr.next();
			if(item == value && item.equals(value)) {
				status = true;
				break;
			}
		}
		return status;
	}
	
	public boolean update(E oldItem, E newItem) {
		boolean status = false;		
		if(oldItem == null || newItem == null || head == null)
			return status;
		
		Node<E> node = head;
		while(node != null) {
			if(node.item == oldItem && node.item.equals(oldItem)) {				
				node.item = newItem;
				status = true;
				break;
			}
			node = node.next;
		}
		return status;
	}
	
	public boolean delete(E item) {		
		boolean status = false;		
		if(item == null || head == null) {			
			return status;
		}
				
		Node<E> current = head;
		if(current.item == item && current.item.equals(item)) {			
			head = head.next;
			current = null;
			status = true;
			totalSize -= 1;
			return status;
		}
				
		Node<E> previous = current;
		current = current.next;
		while(current != null) {
			if(current.item == item && current.item.equals(item)) {
				previous.next = current.next;
				totalSize -= 1;
				status = true;
			}
			previous = current;			
			current = current.next;			
		}
		return status;
	}
	
	public void removeAllDuplicates() {		
		Node<E> current = head; 
		while(current.next != null) {
			Node<E> previous = current;
			Node<E> nextCurrent = current.next;
			while(nextCurrent.next != null) {
				if(nextCurrent.item.equals(current.item)) {
					previous.next = nextCurrent.next;
				}
				previous = nextCurrent;
				nextCurrent = nextCurrent.next;
			}
			if(nextCurrent.item.equals(current.item)) {
				previous.next = null;
			}
			current = current.next;
		}
	}
	
	public Node<E> removeNthFromEnd(int n) {
		return removeNthFromEnd(head, n);
	}
	
	
	private Node<E> removeNthFromEnd(Node<E> head, int n) {
        
		int size = 1;
		Node<E> node = head;
		if(head == null || n == 0) return head;
		while(node.next != null) {
			node = node.next;
			size+=1;
		}		
		node = head;
		
		return head;
	}

	
	public int size() {
		return totalSize;
	}
	
	public void printAllNodes() {		
		Node<E> node = head;
		while(node != null) {
			System.out.println(node.item);
			node = node.next;
		}
	}
	
	public void addNewEnd(Object item) {}
	
	public void addNewHead(Object item) {}
	
	public void addNodeAfter(Object existItem, Object newItem) {}
	
	public void addNodeBefore(Object existItem, Object newItem) {}

	@Override
	public Iterator<E> iterator() {
		
		Iterator<E> itr = new Iterator<E>() {

			Node<E> current = head;
			
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
            	E item = current.item;           
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return itr;
	}
}
