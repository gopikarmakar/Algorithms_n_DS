package com.hyend.data.storage.structures.priorityqueue;

/**
 * A binary heap based max priority queue implementation. 
 * The priority queue is maintained in a heap-ordered complete binary tree 
 * in the array mpq[] with mpq[0] unused and the N keys in the max priority queue in mpq[1] through mpq[N]. 
 * To implement insert(), we increment N, add the new element at the end, then use swim() to restore the heap order.
 *
 * @author gopi_karmakar
 *
 * @param <Key>
 */
public class MaxPriorityQueue<Key extends Comparable<Key>> {
	
	private Key[] mpq;
	private int N = 0;

	@SuppressWarnings("unchecked")
	public MaxPriorityQueue(int max) {
		mpq = (Key[]) new Comparable[max+1];
	}
	
	/**
	 * Creating MaxPQ with keys.
	 * @param keys
	 */
	public MaxPriorityQueue(Key[] keys) {
		this(keys.length);
		for(Key k : keys)
			insert(k);
	}
	
	public boolean isEmpty() {
		return (N == 0);
	}
	
	public int size() {
		return N;
	}
	
	public void add(Key key) {
		insert(key);
	}
	
	public void addAll(Key[] keys) {
		for(Key k : keys)
			insert(k);
	}
	
	/**
	 * In an N-key priority queue, the heap algorithms require no more than 
	 * 1 + log(N) compares for insert and no more than 2lg N compares for remove the maximum.
	 * @param key
	 */
	private void insert(Key key) {
		mpq[++N] = key;
		swim(N);
	}
	
	public Key peek() {
		return mpq[1];
	}
	
	/**
	 * we take the value to be returned from mpq[1], then move pq[N] to pq[1], 
	 * decrement the size of the heap, and use sink() to restore the heap condition. 
	 * We also set the now-unused position mpq[N+1] to null to allow the system to 
	 * reclaim the memory associated with it. Code for dynamic array resizing is omitted.
	 * @return
	 */
	public Key removeMax() {
		Key max = mpq[1];
		exchange(1, N--);
		mpq[N+1] = null;
		sink(1);
		return max;
	}
	
	public void removeLast() {
		if(N > 1)
			mpq[N--] = null;	
	}
	
	private boolean less(int i, int j) {
		return (mpq[i].compareTo(mpq[j]) < 0);
	}
	
	private void exchange(int i, int j) {
		Key temp = mpq[i];
		mpq[i] = mpq[j];
		mpq[j] = temp;
	}
	
	/**
	 * Bottom up Heapify
	 * @param k
	 */
	private void swim(int k) {		
		while(k > 1 && less(k/2, k)) {
			exchange(k/2, k);
			k = k/2;
		}
	}
	
	/**
	 * Top down Heapify
	 * @param k
	 */
	private void sink(int k) {		
		while(2*k < N) {			
			int j = 2*k;
			if(j < N && less(j, j+1)) j+=1;
			if(!less(k, j)) break;
			exchange(k, j);
			k = j;
		}
	}	
}
