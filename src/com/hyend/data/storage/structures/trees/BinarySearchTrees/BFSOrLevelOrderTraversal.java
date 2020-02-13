package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BFSOrLevelOrderTraversal {
	
	public static void main(String[] args) {
		
		Node<?, ?> tree = BinarySearchTree.createDefault();
		print(tree, true);
	}
	
	public static void print(Node<?, ?> tree, boolean withParent) {
	
		Queue<Node<?, ?>> queue = new LinkedList<>();
		queue.add(tree);
		
		while(!queue.isEmpty()) {
			
			Node<?, ?> current = queue.poll();				
			
			if(current != null) {
							
				System.out.println("Key = " + current.key + 
						((current.value != null) ? " Value = " + current.value : "") +
						((withParent == true) ? ((current.parent!= null) ? "\tParent = " + current.parent.key : "\tIt's Root") : ""));					
			}
			
			if(current.left != null)	queue.add(current.left);			
			if(current.right != null)	queue.add(current.right);
		}
	}
}
