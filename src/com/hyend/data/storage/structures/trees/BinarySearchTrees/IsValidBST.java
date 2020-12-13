package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Validate if a given BST is a valid BST 
 * 
 * @author gopi_karmakar
 */
public class IsValidBST {
	
	public static void main(String[] args) {
	
		Node<Integer, ?> tree = BinarySearchTree.createDefault();		
		
		System.out.println(isValidBST(tree));
	}
	
	/**
	 * Accepted in Leetcode with 100% runtime.
	 */
	public static boolean isValidBST(Node<Integer, ?> root) {
		
		if(root == null) return true;
		
		return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	/**
	 * A PreOrder DFS O(n) time complexity solution.
	 * 
	 * Look into Binary Tree Package for a better BFS solution.  
	 */
	private static boolean isBST(Node<Integer, ?> node, long min, long max) {
		
		if(node == null)
			return true;
		
		if(node.key <= min || node.key >= max)
			return false;
		
		return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
	}
}
