package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

public class ConstructABinaryTreeFromPreOrderTraversalData {

	private static int subTreeIdx = 0;
	
	public static void main(String[] args) {
		
		String[] preOrderKeys = {"H", "B", "F", null, null, "E", "A", null, null, null, "C", null, "D", null, "G", "I", null, null, null};
		BinaryTree.printPreOrderRecursive(construct((Object[]) preOrderKeys), false);
	}
	
	@SuppressWarnings("unchecked")
	public static Node<?> construct(Object...keys) {
		
		Object key = keys[subTreeIdx];
		++subTreeIdx;
		
		if(key == null) return null;		
		
		Node<?> leftSubTree = (Node<Object>) construct(keys);
		Node<?> rightSubTree = (Node<Object>) construct(keys);
		
		return new Node<Object>(key, (Node<Object>) leftSubTree, (Node<Object>) rightSubTree);
	}	
}
