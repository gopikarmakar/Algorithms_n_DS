package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the K large elements of BST 
 *   
 * @author gopi_karmakar
 */
public class FindKLargeElements {

	public static void main(String[] args) {
		
		Node<Integer, ?> bst = BinarySearchTree.createDefault();
		
		List<Integer> list = new ArrayList<>();
		
		find(bst, list, 4);
		
		System.out.println(list);
	}
	
	/**
	 * The time complexity is O(h + k)
	 */
	private static void find(Node<Integer, ?> bst, List<Integer> list, int k) {
				
		if(bst != null && list.size() < k) {			
					
			find(bst.right, list, k);
			
			if(list.size() < k) {
				
				list.add(bst.key);
				
				find(bst.left, list, k);
			}
		}
	}
}
