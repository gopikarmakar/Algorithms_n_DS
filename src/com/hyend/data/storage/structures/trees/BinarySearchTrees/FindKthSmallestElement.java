package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.Stack;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Find Kth smallest element in a BST
 * 
 * @author gopi_karmakar
 */
public class FindKthSmallestElement {
		
	private static int count = 0;
	
	private static Node<Integer, ?> min = null;

	public static void main(String[] args) {
		
		Node<Integer, ?> root = BinarySearchTree.createDefault();
		
		System.out.println(kthSmall(root, 4));		
		
		count = 0;
		kthSmallest(root, 4);
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
		
		if(count == k) {
			min = node;
			return;
		}
		 
		kthSmallest(node.right, k);	
		
		return;
	}
}
