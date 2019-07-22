package com.hyend.data.storage.structures.trees.BinaryTrees;


/**
 * Creating a balanced Binary by balancing the
 * subtrees in BFS or level order fashion.
 *  
 * @author gopi_karmakar
 *
 */
public class BuildABinaryTreeInLevelOrder {

	public static void main(String[] args) {			
		BinaryTree.Node<Integer> root = build();
		//BinaryTree.printBFS(root);
		BinaryTree.printInOrderRecursive(root);
	}
	
	public static BinaryTree.Node<Integer> build() {
		int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		return build(keys);
	}
	
	public static BinaryTree.Node<Integer> build(int...keys) {			
		return levelOrederBTCreation(keys, null, 0);
	}
	
	private static BinaryTree.Node<Integer> levelOrederBTCreation(int[] keys, BinaryTree.Node<Integer> root, int i) {		
		if(i < keys.length) {			
			if(root == null)
				root = new BinaryTree.Node<Integer>(keys[i]);			
			root.left = levelOrederBTCreation(keys, root.left, (i*2)+1);			
			root.right = levelOrederBTCreation(keys, root.right, (i*2)+2);
		}
		return root;
	}
}