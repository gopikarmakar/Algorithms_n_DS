package com.hyend.data.storage.structures.linkedlists.doubly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Convert a sorted double linked list to a balanced binary search tree
 * for e.g: DLL: 1<==>2<==>3<==>4<==>5<==>6<==>7<==>8<==>9<==>10 
 * BSTree:						6
 * 				3								9	
 * 		2				5				8				10
 * 	1				4				7
 * 
 * @author gopi_karmakar
 */
public class ConvertSortedDoublyLinkedListToBST {

	private static Node<Integer> head = null;
	
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> dll = DoublyLinkedList.createDefault();
		head = dll.head;
		
		Node<Integer> root = convert(0, dll.size());
		
		levelOrderTraversal(root);
		
		inOrderTraversal(root);
	}
	
	/**
	 * The algorithms spends O(1) time per node, leading to an O(n) time complexity. 
	 * No dynamic memory allocation is required. The maximum number of call frames  
	 * in the function call stack is log(n), yielding an O(log (n)) space complexity.
	 */
	private static Node<Integer> convert(int start, int end) {
		
		if(start >= end)
			return null;
		
		int mid = start + ((end - start) / 2);
		
		Node<Integer> left = convert(start, mid);
		
		Node<Integer> current = new Node<>(head.key, left, null);
		
		head = head.next;
		
		current.next = convert(mid + 1, end);
		
		return current;
	}
	
	private static void inOrderTraversal(Node<Integer> node) {
		
		if (node == null) 
            return; 		
		
		inOrderTraversal(node.prev);
		
		System.out.println(node.key);
		
		inOrderTraversal(node.next);		
	}
	
	private static void levelOrderTraversal(Node<Integer> node) {
		
		Queue<Node<Integer>> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			
			Node<Integer> current = queue.poll();				
			
			if(current != null) {
							
				System.out.println("Item = " + current.key);					
			}
			
			if(current.prev != null)	queue.add(current.prev);			
			if(current.next != null)	queue.add(current.next);
		}
	}
}
