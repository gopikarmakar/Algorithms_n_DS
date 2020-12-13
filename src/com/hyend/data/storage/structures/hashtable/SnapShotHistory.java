package com.hyend.data.storage.structures.hashtable;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Facebook Interview Question
 * 
 * For the explanation visit below link:
 * https://leetcode.com/discuss/interview-question/755014/Facebook-or-Design-a-data-structure-for-History-Set
 * 
 * @author gopi_karmakar
 */
public class SnapShotHistory<K extends Comparable<K>> {

	private static Integer sequenceId = 0;
	
	private Map<K, Integer> cache;
	
	private Map<Integer, List<K>> snapShot; 
	
	public SnapShotHistory() {
		
		snapShot = new HashMap<>();
		cache = new LinkedHashMap<>();	
	}
	
	public static void main(String[] args) {
		
		SnapShotHistory<String> snapShot = new SnapShotHistory<>();
		
		Integer seq1 = snapShot.add("a");
		Integer seq2 = snapShot.add("b");
		Integer seq3 = snapShot.add("c");		
		Integer seq4 = snapShot.discard("b");	
		
		System.out.println(snapShot.members(seq2));
		System.out.println(snapShot.members(seq3));		
		System.out.println(snapShot.members(seq4));
	}
	
	public Integer add(K k) {
		
		sequenceId += 1;
		
		cache.put(k, sequenceId);
		snapShot.put(sequenceId, new ArrayList<>(cache.keySet()));
		
		return sequenceId;
	}
	
	public Integer discard(K k) {
		
		sequenceId += 1;
		
		Integer sId = cache.remove(k);
		/**
		 * Just In case if we want snapshot even after the 
		 * key is deleted like seq2 
		 */
		//snapShot.remove(sId);  
		snapShot.put(sequenceId, new ArrayList<>(cache.keySet()));
		
		return sequenceId;
	}
	
	public List<K> members(Integer sequenceId) {
		
		return snapShot.get(sequenceId);
	}
}
