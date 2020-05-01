package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.Stack;

/**
 * Find Kth smallest element in a BST
 *  
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * @author gopi_karmakar
 */
public class FindKthSmallestElement {
		
	private static int count = 0;
	private static boolean flag = false;
	
	private static Node<Integer, ?> min = null;

	public static void main(String[] args) {
		
		Node<Integer, ?> bst = BinarySearchTree.createDefault();
		
		System.out.println(kthSmall(bst, 4));		
		
		count = 0;		
		kthSmallest(bst, 4);
		System.out.println(min);
	}	
	
	/** 
	 * Iterative and O(n-k) time space complexity solution.
	 */
	private static Node<Integer, ?> kthSmall(Node<Integer, ?> node, int k) {
		
		Stack<Node<Integer, ?>> stack = new Stack<>();
		
		Node<Integer, ?> e = node;
		
		while(!stack.isEmpty() || e != null) {
			
			if(e != null) {
				stack.push(e);
				e = e.left;
			}
			else {
				
				e = stack.pop();
				count++;
				if(count == k) {
					return e;
				}
				e = e.right;									
			}
		}
		return null;
	}
	
	/**
	 * Recursive and O(n-k) time space complexity solution.
	 */
	private static void kthSmallest(Node<Integer, ?> node, int k) {
		
		if(node == null) return;
			
		kthSmallest(node.left, k);
		
		count++;
		
		if(count == k && flag == false) {
			min = node;
			flag = true;
		}
		 
		kthSmallest(node.right, k);			
	}
}
