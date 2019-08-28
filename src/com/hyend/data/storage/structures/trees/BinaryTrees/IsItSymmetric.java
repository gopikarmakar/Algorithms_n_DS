package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * A solution to check whether a Binary Tree is symmetric.  
 *  
 * @author gopi_karmakar
 */
public class IsItSymmetric {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Integer[] correctKeys = {1,2,2,4,5,5,4,8,9,10,11,11,10,9,8};
		//Integer[] wrongKeys = {1,2,3,4,5,5,4,8,9,9,8,10,11,11,10};		
		
		Node<Integer> tree = (Node<Integer>) BinaryTree.createDefault(BinaryTree.LEVEL_ORDER, (Object[]) correctKeys);
		System.out.println("Is It A Symmetry = " + isItASymmetry(tree.left, tree.right));
	}
	
	/**
	 * A better algorithm is we do not need to construct the mirrored subtrees.
	 * All that is important is whether a pair of subtrees are mirror images. 
	 * As soon as a pair fails the test, we can short circuit the check to false.
	 * 
	 * The time and space complexities are O(n) and O(h) respectively.
	 * Where n is the number of nodes and h is the height.
	 *  
	 * @param BinaryTree.Node<Key> leftSubTree
	 * @param BinaryTree.Node<key> rightSubTree
	 * @return
	 */
	public static boolean isItASymmetry(Node<Integer> leftSubTree, Node<Integer> rightSubTree) { 
		
		if(leftSubTree == null && rightSubTree == null) {
			return true; 
		}
		else if(leftSubTree != null && rightSubTree != null) {
			
			 return (leftSubTree.key == rightSubTree.key) && 
					 isItASymmetry(leftSubTree.left, rightSubTree.right) &&
					 isItASymmetry(leftSubTree.right, rightSubTree.left);
		}
		// One subtree is empty, and the other is not.
		return false;
	}
}