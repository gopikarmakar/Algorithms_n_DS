package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * @author gopi_karmakar 
 */
public class IndOrderTraversalIterative {

	public static void main(String[] args) {
		print(BinarySearchTree.createDefault());
	}
	
	/**
	 * O(h) time complexity
	 */
	public static void print(Node<?, ?> tree, boolean... withParent) {
	
		Stack<Node<?, ?>> stack = new Stack<>();
		List<Node<?, ?>> nodes = new ArrayList<>();
		
		Node<?, ?> current = tree;
		
		while(!stack.isEmpty() || current != null) {
			
			if(current != null) {
				stack.add(current);
				current = current.left;				
			}
			else {
				current = stack.pop();
				nodes.add(current);
				current = current.right;
			}
		}
		
		for(Node<?, ?> node :  nodes)
			BinarySearchTree.print(node, withParent);
	}
}