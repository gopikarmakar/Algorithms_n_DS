package com.hyend.data.storage.structures.linkedlists.singly;

/**
 * An Amazon interview question.
 * 
 * Remove the Kth node from the end of the linked list
 * 
 * @author gopi_karmakar
 */
public class RemoveKthNodeFromEnd {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> sll = SinglyLinkedList.createDefault();
		System.out.println("Before");
		sll.print();
		
		Node<Integer> newList = removeKthNodeFromEnd(sll.head, 3);
		System.out.println("\nAfter");
		sll.print(newList);
	}
	
	/**
	 * Time complexity is O(n) where n is the length of list.
	 * Space complexity is O(1)
	 */
	private static Node<Integer> removeKthNodeFromEnd(Node<Integer> head, int k) {
		
		Node<Integer> dummyHead = new Node(head);
		
		//Setting first to dummyHead.next because we want to keep the second at k-1 position
		Node<Integer> first = dummyHead.next;
		
		while(k-- > 0) {
			
			first = first.next;
		}
		
		Node<Integer> second = dummyHead;
		
		while(first != null) {
			
			first = first.next;
			second = second.next;			
		}
		
		second.next = second.next.next;
		
		return dummyHead;				
	}
}
