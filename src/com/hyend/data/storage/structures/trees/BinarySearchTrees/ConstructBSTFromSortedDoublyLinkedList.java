package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Convert a sorted double linked list to a balanced binary search tree
 * for e.g: DLL: 1<==>2<==>3<==>4<==>5<==>6<==>7<==>8<==>9<==>10 
 * BSTree:						6
 * 				3								9	
 * 		2				5				8				10
 * 	1				4				7
 * 
 * @author gopi_karmakar
 */
public class ConstructBSTFromSortedDoublyLinkedList<K extends Comparable<K>, V> {

	public static void main(String[] args) {
		
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};	
		
		// Java's LinkedList is basically a DoubleyLinkedList
		LinkedList<Integer> dll = new LinkedList<>(Arrays.asList(arr)); 
		
		ConstructBSTFromSortedDoublyLinkedList<Integer, ?> bst = 
				new ConstructBSTFromSortedDoublyLinkedList<>();
		
		Node<Integer, ?> root = bst.create(dll);
		
		BinarySearchTree.printLevelOrder(root, true);
	}
	
	public Node<K, V> create(LinkedList<K> dll) {
		
		return construct(dll, 0, dll.size());
	}
	
	private Node<K, V> construct(LinkedList<K> dll, int start, int end) {
		
		if(start >= end)
			return null;
		
		int mid = start + (end - start) / 2;
		
		Node<K, V> left = construct(dll, start, mid);
		
		Node<K, V> current = new Node<>(dll.poll(), null);
		
		current.left = left;
		
		if(current.left != null)
			current.left.parent = current;
		
		current.right = construct(dll, mid + 1, end);
		
		if(current.right != null)
			current.right.parent = current;
		
		return current;
	}
}
