package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.Queue;

import javax.naming.spi.DirStateFactory.Result;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A Binary Tree structure is each node holds two children 
 * left and right child that's why it's called binary tree.
 * A complete family with parent and child called subtree.
 * 
 * 								314
 * 				6								6
 * 		271				561 			2	 			271
 * 	28   	0 				3  				 1 				28
 * 						17				401     257
 * 										   641
 * 
 * @author gopi_karmakar
 */
public class BinaryTree {
		
	public static final int LEFT_SKEWED 		= 1;
	public static final int RIGHT_SKEWED 		= 2;
	public static final int LEFT_LEANING 		= 3;	
	public static final int RIGHT_LEANING 		= 4;
	public static final int SHORT_HEIGHTED 		= 5;
	public static final int WEIGHT_BALANCED 	= 6;	
	
	public static final int DEFAULT_TREE_SIZE 	= 15;
	
	public static Node<Integer> buildDefault() {
				
		return BuildABinaryTreeInLevelOrder.buildDefault();
	}
	
	public static <K> Node<K> build(int type, K[] keys) {
		
		Node<K> tree = null;
		switch (type) {
		
			case BinaryTree.SHORT_HEIGHTED: 
				
				BuildABinaryTreeInLevelOrder<K> levelOrderBT = new BuildABinaryTreeInLevelOrder<>();
				tree = levelOrderBT.build(keys);							
			
			break;
			case BinaryTree.WEIGHT_BALANCED:				
				
				BuildALeftOrRightWeightedBinaryTree<K> weighted = new BuildALeftOrRightWeightedBinaryTree<>();				
				tree = weighted.build(keys);
				
			break;				
			case BinaryTree.LEFT_SKEWED:
			case BinaryTree.LEFT_LEANING:
			case BinaryTree.RIGHT_SKEWED:
			case BinaryTree.RIGHT_LEANING:
			
				tree = BuildLeftOrRightLeaningOrSkewedBT.build(type, keys);
				
			break;
		}
		return tree;
	}
	
	/**
	 * It's been called level order too.
	 */
	public static void printBFS(Node<?> tree, boolean... withParent) {		
		
		Queue<Node<?>> queue = new LinkedList<>();
		List<List<Node<?>>> nodes = new ArrayList<>();
		
		queue.add(tree);		
		
		while(!queue.isEmpty()) {	
			
			int size = queue.size();
			List<Node<?>> list = new ArrayList<>();
			
			for(int i = 0; i < size; ++i) {
				
				Node<?> e = queue.poll();
				
				if(e != null) {
					
					list.add(e);
					
					if(e.left != null) queue.add(e.left);
					if(e.right != null) queue.add(e.right);
				}
			}
			nodes.add(list);						
		}
		
		nodes.forEach(l -> {
		
			l.forEach(e -> {
				
				System.out.print("[" +e.key + 
					((withParent.length > 0 && withParent[0]) ? ((e.parent!= null) ? 
					"\tParent = " + e.parent.key : "\tIt's Root") : "") + "] ");
			});
			System.out.println();
		});
	}
	
	public static void printInOrderRecursive(Node<?> tree, boolean... withParent) {
		if(tree == null) //Base case
			return;
		
		printInOrderRecursive(tree.left, withParent);		
		
		print(tree, withParent);		
		
		printInOrderRecursive(tree.right, withParent);
	}	
	
	public static void printPreOrderRecursive(Node<?> tree, boolean... withParent) {
		if(tree == null) //Base case
			return;
		
		print(tree, withParent);
		
		printPreOrderRecursive(tree.left, withParent);
		printPreOrderRecursive(tree.right, withParent);
	}
	
	public static void printPreOrderIterative(Node<?> tree, boolean... withParent) {
		
		if(tree == null) //Base case
			return;
		
		System.out.println(PreOrderTraversalIterative.traversePreOrder(tree));
	}
	
	public static void printPostOrderRecursive(Node<?> tree, boolean... withParent) {
		if(tree == null) //Base case
			return;
				
		printPostOrderRecursive(tree.left, withParent);
		printPostOrderRecursive(tree.right, withParent);
		
		print(tree, withParent);
	}
	
	public static void print(Node<?> node, boolean... withParent) {
		
		System.out.println(node.toString() + 
			((withParent.length > 0 && withParent[0]) ? ((node.parent!= null) ? 
			"\tParent = " + node.parent.key : "\tIt's Root") : ""));
	}
}
