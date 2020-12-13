package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

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
public class IsItHeightBalanced {
	
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		
		Node<Integer> root = BinaryTree.buildDefault();
		
		isHeightBalanced(root);
		System.out.println("Is Height Balanced = " + (max < 2));

		boolean status = isBalanced(root);
		System.out.println("Is It Balanced = " + status);
	}
		
	/**
	 * An Efficient O(h) time complexity solution.
	 *  
	 * Accepted in Leetcode with 0ms 100% runtime and
	 * 74% less memory usage among all Leetcode submissions.  
	 */
	private static int isHeightBalanced(Node<Integer> node) {
		
		if(node == null) {
			return 0;
		}
		
		int lh = isHeightBalanced(node.left);
		
		int rh = isHeightBalanced(node.right);		
		
		max = Math.max(max, Math.abs(lh - rh));
		
		return Math.max(lh, rh) + 1; 
	}
		
	
//##########################################################################################
	/**
	 * Another quite better Solution.
	 * Since we cache the intermediate results. 
	 * 
	 * Accepted in Leetcode with 0ms 100% runtime but uses li'l more 
	 * space as it's 9% less memory usage among all Leetcode submissions.
	 */
	private static boolean isBalanced(Node<Integer> root) {
		return checkBalance(root).balanced;
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
	 * The time complexity is the same as that for a PostOrder traversal, namely O(n).
	 */
	private static BalanceStatusWithHeight checkBalance(Node<Integer> node) {
		
		if(node == null)
			return new BalanceStatusWithHeight(true, -1); //Base Case
		
		BalanceStatusWithHeight leftTreeResult = checkBalance(node.left);
		if(!leftTreeResult.balanced)
			return leftTreeResult;	//Left sub tree isn't balanced.
		
		BalanceStatusWithHeight rightTreeResult = checkBalance(node.right);
		if(!rightTreeResult.balanced)
			return rightTreeResult;	//Right sub tree isn't balanced.
		
		boolean isBalanced = (Math.abs(leftTreeResult.height - rightTreeResult.height) <= 1); 
		int height = Math.max(leftTreeResult.height, rightTreeResult.height) + 1;
		return new BalanceStatusWithHeight(isBalanced, height);
	}
	
	private static class BalanceStatusWithHeight {
		
		private int height;
		private boolean balanced;
		
		public BalanceStatusWithHeight(boolean balanced, int height) {
			this.height = height;
			this.balanced = balanced;			
		}
	}
}
