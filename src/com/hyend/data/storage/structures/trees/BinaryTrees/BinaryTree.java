package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.Queue;

import javax.swing.text.AbstractDocument.LeafElement;

import java.util.LinkedList;

/**
 * A Binary Tree structure is each node holds two children 
 * left and right child that's why it's called binary tree.
 * A complete family with parent and child called subtree.
 * 
 * 								1
 * 				2								3
 * 		4				5 				6	 			7
 * 	8   	9 		10		11  	12		13 		14		15
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
	
	private static final int DEFAULT_TREE_SIZE = 15;

	/**
	 * A single Binary Tree node.
	 * 
	 * @author gopi_karmakar
	 *
	 * @param <Key>
	 */
	public static class Node<Key> {		
		Key key;
		int size;
		int weight;
		Node<Key> left;
		Node<Key> right;
		Node<Key> parent;
		public Node(Key key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}		
		
		public Node(Key key, Node<Key> left, Node<Key> right) {
			this.key = key;
			this.left = left;
			this.right = right;
		}
	}
	
	public static Node<?> createDefault(int order, Object...keys) {
		if(keys == null || keys.length == 0) {
			keys = new Integer[DEFAULT_TREE_SIZE];
			for(int i = 0; i < DEFAULT_TREE_SIZE; i++)
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
			case BinaryTree.WEIGHT_BALANCED:
				if(keys instanceof Integer[])
					tree = BuildALeftOrRightWeightedBinaryTree.build(keys);
				break;
		}
		return tree;
	}
	
	/** 
	 * Creating only Integer valued Binary Trees.
	 * Just for the varieties of Binary Tree creation
	 * 
	 * @param type
	 * @param keys
	 * @return
	 */
	public static Node<Integer> build(int type, int...keys) {
		Node<Integer> root = null;
		root = BuildLeftOrRightLeaningAndSkewedBT.build(type, keys);		
		return root;
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
