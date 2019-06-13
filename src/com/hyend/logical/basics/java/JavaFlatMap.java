package com.hyend.logical.basics.java;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/** 
 * What is flattening
 * 
 * Before flattening   : [[1, 2, 3], [4, 5], [6, 7, 8]]
 * After flattening    : [1, 2, 3, 4, 5, 6, 7, 8]
 *
 * @author gopi_karmakar
 */
public class JavaFlatMap {

	public static void main(String[] args) {
		integerArrayFlatMap();
		stringArrayFlatMap();			
	}
	
	private static void integerArrayFlatMap() {
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(4,5,6);
		List<Integer> list3 = Arrays.asList(7,8,9);
		
		List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
		
		List<Integer> list = listOfLists.stream()
										.flatMap(x -> x.stream())
										.collect(Collectors.toList());
		
		System.out.println(list);
	}
	
	/**
	 * FlatMap won't sort the data. It'll just convert the sublist as a one list. 
	 */
	private static void stringArrayFlatMap() {
		String[][] data = {{"a", "b"}, {"g", "h"}, {"e", "f"}, {"c", "d"}, };
		
		List<String> list = Arrays.stream(data)
								  .flatMap(x -> Arrays.stream(x))
								  .collect(Collectors.toList());
		System.out.println(list);
	}
}
