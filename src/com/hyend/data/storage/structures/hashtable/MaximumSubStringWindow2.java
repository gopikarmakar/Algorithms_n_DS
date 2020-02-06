package com.hyend.data.storage.structures.hashtable;

import java.util.Map;
import java.util.LinkedHashMap;

/**
 * Find Maximum SubString Window when there are duplicates in window
 * for e.g: s = "acbbaca" window = "aba"
 * result = baca (Since there're two a's)
 * 
 * TODO: Need to complete
 * 
 * @author gopi_karmakar
 */
class MaximumSubStringWindow2 {
	
	public static void main(String[] args) {
		
		//String s = "ADOBECODEBANC"; 
		//String t = "ABC";
		//String s = "bbaa";
		//String t = "aba";
		String s = "acbbaca";
		String t = "aba";
		
		MaximumSubStringWindow2 solution = new MaximumSubStringWindow2();		
		
		System.out.println(solution.minWindow(s, t));
	}
    
    public class SubArray {
        
        int start;
        int end;
        
        public SubArray(int start, int end) {
            
            this.start = start;
            this.end = end;
        }
    }
    
    public class State {
        
        Integer position;
        Integer frequency;
        
        public State() {
        	
        	position = null;
        	frequency = 0;
        }
    }
    
    public String minWindow(String s, String t) {
    	
    	if(s == null || s.isEmpty() || t == null || t.isEmpty() ||
                t.length() > s.length())            
                return "";
            
        if(t.equals(s))
            return t;
        
        SubArray subArray = find(s, t);
        
        /*if(subArray.start == -1)
            subArray.start += 1;*/
        
        return s.substring(subArray.start, subArray.end+1);
    }
    
    public SubArray find(String s, String t) {
        
        int idx = 0, seenSoFar = 0;
        
        SubArray subArray = new SubArray(-1, -1);
        
        Map<Character, State> dict = new LinkedHashMap<>();
        
        for(char c : t.toCharArray()) {
            
            State state = dict.getOrDefault(c, new State());
            state.position = null;
            state.frequency += 1;
            dict.put(c, state);
        }
        
        for(char c : s.toCharArray()) {
                        
            if(dict.containsKey(c)) {
                
                State state = dict.get(c);               
                
                if(state.position == null) {                	
                	
                	seenSoFar += 1;
                	state.frequency -= 1;
                }
                else if(state.frequency > 0) {
                	
                	seenSoFar += 1;
                	state.frequency -= 1;
                }

                dict.remove(c);
                
                state.position = idx;  
                dict.put(c, state);
            }
            
            if(seenSoFar == dict.size() && seenSoFar != t.length()) {
            	
            	seenSoFar = reduceByOne(dict, seenSoFar); 
            	System.out.println(seenSoFar);
            }
            else if(seenSoFar == t.length()) {
            	
	            if((subArray.start == -1 && subArray.end == -1) || 
	                (idx - getValueOfFirstEntry(dict).position < 
	                        subArray.end - subArray.start)) {
	                
	                subArray.start = getValueOfFirstEntry(dict).position;
	                subArray.end = idx;
	            }
            }
            
            ++idx;
        }
        return subArray;
    }
    
    private int reduceByOne(Map<Character, State> dict, int seenSoFar) {

        for(Map.Entry<Character, State> e : dict.entrySet()) {
            
            State state = e.getValue();
            state.frequency += 1;
            seenSoFar -= 1;
        }
        return seenSoFar;
    }
    
    private State getValueOfFirstEntry(Map<Character, State> dict) {
        
        State state = null;
        
        for(Map.Entry<Character, State> e : dict.entrySet()) {
            
            state = e.getValue();
            break;
        }
        
        return state;
    }
}