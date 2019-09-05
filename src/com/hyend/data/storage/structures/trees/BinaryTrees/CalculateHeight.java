package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

public class CalculateHeight {
	
	public static void main(String[] args) {		
		
		Node<Integer> root = BinaryTree.buildDefault();
		BinaryTree.printBFS(root, false);
		System.out.println("Height Of The Binary Tree = " + calculateHeight(root));		
	}
	
	/**
	 * An O(n) time complexity PostOrder traversal   
	 * algorithm to calculate the height of a Binary Tree.
	 * 
	 * @param node
	 * @return
	 */
	private static int calculateHeight(Node<Integer> node) {		
		if(node == null)
			return 0;
		
		int LSTH = calculateHeight(node.left);
		int RSTH = calculateHeight(node.right);
		int height = 1 + Math.max(LSTH, RSTH);
		return height;
	}
}
