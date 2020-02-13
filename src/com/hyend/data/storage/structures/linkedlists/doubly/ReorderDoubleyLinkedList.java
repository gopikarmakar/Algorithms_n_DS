package com.hyend.data.storage.structures.linkedlists.doubly;

/**
 * An Amazon Coding Interview Question.
 * Given x1 -> x2 -> x3… -> y3 -> y2 -> y1
 * Reorder it to x1 -> y1 -> x2 -> y2 -> x3 -> y3
 * e.g.
 * Given 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
 * Return 1 -> 10 -> 2 -> 9 -> 3 -> 8 -> 4 -> 7 -> 5 -> 6
 * 
 * @author gopi_karmakar
 */
public class ReorderDoubleyLinkedList {

	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> dll = DoublyLinkedList.createDefault();
		
		Node<Integer> head = reorderLinkedList(dll);
		
		Node<Integer> node = head;
		
		while(node != null) {
			
			System.out.println(node.key);
			node = node.next;
		}
	}
	
	/**
	 * O(n) time complexity with O(1) extra space complexity solution. 
	 */
	public static Node<Integer> reorderLinkedList(DoublyLinkedList<Integer> dll) {
				
		Node<Integer> tail = dll.tail;
		
		Node<Integer> tempTail = null, current = null;
		
		current = dll.head;;
		while(current.next != null) {
			
			tempTail = tail;
			tail = tail.prev;
			tail.next = null;
			tempTail.next = current.next;
			current.next = tempTail;
			current = tempTail.next;
		}
		return dll.head;
	}
}
