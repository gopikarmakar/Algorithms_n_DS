package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * Building a Binary Tree in level order fashion 
 * from an array or list of keys.
 * 
 * @author gopi_karmakar
 */
public class BuildABinaryTreeFromAnArrayOfKeys {

	public static void main(String[] args) {		
		int size = 15;
		int[] keys = new int[size];
		for(int i = 0; i < size; i++)
			keys[i] = i+1;
		
		BinaryTree.printBFS(build(keys), false);
	}
	
	public static BinaryTree.Node<Integer> build(int...keys) {		
		return BuildABinaryTreeInLevelOrder.build(keys);
	} 
}
