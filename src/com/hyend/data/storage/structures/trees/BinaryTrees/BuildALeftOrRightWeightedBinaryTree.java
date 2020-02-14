package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Creating a weight balanced left or right
 * leaning binary tree.
 * 
 * @author gopi_karmakar
 */
public class BuildALeftOrRightWeightedBinaryTree<K> {	
	
	public static void main(String[] args) {
		
		Integer[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};		
		
		BuildALeftOrRightWeightedBinaryTree<Integer> tree = new BuildALeftOrRightWeightedBinaryTree<>();		
		BinaryTree.printBFS(tree.build(keys), true);
	}
	
	public Node<K> build(K[] keys) {
				
		Node<K> root = null;
		
		for(K x : keys)
			add(x);
				
		return root;		
	}
	
	/**
	 * Iteratively adding nodes s
	 */
	private Node<K> root = null;
	private Node<K> parent = null;
	
	public Node<K> add(K key) {
		
		boolean isLeftImBalanced = false;
		boolean isRightImBalanced = false;		
		
		Node<K> node = root;
		if(node == null) {
			root = new Node<>(key);
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
				node = parent.left = new Node<>(key);
				node.parent = parent;
			}
			else if(isRightImBalanced) {
				node = parent.right = new Node<>(key);
				node.parent = parent;
			}	
			
			return node;
		}
	}
	
	/**
	 * Adding recursively
	 */
	public Node<K> add(Node<K> node, K key) {
		
		if(node == null) {
			node = new Node<>(key);
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
