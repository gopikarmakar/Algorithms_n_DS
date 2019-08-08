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

	public static void main(String[] args) {	
		//Integer[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		Node<Integer> root = buildDecimalBT();
		//BinaryTree.printBFS(root, true);
		BinaryTree.printInOrderRecursive(root, true);
		//BinaryTree.printPreOrderRecursive(root, true);
	}
	
	public static Node<Integer> buildDecimalBT(Integer...keys) {		
		LevelOrderBT<Integer> bt = new LevelOrderBT<>();
		return bt.build(keys);
	}
	
	public static Node<String> buildStringBT(String...keys) {		
		LevelOrderBT<String> bt = new LevelOrderBT<>();
		return bt.build(keys);
	}
	
	private static class LevelOrderBT<K> {							
		
		@SuppressWarnings("unchecked")
		public Node<K> build(K...keys) {			
			return levelOrederBTCreation(keys, null, null, 0);
		}
		
		int size = 0;
		private Node<K> levelOrederBTCreation(K[] keys, 
				Node<K> parent, Node<K> node, int i) {
			
			if(i < keys.length) {	
				if(node == null) {
					if(keys[i] == null) return node;
					
					node = new Node<K>(keys[i]);					
					size+=1;
					node.size = size;
					node.parent = parent;					
				}				
				node.left = levelOrederBTCreation(keys, node, node.left, (i*2)+1);			
				node.right = levelOrederBTCreation(keys, node, node.right, (i*2)+2);
			}
			return node;
		}
	}
}