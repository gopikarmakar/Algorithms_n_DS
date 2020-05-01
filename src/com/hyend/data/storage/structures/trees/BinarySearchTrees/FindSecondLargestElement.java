package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * A Google Interview Question
 * 
 * Find the second largest element in the BST. 
 * 
 * @author gopi_karmakar
 */
public class FindSecondLargestElement {

	public static void main(String[] args) {
		 
		Node<Integer, ?> bst = BinarySearchTree.createDefault();
		System.out.println(find(bst));
	}
	
	/**
	 * Iterative O(n) time and O(1) space complexity solution.
	 * Where n is the length of most right side nodes. 
	 */
	private static Node<Integer, ?> find(Node<Integer, ?> node) {
				
		if(node == null)
			return null;
		
		Node<Integer, ?> e = node;
		Node<Integer, ?> result = e;
		
		while(e.right != null) {
			
			result = e;							
			e = e.right;
		}
		
		if(e.left != null)
			result = e.left;
		
		return result;
	}
}
