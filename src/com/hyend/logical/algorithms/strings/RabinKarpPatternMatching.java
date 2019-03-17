package com.hyend.logical.algorithms.strings;

/**
 * Rabin Karp Algorithm for Pattern matching.
 *  
 * @author gopi_karmakar
 *
 */
public class RabinKarpPatternMatching {
	
	int prime = 31;
	
	public boolean isPatternMatched(String text, String pattern) {
		
		boolean status = false;	
		int n = text.length()-1;
		int m = pattern.length()-1;
		long textHash = createHash(text, m);
		long patternHash = createHash(pattern, m);		
		
		for(int i = 1; i <= n-m+1; i++) {
			
			if(patternHash == textHash) {
				String sub = text.substring(i-1, i+m);
				System.out.println(sub);
				if(sub.equals(pattern)) {					
					status = true;
				}					
			}
			if(i <= n-m) {
				textHash = recreateHash(text, i-1, i+m, textHash, m);
			}
		}		
		return status;
	}
	
	/**
	 * key = abcdef and length = 3
	 * hash = ascii(a) * 31^0 + ascii(b) * 31^1 + ascii(c) * 31^2  
	 * @param key
	 * @param length
	 * @return
	 */
	private long createHash(String key, int length) {
		
		long hash = 0;
		for(int i = 0; i <= length; i++) {
			hash += key.charAt(i) * Math.pow(prime, i);
		}
		return hash;
	}
	
	/**
	 * In order to maintain the hash order 
	 * There are three steps to create a new hash an new char
	 * 
	 * 1: First we have to remove the old char value.
	 * 2: Bring it to the previous state by diving by base prime number.
	 * 3: Add the new character's hash to the reverted state's hash after computing 
	 * the new char hash with position exponentiation with the prime base.
	 * 
	 *  
	 * str = bcd and length = 3
	 * prevHash - ascii(a) = ascii(b) * 31^1 + ascii(c) * 31^2
	 * (ascii(b) * 31^1 + ascii(c) * 31^2) / 31 = ascii(b) * 31^0 + ascii(c) * 31*1
	 * newwHash = ascii(b) * 31^0 + ascii(c) * 31^1 + ascii(d) * 31^2
	 * 
	 * @param str
	 * @param prevIndex
	 * @param newIndex
	 * @param prevHash
	 * @param length
	 * @return
	 */
	private long recreateHash(String str, int prevIndex, int newIndex, long prevHash, int length) {

		long newHash = prevHash - str.charAt(prevIndex);
		newHash /= prime;
		newHash += str.charAt(newIndex) * Math.pow(prime, length);
		return newHash;
	}
}
