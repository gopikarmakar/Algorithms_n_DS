package com.hyend.data.storage.structures.trees.BinarySearchTree;

import com.hyend.data.storage.structures.trees.BinarySearchTree.BinarySearchTree.Node;

/**
 * Constructing a Binary Search Tree
 * Recursively and Iteratively.
 * 
 * 	       		       11
 *   		  5                15
 *   	 3        8         14    16
 *     2   4    7   9     13         19
 *  1         6		    12	     17      20
 *					               18       21 
 * @author gopi_karmakar
 * 
 */
public class BSTNodeInsertion {	
	
	public static void main(String[] args) {			    
	    BinarySearchTree.printInOrder(BinarySearchTree.RECURSIVE, create(BinarySearchTree.ITERATIVE), true);
	}
	
	public static Node<Integer, Object> create(int type) {
		
		Integer[] keys = {11, 15, 5, 16, 3, 14, 8, 13, 4, 19, 7, 12, 2, 17, 1, 18, 6, 20, 9, 21};		
		Node<Integer, Object> tree = null;
		BSTInsert<Integer, Object> bstInsert = new BSTNodeInsertion.BSTInsert<Integer, Object>();		
		for(int x : keys) 
			tree = bstInsert.put(type, x, ""+x);
		
		return tree;
	}
	
	private static BSTInsert<Integer, Object> bstInsertInt = new BSTNodeInsertion.BSTInsert<Integer, Object>();
	
	public static Node<Integer, Object> create(int type, Integer key, Object value) {				
		Node<Integer, Object> tree = null;		
		tree = bstInsertInt.put(type, key, value);		
		return tree;
	}
	
	private static BSTInsert<String, Object> bstInsertString = new BSTNodeInsertion.BSTInsert<String, Object>();

	public static Node<String, Object> create(int type, String key, Object value) {				
		Node<String, Object> tree = null;		
		tree = bstInsertString.put(type, key, value);		
		return tree;
	}
	
	/** 
	 * A Binary Search Tree guarantees O(log(n) time for Insertions.
	 * Average-case cost (after N random inserts) 	:  	1.39 log(N)
	 * Worst-case cost (after N random inserts) 	: 	O(n)	 
	 *
	 * @param <K>
	 * @param <V>
	 * @author gopi_karmakar
	 */
	private static class BSTInsert<K extends Comparable<K>, V> {
		
		private Node<K, V> root = null;
				
		public Node<K, V> put(int type, K key, V value) {
			
			if(type == BinarySearchTree.RECURSIVE)
				root = addRecursively(root, null, key, value);
			else if(type == BinarySearchTree.ITERATIVE)
				addIterarively(key, value, null);
			
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
		@SuppressWarnings({ "rawtypes", "unchecked" })
		private Node<K, V> addRecursively(Node<K, V> node,  
				Node<K, V> parent, K key, V value) {
			
			if(node == null) {
				node = new Node(parent, key, value);
				return node;
			}
			parent = node;
			int cmp = key.compareTo(node.key);
			
			if(cmp < 0)			node.left = addRecursively(node.left, parent, key, value);
			else if(cmp > 0)	node.right = addRecursively(node.right, parent, key, value);
			else				node.value = value; 			
			
			return node;		
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
			
			return node;
		}
	}
}