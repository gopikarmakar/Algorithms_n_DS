package com.hyend.data.storage.structures.trees.BinaryTrees;

public class BFSOrLevelOrderTraversal {

	public static void main(String[] args) {
		
		Node<Integer> tree = BinaryTree.buildDefault();
		
		BinaryTree.printBFS(tree, true);
	}
}
