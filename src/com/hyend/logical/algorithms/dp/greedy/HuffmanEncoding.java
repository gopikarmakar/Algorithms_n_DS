package com.hyend.logical.algorithms.dp.greedy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * Huffman Encoding algorithm implementation.
 * 
 * Watch below video for detailed explanation about
 * Huffman Encoding algorithm for data compression.
 *  
 * https://www.youtube.com/watch?v=co4_ahEDCho 
 * 
 * Since each invocation at the lines 93,94 and 95 requires 
 * two extract-min and one insert operation, it takes0(n log n) time 
 * to build the Huffman tree, where n is the number of characters. 
 * It's possible for the tree to be very skewed. In such a situation, 
 * the codewords are of length 1, 2,3,...,n, so the time to generate 
 * the code table becomes O(1 + 2 + ... + n) = O(n^2).
 * 
 * @author gopi_karmakar
 */
public class HuffmanEncoding {

	/**
	 * Encoded Table:
	 * A -> 011
	 * B -> 10
	 * C -> 11
	 * D -> 00
	 * E -> 010
	 * This encoded tree table should be sent along with
	 * the encoded message to decoded the message.
	 * For e.g if the message = "BCCABBDDAECCBBAEDDCC" = 160 bits
	 * then as per our output the encoding will be: 
	 * "101111011101000000110101111101001101000001111" = 45 bits
	 * Then keep on iterating left child for 0 and right child for 1
	 * will reach to the leaf where we'll find the character.
	 */
	private static BinaryTree huffmanCodeTree = null;
	
	public static void main(String[] args) {
		
		String message = "BCCABBDDAECCBBAEDDCC";
		
		System.out.println("Actual Message : " + message);
		
		Map<Character, String> encodingTable = huffmanEncoding(mapFrequency(message));
		
		System.out.println("\nEncoded Table:");
		for(Map.Entry<Character, String> e : encodingTable.entrySet()) {
			
			System.out.println(e.getKey() + " -> " + e.getValue());
		}				
		
		String encodedString = encode(message, encodingTable);
				
		System.out.println("\nEncoded Message : " + encodedString);
		
		System.out.println("\nDecoded Message : " + decode(encodedString));		
	}
	
	static class CharWithFrequency {
		
		public char c;
		public int frequency;
		
		public CharWithFrequency(char c, int frequency) {
			this.c = c;
			this.frequency = frequency;			
		}
		
		@Override
		public String toString() {		
			return "Char = " + c + " and Frequency = " + frequency;
		}
	}
	
	static class BinaryTree implements Comparable<BinaryTree> {
		
		int totalFreq;
		BinaryTree left;
		BinaryTree right;
		CharWithFrequency cwf;
		
		public BinaryTree(CharWithFrequency cwf, int totalFreq,
				BinaryTree left, BinaryTree right) {
			
			this.cwf = cwf;
			this.totalFreq = totalFreq;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public int compareTo(BinaryTree o) {
			return Integer.compare(this.totalFreq, o.totalFreq);
		}
		
		@Override
		public boolean equals(Object obj) {

			if(obj == null || !(obj instanceof BinaryTree))
				return false;
			
			return (obj == this) ? true : 
				this.totalFreq == ((BinaryTree) obj).totalFreq;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(this.totalFreq); 
		}
	}
	
	private static Map<Character, String>
		huffmanEncoding(Collection<CharWithFrequency> symbols) {
					
		Map<Character, String> encodingTable = new HashMap<>();
		PriorityQueue<BinaryTree> candidates = new PriorityQueue<>();		
		
		// Creating all the leaves node.
		for(CharWithFrequency cwf : symbols) {			
			candidates.add(new BinaryTree(cwf, cwf.frequency, null, null));
		}
		
		// Merging leaves and creating parents until root parent 
		while(candidates.size() > 1) {
			
			BinaryTree left = candidates.remove();
			BinaryTree right = candidates.remove();
			candidates.add(new BinaryTree(null, 
					left.totalFreq + right.totalFreq, left, right));
		}			
		
		huffmanCodeTree = candidates.peek();
		
		assignCode(candidates.peek(), new StringBuilder(), encodingTable);
		
		return encodingTable;
	}
	
	private static void assignCode(BinaryTree tree, StringBuilder code,
			Map<Character, String> encodingTable) {
		
		if(tree != null) {
			
			if(tree.cwf != null) {
								
				encodingTable.put(tree.cwf.c, code.toString());
			}
			else {
				
				assignCode(tree.left, code.append("0"), encodingTable);
				code.setLength(code.length()-1);
								
				assignCode(tree.right, code.append("1"), encodingTable);
				code.setLength(code.length()-1);
			}
		}
	}
	
	private static String encode(String message, Map<Character, String> encodingTable) {
		
		StringBuilder sb = new StringBuilder();
		
		for(char c : message.toCharArray()) {
			
			sb.append(encodingTable.get(c));
		}		
		
		return sb.toString();
	}
	
	private static String decode(String encodedMessage) {
		
		int i = 0;
		
		StringBuilder sb = new StringBuilder();		
		
		while(i < encodedMessage.length()) {						
						
			BinaryTree tree = huffmanCodeTree;							
			
			while(tree.left != null || tree.right != null) {
				
				char c = encodedMessage.charAt(i);
				
				if(c == '0') {					
					tree = tree.left;
				}
				else if(c == '1') {					
					tree = tree.right;
				}
				i++;
			}
			sb.append(tree.cwf.c);
			//System.out.print(tree.cwf.c);
		}
		return sb.toString();
	}
	
	private static Collection<CharWithFrequency> mapFrequency(String message) {
		
		Map<Character, CharWithFrequency> map = new HashMap<>();
		
		for(char c : message.toCharArray()) {
			
			CharWithFrequency cwf = map.getOrDefault(c, new CharWithFrequency(c, 0));
			cwf.frequency += 1;
			map.put(c,  cwf);
		}		
		
		return map.values();
	}
}
