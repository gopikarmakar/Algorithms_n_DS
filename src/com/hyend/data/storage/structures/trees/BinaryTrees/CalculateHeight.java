package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Calculate the height of a given binary tree
 * 
 * @author gopi_karmakar
 */
public class CalculateHeight {
	
	public static void main(String[] args) {		
		
		Node<Integer> root = BinaryTree.buildDefault();
		BinaryTree.printBFS(root, false);
		System.out.println("Height Of The Binary Tree = " + compute(root));		
	}
	
	/**
	 * An O(h) time complexity PostOrder traversal   
	 * algorithm to calculate the height of a Binary Tree.	 
	 */
	private static int compute(Node<Integer> node) {		
		if(node == null)
			return 0;
		
		int LSTH = compute(node.left);
		
		int RSTH = compute(node.right);
		
		return (1 + Math.max(LSTH, RSTH));
		
		//return height;
	}
}
