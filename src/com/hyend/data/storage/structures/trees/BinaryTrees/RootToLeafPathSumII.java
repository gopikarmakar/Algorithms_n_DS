package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths
 * where each path's sum equals the given sum.
 * 
 * 			 5
 *    		/ \
 *   	   4   8
 *  	  /   / \
 * 		11  13   4
 *	    / \     / \
 *	   7   2   5   1
 * 
 * Sum = 22 
 * return : {{5,4,11,2},{5,8,4,5}}
 * 
 * @author gopi_karmakar
 */
public class RootToLeafPathSumII {

	public static void main(String[] args) {
		
		List<List<Integer>> paths = new ArrayList<>();
		
		Integer keys[] = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1};		
		
		Node<Integer> node = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		
		//BinaryTree.printBFS(root, true);
		
		path(node, 22, 0, new ArrayList<>(), paths);
		
		System.out.println(paths);
	}
	
	/**
	 * Efficient Solution Accepted with 99.96% runtime.
	 */
	private static void path(Node<Integer> node, int sum, int partialSum,
			List<Integer> path, List<List<Integer>> paths) {
		
		if(node == null)
			return;
		
		path.add(node.key);
		
		partialSum += node.key;
		
		if(node.left == null && node.right == null) {
			
			if(partialSum == sum) {
				paths.add(new ArrayList<>(path));
			}
		}
		else {
		
			path(node.left, sum, partialSum, path, paths);
			path(node.right, sum, partialSum, path, paths);
		}
		
		path.remove(path.size()-1);
	}
}
