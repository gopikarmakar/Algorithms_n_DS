package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Solution to find whether there's any Root-to-Leaf 
 * path exist for a specified sum
 * 
 * @author gopi_karmakar
 */
public class RootToLeafPathExistForSum {

	public static void main(String[] args) {
		
		Node<Integer> root = BinaryTree.buildDefault();
		System.out.println("Does path exist = " + hasPath(root, 601, 0));		
	}
	
	/**
	 * The time complexity and space complexity are 0(n) and 0(h), respectively.
	 * 
	 * @param node
	 * @param targetSum
	 * @param partialSum
	 * @return
	 */
	private static boolean hasPath(Node<Integer> node, int targetSum, int partialSum) {
		
		if(node == null) return false;
		
		partialSum += node.key;
		if(node.left == null && node.right == null) {
			return (partialSum == targetSum);
		}
		
		return hasPath(node.left, targetSum, partialSum) ||
			   hasPath(node.right, targetSum, partialSum);
	}
}
