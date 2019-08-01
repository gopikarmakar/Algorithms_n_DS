package com.hyend.data.storage.structures.trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.hyend.data.storage.structures.trees.BinarySearchTree.BinarySearchTree.Node;

public class BSTPreOrderTraversalIterative {

	public static void main(String[] args) {
		print(BinarySearchTree.create(BinarySearchTree.ITERATIVE), true);
	}
	
	public static void print(Node<?, ?> tree, boolean withParent) {
	
		Stack<Node<?, ?>> stack = new Stack<>();
		stack.add(tree);
		List<Node<?, ?>> nodes = new ArrayList<>();
		
		while(!stack.isEmpty()) {		
			
			Node<?, ?> current = stack.pop();
			
			if(current != null) {				
				nodes.add(current);
				stack.add(current.right);
				stack.add(current.left);
			}
		}
		
		for(Node<?, ?> node :  nodes)
			System.out.println("Key = " + node.key + " Value = " + node.value + ((withParent == true) ? 
				((node.parent!= null) ? "\tParent = " + node.parent.key : "\tIt's Root") : ""));
	}
}
