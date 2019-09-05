package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * Building a minimum height binary tree from an array of values.
 * It's a variant of Build A Binary Tree in Level Order. 
 * 
 * @author gopi_karmakar
 */
public class BuildAMinimumHeightBTFromListOfValues {

	public static void main(String[] args) {
		
		Node<Integer> tree = BinaryTree.buildDefault(); 
		
		BinaryTree.printBFS(tree, true);
	}
}
