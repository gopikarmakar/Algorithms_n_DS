package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.Stack;

/**
 * Find Kth Largest element in a BST
 * 
 * @author gopi_karmakar
 */
public class FindKthLargestElement {

	private static int count = 0;
	private static boolean flag = false;
	
	private static Node<Integer, ?> max;
	
	public static void main(String[] args) {
		
		Node<Integer, ?> bst = BinarySearchTree.createDefault();
		
		System.out.println(kthLarge(bst, 4));
		
		count = 0;
		kthLargest(bst, 4);
		System.out.println(max);
	}
	
	/** 
	 * Iterative and O(n-k) time space complexity solution.
	 */
	private static Node<Integer, ?> kthLarge(Node<Integer, ?> node, int k) {
		
		Stack<Node<Integer, ?>> stack = new Stack<>();
		
		Node<Integer, ?> e = node;
		
		while(!stack.isEmpty() || e != null) {
			
			if(e != null) {
				
				stack.add(e);
				e = e.right;
			}
			else {
				
				e = stack.pop();
				
				count++;
				
				if(count == k)
					return e;
				
				e = e.left;
			}
		}	
		return null;
	}
	
	/**
	 * Recursive and O(n-k) time space complexity solution.
	 */
	private static void kthLargest(Node<Integer, ?> node, int k) {
		
		if(node == null) return;
		
		kthLargest(node.right, k);
		
		count++;
		if(count == k && flag == false) {
			max = node;
			flag = true;
		}
		
		kthLargest(node.left, k);
	}
}
