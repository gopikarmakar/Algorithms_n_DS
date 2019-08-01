package com.hyend.data.storage.structures.trees.BinarySearchTree;

import com.hyend.data.storage.structures.trees.BinarySearchTree.BinarySearchTree.Node;

/**
 * 
 * @author gopi_karmakar
 */
public class BSTPostOrderTraversalRecursive {
	
	public static void main(String[] args) {
		
		print(BinarySearchTree.create(BinarySearchTree.ITERATIVE), true);
	}
	
	public static void print(Node<?, ?> tree, boolean withParent) {
		if(tree == null) //Base case
			return;
		
		print(tree.left, withParent);
		print(tree.right, withParent);
		
		System.out.println("Key = " + tree.key + "Value = " + tree.value + ((withParent == true) ? 
				((tree.parent!= null) ? "\tParent = " + tree.parent.key : "\tIt's Root") : ""));
	}

}
