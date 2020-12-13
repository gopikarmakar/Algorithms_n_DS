package com.hyend.data.storage.structures.trees.BinarySearchTrees;

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
		
		Node<Integer, ?> root = BinarySearchTree.createDefault();
		
		//Node<Integer, ?> node1 = root.left.left.right;
		Node<Integer, ?> node1 = root.left.right;
		System.out.println(node1.key);
		
		Node<Integer, ?> node2 = root.left.right.right;
		System.out.println(node2.key);
				
		Node<Integer, ?> lca = null;
		
		if(node1.key > node2.key) {			
			Node<Integer, ?> temp = node1;
			node1 = node2;
			node2 = temp;
		}
		
		/**
		 * The basic four cases for a LCA in BST.
		 */
		if(node1.key == root.key || node2.key == root.key) {
			lca = root;			
		}
		else if((node1.key < root.key && node2.key > root.key) ||
				(node2.key < root.key && node1.key > root.key)) {
			lca = root;
		}
		else if(node1.key < root.key && node2.key < root.key) {
			root = root.left;
		}
		else if(node1.key > root.key && node2.key > root.key) {
			root = root.right;
		}
		
		/**
		 * If the first two cases didn't satisfy then,
		 * LCA is either in left or in right subtree.
		 * Assuming that given Nodes are not null and 
		 * always will be, node1 <= node2.
		 */
		if(lca == null)			
			lca = findLCA(root, node1, node2);
		
		System.out.println("LCA = " + lca.key);		
	}
	
	/**
	 * Time complexity will is O(h) where h is the height of the BST.
	 */
	private static Node<Integer, ?> findLCA(Node<Integer, ?> root, 
											Node<Integer, ?> node1,
											Node<Integer, ?> node2) {				
		Node<Integer, ?> p = root;
				
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