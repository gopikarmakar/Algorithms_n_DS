package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * Two different solutions to find a Lowest Common Ancestor 
 * for two different nodes in a Binary Tree. 
 * 
 * @author gopi_karmakar
 *
 */
public class FindLCAInBinaryTree {
	
	public static void main(String[] args) {
		
		BinaryTree.Node<Integer> root = buildTree();
		//BinaryTree.printBFS(root);
		int node1 = 9, node2 = 5;
		BinaryTree.Node<Integer> ancestor = findLCAWithoutParent(root, node1, node2).ancestor;		
		System.out.println("LCA for " + node1 + " and " + node2 + " = " + ancestor.key);
	}
	
	private static class Status {
	
		public int numTargetNodes;
		public BinaryTree.Node<Integer> ancestor;
		
		public Status(int numTargetNodes, BinaryTree.Node<Integer> node) {
			this.numTargetNodes = numTargetNodes;
			this.ancestor = node;
		}
	}
	
	/**
	 * 1: Find LCA when there's no track of
	 * parent for any child node
	 * 
	 * This Algorithm is structurally similar 
	 * to a recursive PostOrder traversal
	 * 
	 * The time complexity for this algorithm is O(n) 
	 * and the space complexity is O(h) where h is the height of the tree.	 
	 * 
	 * @param root
	 * @param node1
	 * @param node2
	 * @return
	 */
	private static Status findLCAWithoutParent(BinaryTree.Node<Integer> root, int node1, int node2) {
		
		if(root == null) {
			return new Status(0, null);
		}
		
		Status leftResult = findLCAWithoutParent(root.left, node1, node2);
		if(leftResult.numTargetNodes == 2)
			return leftResult;		//Found both nodes in the left subtree.
		
		Status rightResult = findLCAWithoutParent(root.right, node1, node2);
		if(rightResult.numTargetNodes == 2)
			return rightResult;		//Found both nodes in the right subtree.
		
		int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes +
				((root.key == node1) ? 1 : 0) + ((root.key == node2) ? 1 : 0);
		
		return new Status(numTargetNodes, ((numTargetNodes == 2) ? root : null));
	}
	
	/**
	 * 2: Find LCA when there's a track of
	 * parent for every child node
	 * 
	 * @return
	 */
	private static Status findLCAWithParent() {
		
		return null;		
	}
	
	private static BinaryTree.Node<Integer> buildTree() {	
		/*BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(1);
		root.left = new BinaryTree.Node<Integer>(2);
		root.right = new BinaryTree.Node<Integer>(3);
		root.left.left = new BinaryTree.Node<Integer>(4);
		root.left.right = new BinaryTree.Node<Integer>(5);
		root.right.left = new BinaryTree.Node<Integer>(6);
		root.right.right = new BinaryTree.Node<Integer>(7);
		root.left.left.left = new BinaryTree.Node<Integer>(8);
		return root;*/
		int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		return BuildABinaryTreeFromAnArrayOfKeys.build(keys);
	}		
}
