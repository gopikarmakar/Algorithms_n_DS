package com.hyend.logical.interview.questions.google;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

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
	private ConcurrentHashMap<K, WeightedValue> myMap;
	
	class WeightedValue {
		
		V value;
		transient long time = 0;
		
		public WeightedValue(V value) {			
			this.value = value;
			this.time = System.currentTimeMillis();
		}
		
		public V getValue() { 
			return value; 
		}
		
		public long getTime() { 
			return time; 
		}
	}
	
	public TimeCriticalHashMap(int limit) {
		this.limit = limit;
		myMap = new ConcurrentHashMap<K, WeightedValue>();
	}
	
	public V put(K key, V value) {
		
		myMap.putIfAbsent(key, new WeightedValue(value));
		return value;
	}	
	
	public V get(K key) throws NoSuchElementException {
		
		if(!myMap.contains(key))
			throw new NoSuchElementException("Element Not Found");
		
		WeightedValue wv = myMap.get(key);
		if(getCurrentTime() - wv.getTime() <= limit)
			return wv.getValue();		
		
		throw new NoSuchElementException("Element Expired");
	}
	
	private synchronized long getCurrentTime() {
		return System.currentTimeMillis();
	}
}
