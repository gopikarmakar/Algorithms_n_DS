package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import com.hyend.data.storage.structures.trees.BinarySearchTrees.BinarySearchTree.Node;

/**
 * Constructing a Binary Search Tree Recursively
 * and Iteratively with the track of parent.
 * 
 * A Binary Search Tree guarantees O(log(n) time for Insertions.
 * Average-case cost (after N random inserts) 	:  	1.39 log(N)
 * Worst-case cost (after N random inserts) 	: 	O(n)
 * 
 * 	       		       11
 *   		  5                15
 *   	 3        8         14    16
 *     2   4    7   9     13         19
 *  1         6		    12	     17      20
 *					               18       21 
 * @author gopi_karmakar
 */
public class BSTNodeInsertion<K extends Comparable<K>, V> {
	
	/**
	 * Required for iterative insertion.
	 */
	private Node<K, V> root = null;
	
	public static void main(String[] args) {
		Node<?, ?> tree = createDefault();		
	    BinarySearchTree.printInOrder(BinarySearchTree.RECURSIVE, tree, true);
	}
	
	public static Node<Integer, String> createDefault() {
		
		Integer[] keys = {11, 15, 5, 16, 3, 14, 8, 13, 4, 19, 7, 12, 2, 17, 1, 18, 6, 20, 9, 21};		
		
		Node<Integer, String> tree = null;		
		BSTNodeInsertion<Integer, String> bst = new BSTNodeInsertion<>();
		for(int x : keys)
			tree = bst.addIterarively(x, ""+x, null);
		
		return tree;
	}
	
	public Node<K, V> put(int type, K key, V value) {			
		
		if(type == BinarySearchTree.RECURSIVE)
			root = addRecursively(root, null, key, value);
		else if(type == BinarySearchTree.ITERATIVE)
			root = addIterarively(key, value, null);
		
		return root;
	}
	
	/**
	 * Iterative Binary Search Tree node insertion.
	 * @param key
	 * @param value
	 * @param parent
	 * @return
	 */
	private Node<K, V> addIterarively(K key, V value,
			Node<K, V> parent) {		
		
		Node<K, V> node = root;			
		if(node == null) {			
			root = new Node<>(null, key, value);
			root.parent = parent;
			return root;
		}
		int cmp = 0;
		do {
			parent = node;
			cmp = key.compareTo(node.key);
			if(cmp < 0)			node = node.left;
			else if(cmp > 0)	node = node.right;	
			else 				node.value = value;
		} while(node != null);
	
		if(cmp < 0) 
			node = parent.left = new Node<>(parent, key, value);
		else if(cmp > 0)
			node = parent.right = new Node<>(parent, key, value);			
		
		return root;
	}
	
	/**
	 * Recursive Binary Search Tree node insertions.		 
	 * @param node
	 * @param parent
	 * @param key
	 * @param value
	 * @return
	 */
	private Node<K, V> addRecursively(Node<K, V> node,  
			Node<K, V> parent, K key, V value) {
		
		if(node == null) {
			node = new Node<>(parent, key, value);
			return node;
		}
		parent = node;
		int cmp = key.compareTo(node.key);
		
		if(cmp < 0)			node.left = addRecursively(node.left, parent, key, value);
		else if(cmp > 0)	node.right = addRecursively(node.right, parent, key, value);
		else				node.value = value; 			
		
		return node;		
	}
}