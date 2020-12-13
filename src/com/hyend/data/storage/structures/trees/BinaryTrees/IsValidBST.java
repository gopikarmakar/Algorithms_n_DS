package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Check whether a given Binary Tree is a BST 
 * 
 * @author gopi_karmakar
 */
public class IsValidBST {

	public static void main(String[] args) {
		
		//Integer[] keys = {2, 1, 3};
		//Integer[] keys = {0, -1};
		Integer[] keys = {5, 1, 4, null, null, 3, 6};
		
		Node<Integer> tree = BinaryTree.buildDefault();
		
		Node<Integer> tree2 = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		
		//BinaryTree.printPreOrderRecursive(tree);
		//BinaryTree.printBFS(tree, true);
		
		System.out.println(isValidBST(tree, Long.MIN_VALUE, Long.MAX_VALUE));
	}	
	
	/**
	 * A DFS Algorithm to validate the BST property of a Binary Tree.
	 * 
	 * Accepted in Leetcode with 0ms 100% runtime	 
	 */
	private static boolean isValidBST(Node<Integer> node, long min, long max) {
		
		if(node == null)
			return true;
		
		if(node.key <= min || node.key >= max)
			return false;
		
		return isValidBST(node.left, min, node.key) && 
				isValidBST(node.right, node.key, max);
	}
}