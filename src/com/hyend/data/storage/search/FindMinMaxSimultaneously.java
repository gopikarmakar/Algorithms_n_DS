package com.hyend.data.storage.search;

/**
 * Find the Min and Max simultaneously such that it takes the 
 * least comparisons. Since some times the comparison can be very expensive 
 * in case of very long strings comparisons or if the objects in the array 
 * may have nested calls. Therefore, it is natural to ask if both the 
 * min and the max can be computed with less than the 2(n - 1)
 * comparisons required to compute the min and the max independently. 
 * 
 * @author gopi_karmakar
 */
public class FindMinMaxSimultaneously {

	public static void main(String[] args) {
		
		int[] arr = {3, 2, 5, 1, 2, 4, -5};
		
		MinMax minMax = findMinMax(arr);
		
		System.out.println("Min = " + minMax.min + " and Max = " + minMax.max);
	}
	
	private static class MinMax {
		
		public int min, max;
		
		public MinMax(int min, int max) {
			this.min = min;
			this.max = max;
		}
		
		public static MinMax minMax(int min, int max) {
			
			return (Integer.compare(max, min) < 0) ? new MinMax(max, min) : new MinMax(min, max);
		}			
	}
	
	/**
	 * It's a streaming style implemented solution
	 * with O(n) time complexity, O(1) extra space and
	 * with something around (n-2/2) comparisons.  
	 */
	private static MinMax findMinMax(int...arr) {
		
		int n = arr.length;
		if(n <= 1) return new MinMax(0, 0);
	
		MinMax globalMinMax = MinMax.minMax(arr[0], arr[1]);
		
		for(int i = 2; i < n-1; i += 2) {
			
			MinMax localMinMax = MinMax.minMax(arr[i], arr[i+1]);
			
			globalMinMax = new MinMax(Math.min(globalMinMax.min, localMinMax.min), 
									  Math.max(globalMinMax.max, localMinMax.max));
		}
		
		/**
		 * Since we're incrementing by 2 i.e we need to 
		 * check the last digit for odd length array. 
		 */
		if(arr.length %2 != 0) {
			
			globalMinMax = new MinMax(Math.min(globalMinMax.min, arr[n-1]),
									  Math.max(globalMinMax.max,  arr[n-1]));
		}		
		return globalMinMax;				
	}
	
	
}
