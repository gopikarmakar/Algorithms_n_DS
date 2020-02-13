package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeTwoBSTs {

	public static void main(String[] args) {
		
		Integer[] arr1 = {2, 5, 11, 17, 23};
		Integer[] arr2 = {3, 7, 13, 19};
		
		Node<Integer, ?> bst1 = BinarySearchTree.create(arr1);
		Node<Integer, ?> bst2 = BinarySearchTree.create(arr2);
		
		mergeBSTs(bst1, bst2);
	}
	
	private static void mergeBSTs(Node<Integer, ?> bst1, Node<Integer, ?> bst2) {
		
		LinkedList<Node<Integer, ?>> ll1 = ConvertBSTToSortedDoubleyLL.get(bst1);
		
		System.out.println(ll1);
		
		LinkedList<Node<Integer, ?>> ll2 = ConvertBSTToSortedDoubleyLL.get(bst2);
		
		System.out.println(ll2);
		
		LinkedList<Integer> dll = mergeLists(ll1, ll2);	
		
		System.out.println(dll);		
		
		Node<Integer, ?> tree = BinarySearchTree.create(dll);
		
		BinarySearchTree.printLevelOrder(tree, false);
	}
	
	private static LinkedList<Integer> mergeLists(LinkedList<Node<Integer, ?>> ll1, LinkedList<Node<Integer, ?>> ll2) {
		
		LinkedList<Integer> dll = new LinkedList<>();
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		
		/*while(ll1.isEmpty() || ll2.isEmpty()) {
			
			if(!ll1.isEmpty())
				minPQ.add(ll1.poll().key);
			
			if(!ll2.isEmpty())
				minPQ.add(ll2.poll().key);
		}*/
		
		while(!ll2.isEmpty()) {
						
			minPQ.add(ll2.poll().key);
		}
		
		while(!minPQ.isEmpty()) {
			
			dll.add(minPQ.poll());
		}
		
		return dll;
	}
	
	private static class Compare {
		
		private static class Comparison implements Comparator<Node<Integer, ?>> {
			
			@Override
			public int compare(Node<Integer, ?> a, Node<Integer, ?> b) {
				
				return Integer.compare(a.key, b.key);
			}			
		}
		
		public static Comparison SMALLER_THAN = new Comparison();
	}
}
