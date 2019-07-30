package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.LinkedList;
import java.util.List;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * TODO
 * 
 * @author gopi_karmakar
 *
 */
public class ConstructABinaryTreeFromLinkedList {

	public static void main(String[] args) {
		
		List<Integer> keys = new LinkedList<>();
		for(int x = 1; x <= 15; x++)
			keys.add(x);
				
		BinaryTree.printBFS(build(keys), true);
		//BinaryTree.printInOrderRecursive(tree, true);
	}
	
	@SuppressWarnings("unchecked")
	public static Node<Integer> build(List<Integer> list) {
		
		return null;
	}
}