package com.hyend.logical.algorithms.dp.recursive;

public class GCD {
	
	public int recursive(int p, int q) {
		
		if(q == 0) return p;
		else return recursive(q, p%q);
	}
}
