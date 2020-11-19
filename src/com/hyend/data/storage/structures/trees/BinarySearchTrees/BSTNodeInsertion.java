package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * A concrete Binary Search Tree Implementation Recursively and Iteratively 
 * with the track of Parent node for every child node.
 * 
 * A Binary Search Tree guarantees O(log(n) time for Insertions.
 * Average-case cost (after N random inserts) 	:  	1.39 log(N)
 * Worst-case cost (after N random inserts) 	: 	O(n)
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
public class BSTNodeInsertion<K extends Comparable<K>, V> {
	
	/**
	 * Required for iterative insertion.
	 */
	private Node<K, V> root = null;
	
	public static void main(String[] args) {
		
		Node<?, ?> tree = createDefault();		
	    
		BinarySearchTree.printLevelOrder(tree, true);
		//BinarySearchTree.printInOrder(BinarySearchTree.RECURSIVELY, tree, true);
	}
	
	public static Node<Integer, String> createDefault() {
				
		Integer[] keys = {19, 7, 43, 3, 11, 23, 47, 2, 5, 17, 37, 53, 13, 29, 41, 31, 51};
		
		Node<Integer, String> tree = null;		
		BSTNodeInsertion<Integer, String> bst = new BSTNodeInsertion<>();
		
		for(int x : keys)
			tree = bst.addIterarively(x, null, null);
		
		return tree;
	}
	
	public Node<K, V> add(int type, K key, V value) {			
		
		if(type == BinarySearchTree.RECURSIVELY) {
			root = addRecursively(root, null, key, value);
		}
		else if(type == BinarySearchTree.ITERATIVELY) {
			root = addIterarively(key, value, null);
		}
		
		return root;
	}
	
	/**
	 * Iterative Binary Search Tree node insertion.
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