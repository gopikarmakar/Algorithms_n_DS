package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/path-sum-iii/
 * 
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, 
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * 				      10
 *    				 /  \
 *   				5   -3
 * 				   / \    \
 * 				  3   2   11
 *				 / \   \
 *				3  -2   1
 * Sum = 8
 * Return = 3
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
 * @author gopi_karmakar
 */
public class TopToDownPathSum {

	private static int totalPaths = 0;
	
	public static void main(String[] args) {
		
		Integer keys[] = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};		
		
		Node<Integer> root = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		
		//BinaryTree.printBFS(root, true);
		
		int sum = 8;
		
		path(root, sum, new ArrayList<>());
		System.out.println(totalPaths);
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		System.out.println(path(root, sum, map, 0));
	}
	
	/**
	 * Efficient memoized Solution
	 * Accepted in Leetcode with 99.98% runtime.
	 */
	private static int path(Node<Integer> root, int target, 
			Map<Integer, Integer> map, int partialSum) {
		
		if(root == null) return 0;
   
		partialSum += root.key;
   
		int count = map.getOrDefault(partialSum - target, 0);
   
		map.put(partialSum, map.getOrDefault(partialSum, 0) + 1);
   
		count += path(root.left, target, map, partialSum) + path(root.right, target, map, partialSum);
   
		map.put(partialSum, map.get(partialSum) - 1); // backtracking to clear the previous branch sum
   
		return count;
	}
		
	/**
	 * Inefficient solution with 46% runtime.
	 */
	private static void path(Node<Integer> node, int sum, List<Integer> path) {
		
		if(node == null)
			return;
		
		path.add(node.key);
		
		path(node.left, sum, path);
		path(node.right, sum, path);
	
		int total = 0;
		
		for(int i = path.size()-1; i >= 0; i--) {
			total += path.get(i);
			
			if(total == sum)
				totalPaths += 1;
		}
		path.remove(path.size()-1);
	}
}
