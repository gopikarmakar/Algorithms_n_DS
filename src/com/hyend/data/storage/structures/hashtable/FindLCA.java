package com.hyend.data.storage.structures.hashtable;

import java.util.Set;
import java.util.HashSet;
import java.util.NoSuchElementException;

import com.hyend.data.storage.structures.trees.BinaryTrees.Node;
import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree;

/**
 * Fins the LCA of two given binary nodes.
 * 
 * @author gopi_karmakar
 */
public class FindLCA {

	public static void main(String[] args) {
		
		Node<Integer> tree = BinaryTree.buildDefault();
		//Node<Integer> node1 = tree.left.left.right;
		Node<Integer> node1 = tree.left.left.right;
		//Node<Integer> node1 = tree.left.right.right;
		//Node<Integer> node2 = tree.left.right.right.left;
		Node<Integer> node2 = tree.right.left.right;
		
		System.out.println("Common LCA = " + findLCA(node1, node2).key);		
	}
	
	/**
	 * An efficient solution since we are trading space for time
	 * The recursive LCA without parent solution in Binary Tree 
	 * takes O(1) space and O(h) time where h is the height of the tree.
	 * 
	 * Where this solution takes O(D1+D2) space and time 
	 * where D1 and D2 is the distance from the LCA to the node1 and node2.
	 * In the worst-case, if the nodes are leaves whose LCA is the root, 
	 * then we end up using O(h) space and time where h is the height of the tree.
	 */
	public static Node<Integer> findLCA(Node<Integer> node1, Node<Integer> node2) {
		
		Set<Node<Integer>> set = new HashSet<>();
		
		while(node1 != null && node2 != null) {
			
			if(node1 != null) {
				
				if(!set.add(node1)) {
					return node1;
				}
				node1 = node1.parent;				
			}
			
			if(node2 != null) {
				
				if(!set.add(node2)) {
					return node2;
				}
				node2 = node2.parent;
			}
		}
		
		throw new NoSuchElementException("No LCA Exist!");
	}
}
