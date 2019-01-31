package com.hyend.data.storage.structures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A concrete hashing based symbol table implementation
 * to store a huge number of key / value pairs.
 * It's a separate chaining implementation for hash collisions.
 * 
 * Average-case cost (after N random inserts & search):
 * Insert : O(1)
 * Search : O(1)
 * 
 * Worst-case cost (after N random inserts & search):
 * Insert : < log(N)
 * Search : < log(N)
 * 
 * @author gopi_karmakar
 *
 * @param <K>
 * @param <V>
 */
public class MyHashTable<K, V> {
	
	// 75% of the initial capacity.
	final float DEFAULT_LOAD_FACTOR = .75f;
	
	/**
	 * A power of two.
	 * It means: (1 * (2 ^ 4)) aka 16
	 */
	final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
	
	private int totalSize = 0;
	
	private int currentThreshold = 0;
	
	/**
	 * A power of two.
	 * It means: (1 * (2 ^ 30))
	 * aka Integer.MAX_VALUE / 2
	 */
	private int currentMaxCapacity = 1 << 30;
	
	private Node<K, V> mainSymbolTable[];
	
	public MyHashTable() {}
	
	static class Node<K, V> {	
		
		K key;
		V value;
		Node<K, V> next;
		int hash;
		Node(int hash, K key, V value) {
			this.key = key;
			this.value = value;
			this.hash = hash;
		}
		
		public K getKey() {
			return this.key;
		}
		
		public V getValue() {
			return this.value;
		}
		
		public int getHash() {
			return this.hash;
		}
	}
	
	private class HashIterator implements Iterator<Node<K, V>> {
		
		int index = 0;
		Node<K, V> next;
		
		public HashIterator() {
			Node<K, V>[] tab = mainSymbolTable;
			if(tab != null && size() > 0) {
				do {} while(index < tab.length && ((next = tab[index++]) == null));
			}
		}

		@Override
		public boolean hasNext() {		
			return (next != null);
		}

		@Override
		public Node<K, V> next() {
			Node<K, V>[] tab;
			Node<K, V> temp = next;
			if(temp == null)
				throw new NoSuchElementException();
			if((next = temp.next) == null && (tab = mainSymbolTable) != null) {
				do {} while(index < tab.length && ((next = tab[index++]) == null));
			}
			return temp;
		}		
	}
	
	private class KeyIterator implements Iterator<K> {
		
		HashIterator hashIterator = null;
		
		public KeyIterator() {
			hashIterator = new HashIterator();
		}

		@Override
		public boolean hasNext() {			
			return hashIterator.hasNext();
		}

		@Override
		public K next() {			
			return hashIterator.next().key;
		}		
	}
	
	private class ValueIterator implements Iterator<V> {
		
		HashIterator hashIterator = null;
		
		public ValueIterator() {
			hashIterator = new HashIterator();
		}

		@Override
		public boolean hasNext() {			
			return hashIterator.hasNext();
		}

		@Override
		public V next() {			
			return hashIterator.next().value;
		}		
	}

	public int size() {
		return totalSize;
	}
	
	public boolean isEmpty() {
		HashMap<String, String> hmap = new HashMap<>();
		hmap.values();
		return (totalSize == 0);				
	}
	
	public void printAll() {		
		for(Node<K, V> node : mainSymbolTable) {
			if(node != null) {
				//System.out.println("Key = " + node.key + " Value  = " + node.value);
				while(node.next != null) {					
					//System.out.println("Key = " + node.next.key + " Value  = " + node.next.value);
					node = node.next;
				}
			}
		}
	}
	
