package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * @author gopi_karmakar
 */
public class PrintLevelOrderTraversalBottomToUp {

	public static void main(String[] args) {
		
		Node<Integer> root = BinaryTree.buildDefault();
		
		bfsBottomsUp(root).forEach(l -> {
						
			System.out.println(l);
		});
	}
	
	/**
	 * O(n) space and time complexity
	 */
	private static List<List<Node<Integer>>> bfsBottomsUp(Node<Integer> root) {
		
		Queue<Node<Integer>> q = new LinkedList<>();	
		List<List<Node<Integer>>> result = new ArrayList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			 
			int size = q.size();
			List<Node<Integer>> list = new ArrayList<>();
			
			for(int i = 0; i < size; ++i) {
				
				Node<Integer> e = q.poll();
				
				if(e != null) {						
					
					list.add(e);
					if(e.left != null)	q.add(e.left);
					if(e.right != null)	q.add(e.right);
				}							
			}	
			
			if(!list.isEmpty()) {
				//Shifts the old element and adds the new element.
				result.add(0, list);
			}
		}			
		return result;
	}
}
