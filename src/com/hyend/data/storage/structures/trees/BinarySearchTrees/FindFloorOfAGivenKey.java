package com.hyend.data.storage.structures.trees.BinarySearchTrees;

/**
 * Find floor of a given key
 * 
 * A floor in BST is the first key that would appear in an
 * In-Order traversal which is smaller than the input key.
 * 
 * for e.g: For the default BST the floor of 37 will be 31 
 * 
 * @author gopi_karmakar
 */
public class FindFloorOfAGivenKey {

	public static void main(String[] args) {
		
		Node<Integer, ?> bst = BinarySearchTree.createDefault();
		
		System.out.println("Floor " + findFloor(bst, 37));
	}
	
	/**
	 * Time complexity is O(h) where h is the height of tree.
	 * Space complexity is O(1).
	 */
	public static Node<Integer, ?> findFloor(Node<Integer, ?> bst, Integer key) {
		
		Node<Integer, ?> subTree = bst, firstSoFar = null;
		
		while(subTree != null) {
			
			if(subTree.key < key) {
				
				firstSoFar = subTree;
				subTree = subTree.right;
			}
			else {
				subTree = subTree.left;
			}
		}
		
		return firstSoFar;
	}
}
