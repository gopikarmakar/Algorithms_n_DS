package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import com.hyend.data.storage.structures.trees.BinarySearchTrees.BinarySearchTree.Node;

public class IndorderTraversalRecursive {
	
	public static void main(String[] args) {		
		print(BinarySearchTree.createDefault(), true);
	}
	
	public static void print(Node<?, ?> tree, boolean withParent) {
		if(tree == null) //Base case
			return;
		
		print(tree.left, withParent);		
		System.out.println("Key = " + tree.key + " Value = " + tree.value + ((withParent == true) ? 
				((tree.parent!= null) ? "\tParent = " + tree.parent.key : "\tIt's Root") : ""));				
		print(tree.right, withParent);
	}
}