	public V put(K key, V value) {		
		Node<K, V> node;
		int length, index;
				
		if(mainSymbolTable == null || (length = mainSymbolTable.length) == 0) {
			resize();
			length = mainSymbolTable.length;			
		}
		
		int hash = hash(key);
		//int hash = modularHash(key);
		//System.out.println("Hash Code = " + hash);
		/**
		 * The and(&) between the length of the array and the hash of the key
		 * make sure that all bits play their role to dispersed widely and 
		 * provide a small integer value for index with in the range of array. 
		 */
		if((node = mainSymbolTable[index = ((length-1) & hash)]) == null) {
			//System.out.println("Index = " + index);
			mainSymbolTable[index] = new Node<K, V>(hash, key, value);			
		}
		else {			
			Node<K, V> temp = null;
			if(node.hash == hash && ((key == node.key) || 
					(key != null && key.equals(node.key)))) {
				/**
				 * Just break, because this case will be taken care 
				 * in the code below line #106.
				 */
				temp = node;
			}
			else {
				for(;;) {					
					if((temp = node.next) == null) {
						node.next = new Node<K, V>(hash, key, value);
						break;
					}				
					if(temp.hash == hash && ((key == temp.key) || 
							(key != null && key.equals(temp.key)))) {
						/**
						 * Just break, because this case will be taken care 
						 * in the code below line #106.
						 */
						break;
					}
					node = temp;
				}				
			}					
			//Mapping the value of an existing key.						
			if(temp != null) {
				V oldValue = node.value;
				node.value = value;
				return oldValue;
			}
		}		
		// If current threshold exceeds resize the symbol table.		 
		if (++totalSize > currentThreshold)
            resize();
		
		return null;
	}
	
	public V get(K key) {			
		if(mainSymbolTable != null && !isEmpty()) {
			int hash = hash(key);			
			int index = ((mainSymbolTable.length -1) & hash);
			Node<K, V> node = mainSymbolTable[index];
			if(node != null) {			
				if(node.hash == hash && ((node.key == key) || 
						(key != null && key.equals(node.key)))) {
					return node.value;
				}
				else {
					while(node.next != null) {
						node = node.next;
						if(node.hash == hash && ((node.key == key) || 
								(key != null && key.equals(node.key)))) {
							return node.value;
						}
					}
				}
			}
		}
		return null;
	}
	
	public Iterator<K> getKeySet() {
		KeyIterator keyIterator = new KeyIterator();
		return keyIterator;
	}
	
	public Iterator<V> getValueSet() {
		ValueIterator valueIterator = new ValueIterator();
		return valueIterator;
	}
	
	/**
	 * Deleting a key
	 * 
	 * @param key
	 * @return
	 */
	public V delete(K key) {
		
		if(mainSymbolTable != null && isEmpty()) {
			int hash = hash(key);
			int index = ((mainSymbolTable.length -1) & hash);
			Node<K, V> node = mainSymbolTable[index];
			if(node != null ) {
				if((node.hash == hash) && ((node.key == key) || 
						(key != null) && key.equals(node.key))) {
					V value = node.value;
					mainSymbolTable[index] = node.next;
					totalSize -= 1;
					return value;
				}
			}
			else {
				while(node.next != null) {
					node = node.next;
					if((node.hash == hash) && ((node.key == key) || 
							(key != null) && key.equals(node.key))) {
						V value = node.value;							
						node.key = node.next.getKey();
						node.hash = node.next.getHash();
						node.value = node.next.getValue();
						node.next = node.next.next;
						node = node.next;
						totalSize -= 1;
						return value;
					}
				}					
			}				
		}
		return null;
	}
	
	/**
	 * Converting a hashCode() to an array index.
	 * Since our goal is an array index, not a 32-bit integer.
	 * 
	 * A Java's hash function implementation.
	 * Computes key.hashCode() and spreads (XORs) higher bits of hash
     * to lower.  Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys
     * holding consecutive whole numbers in small tables.)  So we
     * apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and
     * quality of bit-spreading. Because many common sets of hashes
     * are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of
     * collisions in bins, we just XOR some shifted bits in the
     * cheapest possible way to reduce systematic lossage, as well as
     * to incorporate impact of the highest bits that would otherwise
     * never be used in index calculations because of table bounds.
     * 
     * In this implementation masking of the signed bit by unsigned right shifting
     * and applying a transform the impact of higher bits to downwards by XOR.
	 * 
	 * @param key
	 * @return
	 */
	private int hash(K key) {
		int hash = key.hashCode();
		/**
		 * Unsigned (hash >>> 16)
		 * aka: (hash / (2 ^ 16))
		 */
		int rHash = (hash >>> 16);
		//System.out.println("Hash before right shift = " + hash);
		//System.out.println("Hash after right shift = " + rHash);		
		return (key == null) ? 0 : (hash) ^ (rHash); 
	}
	
