package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * @author gopi_karmakar
 */
public class SerializeDeserializeBinaryTreeIII {
	
	private static final String NULL = "null";
	private static final String SPLITTER = ",";	

	public static void main(String[] args) {
		
		Integer[] keys = {1, 2, 3, null, null, 4, 5};
		
		Node<Integer> root = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		BinaryTree.printBFS(root, true);
		
		String tree = serialize(root);
		
		System.out.println(tree);
		
		BinaryTree.printBFS(deSerialize(tree), false);
	}
	
	public static String serialize(Node<Integer> root) {
		
		StringBuilder sb = new StringBuilder();
		
		serializeHelper(root, sb);
		
		return sb.toString();		
	}
	
	private static void serializeHelper(Node<Integer> root, StringBuilder sb) {
		
		if(root == null) {
			sb.append(NULL).append(SPLITTER);
			return;
		}
		
		sb.append(root.key).append(SPLITTER);
		
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);
	}	
	
	public static Node<Integer> deSerialize(String tree) {
		
		Queue<String> q = new LinkedList<>();
		q.addAll(Arrays.asList(tree.split(SPLITTER)));
		
		return deSerializeHelper(q);
	}
	
	private static Node<Integer> deSerializeHelper(Queue<String> q) {
		
		String key = q.poll();
		
		if(key.equals(NULL)) return null;
		
		Node<Integer> node = new Node<>(Integer.parseInt(key));
		
		node.left = deSerializeHelper(q);
		node.right = deSerializeHelper(q);
		
		return node;
	}
}
