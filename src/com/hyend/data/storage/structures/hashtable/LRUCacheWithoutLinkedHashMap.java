package com.hyend.data.storage.structures.hashtable;

import java.util.Set;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * LRU (Least Recently Used) cache implementation without LinkedHashMap. 
 * 
 * @author gopi_karmakar
 */
public class LRUCacheWithoutLinkedHashMap {		
	
	public static void main(String[] args) {		
								
		//LRUCache<String> lruCache = new LRUCacheWithoutLinkedHashMap().new LRUCache<>(5);
		LRUCache<String> lruCache = new LRUCache<>(5);
		lruCache.get("One");
		lruCache.add("Two");
		lruCache.add("Three");
		lruCache.add("Four");
		lruCache.add("Five");
		lruCache.printCache();
		lruCache.add("Six");
		lruCache.add("Seven");		
		lruCache.get("Four");		
		lruCache.printCache();
		lruCache.add("Eight");
		lruCache.get("Four");
		lruCache.add("Nine");
		lruCache.printCache();
		lruCache.get(null);
	}
		
	/**
	 * The time complexity for each lookup is O(1) for the hash table lookup and
	 * O(1) for updating the queue, i.e. Total time complexity is O(1) overall.
	 */
	private static class LRUCache<K> {
		
		private int mCapacity = 0;
		private Set<K> items;
		private Deque<K> cache;
		
		public LRUCache(int capacity) {
			
			this.mCapacity = capacity;
			items = new HashSet<K>();
			cache = new LinkedList<K>();			
		}
		
		public K add(K item) throws UnsupportedOperationException {
			
			if(item == null)
				throw new UnsupportedOperationException("Null Not Supported");
			
			if(!items.contains(item)) {				
				if(cache.size() >= mCapacity) {
					K expiredItem = cache.pollLast();
					items.remove(expiredItem);
				}
			}
			else {
				cache.remove(item);
			}
			cache.addFirst(item);
			items.add(item);
			
			return item;
		}
		
		public K get(K item) throws UnsupportedOperationException {
			
			/*if(item == null)
				throw new UnsupportedOperationException("Null Not Supported");*/
			
			/*if(!items.contains(item)) {				
				add(item);
			}
			else {
				cache.remove(item);
				cache.addFirst(item);
			}
			return item;*/
			
			return add(item);
		}
		
		public void printCache() {			
			System.out.println("Printing LRU Cache");
			cache.forEach(x -> {
				System.out.println(x);
			});
		}
	}
}
