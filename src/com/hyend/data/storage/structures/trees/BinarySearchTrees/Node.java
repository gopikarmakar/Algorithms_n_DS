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
	
	public K key;
	public V value;
	public Node<K, V> left;
	public Node<K, V> right;
	public Node<K, V> parent;
	
	public Node(Node<K, V> node) {
		this.key = node.key;
		this.value = node.value;			
	}
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;			
	}
	
	public Node(Node<K, V> parent, K key, V value) {
		this(key, value);
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		
		return "Key = " + key + ((value != null) ? " Value = " + value : "");		
	}
}
