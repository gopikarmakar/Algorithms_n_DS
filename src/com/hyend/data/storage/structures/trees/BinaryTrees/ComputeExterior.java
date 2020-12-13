package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.List;
import java.util.ArrayList;

/**
 * Compute the exterior / boundary nodes of a Binary Tree.
 * O(n) time complexity
 * 
 * @author gopi_karmakar
 */
public class ComputeExterior {

	public static void main(String[] args) {
		
		Node<Integer> tree = BinaryTree.buildDefault();
		
		ComputeExterior boundary = new ComputeExterior();
		List<Node<Integer>> boundaries = boundary.binaryTreeExterior(tree);
		
		boundaries.forEach(e -> {
			System.out.println(e.key);
		});				
	}
	
	private List<Node<Integer>> binaryTreeExterior(Node<Integer> tree) {
		
		List<Node<Integer>> exterior = new ArrayList<>();
		if(tree != null) {
			
			exterior.add(tree);
			leftBoundaryAndLeaves(tree.left, true, exterior);
			rightBoundaryAndLeaves(tree.right, true, exterior);
			
			/*exterior.addAll(leftBoundaryAndLeaves(tree.left, true));
			exterior.addAll(rightBoundaryAndLeaves(tree.right, true));*/						
		}		
		return exterior;
	}
	
	private void leftBoundaryAndLeaves(Node<Integer> node, boolean isBoundary, List<Node<Integer>> leftResult) {		
		
		if(node != null) {
			
			if(isBoundary || isLeaf(node))
				leftResult.add(node);
					
			leftBoundaryAndLeaves(node.left, isBoundary, leftResult);
			leftBoundaryAndLeaves(node.right, (isBoundary && node.left == null), leftResult);
		}		
		return;
	}
	
	private void rightBoundaryAndLeaves(Node<Integer> node, boolean isBoundary, List<Node<Integer>> rightResult) {		
		
		if(node != null) {						
			
			rightBoundaryAndLeaves(node.left, (isBoundary && node.right == null), rightResult);
			rightBoundaryAndLeaves(node.right, isBoundary, rightResult);
			
			if(isBoundary || isLeaf(node))
				rightResult.add(node);						
		}		
		return;		 
	}
	
	/*private List<Node<Integer>> leftBoundaryAndLeaves(Node<Integer> node, boolean isBoundary) {
		
		List<Node<Integer>> leftResult = new ArrayList<>();
		
		if(node != null) {
			
			if(isBoundary || isLeaf(node))
				leftResult.add(node);
			
			leftResult.addAll(leftBoundaryAndLeaves(node.left, isBoundary));
			leftResult.addAll(leftBoundaryAndLeaves(node.right, (isBoundary && node.left == null)));			
		}		
		return leftResult;
	}
	
	private List<Node<Integer>> rightBoundaryAndLeaves(Node<Integer> node, boolean isBoundary) {
		
		List<Node<Integer>> rightResult = new ArrayList<>();
		
		if(node != null) {
			rightResult.addAll(rightBoundaryAndLeaves(node.left, (isBoundary && node.right == null)));
			rightResult.addAll(rightBoundaryAndLeaves(node.right, isBoundary));
			
			if(isBoundary || isLeaf(node))
				rightResult.add(node);
		}		
		return rightResult;
	}*/
	
	private boolean isLeaf(Node<Integer> node) {
		
		return (node.left == null && node.right == null);
	}
}
