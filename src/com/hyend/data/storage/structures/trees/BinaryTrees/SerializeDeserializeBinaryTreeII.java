package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * Solution accepted in Leetcode > 70% runtime.
 * 
 * @author gopi_karmakar
 */
public class SerializeDeserializeBinaryTreeII {

	public static void main(String[] args) {
		
		Integer[] keys = {1, 2, 3, null, null, 4, 5};
		
		Node<Integer> root = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		BinaryTree.printBFS(root, true);
		
		String bt = serialize(root);
		
		System.out.println(bt);
		
		BinaryTree.printBFS(deSerialize(bt), false);
	}
	
	public static String serialize(Node<Integer> root) {
		
		if(root == null) return "X";
		
		String left = serialize(root.left);
		String right = serialize(root.right);
		
		StringBuilder sb = new StringBuilder();
		sb.append(root.key).append(",").append(left).append(",").append(right);
		
		return sb.toString();
	}
	
	public static Node<Integer> deSerialize(String tree) {
		
		Queue<String> q = new LinkedList<>();
		q.addAll(Arrays.asList(tree.split(",")));
		
		return deSerializeHelper(q);
	}
	
	private static Node<Integer> deSerializeHelper(Queue<String> q) {
		
		String key = q.poll();
		
		if(key.equals("X")) return null;
		
		Node<Integer> node = new Node<>(Integer.parseInt(key));
		
		node.left = deSerializeHelper(q);
		node.right = deSerializeHelper(q);
		
		return node;
	}
}
