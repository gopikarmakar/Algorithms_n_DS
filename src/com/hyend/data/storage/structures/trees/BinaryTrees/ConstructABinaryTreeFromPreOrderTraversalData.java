package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * @author gopi_karmakar
 */
public class ConstructABinaryTreeFromPreOrderTraversalData {

	private static int subTreeIdx = 0;
	
	public static void main(String[] args) {
		
		String[] preOrderKeys = {"H", "B", "F", null, null, "E", "A", null, null, null, "C", null, "D", null, "G", "I", null, null, null};
		BinaryTree.printPreOrderRecursive(construct(null, preOrderKeys), true);
	}
	
	public static Node<String> construct(Node<String> parent, String...keys) {
		
		String key = keys[subTreeIdx];
		++subTreeIdx;
		
		if(key == null) return null;		
		
		Node<String> leftSubTree = construct(parent, keys);
		Node<String> rightSubTree = construct(parent, keys);
		 
		return new Node<>(key, leftSubTree, rightSubTree);
	}	
}
