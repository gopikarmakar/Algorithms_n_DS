package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * 								1
 * 				2								3
 * 		4				5 				6	 			7
 *  
 * A Root-to-Leaf Path and Sum
 * For e.g: ((124) + (125) + (136) + (137)) = 522 
 * 
 * @author gopi_karmakar
 */
public class RootToLeafPathSum {

	public static void main(String[] args) {
		
		Integer keys[] = {1, 2, 3, 4, 5, 6, 7};
		
		Node<Integer> root = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		
		System.out.println(pathSum(root, 0));
	}
	
	/**
	 * Efficient solution
	 * Accepted in Leetcode with 0ms 100% runtime.
	 */
	private static int pathSum(Node<Integer> node, int partialSum) {
		
		if(node == null)
			return 0;
		
		partialSum = partialSum * 10 + node.key;
		
		if(node.left == null && node.right == null)
			return partialSum;
		
		return pathSum(node.left, partialSum) + 
				pathSum(node.right, partialSum);
	}
}
