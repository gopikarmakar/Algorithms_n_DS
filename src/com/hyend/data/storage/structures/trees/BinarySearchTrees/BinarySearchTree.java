package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.LinkedList;
import java.util.List;

/**
 * A concrete balanced Binary Search Tree Implementation.
 * 
 * 									 19
 *   		  		7             						43
 *   		3        		11         			23    			47
 *		2    	5    		  	17   			  	37    			53
 *							13					29		41		 51
 *													31  	
 *								
 * @author gopi_karmakar
 */
public class BinarySearchTree {
	
	public static final int RECURSIVELY = 1;
	public static final int ITERATIVELY = 2;
	
	public static <K extends Comparable<K>, V> Node<Integer, ?> createDefault() {		
		
		return BSTNodeInsertion.createDefault();
	}
	
	public static <K extends Comparable<K>, V> Node<K, V> create(K[] arr) {
		
		ConstructBSTFromSortedArray<K, V> bst = new ConstructBSTFromSortedArray<>();
		
		return bst.create(arr);		
	}
	
	public static <K extends Comparable<K>, V> Node<K, V> create(LinkedList<K> dll) {
		
		ConstructBSTFromSortedDoublyLinkedList<K, V> bst = 
				new ConstructBSTFromSortedDoublyLinkedList<>();
		
		return bst.create(dll);		
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
		
		List<List<Node<?, ?>>> nodes = BFSOrLevelOrderTraversal.bfs(tree, withParent);
		
		nodes.forEach(l -> {
			
			l.forEach(e -> {
				
				print(e, withParent);
			});
			System.out.println();
		});
	}
	
	/**
	 * Pre-order DFS traversal of the tree.
	 * 
	 * Time Complexity : O(n) where n is the total 
	 * number of nodes.
	 *    
	 * Traversal Order : Root-Left-Right
	 */
	public static void printPreOrder(int type, Node<?, ?> tree, boolean... withParent) {
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
	public static void printInOrder(int type, Node<?, ?> tree, boolean... withParent) {
		if(type == RECURSIVELY) {
			IndorderTraversalRecursive.print(tree, withParent[0]);
		}
		else if(type == ITERATIVELY) {
			IndOrderTraversalIterative.print(tree, withParent[0]);
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
	public static void printPostOrder(int type, Node<?, ?> tree, boolean... withParent) {
		if(type == RECURSIVELY) {
			PostOrderTraversalRecursive.print(tree, withParent[0]);
		}
		else if(type == ITERATIVELY) {
			PostOrderTraversalIterative.print(tree, withParent[0]);
		}
	}
	
	public static void print(Node<?, ?> node, boolean... withParent) {
		
		System.out.println(node.toString() + 
				((withParent.length > 0 && withParent[0]) ? ((node.parent!= null) ? 
				"\tParent = " + node.parent.key : "\tIt's Root") : ""));
	}
}