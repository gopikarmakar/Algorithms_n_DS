package com.hyend.data.storage.structures.priorityqueue;

import java.util.Collection;

public class MinPriorityQueue {
	
	public static void main(String[] args) {
		
		MyPriorityQueue<Integer> minPQ = new MyPriorityQueue<Integer>(10);
		minPQ.add(5);
		minPQ.add(3);
		minPQ.add(4);
		minPQ.add(2);
		minPQ.add(1);
		
		while(!minPQ.isEmpty()) {
			printMSG(minPQ.remove().toString());			
		}
	}
	
	private static void printMSG(String msg) {
		System.out.println("" + msg);
	}
	
	private static class MyPriorityQueue<Key extends Comparable<Key>> {
		
		private int N = 0;
		private Key[] minPQ;	
		
		@SuppressWarnings("unchecked")
		public MyPriorityQueue(int capacity) {
			minPQ = (Key[]) new Comparable[capacity+1];
		}
		
		public MyPriorityQueue(Collection<Key> keys) {
			this(keys.size());
			addAll(keys);
		}
		
		public void add(Key key) {
			insert(key);
		}
		
		public void addAll(Collection<Key> keys) {
			for(Key k : keys)
				insert(k);
		}
		
		public Key peek() {
			return minPQ[1];
		}
		
		public Key remove() {
			if(minPQ == null || N == 0)
				throw new IllegalStateException("Min PQ is empty");
			Key min = minPQ[1];
			exchange(1, N--);
			minPQ[N+1] = null;
			sink(1);
			return min;
		}
		
		public int size() {
			return N;
		}
		
		public boolean isEmpty() {
			return (size() == 0);
		}
		
		private void insert(Key k) {
			minPQ[++N] = k;
			swim(N);
		}
		
		/**
		 * @param N
		 */
		private void sink(int k) {
			while(2*k <= N) {
				int j = 2*k;
				if(j < N && isGreaterThan(j, j+1)) j++;
				if(!isGreaterThan(k, j)) break;
				exchange(k, j);
				k = j;
			}
		}
		
		/**
		 * @param index
		 */
		private void swim(int index) {
			while(index > 1 && isGreaterThan(index/2, index)) {
				exchange(index/2, index);
				index /= 2;
			}
		}
			
		private boolean isGreaterThan(int l, int r) {
			return (minPQ[l].compareTo(minPQ[r]) > 0);
		}
		
		private void exchange(int l, int r) {
			Key t = minPQ[l];
			minPQ[l] = minPQ[r];
			minPQ[r] = t;
		}
	}
}
