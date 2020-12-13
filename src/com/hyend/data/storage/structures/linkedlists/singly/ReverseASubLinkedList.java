package com.hyend.data.storage.structures.linkedlists.singly;

/**
 * Reverse a sub linked list.
 * 
 * @author gopi_karmakar
 */
public class ReverseASubLinkedList {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> sll = SinglyLinkedList.createDefault();
		
		reverseSubList(sll.head, 6, 10);
		
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
		
		//1->2->3->4->5->6->7->8->9->10		
		
		Node<Integer> prev = subListHead.next;
		
		while(++start < end) {
						
			Node<Integer> next = prev.next;
			prev.next = next.next;
			next.next = subListHead.next;
			subListHead.next = next;	
		}
				
		return dummyHead.next;
	}	
}
