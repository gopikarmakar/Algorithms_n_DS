package com.hyend.data.storage.structures.trie.Ternary;
import java.util.List;

/**
 * @author gopi_karmakar
 */
public class Node<K extends Comparable<K>, V> {

	public K k;
	public V v;
	public int length;
	public int frequency;
	
	public Node<K, V> mid;
	public Node<K, V> left;	
	public Node<K, V> right;
	
	public List<V> values;
	
	public Node() {}
	
	Node(K k, V v) {
		this();
		this.k = k;
		this.v = v;
	}
}
