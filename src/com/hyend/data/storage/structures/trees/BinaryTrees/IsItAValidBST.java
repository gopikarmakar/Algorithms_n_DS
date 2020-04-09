package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Check whether a given Binary Tree is a BST 
 * 
 * @author gopi_karmakar
 */
public class IsItAValidBST {

	public static void main(String[] args) {
		
		//Integer[] keys = {2, 1, 3};
		//Integer[] keys = {0, -1};
		Integer[] keys = {5, 1, 4, null, null, 3, 6};
		
		Node<Integer> tree = BinaryTree.buildDefault();
		
		Node<Integer> tree2 = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		
		//BinaryTree.printPreOrderRecursive(tree);
		//BinaryTree.printBFS(tree, true);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		//System.out.println(isItAValidBST(tree));
		System.out.println(isBSTLevelOrder(tree2));
		//System.out.println(isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}	
	
	/**
	 * A DFS Algorithm to validate the BST property of a Binary Tree.	 
	 */
	private static boolean isBST(Node<Integer> node, int min, int max) {
		
		if(node == null)
			return true;
		
		if(node.key < min || node.key > max)
			return false;
		
		return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
	}
	
	/**
	 * A BFS Algorithm to validate the BST property of a Binary Tree.
	 * It's a quite better algorithm in comparison to DFS because it
	 * validates the BST property for every parent node with it's 
	 * left and right child nodes so for any subtree if the BST   
	 * property fails then it's for sure that the tree isn't a BST.
	 * We don't have to go deeper if the BST property fails at 
	 * initial subtrees itself.	 
	 */
	private static boolean isBSTLevelOrder(Node<Integer> root) {
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(new TreeNode(root, null, null));
		
		TreeNode treeNode = null;
		
		while((treeNode = queue.poll()) != null) {
			
			if(treeNode.node != null) {
				
				if((treeNode.min != null && treeNode.node.key < treeNode.min) || 
					(treeNode.max != null && treeNode.node.key > treeNode.max)) {
					return false;
				}
				
				queue.add(new TreeNode(treeNode.node.left, treeNode.min, (long) treeNode.node.key-1));
				queue.add(new TreeNode(treeNode.node.right, (long) treeNode.node.key+1, treeNode.max));
			}			
		}
		return true;
	}
	
	private static class TreeNode {
		
		Long min, max;
		Node<Integer> node;
		
		public TreeNode(Node<Integer> node, Long min, Long max) {
			this.min = min;
			this.max = max;
			this.node = node;			
		}
	}
}