package com.hyend.data.storage.structures.trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 			5
 * 	2				3
 *				2		4
 *			3		1 
 * @author gopi_karmakar
 */
public class SerializeDeSerializeBT {

	public static void main(String[] args) {
		
		Integer[] keys = {5, 2, 3, null, null, 2, 4, 3, 1};
				
		Node<Integer> bt = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		
		String data = serialize(bt);
		
		System.out.println(data);
		
		BinaryTree.printBFS(deSerialize(data), false);
	}
	
	public static String serialize(Node<Integer> root) {
		
		Queue<Node<Integer>> q = new LinkedList<>();
		
		String data = "";
		
		q.add(root);
		
		while(!q.isEmpty()) {
			
			Node<Integer> node = q.poll();					
			
			if(node != null) {								
				
				data += node.key + ",";
				
				q.add(node.left);
				q.add(node.right);
			}
			else {
				data += node + ",";
			}
		}

		return data.substring(0, data.length()-1);
	}
	
	public static Node<Integer> deSerialize(String data) {
		
		String[] str = data.split(",");
		Integer[] keys = new Integer[str.length];
		
		int i = 0;
		for(String s : str) {
						
			//System.out.println((s.equals("null")) ? s : "s");
			keys[i++] = s.equals("null") ? null : Integer.parseInt(s);
		}
		
		Node<Integer> root = BinaryTree.build(BinaryTree.SHORT_HEIGHTED, keys);
		
		return root;
	}
}
