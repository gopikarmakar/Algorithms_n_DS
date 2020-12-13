package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.Map;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * @author gopi_karmakar
 */
public class ReconstructBinaryTreeFromPreOrderandInOrderData {

	private static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		
		int[] preOrder = {3, 9, 20, 15, 7};
		int[] inOrder = {9, 3, 15, 20, 7};
		
		for(int i = 0; i < inOrder.length; i++) {
			
			map.put(inOrder[i], i);
		}
		
		Node<Integer> root = reconstruct(preOrder, inOrder, null, 0, inOrder.length-1, 0);
		
		BinaryTree.printBFS(root, true);
 	}
	
	/**
	 * O(n) time complexity
	 */
	private static Node<Integer> reconstruct(int[] preOrder, int[] inOrder,
			Node<Integer> parent, int start, int end, int index) {
		
		if(start > end)
			return null;
		
		Node<Integer>  node = new Node<>(preOrder[index], parent);		
		
		int inIndex = map.get(preOrder[index]);
		
		node.left = reconstruct(preOrder, inOrder, node, start, inIndex-1, index+1);
		node.right = reconstruct(preOrder, inOrder, node, inIndex+1, end, index + inIndex - start + 1);
		
		return node;
	}
}
