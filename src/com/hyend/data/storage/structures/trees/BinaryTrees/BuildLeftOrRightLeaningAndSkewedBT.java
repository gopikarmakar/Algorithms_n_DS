package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * Building a left or right leaning and skewed binary trees
 * for testing different cases. 
 * 
 * @author gopi_karmakar
 *
 */
public class BuildLeftOrRightLeaningAndSkewedBT {

	public static void main(String[] args) {
		BinaryTree.Node<Integer> root = build(BinaryTree.RIGHT_SKEWED);
		//BinaryTree.printBFS(root);
		BinaryTree.printInOrderRecursive(root, false);
		//BinaryTree.printPreOrderRecursive(root);		
		//BinaryTree.printPostOrderRecursive(root);
	}
	
	public static BinaryTree.Node<Integer> build(int type, int...keys) {
		if(keys == null || keys.length == 0) {
			keys = new int[9];
			for(int i = 0; i < 9; i++)
				keys[i] = i+1;
		}
		
		BinaryTree.Node<Integer> root = null;
		switch(type) {
			case BinaryTree.LEFT_SKEWED:
				root = buildLeftSkewed(root, keys, 0);
				return root;
			case BinaryTree.RIGHT_SKEWED:
				root = buildRightSkewed(root, keys, 0);
				return root;
			case BinaryTree.LEFT_LEANING:
				for(int key : keys)
					root = buildLeftLeaning(root, key);				
				return root;
			case BinaryTree.RIGHT_LEANING:
				for(int key : keys)
					root = buildRightLeaning(root, key);
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
	private static BinaryTree.Node<Integer> buildLeftLeaning(BinaryTree.Node<Integer> node, int key) {
		if(node == null) {
			node = new BinaryTree.Node<Integer>(key);			
		}
		else {	
			if(node.right == null) {
				node.right = buildLeftLeaning(node.right, key);
			}
			else {
				node.left = buildLeftLeaning(node.left, key);
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
	private static BinaryTree.Node<Integer> buildRightLeaning(BinaryTree.Node<Integer> node, int key) {
		if(node == null) {
			node = new BinaryTree.Node<Integer>(key);			
		}
		else {	
			if(node.left == null) {
				node.left = buildLeftLeaning(node.left, key);
			}
			else {
				node.right = buildLeftLeaning(node.right, key);
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
	private static BinaryTree.Node<Integer> buildLeftSkewed(BinaryTree.Node<Integer> node, int[] keys, int i) {
		if(node == null) {
			node = new BinaryTree.Node<Integer>(keys[i]);			
		}
		
		if(i >= keys.length-1)
			return node;
			
		if(node.left == null) {
			node.left = buildLeftSkewed(node.left, keys, i+1);
		}
		else {
			node.right = buildLeftSkewed(node.right, keys, i+1);
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
	private static BinaryTree.Node<Integer> buildRightSkewed(BinaryTree.Node<Integer> node, int[] keys, int i) {
		
		if(node == null) {
			node = new BinaryTree.Node<Integer>(keys[i]);			
		}
		
		if(i >= keys.length-1)
			return node;
			
		if(node.right == null) {
			node.right = buildRightSkewed(node.right, keys, i+1);
		}
		else {
			node.left = buildRightSkewed(node.left, keys, i+1);
		}
		
		return node;
	}
}
