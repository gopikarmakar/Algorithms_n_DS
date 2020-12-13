package com.hyend.data.storage.structures.linkedlists.singly;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * @author gopi_karmakar
 */
public class MergeTwoSortedLinkedList {

	public static void main(String[] args) {
		
		Integer[] keys1 = {1, 3, 5};
		
		Integer[] keys2 = {2, 4};
		
		SinglyLinkedList<Integer> l1 = SinglyLinkedList.create(keys1);
		
		SinglyLinkedList<Integer> l2 = SinglyLinkedList.create(keys2);
		
		Node<Integer> head = merge(l1.head, l2.head);
		
		SinglyLinkedList.print(head);
	}
	
	/**
	 * Accepted in Leetcode with 0ms 100% runtime
	 */
	private static Node<Integer> merge(Node<Integer> l1, Node<Integer> l2) {
		
		Node<Integer> dummyHead = new Node<>();
		
		Node<Integer> current = dummyHead;
		
		Node<Integer> p1 = l1, p2 = l2;
		
		while(p1 != null && p2 != null) {
			
			if(p1.k < p2.k) {
				current.next = p1;
				p1 = p1.next;
			}
			else {
				current.next = p2;
				p2 = p2.next;
			}
			
			current = current.next;
		}
		
		current.next = (p1 != null) ? p1 : p2;
		
		return dummyHead.next;
	}
}
