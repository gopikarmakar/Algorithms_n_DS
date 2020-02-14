package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Post Order Traversal Recursive
 * 
 * @author gopi_karmakar
 */
public class PostOrderTraversalRecursive {
	
	public static void main(String[] args) {
		
		print(BinarySearchTree.createDefault());
	}
	
	/**
	 * O(h) time complexity
	 */
	public static void print(Node<?, ?> tree, boolean... withParent) {
		if(tree == null) //Base case
			return;
		
		print(tree.left, withParent);
		
		print(tree.right, withParent);
		
		BinarySearchTree.print(tree, withParent);
	}

}
