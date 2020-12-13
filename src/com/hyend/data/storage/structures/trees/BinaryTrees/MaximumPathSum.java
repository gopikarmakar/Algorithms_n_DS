package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * Given a non-empty binary tree, find the maximum path sum.
 * The path must contain at least one node and does not need 
 * to go through the root.
 * 
 * @author gopi_karmakar
 */
public class MaximumPathSum {

	/**
	 * Tree may have negative nodes too
	 * So initialized with MIN_VALUE.
	 */
	private static int maxSum = Integer.MIN_VALUE;
			
	public static void main(String[] args) {
		
		//Integer[] keys = {1, 2, 3};
		
		Integer[] keys = {-10, 9, 20, null, null, 15, 7};
		
		Node<Integer> root = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		
		//BinaryTree.printBFS(root, true);
		
		maxPathSum(root);
		
		System.out.println(maxSum);
	}
	
	/**
	 * Efficient solution
	 * Accepted in Leetcode with 0ms 100% runtime.
	 */
	private static int maxPathSum(Node<Integer> node) {
		
		if(node == null)
			return 0;
		
		int left = maxPathSum(node.left);
		int right = maxPathSum(node.right);
		
		int maxChild = Math.max(left, right);
		int maxParentChild = Math.max(maxChild + node.key, node.key);
		int maxSubTree = Math.max(maxParentChild, left+right+node.key);
		
		maxSum = Math.max(maxSum, maxSubTree);
		
		return maxParentChild;
	}
}
