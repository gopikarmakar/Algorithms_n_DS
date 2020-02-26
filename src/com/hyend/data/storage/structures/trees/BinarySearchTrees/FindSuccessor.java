package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * 
 * @author gopi_karmakar
 */
public class FindSuccessor {

	public static void main(String[] args) {
		
		Node<?, ?> bst = BinarySearchTree.createDefault();
		Node<?, ?> s = successor(bst); 
		System.out.println(s);
	}
	
	public static Node<?, ?> successor(Node<?, ?> node) {
		
		Node<?, ?> successor = node;
		
		if(successor.right != null) {
			
			successor = successor.right;
			
			while(successor.left != null) {
				successor = successor.left;
			}
		}
		else {
			successor = node.left;
		}
		
		return successor;
	}
}
