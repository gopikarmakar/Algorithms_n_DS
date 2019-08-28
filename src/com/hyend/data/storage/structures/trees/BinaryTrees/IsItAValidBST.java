package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

public class IsItAValidBST {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//Integer[] keys = {2, 1, 3};
		//Integer[] keys = {0,-1};
		Integer[] keys = {5,1,4,null,null,3,6};
		
		Node<Integer> tree = (Node<Integer>) BinaryTree.createDefault(BinaryTree.LEVEL_ORDER, keys);
		
		BinaryTree.printPreOrderRecursive(tree, false);
		//BinaryTree.printBFS(tree, true);
		
		//System.out.println(isItAValidBST(tree));
		System.out.println(isBSTLevelOrder(tree));
		//System.out.println(isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}	
	
	/**
	 * A DFS Algorithm to validate the BST property of a Binary Tree.
	 * 
	 * @param node
	 * @param min
	 * @param max
	 * @return
	 */
	private static boolean isBST(Node<Integer> node, int min, int max) {
		
		if(node == null)
			return true;
		
		if(node.key < min || node.key > max)
			return false;
		
		return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
	}
	
	private static class QueueEntry {
		
		Integer min, max;
		Node<Integer> node;
		
		public QueueEntry(Node<Integer> node, Integer min, Integer max) {
			this.min = min;
			this.max = max;
			this.node = node;			
		}
	}
	
	/**
	 * A BFS Algorithm to validate the BST property of a Binary Tree.
	 * It's a quite better algorithm in comparison to DFS because it
	 * validates the BST property for every parent node with it's 
	 * left and right child nodes so for any subtree if the BST   
	 * property fails then it's for sure that the tree isn't a BST.
	 * We don't have to go deeper if the BST property fails at 
	 * initial subtrees itself.
	 * 
	 * @param root
	 * @return
	 */
	private static boolean isBSTLevelOrder(Node<Integer> root) {
		
		Queue<QueueEntry> queue = new LinkedList<QueueEntry>();
		queue.add(new QueueEntry(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		QueueEntry headEntry = null;
		while((headEntry = queue.poll()) != null) {
			if(headEntry.node != null) {
				if(headEntry.node.key < headEntry.min || headEntry.node.key > headEntry.max) {
					return false;
				}
				
				queue.add(new QueueEntry(headEntry.node.left, headEntry.min, headEntry.node.key));
				queue.add(new QueueEntry(headEntry.node.right, headEntry.node.key, headEntry.max));
			}			
		}
		return true;
	}
	
	private static boolean isBSTPostOrder(Node<Integer> root) {		
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
	
	/**
	 * Needs improvement
	 * 
	 * @param node
	 * @return
	 */
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