package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.LinkedList;
import java.util.List;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Solution to form a linked list from the leaves of the tree.
 * 
 * @author gopi_karmakar 
 */
public class ConstructALinkedListFromLeavesOfBT { 
	
	public static void main(String[] args) {
		
		Node<Integer> tree = BinaryTree.buildDefault();

		List<Integer> leaves = new LinkedList<>();
		
		listOfLeaves(tree, leaves);
		
		System.out.println(leaves);
	}

	/**
	 * The time complexity is 0(n), where n is the number of nodes.	 
	 */
	private static void listOfLeaves(Node<Integer> node, List<Integer> leaves) {
		
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