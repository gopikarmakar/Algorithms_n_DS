package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Iteratively traversing PreOrder traversal for a Binary Tree.
 * 
 * @author gopi_karmakar
 */
public class PreOrderTraversalWithoutRecursion {
	
	public static void main(String[] args) {
		Node<Integer> tree = BinaryTree.create(BinaryTree.LEVEL_ORDER);
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
	 * 
	 * @param tree
	 * @return
	 */
	private static List<Integer> traversePreOrder(Node<Integer> tree) {
		Stack<Node<Integer>> path = new Stack<>();
		path.push(tree);
		List<Integer> preOrderList = new ArrayList<>();				
		
		while(!path.isEmpty()) {
			
			Node<Integer> current = path.pop();
			if(current != null) {
				preOrderList.add(current.key);
				path.push(current.right);
				path.push(current.left);
			}			
		}
		return preOrderList;
	}
}
