package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.LinkedList;
import java.util.List;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Solution to form a linked list from the leaves of the tree.
 * 
 * @author gopi_karmakar
 *
 */
public class ConstructALinkedListFromLeaves { 
	
	public static void main(String[] args) {
		
		Node<String> tree = ConstructABinaryTreeFromAnArrayOfKeys.build();
		List<String> leaves = new LinkedList<String>();
		listOfLeaves(tree, leaves);
		
		System.out.println(leaves);
	}

	/**
	 * The time complexity is 0(n), where n is the number of nodes.
	 * 
	 * @param node
	 * @param leaves
	 */
	private static void listOfLeaves(Node<String> node, List<String> leaves) {
		
		if(node != null) {
			
			if(node.left == null && node.right == null) {
				leaves.add(node.key);
			}
			else {
				listOfLeaves(node.left, leaves);
				listOfLeaves(node.right, leaves);
			}
		}
	}
}