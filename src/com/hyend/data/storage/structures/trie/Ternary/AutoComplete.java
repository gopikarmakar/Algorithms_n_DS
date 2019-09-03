package com.hyend.data.storage.structures.trie.Ternary;

/**
 * Google Interview Question
 * Suggest the auto completion for an ongoing typing word.
 * 
 * @author gopi_karmakar
 */
public class AutoComplete {

	public static void main(String[] args) {
		
		Node<Character, String> tree = TernaryTrieDictionary.createDefault();
		//autoComplete(tree, "K");
		//autoComplete(tree, "Ki");
		autoComplete(tree, "Ka");
	}
	
	public static void autoComplete(Node<Character, String> tree, String prefix) {
		
		AutoComplete auto = new AutoComplete();
		tree = auto.crawl(tree, prefix, 0);
		
		TrieDictionaryTraversals.print(tree.mid);
	}
	
	/**
	 * O(log n) time complexity for searching.
	 * 
	 * @param node
	 * @param prefix
	 * @param d
	 * @return
	 */
	private Node<Character, String> crawl(Node<Character, String> node, String prefix, int d) {				
		
		if(node == null) return null;
		
		Character ch = prefix.charAt(d);
		
		int cmp = node.k.compareTo(ch);
		
		if(cmp < 0)
			return crawl(node.left, prefix, d);
		else if(cmp > 0)
			return crawl(node.right, prefix, d);
		else if(d < prefix.length()-1)
			return crawl(node.mid, prefix, d+1);
		else
			return node;
	}
}
