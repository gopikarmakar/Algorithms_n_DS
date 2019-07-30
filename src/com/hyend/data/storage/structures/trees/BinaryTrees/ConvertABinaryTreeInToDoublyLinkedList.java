package com.hyend.data.storage.structures.trees.BinaryTrees;

import com.hyend.data.storage.structures.trees.BinaryTrees.BinaryTree.Node;

/**
 * Creating a doubly linked list from the keys of a
 * Binary Tree in InOrder fashion.
 * 
 * @author gopi_karmakar
 *
 */
public class ConvertABinaryTreeInToDoublyLinkedList {
	
	private static Link<String> head = null;
	private static Link<String> tail = null;	
	
	private static class Link<Key> {
		
		Key key;
		Link<Key> prev;
		Link<Key> next;
		
		Link(Key key) {
			this.key = key;
		}
	}
	
	public static void main(String[] args) {
		
		Node<String> tree = ConstructABinaryTreeFromAnArrayOfKeys.build();
		formDoubleyLinkedList(tree);

		Link<?> current = head;
		
		System.out.print("Head-to-Tail =");
		while(current != null) {
			System.out.print(" " + current.key);
			current = current.next;
		}
		
		System.out.print("\nTail-to-Head =");		
		current = tail;
		while(current != null) {
			System.out.print(" " + current.key);
			current = current.prev;
		}
	}
	
	/**
	 * The time complexity is O(n)
	 * 
	 * @param node
	 */
	private static void formDoubleyLinkedList(Node<String> node) {
		if(node == null)
			return;
		
		formDoubleyLinkedList(node.left);
		addNode(node);
		formDoubleyLinkedList(node.right);		
	}
	
	private static void addNode(Node<String> node) {
		
		Link<String> temp = tail;
		tail = new Link<String>(node.key);
		if(head == null) {
			head = tail;
			return;
		}
		temp.next = tail;
		tail.prev = temp;
	}
}