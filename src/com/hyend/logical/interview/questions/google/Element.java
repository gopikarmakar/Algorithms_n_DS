package com.hyend.logical.interview.questions.google;

public class Element<K, V> {

	K k;
	V v;
	long time;
	
	public Element(K k, V v) {
		this.k = k;
		this.v = v;
	}
	
	public void updateTime() {
		this.time = System.currentTimeMillis();
	}
}
