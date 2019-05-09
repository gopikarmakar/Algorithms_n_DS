package com.hyend.data.storage.sort;

public class TestSort {
	
	 	
	public static void main(String[] args) {
		
		int[] arr = {3,1,5,2,7,4,8,6,9,0};
		//SelectionSort sSort = new SelectionSort();
		//sSort.sort(arr);
		MergeSort mSort = new MergeSort();
		mSort.sort(arr);
		for(int x : arr) {
			printMSG(x);
		}
	}
	
	private static void printMSG(int x) {		
		System.out.println(x);
	}
	
	private static void printMSG(String x) {		
		System.out.println(x);
	}
}
