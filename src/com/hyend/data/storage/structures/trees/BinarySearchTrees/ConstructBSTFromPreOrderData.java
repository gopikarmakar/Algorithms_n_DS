package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Construct a BST from preOrder data
 * 
 * @author gopi_karmakar
 */
public class ConstructBSTFromPreOrderData {

	public static void main(String[] args) {

		int[] preOrder = {10, 5, 1, 7, 40, 50};
		
		Node<Integer, String> tree = toBST(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		BinarySearchTree.printPreOrder(BinarySearchTree.RECURSIVELY, tree, false);		
	}
	
	private static int index = 0;
	
	private static Node<Integer, String> toBST(int[] preOrder, int min, int max) {
		
		if(index >= preOrder.length) 
			return null;
		
		if(preOrder[index] < min && preOrder[index] >= max)
			return null;
		
		Node<Integer, String> node = new Node<>(preOrder[index], null);
		
		index++;
		
		node.left = toBST(preOrder, min, node.key);
		node.right = toBST(preOrder, node.key, max);
		
		return node;
	}
}
