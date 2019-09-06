package com.hyend.data.storage.structures.trie.Ternary;

import java.util.ArrayList;
import java.util.List;


public class Node<K extends Comparable<K>, V> {

	K k;
	V v;
	Node<K, V> left;
	Node<K, V> mid;
	Node<K, V> right;
	
	Node(K k, V v) {
		this.k = k;
		this.v = v;
	}
}
