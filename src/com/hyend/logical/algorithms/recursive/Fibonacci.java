package com.hyend.logical.algorithms.recursive;

public class Fibonacci {
	
	int[] array;
	int x = 0, y = 1, sum = 0, limit = 0, counter = 2;
	
	public Fibonacci() {}
			
	public Fibonacci(int limit) {
		this.limit = limit;
		array = new int[this.limit];
		array[0] = 0;
		array[1] = 1;
	}
	
	public int[] nonRecursive() {
		
		while(counter != limit) {
			sum = x + y;
			array[counter] = sum;
			x = y;
			y = sum;
			counter++;
		}
		return array;
	}
	
	/**
	 * Very inefficient
	 * 
	 * @return
	 */
	public int[] recursive() {
				
		if(counter == this.limit) return array;
		sum = x + y;
		array[counter++] = sum;
		x = y;
		y = sum;
		return recursive();
	}
	
	/**
	 * Find a Fibonacci number at a given position. 
	 * Bottom up approach.
	 * @param n
	 * @return
	 */
	public int findFib(int pos) {
		
		array = new int[pos];
		array[0] = 0;
		array[1] = 1;
		
		if(pos == 1) 		return array[0];
		else if(pos == 2) 	return array[1];
		
		while(counter < pos) {
			array[counter] = array[counter-1] + array[counter-2];
			counter++;
		}			
		return array[counter-1];
	}
	
	/**
	 * Find a Fibonacci number at a given position. 
	 * Memoized solution.
	 * @param limit
	 * @param temp
	 * @return
	 */
	public int findFibMemoized(int limit) {
		int[] temp = new int[limit+1];
		return memoized(limit, temp);
	}
	private int memoized(int pos, int[] temp) {
		
		if(temp[pos] != 0) {
			return temp[pos];
		}
		
		if(pos == 1 || pos == 2)	return 1;
		else {
			sum = memoized(pos-1, temp) + memoized(pos-2, temp);
			temp[pos] = sum;
		}
		return temp[pos];		
	}
}
