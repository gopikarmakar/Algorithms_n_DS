package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree class
 * 
 * @author gopi_karmakar
 *
 */
public class BinaryTree {
	
	public static final int TYPE_LEVEL_ORDER_FASHION = 1;
	public static final int TYPE_LEFT_SKEWED_FASHION = 2;
	public static final int TYPE_RIGHT_SKEWED_FASHION = 3;
	public static final int TYPE_WEIGHT_BALANCED_FASHION = 4;

	/**
	 * A Binary Tree node
	 * @author gopi_karmakar
	 *
	 * @param <Key>
	 */
	public static class Node<Key> {		
		Key key;
		int weight;
		Node<Key> left;
		Node<Key> right;		
		public Node(Key key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}		
	}
	
	public static Node<Integer> create(int type) {
		Node<Integer> root = null;		
		switch (type) {
			case TYPE_LEVEL_ORDER_FASHION:
				root = BuildABinaryTreeInLevelOrder.build();
			case TYPE_WEIGHT_BALANCED_FASHION:
				root = BuildAWeightBalancedBinaryTree.build();
		}
		return root;
	}
	
	/**
	 * It's been called level order too.
	 * @param root
	 */
	public static void printBFS(Node<?> root) {		
		Queue<Node<?>> queue = new LinkedList<>();
		queue.add(root);		
		while(!queue.isEmpty()) {			
			Node<?> node = queue.poll();			
			if(node != null)
				System.out.println(node.key);
			
			if(node.left != null) queue.add(node.left);			
			if(node.right != null) queue.add(node.right);
		}
	}
	
	public static void printInOrderRecursive(Node<?> node) {
		if(node == null) //Base case
			return;
		
		printInOrderRecursive(node.left);
		System.out.println(node.key);
		printInOrderRecursive(node.right);
	}
	
	public static void printPreOrderRecursive(Node<?> node) {
		if(node == null) //Base case
			return;
		
		System.out.println(node.key);
		printPreOrderRecursive(node.left);
		printPreOrderRecursive(node.right);
	}
	
	public static void printPostOrderRecursive(Node<?> node) {
		if(node == null) //Base case
			return;
				
		printPostOrderRecursive(node.left);
		printPostOrderRecursive(node.right);
		System.out.println(node.key);
	}
}
