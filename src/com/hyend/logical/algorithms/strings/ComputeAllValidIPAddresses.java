package com.hyend.logical.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all the valid IP addresses which can be formed
 * by the given string, under valid IP address rules. 
 * 
 * @author gopi_karmakar
 */
public class ComputeAllValidIPAddresses {

	public static void main(String[] args) {		
		for(String address : validateIPAddress("19216811")) {
			System.out.println(address);
		}
	}
	
	/**
	 * The total number of IP addresses is a constant (2^32), 
	 * implying an O(1) time complexity for the below algorithm.
	 * 
	 * @param address
	 * @return
	 */
	private static List<String> validateIPAddress(String address) {
		
		List<String> validIPAddresses = new ArrayList<>();
		
		for(int i = 1; i < 4 && i < address.length(); ++i) {			
			
			final String first = address.substring(0, i);			
			if(isValidPart(first)) {
				
				for(int j = 1; i+j < address.length() && j < 4; ++j) {					
					
					final String second = address.substring(i, i+j);
					if(isValidPart(second)) {						
						
						for(int k = 1; i+j+k < address.length() && k < 4; ++k) {							
							
							final String third = address.substring(i+j, i+j+k);
							final String fourth = address.substring(i+j+k);
							
							if(isValidPart(third) && isValidPart(fourth)) {
								validIPAddresses.add(first+"."+second+"."+third+"."+fourth);
							}							
						}
					}
				}				
			}
		}
		return validIPAddresses;
	}
	
	/**
	 * Validating IP Address rules
	 * 
	 * @param part
	 * @return
	 */
	private static boolean isValidPart(String part) {
		
		if(part.length() > 3)
			return false;
		
		// 00, 01 000, etc. are not valid, but "0" is valid. 
		if(part.startsWith("0") && part.length() > 1)
			return false;
		
		int val = Integer.parseInt(part);
		return (val >= 0 && val <= 255);
	}
}
