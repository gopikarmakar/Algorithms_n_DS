package com.hyend.data.storage.structures.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatOfAllWords {
	
	public static void main(String[] args) {
		String[] words = {"foo", "bar"};
		System.out.println(findSubstring("barfoothefoobarman", words));
	}
	
	private static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();
		if(s == null || s.length() == 0 || words.length == 0)
			return list;
		
		Map<String, Integer> allWordsFreq = new HashMap<String, Integer>();
        for(String w : words) {
        	mapWordFrequency(w, allWordsFreq);
        }
        
        int tsl = s.length();        
        int owl = words[0].length();
        int twl = owl*words.length;
        
        for(int i = 0; i + twl <= tsl; ++i) {
        	if(matchAllWords(i, words.length, owl, s, allWordsFreq))
        		list.add(i);
        }
        return list;
    }
	
	private static boolean matchAllWords(int start, int totalWords, int unitSize, 
			String s, Map<String, Integer> allWordsFreq) {
				
		Map<String, Integer> unitFreq = new HashMap<String, Integer>();
		
		for(int i = 0; i < totalWords; i++) {
			
			String sub = s.substring(start + i * unitSize, start + (i + 1) * unitSize);
			//System.out.println(sub);
			Integer freq = allWordsFreq.get(sub);
			if(freq == null)
				return false;
									
			mapWordFrequency(sub, unitFreq);
			
			if(unitFreq.get(sub) > freq)
				return false;
		}
		return true;
	}
	
	private static void mapWordFrequency(String word, Map<String, Integer> map) {
		
		if(map.containsKey(word)) {
			map.put(word, map.get(word)+1);
		}
		else map.put(word, 1);
	}
}
