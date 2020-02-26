package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Iteratively traversing PreOrder traversal for a Binary Tree.
 * 
 * @author gopi_karmakar
 */
public class PreOrderTraversalIterative {
	
	public static void main(String[] args) {
		
		Node<Integer> tree = BinaryTree.buildDefault();
		
		BinaryTree.printPreOrderRecursive(tree, true);
		
		System.out.println(traversePreOrder(tree));
	}
	
	/**
	 * Since we push and pop each node exactly once, 
	 * the time complexity is 0(n), where n is the number of nodes
	 * The space complexity is 0(h), where h is the height of the tree, 
	 * since, with the possible exception of the top of the stack, 
	 * the nodes in the stack correspond to the right children of the nodes 
	 * on a path beginning at the root.	 
	 */
	public static <K> List<Node<K>> traversePreOrder(Node<K> tree) {
		
		Stack<Node<K>> path = new Stack<>();
		path.push(tree);
		
		List<Node<K>> preOrderList = new ArrayList<>();				
		
		while(!path.isEmpty()) {
			
			Node<K> current = path.pop();
			
			if(current != null) {
				
				preOrderList.add(current);
				path.push(current.right);
				path.push(current.left);
			}			
		}
		return preOrderList;
	}
}
