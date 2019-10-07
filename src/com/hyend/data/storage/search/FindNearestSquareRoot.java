package com.hyend.data.storage.search;

/**
 * Given a number find the nearest square root for that number.
 * For e.g : 
 * sqrt(16) = return 4 
 * sqrt(27) = return 5, Since 5^5 = 25 and 6^6 = 36  
 * Since the 25 < 27 but 36 > 27 so the nearest sqrt(27) = return 5 
 * 
 * @author gopi_karmakar
 */
public class FindNearestSquareRoot {

	public static void main(String[] args) {
		
		int k = 300;
		System.out.println("Nearest SQRT[" + k + "] = " + nearestSQRT(300));
	}
	
	/**
	 * An O(log k) time complexity solution 
	 */
	private static int nearestSQRT(long k) {
		
		long l = 0, r = k;
		
		while(l <= r) {
			
			long mid = l + (r - l) / 2;
			long midSquared = mid * mid;
			
			if(midSquared <= k)
				l = mid + 1;
			else 
				r = mid - 1;
		}
		return (int) l-1;
	}
}
