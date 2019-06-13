package com.hyend.data.storage.structures.trie;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

public class TernaryTrieDictionary {

	public TernaryTrieDictionary() {}
	
	public static void main(String[] args) {
	
		TernaryTrie tTrieDict = new TernaryTrie();
		tTrieDict.put("Asuka");
		tTrieDict.put("Kiaan");
		tTrieDict.put("Keshav");
		tTrieDict.put("Kush");
		tTrieDict.put("Kia");
		tTrieDict.put("Tulsi");		
		tTrieDict.put("Karan");
		tTrieDict.put("Kunal");
		tTrieDict.put("Kiran");
		tTrieDict.put("Kabir");
		
		Iterator<String> itr = tTrieDict.keysWithPrefix("Ki").iterator(); 
		while(itr.hasNext())
			PrintMSG("Total Keys = " + itr.next());
		
		//PrintMSG("Longest Prefix = " + tTrieDict.longestCommonPrefixOf("Kiaaan"));
		//PrintMSG("Unique Substrings = " + tTrieDict.uniqueNSubstrings("cgcgggcgcg", 3));		
	}
	
	private static void PrintMSG(Object msg) {
		System.out.println(msg);
	}
	
	private static class TernaryTrie {
		
		private Node root;
		
		private class Node {		
			char c;
			public String value;
			Node left, mid, right;		
			public Node(char c) {
				this.c = c;
			}
		}
		
		public void put(String key) {
			root = put(root, key, 0);
		}
		
		/**
		 * The prefix trie for "aabbcc" will be
		 * aabbcc aabbc aabb aab aa a
		 * 
		 * @param key
		 */
		private void createPrefixTrie(String key) {		
			int length = key.length();
			for(int i = length; i > 0; i--) {
				String prefix = key.substring(0, i);
				//System.out.println(prefix);
				put(prefix);
			}
		}
		
		/**
		 * @param key
		 * @param n
		 */
		private void createPrefixTrie(String key, int n) {		
			int length = key.length();
			for(int i = length; i >= n; i--) {
				String prefix = key.substring(i-n, i);
				//System.out.println(prefix);
				put(prefix);
			}
		}
		
		/**
		 * The suffix trie for "aabbcc" will be
		 * aabbcc abbcc bbcc bcc cc c
		 * 
		 * @param key
		 * @param n
		 */
		private void creeateSuffixTrie(String key) {		
			int length = key.length();
			for(int i = 0; i < length; i++) {
				String suffix = key.substring(i);
				//System.out.println(suffix);
				put(suffix);
			}
		}
		
		/**
		 * @param key
		 * @param n
		 */
		private void creeateSuffixTrie(String key, int n) {				
			int length = key.length()-n;
			for(int i = 0; i <= length; i++) {
				String suffix = key.substring(i, i+n);
				put(suffix);
			}
		}
		
		/**
		 * @param x
		 * @param key
		 * @param value
		 * @param d
		 * @return
		 */
		private Node put(Node x, String key, int d) {
			
			char c = key.charAt(d);
			if(x == null) {
				x = new Node(c); 
			}		
			if(c < x.c) 				x.left = put(x.left, key, d);
			else if(c > x.c) 			x.right = put(x.right, key, d);
			else if(d < (key).length()-1) x.mid = put(x.mid, key, d+1);
			else {			
				x.value = key;
				//System.out.println("Put x.value = " + x.value + " and x.prefix = " + x.prefix);
			}
			return x;
		}
		
		public String get(String key) {
			Node x = get(root, key, 0);
			if(x == null) return null;
			else return x.value;
		}
		
		private Node get(Node x, String key, int d) {
			
			if(x == null) return null;
			
			char c = key.charAt(d);
			if(c < x.c) 				return get(x.left, key, d);
			else if(c > x.c) 			return get(x.right, key, d);
			else if(d < key.length()-1) return get(x.mid, key, d+1);
			else return x;
		}	
			
		public Iterable<String> keysWithPrefix(String prefix) {
			Queue<String> queue = new LinkedList<String>();
			keysWithPrefix(get(root, prefix, 0).mid, queue);
			return queue;
		}
			
