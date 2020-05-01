package com.hyend.data.storage.structures.linkedlists.singly;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 
 * Find whether the given LinkedList is cyclic or not. 
 * If it is cyclic return the starting cyclic node.  
 * 
 * @author gopi_karmakar
 */
public class CircularLinkedList {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> sll = createSampleCircularLinkedList();
		
		System.out.println("Start of cyle is from = " + detectCycle(sll.head).k);		
	}
	
	/**
	 * Insight: If we move two pointers as being second one twice 
	 * faster than the first one then the both pointers will meet at 
	 * distance of head to first cyclic length steps ahead of first cycle pointer. 
	 * Since the second pointer is moving twice as fast the first pointer.
	 * 
	 * O(n) Time complexity with O(1) extra space. 
	 */
	private static Node<Integer> detectCycle(Node<Integer> head) {
		
		Node<Integer> slow = head, fast = head;		
	
		while(fast != null && fast.next != null && fast.next.next != null) {
		
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				
				slow = head;
				
				while(slow != fast) {
					
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;				
	}
	
	private static SinglyLinkedList<Integer> createSampleCircularLinkedList() {
		
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		
		/*for(int i = 1; i <= 10; ++i) {
			
			sll.add(i);
		}
		// Creating cycle
		sll.tail.next = sll.head.next.next.next.next;*/
		
		for(int i = 1; i <= 4; ++i) {
			
			sll.add(i);
		}
		// Creating cycle
		sll.tail.next = sll.head.next;
		
		return sll;
	}
}
