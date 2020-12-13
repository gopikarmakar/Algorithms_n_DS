package com.hyend.data.storage.search;

/**
 * https://leetcode.com/problems/majority-element/
 * 
 * Find the majority element from a pool of elements
 * in O(n) time and without using any extra memory. 
 * 
 * @author gopi_karmakar
 */
public class FindMajorityElement {

	public static void main(String[] args) {
		
		String[] keys = {"b","a","c","a","a","b","a","a","c","a"};
		System.out.println("Majority Element = " + majority(keys));
	}
	
	/**
	 * O(n) Time complexity with O(1) extra space.
	 * 
	 * Accepted in Leetcode with 1ms runtime
	 */
	private static String majority(String...keys) {
		
		int count = 0;
		String element = "";
		
		for(String k : keys) {
			
			if(count == 0) {
				
				element = k;
				count += 1;
			}
			else if(element.equals(k))
				count++;
			else
				count--;
		}		
		return element;
	}
}