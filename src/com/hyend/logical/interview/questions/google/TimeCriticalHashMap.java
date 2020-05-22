package com.hyend.logical.interview.questions.google;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

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
public class TimeCriticalHashMap<K extends Comparable<K>, V>
		extends LinkedHashMap<K, Element<K, V>> {
	
	public static void main(String[] args) {
		
		TimeCriticalHashMap<String, String> myMap = 
				new TimeCriticalHashMap<>();
		
		myMap.put("1", "One");
		myMap.put("2", "Two");
		myMap.put("3", "Three");
		myMap.put("4", "Four");
		myMap.put("5", "Five");
		
		//print(myMap);		
		
		try {	
			
			Thread.sleep(2);
			System.out.println(myMap.get("2"));
			
			Thread.sleep(1);
			
			//System.out.println("Current Time = " + System.currentTimeMillis());			
			//print(myMap);
			
			System.out.println(myMap.get("1"));						
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}				
		catch (NoSuchElementException nse) {
			System.out.println(nse.getMessage());
		}
		
		try {			
			
			//System.out.println("Current Time = " + System.currentTimeMillis());			
			//print(myMap);
			
			Thread.sleep(3);
			
			System.out.println(myMap.get("2"));					
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (NoSuchElementException nse) {
			System.out.println(nse.getMessage());
		}
		
		try {			
			System.out.println(myMap.get("3"));			
		} 
		catch (NoSuchElementException nse) {
			System.out.println(nse.getMessage());
		}
	}

	/**
	 * Default Serial Version UID 
	 */
	private static final long serialVersionUID = 1L;
	
	private int limit;
	
	public TimeCriticalHashMap() {
		this(5);
	}
			
	public TimeCriticalHashMap(int limit) {
		super(16, 0.75f, false);
		this.limit = limit;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, Element<K, V>> entry) {
		System.out.println("Eldest Entry == " + entry.getValue().v);
		return ((getCurrentTime() - entry.getValue().time) > limit);
	}
	
	public synchronized V put(K k, V v) {
		
		Element<K, V> e = this.getOrDefault(k, new Element<>(k, v));
		e.updateTime();
		super.put(k, e);
		return v;
	}
	
	public synchronized V get(K k) {
		
		if(k == null)
			throw new NullPointerException("Key Can't Be Null");
		
		Element<K, V> e = super.remove(k);
		if(e == null)
			throw new NoSuchElementException("Item removed since It was too old to be in the pool");									
		
		long diff = getCurrentTime() - e.time;
		
		if(diff > this.limit) {			
			throw new NoSuchElementException("Item Expired");
		}
		
		return put(k, e.v);
	}
	
	private synchronized long getCurrentTime() {
		
		return System.currentTimeMillis();
	}
	
	private static <K extends Comparable<K>, V> void print(TimeCriticalHashMap<K, V> myMap) {
		
		for(Map.Entry<K, Element<K, V>> e : myMap.entrySet()) {
			
			System.out.println("Value = " + e.getValue().v + " Time = " + e.getValue().time);
		}
	}
}
