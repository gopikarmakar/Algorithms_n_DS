package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * TODO: Yet to be fixed.
 * 
 * @author gopi_karmakar
 */
public class FindKthNode {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	
		Node<Integer> tree = (Node<Integer>) BinaryTree.create(BinaryTree.LEVEL_ORDER);		
		System.out.println(compuetKTh(tree, 2).key);
	}

	private static Node<Integer> compuetKTh(Node<Integer> tree, int k) {
		
		Node<Integer> node = tree;
		
		while(node != null) {
			int leftSize = (node.left != null) ? node.left.size : 0;
			if(k > leftSize + 1) {		// The Kth node must be in the right subtree.
				k -= leftSize + 1;
				node = node.right;
			}
			else if(leftSize == k-1)	// Node = Kth
				return node;
			else						// Kth must be in left subtree. 
				node = node.left;
		}	
		return null;
	}
}