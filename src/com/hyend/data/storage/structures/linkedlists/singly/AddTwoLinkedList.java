package com.hyend.data.storage.structures.linkedlists.singly;

/**
 * 
 * @author gopi_karmakar
 */
public class AddTwoLinkedList {

	public static void main(String[] args) {
		
		Integer[] keys1 = {2, 4, 3};
		Integer[] keys2 = {5, 6, 4};
		
		SinglyLinkedList<Integer> sll1 = SinglyLinkedList.create(keys1);
		SinglyLinkedList<Integer> sll2 = SinglyLinkedList.create(keys2);
		
		Node<Integer> l1 = sll1.head;
		Node<Integer> l2 = sll2.head;
		
		SinglyLinkedList.print(add(l1, l2));
	}
	
	/**
	 * Solution accepted in Leetcode with 2ms 80% runtime
	 * O(n) time complexity
	 */
	private static Node<Integer> add(Node<Integer> l1, Node<Integer> l2) {
		
		Node<Integer> dummyHead = new Node<>();
		
		Node<Integer> current = dummyHead;
		
		Node<Integer> p1 = l1, p2 = l2;
		
		int carry = 0;
		
		while(p1 != null || p2 != null) {
			
			int e1 = (p1 != null) ? p1.k : 0;
			int e2 = (p2 != null) ? p2.k : 0;
			
			int sum = e1 + e2 + carry;
			
			carry = sum / 10;
			current.next = new Node<>(sum % 10);
			current = current.next;
			
			if(p1 != null) p1 = p1.next;
			if(p2 != null) p2 = p2.next;
		}
		
		if(carry > 0)
			current.next = new Node<>(carry);
		
		return dummyHead.next;
	}
}
