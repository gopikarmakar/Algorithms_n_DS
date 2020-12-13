package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Construct a BST from preOrder data.
 * 
 * 					10
 * 			5				40
 * 		1		7				50	
 * 
 * @author gopi_karmakar
 */
public class ReConstructBSTFromPreOrderData {

	public static void main(String[] args) {

		int[] preOrder = {10, 5, 1, 7, 40, 50};
		
		ReConstructBSTFromPreOrderData bst = new ReConstructBSTFromPreOrderData();
		
		Node<Integer, ?> tree = bst.create(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		System.out.println("Preorder Traversal");
		BinarySearchTree.printPreOrder(BinarySearchTree.RECURSIVELY, tree);
		
		System.out.println("\nLevel Order Traversal");
		BinarySearchTree.printLevelOrder(tree, false);
	}
	
	private int index = 0;
	
	private Node<Integer, String> create(int[] preOrder, int min, int max) {
		
		if(index >= preOrder.length) 
			return null;
		
		if(preOrder[index] < min || preOrder[index] >= max)
			return null;
		
		Node<Integer, String> node = new Node<>(preOrder[index++], null);
		
		//index++;
		
		node.left = create(preOrder, min, node.key);
		node.right = create(preOrder, node.key, max);
		
		return node;
	}
}
