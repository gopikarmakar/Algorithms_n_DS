package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * A concrete Binary Search Tree Implementation with the 
 * tracking of Parent node for every child node.
 * 
 * @author gopi_karmakar
 *
 * @param <K>
 * @param <V>
 */
public class BinarySearchTree {
	
	public static final int RECURSIVE = 1;
	public static final int ITERATIVE = 2;
	
	public static Node<Integer, String> createDefault() {		
		return BSTNodeInsertion.createDefault();
	}
		
	/**
	 * Level-order BFS traversal of the tree.
	 * 
	 * Time Complexity : O(n) where n is the total 
	 * number of nodes.
	 *    
	 * Traversal Order : All nodes of each level.
	 */
	public static void printPreOrder(Node<?, ?> tree, boolean withParent) {
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
		if(type == RECURSIVE)
			PreOrderTraversalRecursive.print(tree, withParent);
		else if(type == ITERATIVE)
			PreOrderTraversalIterative.print(tree, withParent);
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
		if(type == RECURSIVE)
			IndorderTraversalRecursive.print(tree, withParent);
		else if(type == ITERATIVE)
			IndOrderTraversalIterative.print(tree, withParent);
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
		if(type == RECURSIVE)
			PostOrderTraversalRecursive.print(tree, withParent);
		else if(type == ITERATIVE)
			PostOrderTraversalIterative.print(tree, withParent);
	}
}