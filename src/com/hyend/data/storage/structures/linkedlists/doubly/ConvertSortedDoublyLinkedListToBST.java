package com.hyend.data.storage.structures.linkedlists.doubly;

public class ConvertSortedDoublyLinkedListToBST {

	private static Node<Integer> head = null;
	
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> dll = DoublyLinkedList.createDefault();
		head = dll.head;
		
		Node<Integer> root = convert(0, dll.size());
		
		preOrder(root);
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
		
		Node<Integer> current = new Node<>(head.k, left, null);
		
		head = head.next;
		
		current.next = convert(mid + 1, end);
		
		return current;
	}
	
	private static void preOrder(Node<Integer> node) {
		
		if (node == null) 
            return; 
		
		preOrder(node.prev);		
		preOrder(node.next);
		System.out.println(node.k);
	}
}
