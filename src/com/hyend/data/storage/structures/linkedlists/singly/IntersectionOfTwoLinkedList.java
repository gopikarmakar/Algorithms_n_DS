package com.hyend.data.storage.structures.linkedlists.singly;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Two LinkedList connecting to the same head of third LinkedList.
 * Return the node from the point where both the LinkedLists are
 * intersecting each other.  
 *  
 * @author gopi_karmakar
 */
public class IntersectionOfTwoLinkedList {

	public static void main(String[] args) {
	
		Integer[] keys1 = {4, 1};
		Integer[] keys2 = {5, 6, 1};		
		Integer[] keys3 = {8, 4, 5};
		
		SinglyLinkedList<Integer> sl1 = SinglyLinkedList.create(keys1);		
		
		SinglyLinkedList<Integer> sl2 = SinglyLinkedList.create(keys2);
		
		SinglyLinkedList<Integer> sl3 = SinglyLinkedList.create(keys3);				
		
		Node<Integer> l1 = connectToL3(sl1.head, sl3.head);
		Node<Integer> l2 = connectToL3(sl2.head, sl3.head);		
		
		System.out.println(findIntersection(l1, l2));		
	}	
	
	/**
	 * Solution Accepted in LeetCode with 1ms 97.58% runtime. 
	 * O(n) time complexity
	 */
	private static Node<Integer> findIntersection(Node<Integer> l1, Node<Integer> l2) {
		
		int len1 = getLength(l1), len2 = getLength(l2);
		
		if(len1 > len2) {
			l1 = advanceListByK(l1, len1-len2);
		}
		else {
			l2 = advanceListByK(l2, len2-len1);
		}
		
		while(l1 != null && l2 != null && l1 != l2) {
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		// null implies there is no overlap between LI and L2.
		return l1;
	}
	
	private static Node<Integer> advanceListByK(Node<Integer> list, int k) {
		
		while(k-- > 0) {
			
			list = list.next;			
		}
		return list;
	}
	
	private static int getLength(Node<Integer> list) {
		
		int len = 0;
		
		while(list != null) {
			
			len++;
			list = list.next;			
		}
		return len;
	}
	
	///// Create Sample data ///////
	private static Node<Integer> connectToL3(Node<Integer> l1, Node<Integer> l3) {
		
		Node<Integer> head = l1;
		
		while(l1.next != null)
			l1 = l1.next;
		
		l1.next = l3;
		
		return head;
	}
}
