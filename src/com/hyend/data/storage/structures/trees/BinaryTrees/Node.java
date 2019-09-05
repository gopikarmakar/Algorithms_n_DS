package com.hyend.data.storage.structures.trees.BinaryTrees;

/**
 * A single Binary Tree node.
 * 
 * @author gopi_karmakar
 *
 * @param <K>
 */
public class Node<K> {

	public K key;
	public int size;
	public int weight;
	public Node<K> left;
	public Node<K> right;
	public Node<K> parent;
	
	public Node(K k) {
		this(k, null, null, null);
	}
	
	public Node(K k, Node<K> parent) {
		this(k, parent, null, null);
	}
	
	public Node(K k, Node<K> left, Node<K> right) {
		this(k, null, left, right);
	}
	
	public Node(K k, Node<K> parent, Node<K> left, Node<K> right) {
		this.key = k;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}
