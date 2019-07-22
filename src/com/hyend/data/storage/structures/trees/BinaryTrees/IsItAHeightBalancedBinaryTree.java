package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * A solution to check whether a Binary Tree is height balanced.
 * 
 * Variant: Write a program that returns the size of the largest subtree that is complete.
 * 
 * Variant: Define a node in a binary tree to be k-balanced if the difference in the number
 * of nodes in its left and right subtrees is no more than k. Design an algorithm that takes
 * as input a binary tree and positive integer k, and returns a node in the binary tree such 
 * that the node is not k-balanced, but all of its descendants are k-balanced. 
 * 
 * @author gopi_karmakar
 */
public class IsItAHeightBalancedBinaryTree {

	public static void main(String[] args) {
		int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		boolean status = isBalanced(BuildABinaryTreeInLevelOrder.build(keys));
		System.out.println("Is It Balanced = " + status);
	}
	
	private static boolean isBalanced(BinaryTree.Node<Integer> root) {
		return checkBalance(root).balanced;
	}
	
	private static class BalanceStatusWithHeight {
		
		private int height;
		private boolean balanced;
		
		public BalanceStatusWithHeight(boolean balanced, int height) {
			this.height = height;
			this.balanced = balanced;			
		}
	}
	
	/**
	 * A better algorithm is we do not need to store the heights of all nodes 
	 * at the same time. Once we are done with a subtree, all we need is whether 
	 * it is height-balanced, and if so, what its height is. We do not need any  
	 * information about descendants of the subtree's root. 
	 * 
	 * The program implements a PostOrder traversal with some calls possibly 
	 * being eliminated because of early termination. Specifically, if any left 
	 * subtree is not height- balanced we do not need to visit the corresponding 
	 * right subtree. The function call stack corresponds to a sequence of calls 
	 * from the root through the unique path to the current node, and the stack height 
	 * is therefore bounded by the height of the tree, leading to an 0(h) space bound
	 * 
	 * The time complexity is the same as that for a PostOrder traversal, namely 0(n).
	 * 
	 * @param BinaryTree.Node<Key> left
	 * @return
	 */
	private static BalanceStatusWithHeight checkBalance(BinaryTree.Node<Integer> left) {
		
		if(left == null)
			return new BalanceStatusWithHeight(true, -1); //Base Case
		
		BalanceStatusWithHeight leftTreeResult = checkBalance(left.left);
		if(!leftTreeResult.balanced)
			return leftTreeResult;	//Left sub tree isn't balanced.
		
		BalanceStatusWithHeight rightTreeResult = checkBalance(left.right);
		if(!rightTreeResult.balanced)
			return rightTreeResult;	//Right sub tree isn't balanced.
		
		boolean isBalanced = (Math.abs(leftTreeResult.height - rightTreeResult.height) <= 1); 
		int height = Math.max(leftTreeResult.height, rightTreeResult.height) + 1;
		return new BalanceStatusWithHeight(isBalanced, height);
	}
}
