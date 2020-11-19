package com.hyend.data.storage.structures.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Compute all string decompositions. 
 * NOTE: Assume all words are of same length
 * 
 * for e.g: s = "amanaplanacanal", word = {"can", "apl", "ana"} 
 * return "aplanacan" which is a concatenation of all the words in any order.
 * 
 * s = "barfoothefoobarman" words = {"foo", "bar"}
 * return "barfoo" "foobar" which are concatenation of all the words in any order.
 *
 * @author gopi_karmakar
 */
public class ComputeAllStringDecompositions {
	
	public static void main(String[] args) {
		
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
				
//		String s = "amanaplanacanal";
//		String[] words = {"can", "apl", "ana"};
		
		for(int i : findSubstring(s, words)) {			
			System.out.println(s.substring(i, i+(words[0].length() * words.length)));
		}
	}
	
	/**
	 * Let m be the number of words and n the length of each word. Let N be the length of the sentence. 
	 * For any fixed i, to check if the string of length nm starting at an offset of i in the sentence 
	 * is the concatenation of all words has time complexity O(nm), assuming a hash table is used to store 
	 * the set of words. This implies the overall time complexity is O(Nnm). In practice, the individual checks 
	 * are likely to be much faster because we can stop as soon as a mismatch is detected.
	 */
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
		
		int fq = map.getOrDefault(word, 0);
		map.put(word, fq+1);		
	}
}