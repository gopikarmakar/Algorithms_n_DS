package com.hyend.data.storage.structures;

import java.util.Map;
import java.util.Set;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * LRU Cache Explanation 
 * 
 * @author gopi_karmakar
 */
public class LRUCache {		
	
	public static void main(String[] args) {		
								
		//removingEldestEntry();
		//notRemovingEldestEntry();
		OwnLRUCacheImplementation();		
	}
	
	/**
	 * A self LRU cache implementation without using any existing Java API.	 
	 */
	private static class OwnLRUCache {
		
		private int mCapacity = 0;
		private Set<String> items;
		private Deque<String> cache;
		
		public OwnLRUCache(int capacity) {
			
			this.mCapacity = capacity;
			items = new HashSet<String>();
			cache = new LinkedList<String>();			
		}
		
		public void add(String item) {			
			if(!items.contains(item)) {				
				if(cache.size() == mCapacity) {
					String expiredItem = cache.pollLast();
					items.remove(expiredItem);
				}
			}
			else {
				cache.remove(item);
			}
			cache.push(item);
			items.add(item);
		}
		
		public String access(String item) {
			if(!items.contains(item)) {				
				add(item);
			}
			else {
				cache.remove(item);
				cache.push(item);
			}
			return item;
		}
		
		public void iterateCache() {			
			System.out.println("Printing LRU Cache");
			cache.forEach(x -> {
				System.out.println(x);
			});
		}
	}	
	
	/**
	 * LRU cache implementation using existing Java API
	 * 
	 * In this implementation just showing the values in recently accessed order.
	 * So the capacity doesn't matter since we're not removing the eldest entry here but,
	 * LinkedHashMap will keep the items in their most recently used/accessed order. 
	 */
	private static void notRemovingEldestEntry() {
		
		int capacity = 3;
		LinkedHashMap<Integer, String> cache = new LinkedHashMap<Integer, String>(capacity, 0.75f, true);			
		
		cache.put(1000, "Federer");
		cache.put(2000, "Bradman");
		cache.put(3000, "Jordan");
		cache.put(4000, "Woods");
		cache.put(5000, "Ali");
		
		iterateInAccessAndInsertionOrder(cache);
		
		int key1 = 1000;
		System.out.printf("1. Accessting value at key: %d is %s\n", key1, cache.get(key1));
		
		int key2 = 3000;
		System.out.printf("2. Accessting value at key: %d is %s\n", key2, cache.get(key2));
		
		iterateInAccessAndInsertionOrder(cache);
	}
	
	/**
	 * LRU cache implementation using existing Java API.
	 * 
	 * Here capacity matters since we're removing the eldest entry.
	 * So the LinkedHashMap will keep the most recently used/accessed values 
	 * up to the capacity and remove least recently used/accessed values above
	 * capacity.
	 */
	@SuppressWarnings("serial")
	private static void removingEldestEntry() {
		
		int capacity = 3;
		LinkedHashMap<Integer, String> cache = new LinkedHashMap<Integer, String>(capacity, 0.75f, true) {			
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {			
				return this.size() > capacity;
			}
		};
		cache.put(1000, "Federer");
		cache.put(2000, "Bradman");
		cache.put(3000, "Jordan");
		cache.put(4000, "Woods");
		cache.put(5000, "Ali");
		
		/*int key1 = 2000;
		System.out.printf("1. Accessting value at key: %d is %s\n", key1, cache.get(key1));
		
		int key2 = 1000;
		System.out.printf("2. Accessting value at key: %d is %s\n", key2, cache.get(key2));*/
		
		iterateInAccessAndInsertionOrder(cache);
		
		cache.put(2000, "Bradman");
		cache.put(1000, "Federer");
		cache.put(7000, "Messi");
		cache.put(8000, "Kohli");
		cache.put(9000, "Pandya");
		
		/*int key3 = 1000;
		System.out.printf("1. Accessting value at key: %d is %s\n", key3, cache.get(key3));
		
		int key4 = 7000;
		System.out.printf("2. Accessting value at key: %d is %s\n", key4, cache.get(key4));*/
		
		iterateInAccessAndInsertionOrder(cache);
	}	
	
	private static void OwnLRUCacheImplementation() {		
		OwnLRUCache lruCache = new OwnLRUCache(5);
		lruCache.add("One");
		lruCache.add("Two");
		lruCache.add("Three");
		lruCache.add("Four");
		lruCache.add("Five");
		lruCache.iterateCache();
		lruCache.add("Six");
		lruCache.add("Seven");		
		lruCache.access("Four");		
		lruCache.iterateCache();
		lruCache.add("Eight");
		lruCache.access("Four");
		lruCache.add("Nine");
		lruCache.iterateCache();
				
	}
	
	private static void iterateInAccessAndInsertionOrder(Map<Integer, String> cache) {
		System.out.println("Printing LRU Cache");
		cache.forEach((key, value) -> {
			System.out.println("Key:"+ key + ", Value:" + value);
		});		
	}	
}