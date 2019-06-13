package com.hyend.data.storage.structures.trees;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BinaryTree {
	
	public static void main(String[] args) {
		
		Integer[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};		
		BTree<Integer> bTree = new BTree<>();		
		addEvenly(bTree);
		//addUnEven(bTree);
		//recreateBTreeFromListOfKeys(bTree, keys);
		bTree.printBFS();
		printMSG("=================================");
		bTree.pringtInOrder();
		printMSG("Is Balanced = " + bTree.isTreeBalanced());
		//bTree.pringtInOrder();
		//bTree.printInorderNonRecursive();
		//printMSG("Height of Tree = " + bTree.calculateHeight());
						
		//char[] inOrder = {'F', 'B', 'A', 'E', 'H', 'C', 'D', 'I', 'G'};
		//Character[] preOrder = {'H', 'B', 'F', 'E', 'A', 'C', 'D', 'G', 'I'};
		//BTree<Character> cBTree = new BTree<>();
		//recreateBTreeFromPreOrderTraversal(preOrder, cBTree);
		//recreateBTreeFromInandPreOrderTraversal(inOrder, preOrder);
		//cBTree.pringtPreOrder();
		//cBTree.printBFS();
	}
	
	private static void printMSG(String msg) {
		System.out.println(msg);
	}
	
	private static void addUnEven(BTree<Integer> bTree) {
		for(int i = 1; i <= 10; i++)
			bTree.add(i);		
	}
	
	private static void addEvenly(BTree<Integer> bTree) {		
		for(int i = 1; i <= 10; i++)
			bTree.addByWeight(i);
	}
	
	private static void recreateBTreeFromListOfKeys(BTree<Integer> bTree, Integer[] keys) {
		bTree.recreateBTreeFromListOfKeys(keys);
	}
	
	private static void recreateBTreeFromPreOrderTraversal(Character[] preOrder, BTree<Character> bTree) {
	}
	
	private static void recreateBTreeFromInandPreOrderTraversal(char[] inOrder, char[] preOrder) {
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < inOrder.length; i++)
			map.put(inOrder[i], i);
			
	}
	
	//						Tree Implementation Starts Here
	//===================================================================================================
	
	private static class BTree<Key> {		
		class Node {			
			Key k;			
			Node left;
			Node right;
			int weight = 0;
			public Node(Key k) {
				this.k = k;
			}
		}
		
		private Node root;
		private boolean isBalanced = false;
		
		public void add(Key k) {
			root = insert(root, k);
		}
		
		/**
		 * Weight balanced binary tree
		 * @param k
		 * @param v
		 */
		public void addByWeight(Key k) {
			if(root == null)
				root = new Node(k);
			else
				insertByWeight(root, k);
		}
				
		/**
		 * Evenly balanced binary tree
		 * @param preOrder
		 * @return
		 */
		public Node recreateBTreeFromListOfKeys(Key[] preOrder) {
			Queue<Node> q = new LinkedList<>();
			for(Key k : preOrder) {
				if(q.isEmpty()) {
					root = new Node(k);
					q.add(root);
				}
				else {
					Node x = q.peek();
					if(x.left == null) {						
						x.left = new Node(k);
						q.add(x.left);
					}
					else {
						x.right = new Node(k);						
						q.add(x.right);
						q.remove();
					}
				}
			}
			return root;
		}
		
		public void pringtInOrder() {
			inOrder(root);
		}
		
		public void pringtPreOrder() {
			preOrder(root);
		}
		
		public void pringtPostOrder() {
			postOrder(root);
		}
		
		public void printBFS() {			
			Queue<Node> q = new LinkedList<Node>();
			q.add(root);
			do {												
				Node x = q.remove();
				printMSG(x);				
				if(x.left != null) q.add(x.left);
				if(x.right != null) q.add(x.right);
					
			} while(!q.isEmpty());
		}
		
		public void printInorderNonRecursive() {			
			Stack<Node> s = new Stack<>();
			Node x = root;
			do {
				if(x != null) {
					s.add(x);
					x = x.left;
				}
				else {
					if(!s.isEmpty())
						x = s.pop();						
					else break;
					
					printMSG(x);
					x = x.right;
				}
			} while(true);
		}
		
		public int calculateHeight() {
			return heightOfTree(root);
		}
		
		public boolean isTreeBalanced() {
			AtomicBoolean balanced = new AtomicBoolean(true);
			isBalanced(root, balanced);
			return balanced.get();
		}
		
		/**
		 * Left leaning binary tree. 
		 * @param x
		 * @param k
		 * @param v
		 * @return
		 */
		private Node insert(Node x, Key k) {			
			if(x == null) {
				x = new Node(k);
			}
			else {				
				if(x.left == null) {
					x.left = insert(x.left, k);
				}
				else {
					x.right = insert(x.right, k);
				}
			}			
			return x;
		}
		
		/**
		 * Evenly weighted binary tree 
		 * @param x
		 * @param k
		 */
		private void insertByWeight(Node x, Key k) {		
			if(x.left == null) {
				x.left = new Node(k);
				x.left.weight+=1;				
			}
			else if(x.right == null) {
				x.right = new Node(k);
				x.right.weight+=1;				
			}
			else {
				if(x.left.weight <= x.right.weight) {
					x.left.weight+=1;
					insertByWeight(x.left, k);					
				}
				else {
					x.right.weight+=1;
					insertByWeight(x.right, k);
				}				
			}
		}
		
		private void inOrder(Node x) {
			if(x == null)
				return;			
			inOrder(x.left);
			printMSG(x);
			inOrder(x.right);
		}
		
		private void preOrder(Node x) {
			if(x == null)
				return;			
			printMSG(x);
			inOrder(x.left);			
			inOrder(x.right);
		}
		
		private void postOrder(Node x) {
			if(x == null)
				return;						
			inOrder(x.left);			
			inOrder(x.right);
			printMSG(x);
		}
		
		private int heightOfTree(Node x) {			
			if(x == null)
				return 0;			
			int LH = heightOfTree(x.left);
			int RH = heightOfTree(x.right);
			int height = 1 + Math.max(LH, RH);
			return height;
		}
		
		private int isBalanced(Node x, AtomicBoolean balanced) {
			
			if(x == null)
				return 0;
			
			int LH = isBalanced(x.left, balanced);
			int RH = isBalanced(x.right, balanced);
			if((LH+1) > 2*(RH+1) || (RH+1) > 2*(LH+1))
				balanced.set(false);
			
			return 1 + Math.max(LH, RH);			
		}
		
		private void printMSG(Node x) {
			System.out.println("Key = " + x.k + "  and   Weight = " + x.weight);
		}	
	}	
}
