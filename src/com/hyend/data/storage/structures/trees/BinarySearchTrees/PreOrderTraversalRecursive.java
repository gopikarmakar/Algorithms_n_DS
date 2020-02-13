package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Pre-Order traversal recursive
 * 
 * @author gopi_karmakar
 */
public class PreOrderTraversalRecursive {
	
	public static void main(String[] args) {		
		print(BinarySearchTree.createDefault(), true);
	}
	
	/**
	 * O(h) time complexity
	 */
	public static void print(Node<?, ?> tree, boolean withParent) {
		if(tree == null) //Base case
			return;
		
		System.out.println("Key = " + tree.key + 
				((tree.value != null) ? "\tValue = " + tree.value : "") + 
				((withParent == true) ? ((tree.parent!= null) ? "\tParent = " + tree.parent.key : "\tIt's Root") : ""));
		
		print(tree.left, withParent);
		
		print(tree.right, withParent);
	}
}
