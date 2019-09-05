package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Given a Binary Tree count Uni-Value sub trees.
 * 
 * A Uni-Value tree is a tree where the root and it's
 * both left and right children values are the same.
 * 
 * 					5
 * 			1				5
 * 		5		5				5
 * 									5
 * There are 5 Uni-Value subtrees to the above tree. 
 * Since a root with both of it's null children(a leaf)  
 * is an Uni-Val sub tree too.
 * 
 * @author gopi_karmakar
 */
public class CountUniValueSubTrees {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Integer[] keys = {5,1,5,5,5,null,5,null,null,null,null,null,null,null,5};
		Node<Integer> tree = (Node<Integer>) BinaryTree.build(BinaryTree.LEVEL_ORDER, keys);
			
		CountUniValueSubTrees uniVal = new CountUniValueSubTrees();
		uniVal.countUniVal(tree);
		
		System.out.println(uniVal.count);
	}
	
	/**
	 * O(n) time complexity
	 */
	int count = 0;
	public boolean countUniVal(Node<Integer> root) {
		
		if(root == null)
			return true;
		
		boolean isLeft 	= countUniVal(root.left);
		boolean isRight = countUniVal(root.right);
		
		if(root.left != null && root.key != root.left.key) 
			return false;

		if(root.right != null && root.key != root.right.key)
			return false;
		
		if (!isLeft || !isRight) {
			return false;
		}
		
		count++;
		return true;
	}
}
