package com.hyend.data.storage.structures.hashtable;

import java.util.HashMap;
import java.util.Map;

import com.hyend.data.storage.structures.linkedlists.doubly.Node;

/**
 * https://leetcode.com/problems/lru-cache/
 * 
 * An O(1) time and space complexity solution.
 * 
 * @author gopi_karmakar
 */
public class LRUCacheWithDLL<K, V> {
	
	int capacity = 0;
	private Node head = null;
	private Node tail = null;
	private Map<K, Node> cache;
	
	public LRUCacheWithDLL(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
	}
	
	public static void main(String[] args) {
		
		LRUCacheWithDLL<Integer, String> lruCache = new LRUCacheWithDLL<>(5);	
		lruCache.add(1, "One");
		lruCache.add(2, "Two");
		lruCache.add(3, "Three");
		lruCache.add(4, "Four");
		lruCache.add(5, "Five");		
		lruCache.get(3);		
		lruCache.printCache();
		lruCache.add(6, "Six");		
		lruCache.add(7, "Seven");
		lruCache.get(4);
		lruCache.printCache();
		lruCache.add(8, "Eight");
		lruCache.get(3);
		lruCache.add(9, "Nine");
		lruCache.printCache();
	}
	
	class Node {
		
		K key;
		V value;
		Node next = null;
		Node prev = null;		
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Key = " + this.key + " Value = " + this.value;
		}
	}
	
	private V get(K key) {
		
		Node node = cache.get(key);
		
		if(node == null) {
			return null;
		}
		
		return add(node.key, node.value).value;		
	}
	
	private Node add(K key, V value) {
		
		Node node = cache.get(key);
		
		if(node == null) {
			
			if(cache.size() == capacity) {
				
				Node e = removeLast();
				cache.remove(e.key);
			}
		}
		else {
			remove(node);
		}
		return cache.put(key, addFirst(key, value));
	}
	
	private Node addFirst(K key, V value) {
		
		Node node = new Node(key, value);
				
		Node temp = head;
		head = node;
		
		if(tail == null) {			
			tail = head;
			return head;
		}
		head.next = temp;
		temp.prev = head;
				
		return head;
	}
	
	private Node removeLast() {

		Node node = tail;
		
		if(head == tail) {
			head = tail = null;
			return node;
		}
				
		tail = node.prev;
		tail.next = null;
		
		return node;
	}
	
	private void remove(Node node) {
		
		if(node == head && head == tail) {
			head = tail = null;
		}			
		else if(node == head && node.next != null) {
			head = node.next;
			head.prev = null;			
		}
		else if(node == tail && node.prev != null) {
			tail = node.prev;
			tail.next = null;
		}
		else {
		
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}		
		node = null;
	}
	
	private void printCache() {
		
		Node node = head;
		
		System.out.println("Printing Cache = " + cache.size());
		
		while(node != null) {
			
			System.out.println(node);
			node = node.next;
		}
	}
}
