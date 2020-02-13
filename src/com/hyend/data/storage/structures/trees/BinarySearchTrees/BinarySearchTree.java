package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.LinkedList;

/**
 * A concrete balanced Binary Search Tree Implementation.
 *									11
 *   		  		6             						17
 *   		3        		9         			14    			20
 *		2    	5    	8  		10   		13  	16    	19		21
 *	1     	  4    	  7				  	 12    	  15	  18  	
 *								
 * @author gopi_karmakar
 */
public class BinarySearchTree {
	
	public static final int RECURSIVELY = 1;
	public static final int ITERATIVELY = 2;
	
	public static Node<Integer, ?> createDefault() {
		
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		
		return create(arr);
	}
	
	public static <K extends Comparable<K>, V> Node<K, V> create(K[] arr) {
		
		return ConstructBSTFromSortedArray.create(arr);
	}
	
	public static <K extends Comparable<K>, V> Node<K, V> create(LinkedList<K> dll) {
		
		return ConstructBSTFromSortedDoublyLinkedList.create(dll);		
	}
		
	/**
	 * Level-order BFS traversal of the tree.
	 * 
	 * Time Complexity : O(n) where n is the total 
	 * number of nodes.
	 *    
	 * Traversal Order : All nodes of each level.
	 */
	public static void printLevelOrder(Node<?, ?> tree, boolean withParent) {
		BFSOrLevelOrderTraversal.print(tree, withParent);
	}
	
	/**
	 * Pre-order DFS traversal of the tree.
	 * 
	 * Time Complexity : O(n) where n is the total 
	 * number of nodes.
	 *    
	 * Traversal Order : Root-Left-Right
	 */
	public static void printPreOrder(int type, Node<?, ?> tree, boolean withParent) {
		if(type == RECURSIVELY) {
			PreOrderTraversalRecursive.print(tree, withParent);
		}
		else if(type == ITERATIVELY) {
			PreOrderTraversalIterative.print(tree, withParent);
		}
	}
	
	/**
	 * In-order DFS traversal of the tree.
	 * 
	 * Time Complexity : O(n) where n is the total 
	 * number of nodes.
	 *    
	 * Traversal Order : Left-Root-Right
	 */
	public static void printInOrder(int type, Node<?, ?> tree, boolean withParent) {
		if(type == RECURSIVELY) {
			IndorderTraversalRecursive.print(tree, withParent);
		}
		else if(type == ITERATIVELY) {
			IndOrderTraversalIterative.print(tree, withParent);
		}
	}
	
	/**
	 * Post-order DFS traversal of the tree.
	 * 
	 * Time Complexity : O(n) where n is the total 
	 * number of nodes.
	 *    
	 * Traversal Order : Left-Right-Root
	 */
	public static void printPostOrder(int type, Node<?, ?> tree, boolean withParent) {
		if(type == RECURSIVELY) {
			PostOrderTraversalRecursive.print(tree, withParent);
		}
		else if(type == ITERATIVELY) {
			PostOrderTraversalIterative.print(tree, withParent);
		}
	}
}