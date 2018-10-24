package com.hyend.data.storage.structures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A Balanced Binary Search Tree typically is a combination of
 * 2-3 + Red-Black + Binary Search tree implementation.
 * 
 * It provides the guaranteed (O)log(n) time complexity
 * implementation for insert, search and delete operations
 * in average cases and (2)log(n) for worst cases.
 * 
 * Red-Black Tree Implementation Rules:
 * 1: The red links should always be left leaning in a Red-Black Tree.
 * 2: If a parent node has both not-null left-&-right child nodes then:
 *		2.1 If both the child nodes are Red links, then the child nodes should
 *		flip to Black links and only parent node should be the Red link.
 *		
 *		2.2 If the left child node is a Black link and right child node is a 
 *		Red link then the subtree should rotate to left in order to become 
 *		the properly balanced Red links left leaning Red-Black tree.
 *		
 * 3: If a parent node's consecutive two left child nodes are Red links then
 *    the subtree should rotate to right in order to become the properly 
 *    balanced Red links left leaning Red-Black tree.
 *   
 * Recursive implementation of a Red-Black
 * Balanced Binary search tree with the 
 * parent node and number of child 
 * nodes tracking for every node.
 *  
 * @author gopi_karmakar
 * @param <V>
 *
 */
public final class BalancedBSTres<K extends Comparable<K>, V> {
	
	private final boolean RED = true;
	private final boolean BLACK = false;
	
	private int totalSize = 0;
	private Node root, parent;
	
	class Node {
		K key;
		V value;
		int childNodes;
		boolean color;
		Node left, right, parent;
		Node(K key, V value, int childs, boolean color) {
			this.key = key;
			this.value = value;			
			this.color = color;
			this.childNodes = childs;
		}
	}
	
	public int size() {
		return totalSize;
	}
	
	public V find(K key) {
		return contains(root, key).value;
	}
	
	public Node put(K key, V value) {
		root = insertNode(root, key, value);
		root.color = BLACK;
		root.parent = root;
		return root;
	}
	
	public void printAllNodesInOrder() {
		traverseInOrder(root);
	}
	
	public void printAllNodesPreOrder() {
		traversePreOrder(root);
	}
	
	public void printAllNodesPostOrder() {
		traversePostOrder(root);
	}
	
	public void traverseLevelOrder() {
		Queue<Node> nodes = new LinkedList<BalancedBSTres<K,V>.Node>();
		nodes.add(root);		
		do {
			Node node = nodes.remove();
			System.out.println("Parent = " + node.parent.key + " Child = " + node.key +
				" Color = " + node.color + " Child Nodes = " + node.childNodes);
			if(node.left != null) {
				nodes.add(node.left);
			}
			if(node.right != null) {
				nodes.add(node.right);
			}
		} while(!nodes.isEmpty());
	}
	
	public void deleteMin() {		
	}
	
	private int childNodesSize(Node node) {
		if(node == null) return 0;
		return node.childNodes;
	}
	
	private boolean isRed(Node node) {
		if(node == null) return BLACK;
		return node.color == RED;
	}
	
	private void flipColors(Node node) {
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;		
	}
	
	private void traverseInOrder(Node node) {
		if(node != null) {
			traverseInOrder(node.left);
			System.out.println("Node.Key = " + node.key + " Color = " + 
			node.color + " Child Nodes = " + node.childNodes);
			traverseInOrder(node.right);
		}
	}
	
	/**
	 * @param node
	 */
	private void traversePreOrder(Node node) {
		if(node != null) {
			System.out.println("Node.Key = " + node.key + " Color = " + 
			node.color + " Child Nodes = " + node.childNodes);
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
			System.out.println("Node.Key = " + node.key + " Color = " + 
			node.color + " Child Nodes = " + node.childNodes);
		}
	}
	
	private Node rotateLeft(Node node) {
		Node temp = node.right;		
		node.right = temp.left;
		if(node.right != null)
			node.right.parent = node;
		temp.left = node;
		temp.parent = node.parent;
		node.parent = temp;		
		temp.color = node.color;
		node.color = RED;
		temp.childNodes = node.childNodes;
		node.childNodes = 1 + childNodesSize(node.left) + childNodesSize(node.right);
		return temp;
	}
	
	private Node rotateRight(Node node) {
		Node temp = node.left;		
		node.left = temp.right;
		if(node.left != null)
			node.left.parent = node;
		temp.right = node;
		temp.parent = node.parent;
		node.parent = temp;
		temp.color = node.color;
		node.color = RED;
		temp.childNodes = node.childNodes;
		node.childNodes = 1 + childNodesSize(node.left) + childNodesSize(node.right);
		return temp;
	}
	
	private Node insertNode(Node node, K key, V value) {
		if(node == null) {
			node = new Node(key, value, 1, RED);
			node.parent = parent;
			totalSize += 1;
			return node;
		}
		parent = node;
		int cmp = key.compareTo(node.key);
		if(cmp < 0) node.left = insertNode(node.left, key, value);
		else if(cmp > 0) node.right = insertNode(node.right, key, value);
		else node.value = value;
		
		if(isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);		
		if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);		
		if(isRed(node.left) && isRed(node.right)) flipColors(node);
		
		node.childNodes = childNodesSize(node.left) + childNodesSize(node.right) + 1; 
		return node;
	}
	
	private Node contains(Node node, K key) {
		if(node.key == key) return node;
		int cmp = key.compareTo(node.key);
		return (cmp < 0) ? contains(node.left, key) : contains(node.right, key);		
	}
}