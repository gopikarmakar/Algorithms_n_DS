package com.hyend.data.storage.structures.trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.hyend.data.storage.structures.trees.BinarySearchTree.BinarySearchTree.Node;

public class BSTIndOrderTraversalIterative {

	public static void main(String[] args) {
		print(BinarySearchTree.create(BinarySearchTree.ITERATIVE), true);
	}
	
	public static void print(Node<?, ?> tree, boolean withParent) {
	
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
			System.out.println("Key = " + node.key + " Value = " + node.value + ((withParent == true) ? 
				((node.parent!= null) ? "\tParent = " + node.parent.key : "\tIt's Root") : ""));
	}
}
