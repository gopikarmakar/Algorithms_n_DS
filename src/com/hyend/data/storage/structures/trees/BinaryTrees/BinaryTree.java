package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.Queue;
import java.util.LinkedList;

/**
 * A Binary Tree structure is each node holds two children 
 * left and right child that's why it's called binary tree.
 * A complete family with parent and child called subtree.
 * 
 * 								341
 * 				6								6
 * 		271				561 			2	 			271
 * 	28   	0 				3  				 1 				28
 * 						17				401     257
 * 										   641
 * 
 * @author gopi_karmakar
 */
public class BinaryTree {
	
	public static final int LEVEL_ORDER 		= 1;
	public static final int LEFT_SKEWED 		= 2;
	public static final int RIGHT_SKEWED 		= 3;
	public static final int LEFT_LEANING 		= 4;	
	public static final int RIGHT_LEANING 		= 5;
	public static final int WEIGHT_BALANCED 	= 6;
	
	public static final int DEFAULT_TREE_SIZE 	= 15;
	
	public static Node<Integer> buildDefault() {
		
		return BuildABinaryTreeInLevelOrder.buildDefault();
	}
	
	public static Node<?> build(int order, Object...keys) {
		
		if(keys == null || keys.length == 0) {
			keys = new Integer[9];
			for(int i = 0; i < BinaryTree.DEFAULT_TREE_SIZE; i++)
				keys[i] = i+1;
		}
		
		Node<?> tree = null;
		switch (order) {
			case BinaryTree.LEVEL_ORDER:
				if(keys instanceof Integer[]) {
					BuildABinaryTreeInLevelOrder<Integer> levelOrderBT = new BuildABinaryTreeInLevelOrder<>();
					tree = levelOrderBT.build((Integer[]) keys);
				}
				else if(keys instanceof String[]) {
					BuildABinaryTreeInLevelOrder<String> levelOrderBT = new BuildABinaryTreeInLevelOrder<>();
					tree = levelOrderBT.build((String[])keys);
				}				
				break;
				
			// Creating only Integer valued Binary Trees just for testing.
			case BinaryTree.WEIGHT_BALANCED:
				if(keys instanceof Integer[])
					tree = BuildALeftOrRightWeightedBinaryTree.build(keys);
				break;
				
			case BinaryTree.LEFT_SKEWED:
			case BinaryTree.LEFT_LEANING:
			case BinaryTree.RIGHT_SKEWED:			
			case BinaryTree.RIGHT_LEANING:
				if(keys instanceof Integer[])
					tree = BuildLeftOrRightLeaningOrSkewedBT.build(order, (Integer[])keys);
				break;
		}
		return tree;
	}
	
	/**
	 * It's been called level order too.
	 * @param tree
	 */
	public static void printBFS(Node<?> tree, boolean withParent) {		
		Queue<Node<?>> queue = new LinkedList<>();
		queue.add(tree);		
		while(!queue.isEmpty()) {			
			Node<?> node = queue.poll();			
			if(node != null)
				System.out.println(node.key + ((withParent == true) ? 
					((node.parent!= null) ? "\tParent = " + node.parent.key : "\tIt's Root") : ""));
			
			if(node.left != null) queue.add(node.left);			
			if(node.right != null) queue.add(node.right);
		}
	}
	
	public static void printInOrderRecursive(Node<?> tree, boolean withParent) {
		if(tree == null) //Base case
			return;
		
		printInOrderRecursive(tree.left, withParent);		
		System.out.println(tree.key + ((withParent == true) ? 
				((tree.parent!= null) ? "\tParent = " + tree.parent.key : "\tIt's Root") : ""));		
		printInOrderRecursive(tree.right, withParent);
	}	
	
	public static void printPreOrderRecursive(Node<?> tree, boolean withParent) {
		if(tree == null) //Base case
			return;
		
		System.out.println(tree.key + ((withParent == true) ? 
				((tree.parent!= null) ? "\tParent = " + tree.parent.key : "\tIt's Root") : ""));
		printPreOrderRecursive(tree.left, withParent);
		printPreOrderRecursive(tree.right, withParent);
	}
	
	public static void printPostOrderRecursive(Node<?> tree, boolean withParent) {
		if(tree == null) //Base case
			return;
				
		printPostOrderRecursive(tree.left, withParent);
		printPostOrderRecursive(tree.right, withParent);
		System.out.println(tree.key + ((withParent == true) ? 
				((tree.parent!= null) ? "\tParent = " + tree.parent.key : "\tIt's Root") : ""));
	}
}
