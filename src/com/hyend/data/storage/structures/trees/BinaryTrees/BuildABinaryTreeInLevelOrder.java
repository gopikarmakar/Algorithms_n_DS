package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Creating a balanced Binary Tree by adding the
 * nodes in BFS or level order fashion with the 
 * track of each node's parent.
 * 
 * 								1
 * 				2								3
 * 		4				5 				6	 			7
 * 	8   	9 		10		11  	12		13 		14		15
 *  
 *  Root-to-Leaf Path and Sum
 *  1,2,4,8 + 1,2,4,9, + 1,2,5,10 + 1,2,5,11 + 1,3,6,12 + 1,3,6,13 + 1,3,7,14 + 1,3,7,15
 *  15+16++18+19+22+23+25+26 = 164
 *  
 * @author gopi_karmakar
 */
public class BuildABinaryTreeInLevelOrder {
	
	private static final int DEFAULT_SIZE = 15;
	
	public static void main(String[] args) {	
		int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		BinaryTree.Node<Integer> root = build(15);
		//BinaryTree.printBFS(root, true);
		BinaryTree.printInOrderRecursive(root, true);
		//BinaryTree.printPreOrderRecursive(root, true);
	}
	
	public static BinaryTree.Node<Integer> build(int...keys) {
		if(keys == null || keys.length == 0) {
			keys = new int[DEFAULT_SIZE];
			for(int i = 0; i < DEFAULT_SIZE; i++)
				keys[i] = i+1;
		}
		return levelOrederBTCreation(keys, null, null, 0);
	}
	
	private static BinaryTree.Node<Integer> levelOrederBTCreation(int[] keys, 
			Node<Integer> parent, Node<Integer> node, int i) {		
		if(i < keys.length) {	
			if(node == null) {				
				node = new BinaryTree.Node<Integer>(keys[i]);
				node.parent = parent;
			}
			node.left = levelOrederBTCreation(keys, node, node.left, (i*2)+1);			
			node.right = levelOrederBTCreation(keys, node, node.right, (i*2)+2);
		}
		return node;
	}
}