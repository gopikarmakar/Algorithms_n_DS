package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.Stack;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * @author gopi_karmakar
 */
public class FlattenBinaryTreeIntoLinkedList {

	public static void main(String[] args) {
		
		Integer[] keys = {1, 2, 5, 3, 4, null, 6};
		
		Node<Integer> tree = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		
		BinaryTree.printBFS(tree, true);
		
		flat(tree);
				
		BinaryTree.printPreOrderRecursive(tree, false);
		
		System.out.println("\nIn Place: \n");
		
		Node<Integer> root = flatten(tree);
		
		BinaryTree.printPreOrderRecursive(root, false);
	}
	
	/**
	 * A quite easy solution but takes O(n) extra space.
	 * Accepted in LeetCode with 1ms Runtime.
	 */
	private static void flat(Node<Integer> root) {
		
		if(root == null)
			return;
					
		Stack<Node<Integer>> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			Node<Integer> current = stack.pop();
			
			if(current.right != null) {
				stack.push(current.right);
			}
			
			if(current.left != null) {
				stack.push(current.left);
			}
			
			if(!stack.isEmpty()) {
				current.right = stack.peek();
			}
			
			current.left = null;
		}		
	}
	
	/**
	 * A li'l complex but quite efficient in place solution.
	 * Accepted in Leetcode with 0ms 100% runtime.
	 */
	private static Node<Integer> flatten(Node<Integer> root) {
		
		if(root == null)
			return null;
		
		Node<Integer> left = flatten(root.left);
		Node<Integer> right = flatten(root.right);
		
		Node<Integer> current = root;
		
		if(left != null) {
			
			current.right = left;
			while(current.right != null) {
				current = current.right;
			}
		}
		
		if(right != null) {			
			current.right = right;
		}
		
		root.left = null;
		
		return root;
	}
}
