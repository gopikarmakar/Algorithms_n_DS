package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Solution: To compute the sum of the binary numbers 
 * represented by the root-to-leaf paths.
 * 
 * 							1	
 * 					0				1
 * 				0		1		0		0	
 * 	    	  0	  1	  0	  1	  0	  0	  1   0
 * 
 * Each node of this Binary Tree contains a binary digit.
 * A root- to-leaf path can be associated with a binary number.
 * For E.g: ((1000)2 = 8) + ((1001)2 = 9) + ((1010)2 = 10) + ((1011)2 = 11), 
 * 			((1100)2 = 12) + ((1100)2 = 12) + ((1101)2 = 13) + ((1100)2 = 12) = 87
 * 			
 * 
 * @author gopi_karmakar
 */
public class SumRootToLeafPathOfABinaryTree {

	public static void main(String[] args) {
	
		int keys[] = {1,0,1,0,1,0,0,0,1,0,1,0,0,1,0};		
		int size = (keys!=null && keys.length > 0) ? keys.length : 0;
		
		Node<Integer> root = BinaryTree.create(BinaryTree.LEVEL_ORDER, size, keys);
		//BinaryTree.printInOrderRecursive(root, false);
		
		int sum = sumRootToLeafPath(root, 0);
		System.out.println("Root-To-Leaf Path Sum = " + sum);
	}
	
	/**
	 * To compute binary to decimal we take the integer for the node's parent, 
	 * double it, and add the bit at that node
	 * 
	 * Time and space complexity for this algorithm are 
	 * O(n) and O(h) respectively.
	 * 
	 * @param node
	 * @param partialPathSum
	 * @return
	 */
	private static int sumRootToLeafPath(Node<Integer> node, int partialPathSum) {
		
		if(node == null)
			return 0;
		
		partialPathSum = partialPathSum * 2 + node.key;
		if(node.left == null && node.right == null)	//Leaf
			return partialPathSum;
		
		//Non Leaf
		return sumRootToLeafPath(node.left, partialPathSum) +
			   sumRootToLeafPath(node.right, partialPathSum);
	}
}
