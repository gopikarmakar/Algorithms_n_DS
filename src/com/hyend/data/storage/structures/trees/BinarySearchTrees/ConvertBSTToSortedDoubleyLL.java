package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.LinkedList;

import com.hyend.data.storage.structures.linkedlists.doubly.DoublyLinkedList;

/**
 * Converting a BST to Sorted Doubly LinkedL List;
 * 
 * @author gopi_karmakar
 */
public class ConvertBSTToSortedDoubleyLL<K extends Comparable<K>, V> {
	
	public static void main(String[] args) {
		
		Node<Integer, ?> tree = BinarySearchTree.createDefault();
		
		ConvertBSTToSortedDoubleyLL<Integer, ?> bst = new ConvertBSTToSortedDoubleyLL<>();
		
		DoublyLinkedList<Node<Integer, ?>> dll = new DoublyLinkedList<>();
		
		bst.convert(tree, dll);
		bst.print(DoublyLinkedList.FORWARD, dll);
	}
	
	public LinkedList<Node<Integer, ?>> get(Node<Integer, ?> bst) {
		
		LinkedList<Node<Integer, ?>> dll = new LinkedList<>();
		convert(bst, dll);
		return dll;
	}
	
	/**
	 * O(n) time complexity recursive InOrder solution.
	 */
	private void convert(Node<Integer, ?> node, DoublyLinkedList<Node<Integer, ?>> dll) {
	
		if(node == null) return;
		
		convert(node.left, dll);
		dll.add(node);		
		convert(node.right, dll);
	}
	
	private void convert(Node<Integer, ?> node, LinkedList<Node<Integer, ?>> dll) {
		
		if(node == null) return;
		
		convert(node.left, dll);
		dll.add(node);		
		convert(node.right, dll);
	}
	
	private void print(int order, DoublyLinkedList<Node<Integer, ?>> dll) {				
		
		dll.printAllNodes(order);			
	}
}
