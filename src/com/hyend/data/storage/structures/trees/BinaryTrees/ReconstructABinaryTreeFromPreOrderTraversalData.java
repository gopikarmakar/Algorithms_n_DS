package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * 
 * @author gopi_karmakar
 */
public class ReconstructABinaryTreeFromPreOrderTraversalData {

	private static int subTreeIdx = 0;
	
	public static void main(String[] args) {
		
		String[] preOrderKeys = {"H", "B", "F", null, null, "E", "A", null, null, null, "C", null, "D", null, "G", "I", null, null, null};
		BinaryTree.printPreOrderRecursive(construct(preOrderKeys), false);
	}
	
	public static Node<String> construct(String...keys) {
		
		String key = keys[subTreeIdx];
		++subTreeIdx;
		
		if(key == null) return null;
		
		Node<String> leftSubTree = construct(keys);
		Node<String> rightSubTree = construct(keys);
		 
		return new Node<>(key, leftSubTree, rightSubTree);
	}	
}
