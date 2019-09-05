package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * The successor of a node in a binary tree is the node that
 * appears immediately after the given node in an InOrder traversal. 
 * 
 * @author gopi_karmakar
 */
public class FindInOrderSuccessorOfAGivenNode {

	public static void main(String[] args) {		

		Node<Integer> tree = BinaryTree.buildDefault();
		
		BinaryTree.printBFS(tree, true);
		Node<Integer> successor = findSuccessor(tree.left.right);
		System.out.println("The Successor Is = " + successor.key);
	}
	
	/**
	 * The most efficient and simple successor finding solution.
	 * 
	 * Since the number of edges followed cannot be more than the tree height, 
	 * the time complexity is 0(h), where h is the height of the tree
	 */
	private static Node<Integer> findSuccessor(Node<Integer> node) {
		
		Node<Integer> current = node;
		
		if(current.right != null) {
			//Find the left most element in node’s right subtree.
			current = current.right;
			
			while(current.left != null)
				current = current.left;
			
			return current;
		}
		
		// Find the closest ancestor whose left subtree contains node.
		while(current.parent != null && current == current.parent.right) {
			current = current.parent;
		}
		
		/**
		 *  A return value of null from loop means node does not have successor, 
		 *  i.e., it is // the rightmost node in the tree.
		 */
		return current.parent;
	}
}
