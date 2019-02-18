package com.hyend.logical.algorithms.strings;

public class RabinKarpPatternMatching {
	
	int prime = 31;
	
	private long createHash(String key, int length) {
		
		long hash = 0;
		for(int i = 0; i <= length; i++) {
			hash += key.charAt(i) * Math.pow(prime, i);
		}
		return hash;
	}
	
	private long recreateHash(String str, int prevIndex, int newIndex, long prevHash, int length) {

		long newHash = prevHash - str.charAt(prevIndex);
		newHash /= prime;
		newHash += str.charAt(newIndex) * Math.pow(prime, length);
		return newHash;
	}
	
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
}
