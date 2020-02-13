package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Validate if a given BST is a valid BST 
 * 
 * @author gopi_karmakar
 */
public class IsItAValidBST {
	
	public static void main(String[] args) {
	
		Node<Integer, ?> tree = BinarySearchTree.createDefault();		
		System.out.println(isItAValidBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
	
	/**
	 * A PreOrder DFS O(n) time complexity solution.
	 * 
	 * Look into Binary Tree Package for a better BFS solution.  
	 */
	private static boolean isItAValidBST(Node<Integer, ?> node, int min, int max) {
		
		if(node == null) return true;
		
		if(node.key < min || node.key > max) return false;
		
		return isItAValidBST(node.left, min, node.key) && isItAValidBST(node.right, node.key, max);
	}
}
