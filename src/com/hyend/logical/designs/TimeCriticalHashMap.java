package com.hyend.logical.designs;

import java.util.concurrent.ConcurrentHashMap;


/**
 * A google telephonic screening phone interview question.
 * 
 * Solution: implement a time critical hashmap, such that you are given input as: 
 * key, value & time-limit. If the time limit gets over and then the hashmap 
 * must not return any value. This should be strictly implemented as an Object Oriented code.
 * 
 * @author gopi_karmakar
 *
 * @param <K>
 * @param <V>
 */
public class TimeCriticalHashMap<K, V> {

	private transient int limit = 0;
	private ConcurrentHashMap<K, WeightedValue> myMap;
	
	class WeightedValue {		
		V value;
		transient long time = 0;
		public WeightedValue(V value) {			
			this.value = value;
			this.time = System.currentTimeMillis();
		}
		public V getValue() { return value; }
		public long getCurrentTime() { return time; }
	}
	
	public TimeCriticalHashMap(int limit) {
		this.limit = limit;
		myMap = new ConcurrentHashMap<K, WeightedValue>();
	}
	
	public V put(K key, V value) {		
		myMap.put(key, new WeightedValue(value));
		return value;
	}	
	
	public V get(K key) {
		WeightedValue wv = myMap.get(key);
		if(wv.getCurrentTime() - getCurrentTime() <= limit)
			return wv.getValue();
		else return null;
	}
	
	private synchronized long getCurrentTime() {
		return System.currentTimeMillis();
	}
}
