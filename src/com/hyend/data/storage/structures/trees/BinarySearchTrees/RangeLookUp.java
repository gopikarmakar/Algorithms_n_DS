package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all the nodes fall under a range.
 * 
 * @author gopi_karmakar
 */
public class RangeLookUp {

	public static void main(String[] args) {
		
		Node<Integer, ?> root = BinarySearchTree.createDefault();
		
		List<Integer> list = new ArrayList<>();
		
		range(root, new Interval(16, 31), list);
		
		System.out.println(list);
	}
	
	private static class Interval {
		
		int left, right;
		
		public Interval(int left, int right) {
			
			this.left = left;
			this.right = right;
		}
	}	
	
	/**
	 * The nodes can be partitioned into three subsets. 
	 * Nodes on the search path to 16, 
	 * nodes on the search path to 42, and the rest. 
	 * The traversal spends O(h) time 
	 * visiting the first two subsets, 
	 * and O(m) time traversing the third subset.
	 * Each edge is visited twice, once downwards and once upwards. 
	 * i.e the total time complexity is O(m + h), 
	 * which is much better than O(n) brute-force approach 
	 * when the tree is balanced, and very few keys he in the specified range.
	 */
	private static void range(Node<Integer, ?> root, Interval interval, List<Integer> list) {
		
		if(root == null)
			return;
		
		//if(interval.left <= bst.key && interval.right >= bst.key) {
		if(root.key >= interval.left && root.key <= interval.right) {
			
			range(root.left, interval, list);
			
			list.add(root.key);
			
			range(root.right, interval, list);
		}
		else if(interval.left > root.key) {
			
			range(root.right, interval, list);
		}
		else {
			
			range(root.left, interval, list);	
		}
	}
}
