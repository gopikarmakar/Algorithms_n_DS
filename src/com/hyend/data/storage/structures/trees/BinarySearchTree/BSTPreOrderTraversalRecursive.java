package com.hyend.data.storage.structures.trees.BinarySearchTree;

import com.hyend.data.storage.structures.trees.BinarySearchTree.BinarySearchTree.Node;

public class BSTPreOrderTraversalRecursive {
	
	public static void main(String[] args) {		
		print(BinarySearchTree.create(BinarySearchTree.ITERATIVE), true);
	}
	
	public static void print(Node<?, ?> tree, boolean withParent) {
		if(tree == null) //Base case
			return;
		
		System.out.println("Key = " + tree.key + "\tValue = " + tree.value + ((withParent == true) ? 
				((tree.parent!= null) ? "\tParent = " + tree.parent.key : "\tIt's Root") : ""));
		
		print(tree.left, withParent);
		print(tree.right, withParent);
	}

}
