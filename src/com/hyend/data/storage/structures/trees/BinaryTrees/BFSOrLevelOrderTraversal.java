package com.hyend.data.storage.structures.trees.BinaryTrees;

public class BFSOrLevelOrderTraversal {

	public static void main(String[] args) {
		
		Node<Integer> tree = BinaryTree.buildDefault();
		
		System.out.println("\nLevelOrder:");
		
		BinaryTree.printBFS(tree, false);
		
		System.out.println("\nPreOrder:");
		
		BinaryTree.printPreOrderRecursive(tree, true);
		
		System.out.println("\nPostOrder:");
		
		BinaryTree.printPostOrderRecursive(tree, true);
	}
}
