package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Building a left or right leaning and skewed binary trees
 * for testing different cases. 
 * 
 * @author gopi_karmakar
 */
public class BuildLeftOrRightLeaningOrSkewedBT<K> {

	public static void main(String[] args) {
		
		Integer[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Node<Integer> root = build(BinaryTree.LEFT_SKEWED, keys);
		BinaryTree.printBFS(root, true);
		
		//BinaryTree.printInOrderRecursive(root, true);
		//BinaryTree.printPreOrderRecursive(root, true);		
		//BinaryTree.printPostOrderRecursive(root, true);
	}
	
	public static <K> Node<K> build(int order, K[] keys) {
		
		BuildLeftOrRightLeaningOrSkewedBT<K> tree = new BuildLeftOrRightLeaningOrSkewedBT<>(); 
		
		Node<K> root = null;
		
		switch(order) {
			case BinaryTree.LEFT_SKEWED:
				root = tree.buildLeftSkewed(null, root, keys, 0);
				break;
			case BinaryTree.RIGHT_SKEWED:
				root = tree.buildRightSkewed(null, root, keys, 0);
				break;
			case BinaryTree.LEFT_LEANING:				
				root = tree.buildLeftLeaning(null, root, keys, 0);				
				break;
			case BinaryTree.RIGHT_LEANING:				
				root = tree.buildRightLeaning(null, root, keys, 0);
				break;
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
	 */
	private Node<K> buildLeftLeaning(Node<K> parent, Node<K> node, K[] keys, int i) {
		
		if(node == null) {
			node = new Node<K>(keys[i]);
			node.parent = parent;
		}
		else {	
			if(node.right == null) {
				node.right = buildLeftLeaning(node, node.right, keys, i+1);
			}
			else {
				node.left = buildLeftLeaning(node, node.left, keys, i+1);
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
	 */
	private Node<K> buildRightLeaning(Node<K> parent, Node<K> node, K[] keys, int i) {
		
		if(node == null) {
			node = new Node<K>(keys[i]);
			node.parent = parent;
		}
		else {
			if(node.left == null) {
				node.left = buildRightLeaning(node, node.left, keys, i+1);
			}
			else {
				node.right = buildRightLeaning(node, node.right, keys, i+1);
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
	 */
	private Node<K> buildLeftSkewed(Node<K> parent, Node<K> node, K[] keys, int i) {
		
		if(node == null) {
			node = new Node<K>(keys[i]);
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
	 */
	private Node<K> buildRightSkewed(Node<K> parent, Node<K> node, 
			K[] keys, int i) {
		
		if(node == null) {
			node = new Node<K>(keys[i]);
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
