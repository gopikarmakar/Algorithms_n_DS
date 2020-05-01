package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * A Google Interview Question
 * 
 * Find the second smallest element in the BST.  
 * 
 * @author gopi_karmakar
 */
public class FindSecondSmallestElement {

	public static void main(String[] args) {
		
		Node<Integer, ?> bst = BinarySearchTree.createDefault();
		System.out.println(find(bst));
	}
	
	private static Node<Integer, ?> find(Node<Integer, ?> node) {
		
		if(node == null)
			return null;
		
		Node<Integer, ?> e = node;
		Node<Integer, ?> result = e;
		
		while(e.left != null) {
			
			result = e;
			e = e.left;
		}
		
		if(e.right != null)
			result = e.right;
		
		return result;
	}
}
