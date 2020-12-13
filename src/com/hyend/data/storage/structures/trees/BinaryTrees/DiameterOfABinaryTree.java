package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * Calculate the diameter of the Binary Tree.
 * 
 * @author gopi_karmakar
 */
public class DiameterOfABinaryTree {

	private static int diameter = 0;
	
	public static void main(String[] args) {
			
		//Node<Integer> tree = BinaryTree.build(BinaryTree.RIGHT_LEANING);
		Node<Integer> tree = BinaryTree.buildDefault();
		
		BinaryTree.printBFS(tree);
		
		diameter(tree);
		
		System.out.println("\nDiameter = " + diameter);
	}
	
	/**
	 * Get the length of right subtree and left subtree
	 * compare total height of both subtrees to diameter
	 * return max length left/right subtree to parent.
	 * 
	 * O(h) time complexity solution.
	 */	
	private static int diameter(Node<Integer> node) {
		
		if(node == null) return 0;
				
		int lh = diameter(node.left); 
		int rh = diameter(node.right);
		
		diameter = Math.max(diameter, (lh + rh));
		
		return 1 + Math.max(lh, rh);
	}
}
