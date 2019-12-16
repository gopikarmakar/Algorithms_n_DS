package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * A single node of Binary Search Tree
 * 
 * @author gopi_karmakar
 *
 * @param <K>
 * @param <V>
 */
public class Node<K extends Comparable<K>, V> {
	
	K key;
	V value;
	Node<K, V> left;
	Node<K, V> right;
	Node<K, V> parent;
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;			
	}
	
	public Node(Node<K, V> parent, K key, V value) {
		this(key, value);
		this.parent = parent;
	}
}
