package com.hyend.data.storage.structures.linkedlists.singly;

/**
 * Reverse a linked list
 * 
 * @author gopi_karmakar
 */
public class ReverseLinkedList {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> sll = SinglyLinkedList.createDefault();			
		
		sll.print(reverse(sll.head));
	}
	
	/**
	 * 	O(n) time complexity with O(1) extra space.
	 */
	private static Node<Integer> reverse(Node<Integer> head) {
		
		Node<Integer> current = head, prev = null, next = null;
		
		Node<Integer> dummyHead = new Node<>();		
		
		int n = 0;
		while(current.next != null) {
			
			next = current.next;
			current.next = next.next;
			next.next = dummyHead.next;
			dummyHead.next = next;
			
		}
		
		//System.out.println(current.k);
		return dummyHead.next;
		
		/*while(current != null) {
			
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}*/		
		//return prev;
	}
}