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
		
		//Stack<Node<?, ?>> nodes = new Stack<>();
		List<Node<?, ?>> nodes = new ArrayList<>();
		
		while(!stack.isEmpty()) {
			
			Node<?, ?> current = stack.pop();
			
			if(current != null) {
				
				nodes.add(current);				
				stack.add(current.left);
				stack.add(current.right);
			}
		}
		
		/*while(!nodes.isEmpty()) {
			
			Node<?, ?> node = nodes.pop();
			BinarySearchTree.print(node, withParent);
		}*/		
		
		Collections.reverse(nodes);
		
		for(int i = 0; i < nodes.size(); ++i) {
			BinarySearchTree.print(nodes.get(i), withParent);
		}
 	}
}
