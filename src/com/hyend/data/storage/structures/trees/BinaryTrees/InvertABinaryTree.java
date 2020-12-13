package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 * @author gopi_karmakar
 */
public class InvertABinaryTree {

	public static void main(String[] args) {
		
		Node<Integer> tree = BinaryTree.buildDefault();
		BinaryTree.printBFS(tree);
		
		System.out.println("\nInverted Tree :\n");
		BinaryTree.printBFS(invert(tree));
	}
	
	/**
	 * Accepted in Leetcode with 0ms 100% runtime.
	 */
	private static Node<Integer> invert(Node<Integer> node) {
		
		if(node == null)
			return null;
		
		Node<Integer> temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		invert(node.left);
		invert(node.right);
		
		return node;
	}
}
