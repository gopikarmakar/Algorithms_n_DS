package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Calculate the diameter of the Binary Tree.
 * 
 * @author gopi_karmakar
 */
public class DiameterOfABinaryTree {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
			
		//Node<Integer> tree = BinaryTree.build(BinaryTree.RIGHT_LEANING);
		Node<Integer> tree = (Node<Integer>) BinaryTree.createDefault(BinaryTree.LEVEL_ORDER);
		BinaryTree.printBFS(tree, true);
		System.out.println("Diameter = " + diameter(tree, new Height()));
	}
	
	private static class Height {
		int height;
	}
	
	/**
	 * An O(n) time complexity solution
	 * 
	 * @param node
	 * @param height
	 * @return
	 */
	private static int diameter(Node<Integer> node, Height height) {
		
		if(node == null) return 0;
				
		Height lh = new Height();
		Height rh = new Height();
		int lDia = diameter(node.left, lh);
		int rDia = diameter(node.right, rh);
		
		height.height = Math.max(lh.height, rh.height) + 1;
		return Math.max(Math.max(lDia, rDia), ((lh.height + rh.height) + 1)); 
	}
}
