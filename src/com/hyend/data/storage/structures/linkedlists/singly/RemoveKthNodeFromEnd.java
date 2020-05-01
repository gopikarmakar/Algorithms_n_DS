package com.hyend.data.storage.structures.linkedlists.singly;

/** 
 * An Amazon interview question.
 * 
 * Remove the Kth node from the end of the linked list
 * 
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author gopi_karmakar
 */
public class RemoveKthNodeFromEnd {

	public static void main(String[] args) {
		
		//SinglyLinkedList<Integer> sll = SinglyLinkedList.createDefault();
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		sll.add(1);
		System.out.println("Before");
		sll.print();
		
		Node<Integer> newList = removeKthNodeFromEnd(sll.head, 1);
		System.out.println("\nAfter");
		sll.print(newList);
	}
	
	/**
	 * Time complexity is O(n) where n is the length of list.
	 * Space complexity is O(1)
	 */
	private static Node<Integer> removeKthNodeFromEnd(Node<Integer> head, int k) {
		
		/*
		 *  Starting with -1 null node since taking care of
		 *  LinkedList size 1 and k = 1 in that case 
		 *  the linked list should empty.
		 */
		Node<Integer> dummyHead = new Node<>(-1);
		dummyHead.next = head;
		
		Node<Integer> first = dummyHead;
		Node<Integer> second = dummyHead;
		
		while(k-- > 0) {		
			first = first.next;
		}
					
		while(first.next != null) {
			
			first = first.next;
			second = second.next;			
		}
		
		second.next = second.next.next;			
		
		return dummyHead.next;				
	}
}
