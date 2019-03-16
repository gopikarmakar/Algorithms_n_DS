package com.hyend.data.storage.structures;

import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author gopi_karmakar
 *
 * A concrete Single LinkedList Implementation.
 * @param <E>
 */
public class MyLinkedList<E extends Comparable<E>> implements Iterable<E> {

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
		while(current != null) {
			Node<E> nextCurrent = current.next;
			while(nextCurrent != null && nextCurrent.item.compareTo(current.item) == 0) {
				nextCurrent = nextCurrent.next;
			}
			current.next = nextCurrent;
			current = nextCurrent;
		}
	}	
	
	public Node<E> reverse() {
		return reverse(head);		
	}
	
	private Node<E> reverse(Node<E> head) {		 
		Node<E> prev = null;
		Node<E> next = null;
		Node<E> current = head;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		this.head = prev;
		//System.out.print("Head = " + head.item);
		return prev;
	}
	
	public Node<E> reverseKGroups(int k) {
		return reverseKGroups(head, k);
	}
	
	/**
	 *         
	 * input : 1->2->3->4->5->6-7 k = 3
	 * output : 3->2->1->6->5->4->7
	 * 
	 * @param k
	 */
	private Node<E> reverseKGroups(Node<E> head, int k) {
		Node<E> current = head; 
		Node<E> next = null;
		Node<E> prev = null; 
         
       int count = 0; 
  
       	/* Reverse first k nodes of linked list */
       	while (count < k && current != null)  {       		
       		next = current.next; 
       		current.next = prev; 
       		prev = current; 
       		current = next;
       		count++;
       	}	 
  
       	/* next is now a pointer to (k+1)th node  
		   Recursively call for the list starting from current. 
		   And make rest of the list as next of first node */
       	if (next != null)  
          head.next = reverseKGroups(next, k); 
  
       	// prev is now head of input list 
       	return prev; 
    }
	
	public Node<E> removeNthFromEnd(int n) {
		return removeKthFromEnd(head, n);
	}
	
	/**
	 * Remove Kth node from the end of the linked list
	 * @param head
	 * @param k
	 * @return
	 */
	private Node<E> removeKthFromEnd(Node<E> head, int k) {
        		
		Node<E> first, second;
		first = head.next;		
		while(k-- >= 0) {
			if(first != null)
				first = first.next;
		}
		
		second = head;
		while(first != null) {
			second = second.next;
			first = first.next;
		}
		second.next = second.next.next;
		return head;
	}
	
	/**
	 * Merge two sorted linked list
	 * @return
	 */
	public Node<E> merge(MyLinkedList<E> list1, MyLinkedList<E> list2) {
	
		Node<E> dummyHead = new Node<>(null);
		Node<E> current = dummyHead;
		Node<E> l1 = list1.head, l2 = list2.head;
		
		while(l1 != null && l2 != null) {
			if(l1.item.compareTo(l2.item) < 0) {
				current.next = l1;
				l1 = l1.next;
			}
			else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		//Appending the remaining nodes of l1 or l2
		current.next = (l1 != null) ? l1 : l2;
		this.head = dummyHead.next;
		dummyHead = null;	// For garbage collection		
		return this.head;
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
