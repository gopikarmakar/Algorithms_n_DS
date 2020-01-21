package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Compute the Kth Node in an InOrder traversal.
 * 
 * @author gopi_karmakar
 */
public class FindKthNode {

	public static void main(String[] args) {
	
		Node<Integer> tree = BinaryTree.buildDefault();	
		BinaryTree.printBFS(tree, true);
		
		System.out.println(compuetKTh(tree, 2).key);
	}

	/**
	 * NOTE: Assume that each node stores the number of nodes
	 * in the subtree rooted at that node. 
	 * 
	 * The brute-force approach is to perform an InOrder walk, 
	 * keeping track of the number of visited nodes, 
	 * stopping when the node being visited is the Kth node.
	 * The time complexity will be O(n).
	 * 
	 * But we can improve the algorithm if we make use of the present information at each node.
	 * For example, if K is greater than the number of nodes in the left subtree, 
	 * the kth node cannot lie in the left subtree
	 * More precisely, if the left subtree has L nodes, then the Kth node is the (k - L)th node in
	 * original tree when we skip the left subtree. Conversely, if k < L, the desired node lies in the left subtree.
	 */
	private static Node<Integer> compuetKTh(Node<Integer> tree, int k) {
		
		Node<Integer> node = tree;
		
		while(node != null) {
			
			int leftSize = (node.left != null) ? node.left.size : 0;
			
			if(leftSize + 1 < k) {		// The Kth node must be in the right subtree.
				
				k -= leftSize + 1;
				node = node.right;
			}
			else if(leftSize == k-1) {	// Node = Kth
				return node;
			}
			else {						// Kth must be in left subtree. 
				node = node.left;
			}
		}	
		return null;
	}
}