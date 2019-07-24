package com.hyend.data.storage.structures.trees.BinaryTrees;

public class CalculateHeightOfABinaryTree {
	
	public static void main(String[] args) {
		BinaryTree.Node<Integer> root = BinaryTree.create(BinaryTree.LEVEL_ORDER);
		BinaryTree.printBFS(root, false);
		System.out.println("Height Of The Binary Tree = " + calculateHeight(root));		
	}
	
	/**
	 * A PostOrder traversal algorithm to Calculate 
	 * the height of a Binary Tree
	 * 
	 * @param node
	 * @return
	 */
	private static int calculateHeight(BinaryTree.Node<Integer> node) {		
		if(node == null)
			return 0;
		
		int LSTH = calculateHeight(node.left);
		int RSTH = calculateHeight(node.right);
		int height = 1 + Math.max(LSTH, RSTH);
		return height;
	}
}
