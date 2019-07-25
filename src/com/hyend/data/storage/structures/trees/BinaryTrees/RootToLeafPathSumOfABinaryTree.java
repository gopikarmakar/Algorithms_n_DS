package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Solutions-1: To compute the sum of the binary numbers 
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
 * Solutions-2: Root- to-Leaf path sum for a decimal valued Binary Tree. 
 * 
 * @author gopi_karmakar
 */
public class RootToLeafPathSumOfABinaryTree {
	
	private static final int DECIMAL = 1;
	private static final int BINARY_DIGIT = 2;
	

	public static void main(String[] args) {		
		int sum = 0;
		//sum = testDecimalBinaryTree();		
		Integer keys[] = {1,0,1,0,1,0,0,0,1,0,1,0,0,1,0}; // Keys for Binary digit tree 
		sum = testBinaryDigitBinaryTree(keys);		
		System.out.println("Root-To-Leaf Path Sum = " + sum);
	}
	
	@SuppressWarnings("unchecked")
	private static int testDecimalBinaryTree() {
		Node<Integer> root = (Node<Integer>) BinaryTree.create(BinaryTree.LEVEL_ORDER);		
		return sumRootToLeafPath(DECIMAL, root, 0);		
	}
	
	@SuppressWarnings("unchecked")
	private static int testBinaryDigitBinaryTree(Integer...keys) {	
		Node<Integer> root = (Node<Integer>) BinaryTree.create(BinaryTree.LEVEL_ORDER, (Object[])keys);		
		return sumRootToLeafPath(BINARY_DIGIT, root, 0);
	}
	
	/**
	 * Solution 1 and 2 : Compute binary to decimal we take the 
	 * integer for the node's parent, double it, and add the bit at that node
	 * 
	 * Time and space complexity for this algorithm are 
	 * O(n) and O(h) respectively.
	 * 
	 * @param node
	 * @param partialPathSum
	 * @return
	 */
	private static int sumRootToLeafPath(int type, Node<Integer> node, int partialPathSum) {
		
		if(node == null)
			return 0;
		
		if(type == DECIMAL) 			partialPathSum += node.key;		
		else if(type == BINARY_DIGIT)	partialPathSum = partialPathSum * 2 + node.key;
						
		if(node.left == null && node.right == null)	//Leaf
			return partialPathSum;
		
		//Non Leaf
		return sumRootToLeafPath(type, node.left, partialPathSum) +
			   sumRootToLeafPath(type, node.right, partialPathSum);
	}
}