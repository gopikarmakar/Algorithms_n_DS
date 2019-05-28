package com.hyend.data.storage.structures.priorityqueue;

public class MinPriorityQueue {

	private int index = 0;
	private int[] minPQ;
	
	public MinPriorityQueue() {
		this(0);
	}
	
	public MinPriorityQueue(int capacity) {
		this.minPQ = new int[capacity+1];
	}
	
	public void add(int k) {
		insert(k);
	}
	
	public void addAll(int[] keys) {
		for(int k : keys)
			insert(k);
	}
	
	public int peek() {
		return minPQ[1];
	}
	
	public int remove() {
		if(minPQ == null || index == 0)
			throw new IllegalStateException("Min PQ is empty");
		int min = minPQ[1];
		exchange(1, index--);
		minPQ[index+1] = 0;
		sink(1);
		return min;
	}
	
	public int size() {
		return index-1;
	}
	
	private void insert(int k) {
		minPQ[++index] = k;
		swim(index);
	}
	
	/**
	 * 6 2 3 4 5
	 * @param index
	 */
	private void sink(int k) {
		while(2*k <= index) {
			int j = 2*k;
			if(j < index && isGreaterThan(j+1, j)) j++;
			if(!isGreaterThan(k, j)) break;
			exchange(k, j);
			k = j;
		}
	}
	
	/**
	 * 2 3 4 1
	 * @param index
	 */
	private void swim(int index) {
		if(index > 1 && isGreaterThan(index/2, index)) {
			exchange(index/2, index);
			index /= 2;
		}
	}
		
	private boolean isGreaterThan(int l, int r) {
		return (minPQ[l] > minPQ[r]);
	}
	
	private void exchange(int l, int r) {
		int t = minPQ[l];
		minPQ[l] = minPQ[r];
		minPQ[r] = t;
	}
}
