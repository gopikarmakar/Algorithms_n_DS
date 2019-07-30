package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

public class IsItAValidBST {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//Integer[] keys = {2, 1, 3};
		Integer[] keys = {5,1,4,null,null,3,6};
		
		Node<Integer> tree = (Node<Integer>) BuildABinaryTreeInLevelOrder.build((Object[]) keys);
		
		BinaryTree.printPreOrderRecursive(tree, false);
		//BinaryTree.printBFS(tree, true);
		
		System.out.println(isItAValidBST(tree));
	}
	
	private static boolean isItAValidBST(Node<Integer> root) {		
		return checkViaPostOrder(root).status;		
	}
	
	private static class Status {
				
		Node<Integer> node;
		boolean status = false;		
		
		public Status(boolean status, Node<Integer> node) {
			this.node = node;
			this.status = status;			
		}
	}
	
	private static Status checkViaPostOrder(Node<Integer> node) {
		
		if(node == null)
			return new Status(true, null);
		
		Status leftResult = checkViaPostOrder(node.left);
		Status rightResult = checkViaPostOrder(node.right);
		
		if(leftResult.status && rightResult.status)
			if(leftResult.node == null && rightResult.node == null) {
				return new Status(true, node);
		}
		else if((leftResult.node != null && leftResult.node.key <= node.key) && 
				(rightResult.node != null && rightResult.node.key >= node.key)) {
			
			return new Status(true, node);
		}

		return new Status(false, node);
	}
}
