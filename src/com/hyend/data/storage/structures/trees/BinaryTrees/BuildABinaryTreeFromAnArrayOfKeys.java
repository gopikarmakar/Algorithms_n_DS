package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * Building a Binary Tree in level order fashion 
 * from an array or list of keys.
 * 
 * @author gopi_karmakar
 */
public class BuildABinaryTreeFromAnArrayOfKeys {

	public static void main(String[] args) {
		//int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		BinaryTree.printBFS(build(), false);
	}
	
	public static BinaryTree.Node<Integer> build(int...keys) {
		if(keys == null || keys.length == 0) {
			keys = new int[15];
			for(int i = 0; i < 15; i++)
				keys[i] = i+1;
		}
		return BuildABinaryTreeInLevelOrder.build(15, keys);
	} 
}
