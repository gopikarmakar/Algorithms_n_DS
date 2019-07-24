package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A Binary Tree structure is each node holds two children 
 * left and right child that's why it's called binary tree.
 * A complete family with parent and child called subtree.
 * 
 * 					1
 * 			2				3
 * 		4		5		6		7
 * 	8
 * 
 * BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(1);
 * root.left = new BinaryTree.Node<Integer>(2);
 * root.right = new BinaryTree.Node<Integer>(3);
 * root.left.left = new BinaryTree.Node<Integer>(4);
 * root.left.right = new BinaryTree.Node<Integer>(5);
 * root.right.left = new BinaryTree.Node<Integer>(6);
 * root.right.right = new BinaryTree.Node<Integer>(7);
 * root.left.left.left = new BinaryTree.Node<Integer>(8);
 * return root;
 * 
 * @author gopi_karmakar
 *
 */
public class BinaryTree {
	
	public static final int LEVEL_ORDER 		= 1;
	public static final int LEFT_SKEWED 		= 2;
	public static final int RIGHT_SKEWED 		= 3;
	public static final int LEFT_LEANING 		= 4;	
	public static final int RIGHT_LEANING 		= 5;
	public static final int WEIGHT_BALANCED 	= 6;

	/**
	 * A single Binary Tree node.
	 * 
	 * @author gopi_karmakar
	 *
	 * @param <Key>
	 */
	public static class Node<Key> {		
		Key key;
		int weight;
		Node<Key> left;
		Node<Key> right;
		Node<Key> parent;
		public Node(Key key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}		
	}
	
	public static Node<Integer> create(int type, int...keys) {
		Node<Integer> root = null;		
		switch (type) {
			case LEVEL_ORDER:
				root = BuildABinaryTreeInLevelOrder.build(keys);
				break;
			case LEFT_LEANING:
				root = BuildLeftOrRightLeaningAndSkewedBT.build(type, keys);
				break;
			case RIGHT_LEANING:
				root = BuildLeftOrRightLeaningAndSkewedBT.build(type, keys);
				break;
			case LEFT_SKEWED:
				root = BuildLeftOrRightLeaningAndSkewedBT.build(type, keys);
				break;
			case RIGHT_SKEWED:
				root = BuildLeftOrRightLeaningAndSkewedBT.build(type, keys);
				break;
			case WEIGHT_BALANCED:
				root = BuildAWeightBalancedBinaryTree.build(keys);
				break;
		}
		return root;
	}
	
	/**
	 * It's been called level order too.
	 * @param root
	 */
	public static void printBFS(Node<?> root, boolean withParent) {		
		Queue<Node<?>> queue = new LinkedList<>();
		queue.add(root);		
		while(!queue.isEmpty()) {			
			Node<?> node = queue.poll();			
			if(node != null)
				System.out.println(node.key + ((withParent == true) ? 
					((node.parent!= null) ? "\tParent = " + node.parent.key : "\tIt's Root") : ""));
			
			if(node.left != null) queue.add(node.left);			
			if(node.right != null) queue.add(node.right);
		}
	}
	
	public static void printInOrderRecursive(Node<?> node, boolean withParent) {
		if(node == null) //Base case
			return;
		
		printInOrderRecursive(node.left, withParent);		
		System.out.println(node.key + ((withParent == true) ? 
				((node.parent!= null) ? "\tParent = " + node.parent.key : "\tIt's Root") : ""));		
		printInOrderRecursive(node.right, withParent);
	}	
	
	public static void printPreOrderRecursive(Node<?> node, boolean withParent) {
		if(node == null) //Base case
			return;
		
		System.out.println(node.key + ((withParent == true) ? 
				((node.parent!= null) ? "\tParent = " + node.parent.key : "\tIt's Root") : ""));
		printPreOrderRecursive(node.left, withParent);
		printPreOrderRecursive(node.right, withParent);
	}
	
	public static void printPostOrderRecursive(Node<?> node, boolean withParent) {
		if(node == null) //Base case
			return;
				
		printPostOrderRecursive(node.left, withParent);
		printPostOrderRecursive(node.right, withParent);
		System.out.println(node.key + ((withParent == true) ? 
				((node.parent!= null) ? "\tParent = " + node.parent.key : "\tIt's Root") : ""));
	}
}
