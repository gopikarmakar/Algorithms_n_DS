package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Facebook and Amazon Interview Question
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *  
 * 			1
 * 	2				3
 *				4		5
 *			
 * @author gopi_karmakar
 */
public class SerializeDeSerializeBT {

	/**
	 * Solution Accepted in Leetcode.	 
	 */
	public static void main(String[] args) {
		
		Integer[] keys = {1, 2, 3, null, null, 4, 5};
				
		Node<Integer> bt = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		BinaryTree.printBFS(bt, true);
		
		String data = serialize(bt);
		
		System.out.println(data);
		
		BinaryTree.printBFS(deSerialize(data), true);
	}
	
	/**
	 * Encoding tree with BFS
	 */
	public static String serialize(Node<Integer> root) {				

		if(root == null) return "";
		
		StringBuilder sb = new StringBuilder();
		
		Queue<Node<Integer>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			
			int size = q.size();						
			
			for(int i = 0; i < size; i++) {
				
				Node<Integer> node = q.poll();
				
				if(node == null) {
					sb.append("null");
				}
				else {
					
					sb.append("" + node.key);
					q.add(node.left);
					q.add(node.right);
				}
				sb.append(",");
			}
		}
		
		sb.deleteCharAt(sb.length()-1);
		
		return sb.toString();
	}
	
	/**
	 * Reconstructing tree with BFS.
	 */
	public static Node<Integer> deSerialize(String data) {
		
		if(data.length() == 0) return null;
		
		String[] keys = data.split(",");
		
		Node<Integer> root = new Node<>(Integer.parseInt(keys[0]));
		
		Queue<Node<Integer>> q = new LinkedList<>();
		q.add(root);
		
		for(int i = 1; i < keys.length; i++) {
			
			Node<Integer> parent = q.poll();
			
			if(!keys[i].equals("null")) {
				
				Node<Integer> left = new Node<>(Integer.parseInt(keys[i]));
				parent.left = left;
				left.parent = parent;
				q.add(left);
			}
			
			if(!keys[++i].equals("null")) {
				
				Node<Integer> right = new Node<>(Integer.parseInt(keys[i]));
				parent.right = right;
				right.parent = parent;
				q.add(right);
			}
		}		
		return root;				
	}
}
