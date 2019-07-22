package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * Building a Binary Tree from an array or list  
 * of keys in level order fashion
 * 
 * @author gopi_karmakar
 *
 */
public class BuildABinaryTreeFromAnArrayOfKeys {

	public static void main(String[] args) {
		int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};	
		BinaryTree.printBFS(build(keys));
	}
	
	public static BinaryTree.Node<Integer> build(int...keys) {				
		return BuildABinaryTreeInLevelOrder.build(keys);
	} 
}
