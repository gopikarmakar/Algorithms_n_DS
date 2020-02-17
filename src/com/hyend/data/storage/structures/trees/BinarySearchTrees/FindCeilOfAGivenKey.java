package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Find the ceiling of a given key.
 * 
 * A ceiling in BST is the first key that would appear in an
 * In-Order traversal which is greater than the input key.
 * 
 * for e.g: For the default BST the ceiling of 23 will be 29
 * 
 * @author gopi_karmakar
 */
public class FindCeilOfAGivenKey {

	public static void main(String[] args) {
		
		Node<Integer, ?> bst = BinarySearchTree.createDefault();		
		
		System.out.println(findCeil(bst, 23));
	}
	
	/**
	 * The time complexity is O(h) where h is the height of the tree
	 * Space complexity is O(1)
	 */
	private static Node<Integer, ?> findCeil(Node<Integer, ?> bst, int key) {
		
		Node<Integer, ?> subTree = bst, firstSoFar = null;
		
		while(subTree != null) {
			
			if(subTree.key > key) {
				
				firstSoFar = subTree;				
				subTree = subTree.left;
			}
			else {
				subTree = subTree.right;
			}
		}
		
		return firstSoFar;
	}
}
