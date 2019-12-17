package com.hyend.data.storage.structures.linkedlists.singly;

/**
 * Reverse a sub linked list.
 * 
 * @author gopi_karmakar
 */
public class ReverseASubLinkedList {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> sll = SinglyLinkedList.createDefault();
		
		reverseSubList(sll.head, 3, 7);
		
		sll.print();
	}
	
	/**
	 * The time complexity is dominated by the search for the fth node, i.e.,O(f).
	 */
	private static Node<Integer> reverseSubList(Node<Integer> head, int start, int end) {
		
		Node<Integer> dummyHead = new Node<Integer>(head);
		
		Node<Integer> subListHead = dummyHead;
		
		int k = 1;
		
		while(k++ < start) {
			
			subListHead = subListHead.next;
		}
		
		Node<Integer> subListItr = subListHead.next;
		
		while(++start < end) {
			
			Node<Integer> temp = subListItr.next;
			subListItr.next = temp.next;
			temp.next = subListHead.next;
			subListHead.next = temp;
		}
		return dummyHead.next;
	}	
}
