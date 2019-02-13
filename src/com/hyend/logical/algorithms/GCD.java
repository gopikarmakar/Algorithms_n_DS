package com.hyend.logical.algorithms;

public class GCD {
	
	public int recursive(int p, int q) {
		
		if(q == 0) return p;
		else return recursive(q, p%q);
	}
}
