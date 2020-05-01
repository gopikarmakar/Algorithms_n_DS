package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS or Level order Traversal of a BST 
 * 
 * @author gopi_karmakar
 */
public class BFSOrLevelOrderTraversal {
	
	public static void main(String[] args) {
		
		Node<?, ?> tree = BinarySearchTree.createDefault();
		print(tree, false);
	}
	
	/**
	 * Takes O(n) time and space complexity
	 */
	public static void print(Node<?, ?> tree, boolean... withParent) {
	
		Queue<Node<?, ?>> queue = new LinkedList<>();
		queue.add(tree);
		
		List<List<Node<?, ?>>> nodes = new ArrayList<>();			
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			List<Node<?, ?>> list = new ArrayList<>();
			
			for(int i = 0; i < size; ++i) {
				
				Node<?, ?> current = queue.poll();
				
				list.add(current);
				
				if(current.left != null)	queue.add(current.left);			
				if(current.right != null)	queue.add(current.right);
			}
			nodes.add(list);
		}
		print(nodes, withParent);
	}
	
	private static void print(List<List<Node<?, ?>>> nodes, boolean... withParent) {
	
		nodes.forEach(l -> {
			
			l.forEach(e -> {
				
				System.out.print("[" +e.key + 
					((withParent.length > 0 && withParent[0]) ? ((e.parent!= null) ? 
					"\tParent = " + e.parent.key : "\tIt's Root") : "") + "] ");
			});
			System.out.println();
		});
	}
}
