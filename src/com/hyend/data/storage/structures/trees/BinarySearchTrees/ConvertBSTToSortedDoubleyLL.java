package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.Iterator;
import com.hyend.data.storage.structures.linkedlists.doubly.DoublyLinkedList;
import com.hyend.data.storage.structures.trees.BinarySearchTrees.BinarySearchTree.Node;

/**
 * Converting a BST to Sorted Doubly LinkedL List;
 * 
 * @author gopi_karmakar
 */
public class ConvertBSTToSortedDoubleyLL {
	
	public static void main(String[] args) {
		
		Node<Integer, String> tree = BinarySearchTree.createDefault();
		convert(tree);
		print(DoublyLinkedList.FORWARD);
	}	
		
	private static DoublyLinkedList<Node<?, ?>> dll = new DoublyLinkedList<>();
	
	/**
	 * O(n) time complexity recursive InOrder solution.
	 * 
	 * @param node
	 */
	public static void convert(Node<?, ?> node) {
	
		if(node == null) return;
		
		convert(node.left);
		dll.add(node);
		convert(node.right);
	}
	
	public static void print(int order) {				
		
		Iterator<Node<?, ?>> itr = dll.getIterator(order);
		
		while(itr.hasNext()) {
			Node<?, ?> node = itr.next();
			System.out.println("Key = " + node.key + " Value = " + node.value);
		}
	}
}
