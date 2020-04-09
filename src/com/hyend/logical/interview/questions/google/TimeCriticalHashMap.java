package com.hyend.logical.interview.questions.google;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * A google telephonic screening phone interview question.
 * 
 * Solution: implement a time critical hashmap, such that you are given input as: 
 * key, value & time-limit. If the time limit gets over and then the hashmap 
 * must not return any value. This should be strictly implemented as an Object Oriented code.
 * 
 * @author gopi_karmakar
 */
public class TimeCriticalHashMap<K extends Comparable<K>, V> {

	private transient int limit = 0;
	private ConcurrentMap<K, Pair> myMap;
	
	class Pair {
		
		V value;
		transient long time = 0;
		
		public Pair(V value) {			
			this.value = value;
			this.time = System.currentTimeMillis();
		}
		
		public V getValue() { 
			return value; 
		}
		
		public long getSavedTime() { 
			return time; 
		}
	}
	
	public TimeCriticalHashMap(int limit) {
		this.limit = limit;
		myMap = new ConcurrentHashMap<K, Pair>();
	}
	
	public V put(K key, V value) {
		
		myMap.put(key, new Pair(value));
		return value;
	}	
	
	public V get(K key) throws NoSuchElementException {
		
		if(!myMap.containsKey(key))
			throw new NoSuchElementException("Element Not Found");
		
		Pair wv = myMap.get(key);
		if(getCurrentTime() - wv.getSavedTime() > limit) {
			
			myMap.remove(key);
			throw new NoSuchElementException("Element Expired");
		}
		
		return wv.getValue();		
	}
	
	private synchronized long getCurrentTime() {
		return System.currentTimeMillis();
	}
}
