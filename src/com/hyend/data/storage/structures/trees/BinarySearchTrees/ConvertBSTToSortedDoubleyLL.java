package com.hyend.data.storage.structures.trees.BinarySearchTrees;

import java.util.Iterator;
import java.util.LinkedList;

import com.hyend.data.storage.structures.linkedlists.doubly.DoublyLinkedList;

/**
 * Converting a BST to Sorted Doubly LinkedL List;
 * 
 * @author gopi_karmakar
 */
public class ConvertBSTToSortedDoubleyLL {
	
	private static LinkedList<Node<Integer, ?>> ll = new LinkedList<>();
	private static DoublyLinkedList<Node<Integer, ?>> dll = new DoublyLinkedList<>();
	
	public static void main(String[] args) {
		
		Node<Integer, ?> tree = BinarySearchTree.createDefault();
		convert(tree);
		print(DoublyLinkedList.FORWARD);
	}
	
	public static LinkedList<Node<Integer, ?>> get(Node<Integer, ?> node) {
		
		convert(node);
		return ll;
	}
	
	/**
	 * O(n) time complexity recursive InOrder solution.
	 */
	private static void convert(Node<Integer, ?> node) {
	
		if(node == null) return;
		
		convert(node.left);
		ll.add(node);
		dll.add(node);		
		convert(node.right);
	}
	
	private static void print(int order) {				
		
		dll.printAllNodes(order);
		
		/*Iterator<Node<Integer, ?>> itr = dll.getIterator(order);
		
		while(itr.hasNext()) {
			Node<?, ?> node = itr.next();
			System.out.println("Key = " + node.key + " Value = " + node.value);
		}*/
	}
}
