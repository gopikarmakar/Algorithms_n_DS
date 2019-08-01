package com.hyend.data.storage.structures.trees.BinarySearchTree;

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
	
	/**
	 * A single node of Binary Search Tree
	 * 
	 * @author gopi_karmakar
	 *
	 * @param <K>
	 * @param <V>
	 */
	public static class Node<K extends Comparable<K>, V> {
		
		K key;
		V value;
		Node<K, V> left;
		Node<K, V> right;
		Node<K, V> parent;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;			
		}
		
		public Node(Node<K, V> parent, K key, V value) {
			this(key, value);
			this.parent = parent;
		}
	}
	
	public static Node<Integer, Object> create(int type) {		
		return BSTNodeInsertion.create(type);
	}
		
	/**
	 * Level-order BFS traversal of the tree.
	 *    
	 * Traversal Order : All nodes of each level.
	 */
	public static void printPreOrder(Node<?, ?> tree, boolean withParent) {
		BSTLevelOrderOrBFSTraversal.print(tree, withParent);
	}
	
	/**
	 * Pre-order DFS traversal of the tree.
	 *    
	 * Traversal Order : Root-Left-Right
	 */
	public static void printPreOrder(int type, Node<?, ?> tree, boolean withParent) {
		if(type == RECURSIVE)
			BSTPreOrderTraversalRecursive.print(tree, withParent);
		else if(type == ITERATIVE)
			BSTPreOrderTraversalIterative.print(tree, withParent);
	}
	
	/**
	 * In-order DFS traversal of the tree.
	 *    
	 * Traversal Order : Left-Root-Right
	 */
	public static void printInOrder(int type, Node<?, ?> tree, boolean withParent) {
		if(type == RECURSIVE)
			BSTIndorderTraversalRecursive.print(tree, withParent);
		else if(type == ITERATIVE)
			BSTIndOrderTraversalIterative.print(tree, withParent);
	}
	
	/**
	 * Post-order DFS traversal of the tree.
	 *    
	 * Traversal Order : Left-Right-Root
	 */
	public static void printPostOrder(int type, Node<?, ?> tree, boolean withParent) {
		if(type == RECURSIVE)
			BSTPostOrderTraversalRecursive.print(tree, withParent);
		else if(type == ITERATIVE)
			BSTPostOrderTraversalIterative.print(tree, withParent);
	}
}