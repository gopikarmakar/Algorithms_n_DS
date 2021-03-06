package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Pre-Order traversal recursive
 * 
 * @author gopi_karmakar
 */
public class PreOrderTraversalRecursive {
	
	public static void main(String[] args) {		
		print(BinarySearchTree.createDefault());
	}
	
	/**
	 * O(h) time complexity
	 */
	public static void print(Node<?, ?> tree, boolean... withParent) {
		if(tree == null) //Base case
			return;
		
		BinarySearchTree.print(tree, withParent);
		
		print(tree.left, withParent);
		
		print(tree.right, withParent);
	}
}