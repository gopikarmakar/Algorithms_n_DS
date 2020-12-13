package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * A Facebook Interview Question
 * 
 * Each node of this Binary Tree contains a binary digit.
 * Compute the sum of the binary numbers represented by the root-to-leaf paths.
 * 							1	
 * 					0				1
 * 				0		1		0		0	
 * 	    	  0	  1	  0	  1	  0	  0	  1   0
 * 
 * A Root-to-Leaf path can be associated with a binary number.
 * For E.g: ((1000)2 = 8) + ((1001)2 = 9) + ((1010)2 = 10) + ((1011)2 = 11), 
 * 			((1100)2 = 12) + ((1100)2 = 12) + ((1101)2 = 13) + ((1100)2 = 12) = 87
 * 			
 * Variant: Compute Root-to-Leaf path sum for a decimal valued Binary Tree.
 * 								1
 * 				2								3
 * 		4				5 				6	 			7
 * 	8   	9 		10		11  	12		13 		14		15
 *  
 * A Root-to-Leaf Path and Sum
 * For e.g: ((1+2+4+8) = 15) + ((1+2+4+9) = 16) + ((1+2+5+10) = 18) + ((1+2+5+11) = 19) +
 * ((1+3+6+12) = 22) + ((1+3+6+13) = 23) + ((1+3+7+14) = 25) + ((1+3+7+15) = 26) = 164 
 * 
 * @author gopi_karmakar
 */
public class RootToLeafPathSumI {
	
	private static final int BINARY = 1;
	private static final int DECIMAL = 2;	
		
	public static void main(String[] args) {		
		
		int sum = 0;
		sum = testDecimalBinaryTree();		
		System.out.println("Root-To-Leaf Path Sum = " + sum);
		
		Integer keys[] = {1,0,1,0,1,0,0,0,1,0,1,0,0,1,0}; // Keys for Binary digit tree 
		sum = testBinaryDigitBinaryTree(keys);		
		System.out.println("Root-To-Leaf Path Sum = " + sum);
	}

	private static int testDecimalBinaryTree() {
		
		Node<Integer> root = BinaryTree.buildDefault();		
		return sumRootToLeafPath(DECIMAL, root, 0);		
	}
	
	private static int testBinaryDigitBinaryTree(Integer...keys) {
		
		Node<Integer> root = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);		
		return sumRootToLeafPath(BINARY, root, 0);
	}
	
	/**
	 * Solution 1 and 2 : To Compute binary to decimal we take the 
	 * integer for the node's parent, double it, and add the bit at that node
	 * 
	 * Time and space complexity for this algorithm are 
	 * O(n) and O(h) respectively.
	 */
	private static int sumRootToLeafPath(int type, Node<Integer> node, int partialPathSum) {
		
		if(node == null)
			return 0;
		
		if(type == DECIMAL) 		partialPathSum += node.key;		
		else if(type == BINARY)		partialPathSum = partialPathSum * 2 + node.key;
						
		if(node.left == null && node.right == null)	//Leaf
			return partialPathSum;
		
		//Non Leaf
		return sumRootToLeafPath(type, node.left, partialPathSum) +
			   sumRootToLeafPath(type, node.right, partialPathSum);
	}
}