package com.hyend.logical.interview.questions.google;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A google telephonic screening phone interview question.
 * 
 * Solution: implement a time critical hashmap such that,
 * you are given input as: key, value & time-limit. 
 * If the time limit gets over and then the hashmap 
 * must not return any value. This should be strictly 
 * implemented as an Object Oriented code.
 * 
 * Test Cases:
 * 1: The expired objects from the pool should be kept on removing 
 * to handle the memory overflow, in case of very rapid 
 * put and get of new objects.
 * 
 * 2: The existing object should update the access time.
 *   
 * @author gopi_karmakar
 */
public class TimeCriticalHashMapII<K extends Comparable<K>, V> {

	private int limit = 0;
	private Entry head = null;
	private Entry tail = null;
	private ConcurrentMap<K, Entry> myMap;
	
	class Entry {							
		
		K key;
		V value;
		long time = 0;
		
		Entry next;
		Entry prev;
		
		public Entry(K key, V value) {
			setKey(key); 
			setValue(value);
			setCurrentTime();
		}
		
		public void setKey(K key) { 
			this.key = key;  
		}
		
		public void setValue(V value) { 
			this.value = value; 
		}
		
		public void setCurrentTime() { 
			this.time = System.currentTimeMillis();
		}
		
		public K getKey() { 
			return this.key; 
		}
		
		public V getValue() { 
			return this.value; 
		}
		
		public long getSavedTime() { 
			return time; 
		}
	}	
	
	public TimeCriticalHashMapII(int limit) {
		this.limit = limit;
		myMap = new ConcurrentHashMap<K, Entry>();
	}
	
	public V put(K key, V value) {
		
		invalidateExpiredElements();	
		
		Entry entry = myMap.get(key);
		if(entry != null) {			
			entry = myMap.put(key, updateAndMoveToFirst(entry));
		}
		else {
			entry = myMap.put(key, addFirst(key, value));			
		}
		
		return entry.value;
	}	
	
	public V get(K key) throws NoSuchElementException {
		
		if(!myMap.containsKey(key))
			throw new NoSuchElementException("Element Not Found");
		
		invalidateExpiredElements();
		
		Entry e = myMap.get(key);		
		if(e != null && (getCurrentTime() - e.getSavedTime() > limit)) {
			
			remove(e);
			myMap.remove(key);			
			throw new NoSuchElementException("Element Expired");
		}		
		return e.getValue();		
	}
	
	private synchronized void invalidateExpiredElements() {
		
		Entry e = getLast();
		if(e != null && (getCurrentTime() - e.getSavedTime() > limit)) {
			
			removeLast();
			myMap.remove(e.key);
		}
	}
	
	private synchronized Entry addFirst(K key, V value) {
		
		Entry entry = new Entry(key, value);
		
		Entry temp = head;
		head = entry;
		
		if(tail == null) {			
			tail = head;
			return head;
		}
		temp.prev = head;
		head.next = temp;
		
		return head;
	}
	
	private synchronized Entry updateAndMoveToFirst(Entry entry) {		

		remove(entry);		

		entry.setCurrentTime();
		
		if(head == null) {
			entry.prev = null;
			entry.next = null;
			head = tail = entry;			
			return head;
		}
								
		Entry temp = head;
		head = entry;
		head.prev = null;
		entry = null;
		
		temp.prev = head;
		head.next = temp;		

		return head;
	}		
	
	private synchronized Entry getLast() {
		return tail;
	}
	
	private synchronized Entry removeLast() {

		Entry entry = tail;
		
		if(head == tail) {
			head = tail = null;
			return entry;
		}
				
		tail = entry.prev;
		tail.next = null;
		
		return entry;
	}
	
	private synchronized void remove(Entry entry) {
		
		if(entry == head && head == tail) {
			head = tail = null;
		}			
		else if(entry == head && entry.next != null) {
			head = entry.next;
			head.prev = null;
		}
		else if(entry == tail && entry.prev != null) {
			tail = entry.prev;
			tail.next = null;
		}
		else {
		
			entry.prev.next = entry.next;
			entry.next.prev = entry.prev;
		}		
		entry = null;
	}
	
	private synchronized long getCurrentTime() {
		return System.currentTimeMillis();
	}
}