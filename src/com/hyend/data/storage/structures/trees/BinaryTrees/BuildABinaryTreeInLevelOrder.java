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
 *  Variant: Build a minimum height BT from an array/list of values.
 *  
 * @author gopi_karmakar
 */
public class BuildABinaryTreeInLevelOrder<K> {

	public static void main(String[] args) {	
		
		Integer[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		BuildABinaryTreeInLevelOrder<Integer> levelOrderBT = new BuildABinaryTreeInLevelOrder<>();
		Node<Integer> tree = levelOrderBT.build(keys);
		
		BinaryTree.printBFS(tree, true);
		//BinaryTree.printInOrderRecursive(tree, true);
		//BinaryTree.printPreOrderRecursive(tree, true);
	}
	
	@SuppressWarnings("unchecked")
	public Node<K> build(K...keys) {			
		return build(keys, null, null, 0);
	}
	
	int size = 0;
	private Node<K> build(K[] keys, 
			Node<K> parent, Node<K> node, int i) {
		
		if(i < keys.length) {	
			if(node == null) {
				if(keys[i] == null) return node;
				
				node = new Node<K>(keys[i]);					
				size+=1;
				node.size = size;
				node.parent = parent;					
			}				
			node.left = build(keys, node, node.left, (i*2)+1);			
			node.right = build(keys, node, node.right, (i*2)+2);
		}
		return node;
	}
}