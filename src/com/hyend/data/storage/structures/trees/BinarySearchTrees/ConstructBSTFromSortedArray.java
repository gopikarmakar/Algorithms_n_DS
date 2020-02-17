package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Construct a minimum height BST from a sorted array.
 * 
 * for e.g: array: {{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53}
 *  
 * BSTree:							 23
 *   		  		11             						41
 *   		5        		17         			31    			47
 *		3    	7    	13  	19   		29  	37    	43		53
 *	2     	
 * 
 * @author gopi_karmakar
 */
public class ConstructBSTFromSortedArray<K extends Comparable<K>, V> {

	private int index = 0;

	public static void main(String[] args) {

		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};	
		
		ConstructBSTFromSortedArray<Integer, ?> bst = new ConstructBSTFromSortedArray<>();
		
		Node<Integer, ?> root = bst.create(arr);	
		
		BinarySearchTree.printLevelOrder(root, true);
	}
	
	public Node<K, V> create(K[] arr) {
		
		index = 0;
		return construct(arr, 0, arr.length);
	}

	/**
	 * The algorithms spends O(1) time per node, leading to an O(n) time complexity. 
	 * No dynamic memory allocation is required. The maximum number of call frames  
	 * in the function call stack is log(n), yielding an O(log (n)) space complexity.
	 */
	private Node<K, V> construct(K[] arr, int start, int end) {

		if(start >= end)
			return null;

		int mid = start + (end - start) / 2;

		Node<K, V> left = construct(arr, start, mid);

		Node<K, V> current = new Node<>(arr[index], null);
		
		current.left = left;
		
		if(current.left != null)
			current.left.parent = current;
		
		index += 1;
		
		current.right = construct(arr, mid+1, end);
				
		if(current.right != null)
			current.right.parent = current;

		return current;
	}
}