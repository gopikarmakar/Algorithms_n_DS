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
		
		Node<Integer, ?> bst = BinarySearchTree.createDefault();
		
		List<Integer> list = new ArrayList<>();
		
		range(bst, new Interval(16, 31), list);
		
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
	 * The nodes can be partitioned into three subsets. Nodes on the search path to 16, 
	 * nodes on the search path to 42, and the rest. The traversal spends O(h) time 
	 * visiting the first two subsets, and O(m) time traversing the third subset.
	 * Each edge is visited twice, once downwards and once upwards. Therefore the 
	 * total time complexity is O(m + h), which is much better than O(n)
	 * brute-force approach when the tree is balanced, and very few keys he in the specified range.
	 */
	private static void range(Node<Integer, ?> bst, Interval interval, List<Integer> list) {
		
		if(bst == null)
			return;
		
		if(interval.left <= bst.key && interval.right >= bst.key) {
			
			range(bst.left, interval, list);
			
			list.add(bst.key);
			
			range(bst.right, interval, list);
		}
		else if(interval.left > bst.key) {
			
			range(bst.right, interval, list);
		}
		else {
			
			range(bst.left, interval, list);
		}
	}
}
