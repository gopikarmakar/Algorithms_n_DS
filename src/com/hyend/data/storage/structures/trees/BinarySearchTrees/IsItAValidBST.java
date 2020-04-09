package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Validate if a given BST is a valid BST 
 * 
 * @author gopi_karmakar
 */
public class IsItAValidBST {
	
	public static void main(String[] args) {
	
		Node<Integer, ?> tree = BinarySearchTree.createDefault();		
		System.out.println(isItAValidBST(tree, null, null));
	}
	
	/**
	 * A PreOrder DFS O(n) time complexity solution.
	 * 
	 * Look into Binary Tree Package for a better BFS solution.  
	 */
	private static boolean isItAValidBST(Node<Integer, ?> node, Long min, Long max) {
		
		if(node == null) return true;
		
		if((min != null && node.key < min) || (max != null && node.key > max)) 
			return false;
		
		return isItAValidBST(node.left, min, (long) node.key-1) && 
				isItAValidBST(node.right, (long) node.key+1, max);
	}
}
