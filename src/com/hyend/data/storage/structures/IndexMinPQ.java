package com.hyend.data.storage.structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * In an index priority queue of size N, the number of compares 
 * required is proportional to at most log N for insert, 
 * change priority, delete, and remove the minimum.
 * 
 * @author gopi_karmakar
 *
 * @param <Key>
 */
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer> {
	
	private int n;				// Number of Elements on PQ
	private int maxN;			// Maximum Number of Elements on PQ
	private int[] pq;			// Binary heap using 1 based indexing. Hold indexes of keys in order from min to max;
	private int[] qp;			// Hold positions of keys. Inverse of pq, qp[pq[i]] = pq[qp[i]] = i;
	private Key[] keys;			// keys[i] = priority of i
	
	@SuppressWarnings("unchecked")
	public IndexMinPQ(int maxN) {
		if(maxN < 0) throw new IllegalArgumentException();
		this.maxN = maxN;
		n = 0;
		pq = new int[maxN+1];
		qp = new int[maxN+1];
		keys = (Key[]) new Comparable[maxN+1];
		for(int i = 0; i <= maxN; i++)
			qp[i] = -1;
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return (n==0);
	}	
	
	/**
	 * Returns whether index is available or not 
	 * @param i
	 * @return
	 */
	public boolean contains(int i) {
		validate(i);
		return (qp[i] != -1);
	}
	
	/**
	 * Associates key with index and tracks of index in qp[]
	 * @param i
	 * @param key
	 */
	public void insert(int i, Key key) {
		validate(i);
		n++;
		qp[i] = n;
		pq[n] = i;
		keys[i] = key;
		swim(n);
	}
	
	public int minIndex() {
		return pq[1];
	}
	
	public Key minKey() {
		return keys[pq[1]];
	}
	
	/**
	 * Returns the actual key without and priority ordering 
	 * from the keys as per index. 
	 * @return
	 */
	public Key keyOf(int i) {
		validate(i);
		if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
		else return keys[i];
	}
	
	/**
	 * Change the key associated with index {@code i} to the specified value.
	 * @param i
	 * @param key
	 */
	public void changeKeyAt(int i, Key key) {
		validate(i);
		if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
		keys[i] = key;
		swim(qp[i]);
		sink(qp[i]);
	}
	
	/**
	 * Removes a minimum key and returns its associated index.
	 * @return
	 */
	public int deleteMin() {
		if (n == 0) throw new NoSuchElementException("Priority queue underflow");
		int min = pq[1];
		exchange(1, n--);
		sink(1);
		assert (min == pq[n+1]);
		qp[min] = -1;		// delete the key position.
		keys[min] = null;	// to help with garbage collection
		// Since the last element of pq is moved to first position. So removing the value from last position. 
		pq[n+1] = -1;
		return min;
	}
	
	public void delete(int i) {
		validate(i);
		if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
		int index = qp[i];
		exchange(index, n--);
		swim(index);
		sink(index);
		keys[i] = null;
		qp[i] = -1;
	}
	
	/**
	 * Decrease the key associated with index to the specified value.
	 * 
	 * @param  i the index of the key to decrease
     * @param  key decrease the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if {@code key >= keyOf(i)}
     * @throws NoSuchElementException no key is associated with index
	 * @param i
	 * @param key
	 */
	public void decreaseKeyAt(int i, Key key) {
        if (i < 0 || i >= maxN) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) <= 0)
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        keys[i] = key;
        swim(qp[i]);
    }
	
	/**
     * Increase the key associated with index to the specified value.
     *
     * @param  i the index of the key to increase
     * @param  key increase the key associated with index {@code i} to this key
     * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if {@code key <= keyOf(i)}
     * @throws NoSuchElementException no key is associated with index
     */
    public void increaseKey(int i, Key key) {
        if (i < 0 || i >= maxN) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) >= 0)
            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        keys[i] = key;
        sink(qp[i]);
    }
	
	/**
	 * Helper Functions.
	 */	
	private void validate(int index) {
		if(index < 0 || index >= maxN) throw new IllegalArgumentException();
	}
	
	private boolean isGreater(int i, int j) {
		return (keys[pq[i]].compareTo(keys[pq[j]]) > 0);
	}
	
	private void exchange(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}
	
	private void swim(int k) {
		if(k > 1 && isGreater(k/2, k)) {
			exchange(k, k/2);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while(2*k <= n) {
			int j = 2*k;
			if(j < n && isGreater(j, j+1)) j+=1;
			if(!isGreater(k, j)) break;
			exchange(k, j);
			k = j;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new HeapIterator();
	}
	
	class HeapIterator implements Iterator<Integer> {
		
		private IndexMinPQ<Key> copy;
		
		public HeapIterator() {
			copy = new IndexMinPQ<>(pq.length-1);
			for(int i = 1; i <= size(); i++) {
				copy.insert(pq[i], keys[pq[i]]);
			}
		}

		@Override
		public boolean hasNext() {			
			return !copy.isEmpty();
		}

		@Override
		public Integer next() {
			if(!hasNext()) throw new NoSuchElementException();
			return copy.deleteMin();
		}
	}
}