		private void keysWithPrefix(Node x, Queue<String> queue) {
							
			if(x == null) return;
					
			if(x.value != null) queue.add(x.value);
							
			keysWithPrefix(x.mid, queue);
			keysWithPrefix(x.left, queue);		
			keysWithPrefix(x.right, queue);		
		}
		
		public String longestCommonPrefixOf(String str) {
			
			int length = longestCommonPrefixOf(root, str, 0, 0);
			//System.out.println("Length = " + length);
			return str.substring(0, length+1);
		}
		
		private int longestCommonPrefixOf(Node x, String str, int d, int length) {
			
			char c = str.charAt(d);
			if(x == null) return length;		
			if(x.value != null && x.c == c) length = d;			
			if(d == str.length()) return length;						
			
			if(c < x.c) 				return longestCommonPrefixOf(x.left, str, d, length);
			else if(c > x.c) 			return longestCommonPrefixOf(x.right, str, d, length);
			else if(d < str.length()-1) return longestCommonPrefixOf(x.mid, str, d+1, length);
			else 						return length;
		}
			
		public int uniqueNSubstrings(String key, int n) {				
		
			int count = 0;
			//creeateSuffixTrie(key, 3);
			createPrefixTrie(key, 3);
			
			int index = 0;
			int length = key.length()-n;
			
			Set<String> uniqueStrings = new HashSet<String>();
			
			while(index < length) {
				count = getUniqueNSubstrings(root, key.substring(index, index+n), 0, uniqueStrings);
				index += 1;
			}
			return count;
		}
			
		private int getUniqueNSubstrings(Node x, String key, int d, Set<String> uniqueStrings) {
					
			if(x == null) return uniqueStrings.size();
			if(x.value != null) {			
				uniqueStrings.add(x.value);
				System.out.println("x.value = " + x.value);
			}
			if(d == key.length()) return uniqueStrings.size();
			
			char c = key.charAt(d);
			if(c < x.c ) 				getUniqueNSubstrings(x.left, key, d, uniqueStrings);
			else if (c > x.c) 			getUniqueNSubstrings(x.right, key, d, uniqueStrings);		
			else if(d < key.length()-1) getUniqueNSubstrings(x.mid, key, d+1, uniqueStrings);
			
			return uniqueStrings.size();		
		}
		
		int maxCount = 0;
		private void traverseTrie(Node x, int k, Queue<String> queue) {		
			if(x == null) return;		
			if(x.value != null) {
				System.out.println("x.value = " + x.value);
				int c = getTotalDistinctChars(x.value);
				//System.out.println("count = " + c);
				if(getTotalDistinctChars(x.value) == k) {
					queue.add(x.value);
					//int l = x.value.length();
					//System.out.println("length = " + l);
					//if(maxCount < l)
						//maxCount = x.value.length();
				}
			}		
			//System.out.println("max = " + max);
			traverseTrie(x.left, k, queue);
			traverseTrie(x.mid, k, queue);
			traverseTrie(x.right, k, queue);		
			return;
		}
		
		private int getTotalDistinctChars(String text) {
	 		int count = 0;
	 		boolean[] chars = new boolean[26];
	 		for(char c : text.toCharArray()) {
	 			if(!chars[c - 'a']) {
	 				count += 1;
	 				chars[c - 'a'] = true;
	 			} 			
	 		}
	 		return count;
	 	}
		
		public int longestSubStringWithKDistinctChars(String key, int k) {
			Queue<String> list = new LinkedList<>();		
			createPrefixTrie(key);
			creeateSuffixTrie(key);
			creeateSuffixTrie(key, k);
			traverseTrie(root, k, list);
			
			int maxLength = 0;
			Iterator<String> itr = list.iterator();
			
			while(itr.hasNext()) {
				String item = itr.next();
				System.out.println(item);
				int l = item.length();
				if(maxLength < l)
					maxLength = l;			
			}
			return maxLength;
		}
	}

	
}