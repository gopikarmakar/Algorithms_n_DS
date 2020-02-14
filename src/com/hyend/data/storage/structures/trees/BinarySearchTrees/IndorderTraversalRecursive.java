package com.hyend.data.storage.structures.trees.BinarySearchTrees;

public class IndorderTraversalRecursive {
	
	public static void main(String[] args) {		
		print(BinarySearchTree.createDefault());
	}
	
	public static void print(Node<?, ?> tree, boolean... withParent) {
		if(tree == null) //Base case
			return;
		
		print(tree.left, withParent);		

		BinarySearchTree.print(tree, withParent);
		
		print(tree.right, withParent);
	}
}
