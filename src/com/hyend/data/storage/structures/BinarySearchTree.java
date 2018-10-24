package com.hyend.data.storage.structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import com.hyend.data.storage.structures.BinarySearchTree.Node;

public class BinarySearchTree {
	
	private int size = 0;	
	private Node root, parent;
	
	class Node {
		int key;
		Object value;
		Node left;
		Node right;
		Node parent;
		public Node(int key, Object value) {
			this.key = key;
			this.value = value;
		}				
	}
	
	public BinarySearchTree() {
		root = null;
		parent = null;
	}
	
	private Node insertNode(Node currentNode, int key, Object value) {		
		if(currentNode == null) {
			currentNode = new Node(key, value);
			currentNode.parent = parent;
			size+=1;
			return currentNode;
		}
		parent = currentNode;
		if(key < currentNode.key)
			currentNode.left = insertNode(currentNode.left, key, value);
		else if(key > currentNode.key)
			currentNode.right = insertNode(currentNode.right, key, value);
		
		//Else value is already present in the tree. Just return that value.
		return currentNode;
	}
	
	private Node containsNode(Node node, int key) {
		if(node == null) {
			System.out.println("root = " + node);
			return null;
		}	
					
		if(key == node.key)
			return node;
				
		return (key < node.key) ? containsNode(node.left, key) : containsNode(node.right, key);
	}
	
	/**
	 * It'll traverse the left side of the tree 
	 * to find the smallest key from the  
	 * right side of the node to be deleted. 
	 *    
	 * @param node
	 * @return
	 */
	private Node findSmallest(Node node) {		
		
		return (node.left == null) ? node : findSmallest(node.left);
	}
	
	private Node deleteNode(Node node, int key) {
		if(node == null) {
			return null;
		}
		
		if(key == node.key) {			
			node = null;
			return node;
		}
		
		if(key < node.key) {
			node.left = deleteNode(node.left, key);
			return node;
		}
		else {
			node.right = deleteNode(node.right, key);
			return node;
		}
	}
	
	/**
	 * @param node
	 */
	private void traverseInOrder(Node node) {		
		if(node != null) {
			traverseInOrder(node.left);
			System.out.println("Parent = " + node.parent.key + " Child = " + node.key);
			traverseInOrder(node.right);
		}
	}
	
	/**
	 * @param node
	 */
	private void traversePreOrder(Node node) {
		if(node != null) {
			System.out.println("Parent = " + node.parent.key + " Child = " + node.key);
			traversePreOrder(node.left);			
			traversePreOrder(node.right);
		}
	}
	
	/**
	 * @param node
	 */
	private void traversePostOrder(Node node) {
		if(node != null) {			
			traversePostOrder(node.left);			
			traversePostOrder(node.right);
			System.out.println("Parent = " + node.parent.key + " Child = " + node.key);
		}
	}
	
	private void traverseLevelOrder() {
		if(root == null)
			return;
		
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(root);
		
		while(!nodes.isEmpty()) {
			Node node = nodes.remove();
			System.out.print(node.key + "  ");
			if(node.left != null) {
				nodes.add(node.left);
			}
			if(node.right != null) {
				nodes.add(node.right);
			}
		}
	}
	
	/**
	 * Insertion & Fetching of a value 
	 * from a Binary Search Tree
	 * always guarantees O(logn) time.
	 * 
	 * After adding the values to tree
	 * the tree will become like:
	 *       6
	 *   4      8
	 * 3   5  7   9
	 * 
	 * @param value
	 * @return
	 */
	public Node put(int key, Object value) {
		if(root == null) {
			root = new Node(key, value);
			parent = root.parent = root;
			size+=1;
			return root;
		}
		else {
			Node leaf = insertNode(root, key, value);
			return leaf;
		}
	}
		
	/**
	 * Returning the value of the key
	 * from the tree.
	 * 
	 * @param key
	 * @return
	 */
	public Object contains(int key) {
		return containsNode(root, key).value;		 
	}
	
	public boolean delete(int key) {
		boolean status = false;
		Node node = containsNode(root, key);		
		if(node.left == null && node.right == null) {
			if(key < node.parent.key) {
				node.parent.left = null;
				System.out.println("Node to delete = " + node.key);				
				status = true;
			}
			else if(key > node.parent.key) {
				node.parent.right = null;
				status = true;
			}			
		}
		else if(node.left != null && node.right == null) {
			node.left.parent.key = node.left.key;
			node.left.parent.value = node.left.value;
			node.left = null;
			status = true;
		}
		else if(node.left == null && node.right != null) {
			node.right.parent.key = node.right.key;
			node.right.parent.value = node.right.value;
			node.right = null;
			status = true;
		}
		else {
			Node smallestNode = findSmallest(node.right);
			node.key = smallestNode.key;
			node.value = smallestNode.value;
			System.out.println("Node to delete = " + node.right.key);
			if(node.right.key == smallestNode.key)
				node.right = null;
			else
				deleteNode(node.right, smallestNode.key);
		}
		return status;
	}
	
	/**
	 * It's one of the ways for Depth First Search
	 *  It traverse the till the depth from the root
	 * In-Order traversal of tree visits 
	 * first the left sub-tree, 
	 * then the root node, 
	 * and finally the right sub-tree
	 */
	public void printAllInOrderNodes() {
		traverseInOrder(root);
	}
	
	/**
	 * Another way of Depth First Search
	 * Pre-Order traversal of tree visits
	 * first the root node, 
	 * then the left subtree, 
	 * and finally the right subtree
	 */
	public void printAllPreOrderNodes() {
		traversePreOrder(root);
	}
	
	/**
	 * Another way of Depth First Search
	 * Post-order traversal of tree visits 
	 * first the left subtree, 
	 * then the right subtree, 
	 * and finally the root node at the end
	 */
	public void printAllPostOrderNodes() {
		traversePostOrder(root);
	}
	
	/**
	 * Level order or Breadth First Search (DFS)
	 * traverse all the nodes in a level from root.
	 * Unlike traversing till depth.
	 */
	public void printAllLevelOrderNodes() {
		traverseLevelOrder();
	}
	
	public int size() {
		return size;
	}
}
