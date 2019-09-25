package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Two different solutions to find a Lowest Common Ancestor 
 * for two different nodes of a Binary Tree. 
 * 
 * 1: When a child node have no track of it's parent node 
 * 2: When a child node have track of it's parent node
 * 
 * @author gopi_karmakar
 *
 */
public class FindLCA {
	
	public static void main(String[] args) {
				
		Node<Integer> tree = BinaryTree.buildDefault();
		//BinaryTree.printBFS(tree, true);
		
		Node<Integer> node1 = tree.left.right.right;
		//Node<Integer> node2 = tree.right.right;
		Node<Integer> node2 = tree.left.left.right;

		Node<Integer> lca = findLCAWithoutParent(tree, node1, node2).ancestor;	
		
		//Node<Integer> lca = findLCAWithParent(node1, node2);
		
		System.out.println("LCA for " + node1.key + " and " + node2.key + " = " + lca.key);
	}
	
	private static class Status {
	
		public int numTargetNodes;
		public Node<Integer> ancestor;
		
		public Status(int numTargetNodes, Node<Integer> node) {
			this.numTargetNodes = numTargetNodes;
			this.ancestor = node;
		}
	}
	
	/**
	 * 1: Find LCA when there's no track of parent node
	 * 
	 * This Algorithm is structurally similar 
	 * to a recursive PostOrder traversal
	 * 
	 * The time complexity for this algorithm is O(n) 
	 * and the space complexity is O(h) where h is the height of the tree.
	 */
	private static Status findLCAWithoutParent(Node<Integer> node, 
			Node<Integer> node1, Node<Integer> node2) {
		
		if(node == null) {
			return new Status(0, null);
		}
		
		Status leftResult = findLCAWithoutParent(node.left, node1, node2);
		if(leftResult.numTargetNodes == 2)
			return leftResult;		//Found both nodes in the left subtree.
		
		Status rightResult = findLCAWithoutParent(node.right, node1, node2);
		if(rightResult.numTargetNodes == 2)
			return rightResult;		//Found both nodes in the right subtree.
		
		int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes +
				((node == node1) ? 1 : 0) + ((node == node2) ? 1 : 0);
		
		return new Status(numTargetNodes, ((numTargetNodes == 2) ? node : null));
	}
	
	/**
	 * 2: Find LCA when there's a track of
	 * parent node for every child node.
	 * An iterative approach.x
	 */
	private static Node<Integer> findLCAWithParent(Node<Integer> node1, Node<Integer> node2) {
		
		int depth1 = getDepth(node1);
		int depth2 = getDepth(node2);
		
		// Makes node1 as the deeper node in order to simplify the code.
		if(depth2 > depth1) {
			Node<Integer> temp = node1;
			node1 = node2;
			node2 = temp;
		}
		
		// Ascends from the deeper node.
		int depthDiff = Math.abs(depth1 - depth2);
		while(depthDiff-- > 0) {
			node1 = node1.parent;
		}
		
		// Now ascends both nodes until we reach the LCA.
		while(node1 != node2) {
			node1 = node1.parent;
			node2 = node2.parent;
		}		
		return node1;
	}
	
	private static int getDepth(Node<Integer> node) {
		
		int depth = 0;
		
		while(node.parent!= null) {
			depth++;
			node = node.parent;			
		}
		return depth;
	}
}