	/**
	 * Converting a hashCode() to an array index. 
	 * Since our goal is an array index, not a 32-bit integer.
	 * 
	 * In this modular hashing implementation, masks off the sign bit 
	 * (to turn the 32-bit number into a 31-bit nonnegative integer)
	 * and then modulo the hashCode() by threshold, to produce 
	 * integers between 0 and max_capacity – 1.
	 * 
	 * Modulus by a prime number is the since it makes sure that all.
	 * bits play it's role which helps to disperse widely in the array.
	 * But in our case we're doing mod by threshold since the symbol table
	 * array is a resizing table an d we can't every time mod by a constant 
	 * number. It should be mod by the number with in the capacity range.
	 * 
	 * In case of modular hashing the average time complexity to 
	 * insert & search a key would be num_of_key / table_length;
	 * 
	 * @param key
	 * @return
	 */
	private int modularHash(K key) {
		return (key.hashCode() & 0x7fffffff) % currentThreshold;
	}
	
	/**
	 * Resizing the symbol table in case if it reaches
	 * it's current threshold or current max capacity.
	 * After resizing copying the previous data to  
	 * the new extended symbol table. 
	 * 
	 * @return
	 */
	private void resize() {
								
		int newCapacity = 0;
		int newThreshold = 0;
		Node<K, V>[] oldTable = mainSymbolTable;
		int oldThreshold = this.currentThreshold;
		int oldCapacity = (oldTable == null) ? 0 : oldTable.length;
		
		if(oldCapacity > 0) {
			if(oldCapacity >= currentMaxCapacity) {				
				// 
				/**
				 * Just Doubling the max_cap and threshold will be 75% of that.
				 * since, 1*2^30 aka Integer.MAX_VALUE / 2.
				 */
				newCapacity = currentMaxCapacity = Integer.MAX_VALUE;				
				newThreshold = (int) (DEFAULT_LOAD_FACTOR * newCapacity);
			}
			else {
				 //Just Doubling the new capacity by old_cap * 2^1;
				newCapacity = oldCapacity << 1;
				if(newCapacity >= currentMaxCapacity && oldCapacity >= DEFAULT_INITIAL_CAPACITY) {
					newCapacity = currentMaxCapacity;
					newThreshold = (int) (DEFAULT_LOAD_FACTOR * newCapacity);
				}
				else if(newCapacity < currentMaxCapacity && oldCapacity >= DEFAULT_INITIAL_CAPACITY) {
					//Since doubling new capacity from capacity so doubling new threshold as well.
					newThreshold = oldThreshold << 1;
				}
			}
		}
		else {
			// Setting initial capacity & threshold for new table if not present.
			newCapacity = DEFAULT_INITIAL_CAPACITY;
			newThreshold = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
		}
		
		currentThreshold = newThreshold;
		//System.out.println("threshold = " + currentThreshold);
		@SuppressWarnings("unchecked")
		Node<K, V>[] newTable = (Node<K, V>[])new Node[newCapacity];
		/**
		 * Recreate the data structure and Copy the data 
		 * from previous table to newly extended table.
		 */
		if(oldTable !=  null) {			
			for(Node<K, V> node : oldTable) {				
				if(node != null) {
					/**
					 * Every node has it's own chain.
					 */
					newTable[(oldCapacity - 1) & node.hash] = node;					
				}
			}
		}
		mainSymbolTable = newTable;
	}
}