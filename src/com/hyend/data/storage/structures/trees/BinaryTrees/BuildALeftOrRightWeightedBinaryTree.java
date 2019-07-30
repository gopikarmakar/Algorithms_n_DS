package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Creating a weight balanced left or right
 * leaning binary tree.
 * 
 * @author gopi_karmakar
 */
public class BuildALeftOrRightWeightedBinaryTree {
	
	private static Node<Object> root = null;
	private static Node<Object> parent = null;
	
	public static void main(String[] args) {
		//int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};		
		BinaryTree.printBFS(build(), true);
	}
	
	public static Node<?> build(Object...keys) {
		if(keys == null || keys.length == 0) {
			keys = new Object[15];
			for(int i = 0; i < 15; i++)
				keys[i] = i+1;
		} 
		for(Object x : keys)
			add(x);
				
		return root;		
	}
	
	/**
	 * Iteratively adding nodes 
	 * 
	 * @param key
	 * @return
	 */
	public static Node<?> add(Object key) {
		
		boolean isLeftImBalanced = false;
		boolean isRightImBalanced = false;		
		
		Node<Object> node = root;
		if(node == null) {
			root = new Node<Object>(key);
			root.parent = parent;
			root.weight += 1;
			return root;
		}
		else {
			
			do {
				parent = node;
				if(node.left == null) {
					node = node.left;
					isLeftImBalanced = true;					
				}
				else if(node.right == null) {
					node = node.right;
					isRightImBalanced = true;					
				}
				else {
					/**
					 * It's a left leaning tree.
					 * Reverse the condition for right leaning
					 */
					if(node.left.weight <= node.right.weight) {
						node = node.left;
					}
					else {
						node = node.right;
					}
				}				
			
			} while(node != null);
			
			if(isLeftImBalanced) {
				node = parent.left = new Node<Object>(key);
				node.parent = parent;
			}
			else if(isRightImBalanced) {
				node = parent.right = new Node<Object>(key);
				node.parent = parent;
			}	
			
			return node;
		}
	}
	
	/**
	 * Adding recursively
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	public static Node<Object> add(Node<Object> node, Object key) {
		
		if(node == null) {
			node = new Node<Object>(key);
			node.parent = parent;
			node.weight += 1;
			return node;
		}
		else {
			
			parent = node;
			if(node.left == null) {
				node.left = add(node.left, key);								
			}
			else if(node.right == null) {
				node.right = add(node.right, key);					
			}
			else {
				if(node.left.weight <= node.right.weight) {
					node = node.left;
				}
				else {
					node = node.right;
				}
			}
			
			return node;
		}
	}
}
