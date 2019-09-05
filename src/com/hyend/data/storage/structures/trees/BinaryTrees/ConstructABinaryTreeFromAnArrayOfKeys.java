package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Building a Binary Tree in level order fashion 
 * from an array or list of keys.
 * 							A
 * 				B							C	
 * 		D				E			F				G
 * 	H		I		J		K	L		M		N		O
 * 
 * Variant: Build a minimum height BT from an array/list of values.
 * 
 * @author gopi_karmakar
 */
public class ConstructABinaryTreeFromAnArrayOfKeys {

	public static void main(String[] args) {		
		
		Node<Integer> tree = BinaryTree.buildDefault(); 
		
		BinaryTree.printBFS(tree, true);
	} 
}
