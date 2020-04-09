package com.hyend.logical.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Knapsack problem.
 * Suppose there're a few items given with their value and weights and we have 
 * a bag which can carry up to some certain weight. Pick some items with in the 
 * bag's capacity such that the items are to be of maximum value.
 * 
 * to pick items with in a given 
 * 
 * @author gopi_karmakar
 */
public class KnapSackProblem {

	public static void main(String[] args) {
		
		// Suppose the bag's capacity is up to 5KG.
		int capacity = 5;
		List<Item> items = createSampleData();
		int[][] cache = new int[items.size()][capacity + 1];
						
		for(int[] c : cache) {
			
			Arrays.fill(c, -1);
		}
		
		int result = optimumSubjectToCapacity(items, items.size()-1, capacity, cache);
		
		System.out.println(result);
	}
		
	/**
	 * The algorithm computes cache[n - 1][w] in O(n * w) time, and uses O(n * w) space.
	 */
	private static int optimumSubjectToCapacity(List<Item> items, int k, int capacity, int[][] cache) {
		
		if(k < 0)
			return 0;
		
		if(cache[k][capacity] == -1) {
			
			int withoutCurrentItem = optimumSubjectToCapacity(items, k - 1, capacity, cache);
			
			int withCurrentItem = (capacity < items.get(k).weight) ? 0 : 
				items.get(k).value + optimumSubjectToCapacity(items, k - 1, capacity - items.get(k).weight, cache);
			
			cache[k][capacity] = Math.max(withCurrentItem, withoutCurrentItem);
		}
		return cache[k][capacity];
	}
	 
	/////////////////////////////// Sample Data Creation /////////////////////////////
	 
	private static class Item {
		
		public int value;
		public int weight;
		
		public Item(int price, int weight) {
			this.value = price;
			this.weight = weight;
		}
		
		@Override
		public String toString() {			
			return "Weight = " + this.weight + " Price = " + this.value;
		}
	}
	
	/**
	 * Let's says there're four items given with their price in USD and weight in KG  
	 */
	private static List<Item> createSampleData() {
		
		List<Item> items = new ArrayList<>();
		
		int[][] data = {{60, 5}, {50, 3}, {70, 4}, {30, 2}};
		
		for(int[] item : data) {
			
			items.add(new Item(item[0], item[1]));
		}
		return items;
	}
}
