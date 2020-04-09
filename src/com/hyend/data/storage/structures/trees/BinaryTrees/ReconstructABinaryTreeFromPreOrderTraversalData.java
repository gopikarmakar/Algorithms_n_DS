package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Reconstruct a binary tree from a preorder traversal with markers.
 * 
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 * 
 * @author gopi_karmakar
 */
public class ReconstructABinaryTreeFromPreOrderTraversalData {

	private static int subTreeIdx = 0;
	
	public static void main(String[] args) {
		
		String[] preOrderKeys = {"H", "B", "F", null, null, "E", "A", null, null, null, "C", null, "D", null, "G", "I", null, null, null};
		
		//String preOrder = "H-B-F---E-A----C--D--G-I";
		
		//String input = "1-2--3--4-5--6--7";
		
		//String[] preOrderKeys2 = preOrder.split("-");
		
		//String[] preOrderKeys3 = input.split("-");
		
		//Node<String> tree = construct(preOrderKeys3);
		
		Node<String> tree = construct(preOrderKeys);
		
		/*System.out.println(tree.left);
		System.out.println(tree.right);
		System.out.println(tree.left.left);
		System.out.println(tree.left.right);
		System.out.println(tree.left.right.left);
		System.out.println(tree.left.right.right);*/
		
		System.out.println("PreOrder");
		BinaryTree.printPreOrderRecursive(tree, false);
		
		System.out.println("Level Order");
		//BinaryTree.printInOrderRecursive(tree, false);
		BinaryTree.printBFS(tree, false);
	}
	
	public static Node<String> construct(String...keys) {
		
		if(subTreeIdx >= keys.length)
			return null;
		
		String key = keys[subTreeIdx];
		++subTreeIdx;
		
		if(key == null || key.length() == 0) return null;
		
		Node<String> leftSubTree = construct(keys);
		Node<String> rightSubTree = construct(keys);
		 
		return new Node<>(key, leftSubTree, rightSubTree);
	}	
}
