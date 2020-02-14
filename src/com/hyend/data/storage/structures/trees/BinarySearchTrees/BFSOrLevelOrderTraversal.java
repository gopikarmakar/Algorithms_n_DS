package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BFSOrLevelOrderTraversal {
	
	public static void main(String[] args) {
		
		Node<?, ?> tree = BinarySearchTree.createDefault();
		print(tree, false);
	}
	
	public static void print(Node<?, ?> tree, boolean... withParent) {
	
		Queue<Node<?, ?>> queue = new LinkedList<>();
		queue.add(tree);
		
		while(!queue.isEmpty()) {
			
			Node<?, ?> current = queue.poll();				
			
			if(current != null) {											
				
				BinarySearchTree.print(current, withParent);
			}
			
			if(current.left != null)	queue.add(current.left);			
			if(current.right != null)	queue.add(current.right);
		}
	}
}
