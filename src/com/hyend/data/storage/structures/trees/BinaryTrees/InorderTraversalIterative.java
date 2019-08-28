package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Iteratively traversing InOrder traversal for a Binary Tree.
 *  
 * @author gopi_karmakar
 */
public class InorderTraversalIterative {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Node<Integer> root = (Node<Integer>) BinaryTree.createDefault(BinaryTree.LEVEL_ORDER);		
		BinaryTree.printInOrderRecursive(root, false);		
		System.out.println(traverseInOrder(root));
	}
	
	/**
	 * The time complexity is 0(n), since the total time spent on each node is O(1).
	 * The space complexity is 0(h), where h is the height of the tree.
	 * 
	 * @param tree
	 * @return
	 */
	private static List<Integer> traverseInOrder(Node<Integer> tree) {		
		Node<Integer> current = tree;
		List<Integer> list = new ArrayList<>();
		Stack<Node<Integer>> stack = new Stack<>();				
		while(!stack.isEmpty() || current != null) {
			if(current != null) {
				stack.push(current);
				current = current.left; //Going Left
			}
			else {
				current = stack.pop();
				list.add(current.key);
				current = current.right; //Going Right
			}
		}
		return list;
	}
}
