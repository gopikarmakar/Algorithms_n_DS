package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * @author gopi_karmakar
 */
public class PostOrderTraversalIterative {
	
	public static void main(String[] args) {
		
		print(BinarySearchTree.createDefault());
	}
	
	/**
	 * O(h) time complexity
	 */
	public static void print(Node<?, ?> tree, boolean... withParent) {
		
		Stack<Node<?, ?>> stack = new Stack<>();
		stack.add(tree);
		
		List<Node<?, ?>> nodes = new ArrayList<>();
		
		while(!stack.isEmpty()) {
			
			Node<?, ?> current = stack.pop();
			
			if(current != null) {
				
				nodes.add(0, current);	// Reversing the list.			
				stack.add(current.left);
				stack.add(current.right);
			}
		}
		
		//Collections.reverse(nodes);
		
		for(int i = 0; i < nodes.size(); ++i) {
			BinarySearchTree.print(nodes.get(i), withParent);
		}
 	}
}
