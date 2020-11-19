package com.hyend.data.storage.structures.linkedlists.singly;

/**
 * An Amazon interview question  
 * 
 * Remove a given node from linked list without providing 
 * it's head pointer. Just providing the node to be deleted.
 * 
 * @author gopi_karmakar
 */
public class RemoveANodeWithoutHeadPointer {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> sll = SinglyLinkedList.createDefault();
		
		System.out.println("Before");
		sll.print();
		
		remove(sll.head.next.next.next.next);
		System.out.println("\nAfter");
		sll.print();
	}
	
	/**
	 * O(1) time complexity
	 */
	private static Node<Integer> remove(Node<Integer> node) {
		
		if(node == null || node.next == null) {
			node = null;
			return null;
		}
		
		Node<Integer> next = node.next;
		node.k = next.k;
		node.next = next.next;
		next = null;
		
		return node;
	}
}
