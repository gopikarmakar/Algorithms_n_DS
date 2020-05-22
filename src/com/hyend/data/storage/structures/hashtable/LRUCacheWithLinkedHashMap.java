package com.hyend.data.storage.structures.hashtable;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * LRU (Least Recently Used) cache implementation with LinkedHashMap.
 * If the accessed key is new and isn't present in the cache then 
 * add that key in to the cache and return. 
 * 
 * @author gopi_karmakar
 */
public class LRUCacheWithLinkedHashMap {

	public static void main(String[] args) {
		
		//LRUCache<String, String> lruCache = new LRUCacheWithLinkedHashMap().new LRUCache<>(5);
		LRUCache<String, String> lruCache = new LRUCache<>(5);
		lruCache.add("One", "one");
		lruCache.add("Two", "Two");
		lruCache.add("Three", "Three");
		lruCache.add("Four", "Four");
		lruCache.add("Five", "Five");
		lruCache.printCache();
		lruCache.add("Six", "Six");
		lruCache.add("Seven", "Seven");		
		lruCache.get("Four");
		lruCache.printCache();
		lruCache.add("Eight", "Eight");
		lruCache.get("Four");
		lruCache.add("Nine", "Nine");
		lruCache.get("Five");
		lruCache.get("Ten");
		lruCache.printCache();
	}
	
	/**
	 * The time complexity for each lookup is O(1) for the hash table lookup and
	 * O(1) for updating the queue, i.e. Total time complexity is O(1) overall.	 
	 */
	private static class LRUCache<K, V> {
		
		int cacheSize = 0;
		
		public LRUCache(int cacheSize) {
			this.cacheSize = cacheSize;			
		}
				
		@SuppressWarnings("serial")
		private Map<K, V> cache = new LinkedHashMap<K, V>(cacheSize, 0.75F, true) {
						

			//private static final long serialVersionUID = 1L;

			@Override
			public boolean removeEldestEntry(Map.Entry<K, V> e) {
				return (this.size() > cacheSize);
			}
		};
		
		public V add(K key, V value) {
					
			V v = cache.putIfAbsent(key, value);			
			return (v == null) ? value : v;
		}
		
		public V get(K key) {
			
			//if(!cache.containsKey(key))
			add(key, null);
			
			return cache.get(key);
		}
		
		public void printCache() {			
			
			System.out.println("Printing LRU Cache");		
			for(Map.Entry<K, V> entry : cache.entrySet()) {
				System.out.println("Key = " + entry.getKey() + " and Value = " + entry.getValue());
			}
		}
	}
}
