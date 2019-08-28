package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Building a left or right leaning and skewed binary trees
 * for testing different cases. 
 * 
 * @author gopi_karmakar
 *
 */
public class BuildLeftOrRightLeaningAndSkewedBT {

	public static void main(String[] args) {
		Node<Integer> root = build(BinaryTree.LEFT_SKEWED);
		BinaryTree.printBFS(root, true);
		//BinaryTree.printInOrderRecursive(root, true);
		//BinaryTree.printPreOrderRecursive(root, true);		
		//BinaryTree.printPostOrderRecursive(root, true);
	}
	
	public static Node<Integer> build(int type, int...keys) {
		if(keys == null || keys.length == 0) {
			keys = new int[9];
			for(int i = 0; i < 9; i++)
				keys[i] = i+1;
		}
		
		Node<Integer> root = null;
		switch(type) {
			case BinaryTree.LEFT_SKEWED:
				root = buildLeftSkewed(null, root, keys, 0);
				return root;
			case BinaryTree.RIGHT_SKEWED:
				root = buildRightSkewed(null, root, keys, 0);
				return root;
			case BinaryTree.LEFT_LEANING:
				for(int key : keys)
					root = buildLeftLeaning(null, root, key);				
				return root;
			case BinaryTree.RIGHT_LEANING:
				for(int key : keys)
					root = buildRightLeaning(null, root, key);
				return root;				
		}
		return root;
	}
	
	
	/**
	 * A left leaning binary tree
	 * 						1
	 * 				3				2
	 * 			5		4
	 * 		7		6
	 * 	9		8		
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private static Node<Integer> buildLeftLeaning(Node<Integer> parent, 
			Node<Integer> node, int key) {
		if(node == null) {
			node = new Node<Integer>(key);
			node.parent = parent;
		}
		else {	
			if(node.right == null) {
				node.right = buildLeftLeaning(node, node.right, key);
			}
			else {
				node.left = buildLeftLeaning(node, node.left, key);
			}
		}		
		return node;
	}
	
	/**
	 * A right leaning binary tree
	 * 			1
	 * 	2				3
	 * 				4		5
	 *					6		7
	 * 						8		9
	 * 		
	 * @param node
	 * @param key
	 * @return
	 */
	private static Node<Integer> buildRightLeaning(Node<Integer> parent,
			Node<Integer> node, int key) {
		if(node == null) {
			node = new Node<Integer>(key);
			node.parent = parent;
		}
		else {
			if(node.left == null) {
				node.left = buildRightLeaning(node, node.left, key);
			}
			else {
				node.right = buildRightLeaning(node, node.right, key);
			}
		}		
		return node;
	}
	
	/**
	 * A completely left skewed binary tree
	 * 
	 * 						1
	 * 					2		null
	 * 				3		null
	 * 			4		null
	 * 		5		null
	 * null		null
	 * 
	 * @param node
	 * @param keys
	 * @param i
	 * @return
	 */
	private static Node<Integer> buildLeftSkewed(Node<Integer> parent, Node<Integer> node, 
			int[] keys, int i) {
		if(node == null) {
			node = new BinaryTree.Node<Integer>(keys[i]);
			node.parent = parent;
		}
		
		if(i >= keys.length-1)
			return node;
			
		if(node.left == null) {
			node.left = buildLeftSkewed(node, node.left, keys, i+1);
		}
		else {
			node.right = buildLeftSkewed(node, node.right, keys, i+1);
		}			
		
		return node;
	}
	
	/**
	 * A completely right skewed binary tree
	 * 
	 * 				1
	 * 		null		2
	 * 			null		3
	 * 				null		4
	 * 					null		5
	 * 						null		null	
	 * 
	 * @param node
	 * @param keys
	 * @param i
	 * @return
	 */
	private static Node<Integer> buildRightSkewed(Node<Integer> parent, Node<Integer> node, 
			int[] keys, int i) {
		
		if(node == null) {
			node = new Node<Integer>(keys[i]);
			node.parent = parent;
		}
		
		if(i >= keys.length-1)
			return node;
			
		if(node.right == null) {
			node.right = buildRightSkewed(node, node.right, keys, i+1);
		}
		else {
			node.left = buildRightSkewed(node, node.left, keys, i+1);
		}
		
		return node;
	}
}
