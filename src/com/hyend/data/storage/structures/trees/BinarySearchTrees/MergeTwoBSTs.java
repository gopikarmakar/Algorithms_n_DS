package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Merge two balanced BSTs to one.
 * 
 * BST-1:		17
 * 		5				23
 * 	2		11	
 * 
 * BST-2:	13
 * 		7		19
 * 	3			
 * 					
* BSTree:						11
 * 				5								19	
 * 		3				7				17				23
 * 	2								13
 *  
 * @author gopi_karmakar
 */
public class MergeTwoBSTs<K extends Comparable<K>, V> {

	public static void main(String[] args) {
		
		Integer[] arr1 = {2, 5, 11, 17, 23};
		Integer[] arr2 = {3, 7, 13, 19};	
		
		Node<Integer, ?> bst1 = BinarySearchTree.create(arr1);
		Node<Integer, ?> bst2 = BinarySearchTree.create(arr2);				
		
		Node<Integer, ?> bst = MergeTwoBSTs.mergeBSTs(bst1, bst2);
		
		BinarySearchTree.printLevelOrder(bst);
	}
	
	public static Node<Integer, ?> mergeBSTs(Node<Integer, ?> bst1, Node<Integer, ?> bst2) {
		
		ConvertBSTToSortedDoubleyLL<Integer, ?> bst = new ConvertBSTToSortedDoubleyLL<>();
		
		LinkedList<Node<Integer, ?>> ll1 = bst.get(bst1);		
		
		LinkedList<Node<Integer, ?>> ll2 = bst.get(bst2);
		
		LinkedList<Integer> dll = mergeLists(ll1, ll2);		
		
		return BinarySearchTree.create(dll);				
	}
	
	private static LinkedList<Integer> mergeLists(LinkedList<Node<Integer, ?>> ll1, LinkedList<Node<Integer, ?>> ll2) {
		
		LinkedList<Integer> dll = new LinkedList<>();
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		
		while(!ll1.isEmpty() || !ll2.isEmpty()) {
			
			if(!ll1.isEmpty())
				minPQ.add(ll1.poll().key);
			
			if(!ll2.isEmpty())
				minPQ.add(ll2.poll().key);
		}
		
		while(!minPQ.isEmpty()) {
			
			dll.add(minPQ.poll());
		}		
		return dll;
	}
}
