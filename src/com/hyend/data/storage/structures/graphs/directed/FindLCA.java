package com.hyend.data.storage.structures.graphs.directed;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;
import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree;

/**
 * Find the lowest common ancestor of two given vertices. 
 * 
 * For e.g: In below three the LCA of 3 and 4 is 1
 *	 			 	1
 * 				  /	  \
 * 		 		2		3
 * 			  /	  \   
 * 			4		5
 * 
 * @author gopi_karmakar
 */
public class FindLCA {

	/**
	 * TODO: Complete It.
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Integer[] keys = {1,2,3,4,5,null,null,null,null,null,null};
		Node<Integer> tree = (Node<Integer>) BinaryTree.build(BinaryTree.LEVEL_ORDER, keys);
		
		BinaryTree.printBFS(tree, true);
	}
}
