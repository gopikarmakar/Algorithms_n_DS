package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import com.hyend.data.storage.structures.trees.BinarySearchTrees.BinarySearchTree.Node;

/**
 * Average-case cost (after N random search)	: 1.39 log(N)
 * Worst-case cost (after N random search)		: O(N)
 *  
 * @author gopi_karmakar
 */
public class BSTNodeSearch {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Node<Integer, ?> tree = (Node<Integer, ?>) BinarySearchTree.createDefault();
		
		Node<Integer, ?> node = contains(tree, 13, BinarySearchTree.RECURSIVE); 
		String msg = (node != null) ? ""+node.value : "Key Doesn't Exist"; 
		System.out.println(msg);
	}
	
	public static Node<Integer, ?> contains(Node<Integer, ?> tree, int key, int type) {
		Node<Integer, ?> node = null;
		
		if(type == BinarySearchTree.RECURSIVE)
			node = recursive(tree, key);
		else if(type == BinarySearchTree.ITERATIVE)
			node = iterative(tree, key);
		
		return node;
	}
		
	private static Node<Integer, ?> recursive(Node<Integer, ?> tree, int key) {	
		if(tree == null)
			return null;
		
		int cmp = Integer.compare(key, tree.key);		
		if(cmp == 0) 
			return tree;						
		return (cmp < 0) ? recursive(tree.left, key) : recursive(tree.right, key);
	}
	
	private static Node<Integer, ?> iterative(Node<Integer, ?> tree, int key) {
		int cmp = 0;
		Node<Integer, ?> current = tree;		
		while(current !=  null) {			
			cmp = Integer.compare(key, current.key);			
			if(cmp == 0) return current;			
			current = ((cmp < 0) ? current.left : current.right);			
		}
		return null;
	}
}