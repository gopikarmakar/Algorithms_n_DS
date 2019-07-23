package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * Creating a balanced Binary Tree by balancing the 
 * left and right subtrees weight equally.
 * 
 * @author gopi_karmakar
 */
public class BuildAWeightBalancedBinaryTree {
	
	public static void main(String[] args) {
		//int[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		BinaryTree.printBFS(build(), false);
	}
	
	public static BinaryTree.Node<Integer> build(int...keys) {
		if(keys == null || keys.length == 0) {
			keys = new int[15];
			for(int i = 0; i < 15; i++)
				keys[i] = i+1;
		}
		BinaryTree.Node<Integer> root = null; 
		for(int x : keys)
			root = addNode(root, x);
				
		return root;		
	}
	
	private static BinaryTree.Node<Integer> addNode(BinaryTree.Node<Integer> tree, int key) {
		
		if(tree == null) {
			tree = new BinaryTree.Node<Integer>(key);
			tree.weight += 1;
			return tree;
		}
		else {
			
			if(tree.left == null) {
				tree.left = addNode(tree.left, key);
			}
			else if(tree.right == null) {
				tree.right = addNode(tree.right, key);
			}
			else {
				if(tree.left.weight <= tree.right.weight) {
					tree.left = addNode(tree.left, key);
				}
				else {
					tree.right = addNode(tree.right, key);
				}
			}
		}		
		return tree;
	}
}
