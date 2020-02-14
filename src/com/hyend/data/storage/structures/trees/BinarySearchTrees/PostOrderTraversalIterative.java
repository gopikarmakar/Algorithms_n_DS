package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.Stack;

public class PostOrderTraversalIterative {
	
	public static void main(String[] args) {
		
		print(BinarySearchTree.createDefault());
	}
	
	public static void print(Node<?, ?> tree, boolean... withParent) {
		
		Stack<Node<?, ?>> stack = new Stack<>();
		stack.add(tree);
		
		Stack<Node<?, ?>> nodes = new Stack<>();
		
		while(!stack.isEmpty()) {
			
			Node<?, ?> current = stack.pop();
			
			if(current != null) {
				
				nodes.add(current);				
				stack.add(current.left);
				stack.add(current.right);
			}
		}
		
		while(!nodes.isEmpty()) {
			
			Node<?, ?> node = nodes.pop();
			BinarySearchTree.print(node, withParent);
		}		
 	}
}
