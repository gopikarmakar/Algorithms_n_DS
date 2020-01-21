package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;

/**
 * Creating a balanced Binary Tree by adding the
 * nodes in BFS or level order fashion with the 
 * track of each node's parent.
 * 
 * 								341
 * 				6								6
 * 		271				561 			2	 			271
 * 	28   	0 				3  				 1 				28
 * 						17				401     257
 * 										   641
 *  
 *  
 * Variant: Build a minimum height BT from an array/list of values.
 *  
 * @author gopi_karmakar
 */
public class BuildABinaryTreeInLevelOrder<K> {

	public static void main(String[] args) {
				
		Node<Integer> tree = buildDefault();
		
		BinaryTree.printBFS(tree, true);
		//BinaryTree.printInOrderRecursive(tree, true);
		//BinaryTree.printPreOrderRecursive(tree, true);
	}
	
	public static Node<Integer> buildDefault() {	
		
		Integer[] keys = {314,6,6,271,561,2,271,28,0,null,3,null,1,null,28,null,null,null,null,null,null,17,null,null,null,401,257,null,null,null,null};
		
		BuildABinaryTreeInLevelOrder<Integer> tree = new BuildABinaryTreeInLevelOrder<>();
		Node<Integer> root = tree.build(keys);
		Node<Integer> parent = root.right.left.right.left;
		parent.right = new Node<>(641, parent);
		
		return root;
	}
	
	public Node<K> build(K[] keys) {			
		return build(keys, null, null, 0);
	}
	
	int size = 0;
	private Node<K> build(K[] keys, Node<K> parent, Node<K> node, int i) {
		
		if(i < keys.length) {
			
			if(keys[i] == null) return null;
			
			if(node == null) {								
				
				node = new Node<K>(keys[i], parent);								
			}				
			node.left = build(keys, node, node.left, (i*2)+1);			
			node.right = build(keys, node, node.right, (i*2)+2);
		}
		return node;
	}
}