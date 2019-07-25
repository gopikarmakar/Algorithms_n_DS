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
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {	
		//Integer[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		Node<Integer> root = (Node<Integer>) build();
		//BinaryTree.printBFS(root, true);
		BinaryTree.printInOrderRecursive(root, true);
		//BinaryTree.printPreOrderRecursive(root, true);
	}
	
	public static Node<?> build(Object...keys) {
		if(keys == null || keys.length == 0) {
			keys = new Object[DEFAULT_SIZE];
			for(int i = 0; i < DEFAULT_SIZE; i++)
				keys[i] = i+1;
		}
		return levelOrederBTCreation(keys, null, null, 0);
	}
	
	@SuppressWarnings("unchecked")
	private static Node<?> levelOrederBTCreation(Object[] keys, 
			Node<Object> parent, Node<Object> node, int i) {		
		if(i < keys.length) {	
			if(node == null) {				
				node = new Node<Object>(keys[i]);
				node.parent = (Node<Object>) parent;
			}
			node.left = (Node<Object>) levelOrederBTCreation(keys, node, node.left, (i*2)+1);			
			node.right = (Node<Object>) levelOrederBTCreation(keys, node, node.right, (i*2)+2);
		}
		return node;
	}
}