package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import com.hyend.data.storage.structures.trees.BinarySearchTrees.BinarySearchTree.Node;

/**
 * Given a BST and two BST nodes, find the LCA of given nodes. 
 *
 * Solution: Unlike PostOrderly searching for LCA in BT, 
 * for LCA in BST we'll make use of BST property to find LCA.
 * 
 * @author gopi_karmakar
 */
public class FindLCA {

	public static void main(String[] args) {
		
		Node<Integer, ?> tree = BinarySearchTree.createDefault();
		Node<Integer, ?> node1 = tree.left.right.left.left;
		Node<Integer, ?> node2 = tree.left.right.right;
				
		Node<Integer, ?> lca = null;
		
		/**
		 * The basic four cases for a LCA in BST.
		 */
		if(node1.key == tree.key || node2.key == tree.key)
			lca = tree;			
		else if((node1.key < tree.key && node2.key > tree.key) ||
				(node2.key < tree.key && node1.key > tree.key))
			lca = tree;	
		else if(node1.key < tree.key && node2.key < tree.key)
			tree = tree.left;
		else if(node1.key > tree.key && node2.key > tree.key)
			tree = tree.right;
		
		/**
		 * If the first two cases didn't satisfy then,
		 * LCA is either in left or in right subtree.
		 * Assuming that given Nodes are not null and 
		 * always will be, node1 <= node2.
		 */
		if(lca == null)			
			lca = findLCA(tree, node1, node2);
		
		System.out.println("LCA = " + lca.key);		
	}
	
	/**
	 * Time complexity will is O(h) where h is the height of the BST.
	 * 
	 * @param tree
	 * @param node1
	 * @param node2
	 * @return
	 */
	private static Node<Integer, ?> findLCA(Node<Integer, ?> tree, 
											Node<Integer, ?> node1,
											Node<Integer, ?> node2) {				
		Node<Integer, ?> p = tree;
		
		/**
		 * Assuming node1 <= node2
		 */
		while(p.key < node1.key || p.key > node2.key) {
			
			while(p.key < node1.key) 
				p = p.right; // LCA must be in p’s right child.
			
			while(p.key > node2.key) 
				p = p.left; // LCA must be in p’s left child.
		}
		
		/**
		 * By Here, node1 < p < node2.
		 * So, P is the LCA for node1 and node2.
		 */
		return p;			
	}
}