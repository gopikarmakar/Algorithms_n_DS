package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Building a Binary Tree in level order fashion 
 * from an array or list of keys.
 * 							A
 * 				B							C	
 * 		D				E			F				G
 * 	H		I		J		K	L		M		N		O
 * 
 * @author gopi_karmakar
 */
public class BuildABinaryTreeFromAnArrayOfKeys {

	public static void main(String[] args) {		
		
		BinaryTree.printBFS(build(), true);
	}
	
	public static Node<String> build() {
		String[] keys = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
		return build(keys);
	}
	
	@SuppressWarnings("unchecked")
	public static Node<String> build(String...keys) {		
		return (Node<String>) BinaryTree.create(BinaryTree.LEVEL_ORDER, (Object[]) keys);
	} 
}
