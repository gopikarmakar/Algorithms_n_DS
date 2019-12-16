package com.hyend.data.storage.structures.linkedlists.singly;

/**
 * Google India Interview Question
 * 
 * A postings list is a singly linked list with an additional "jump" field at each node. 
 * The jump field can point to any other node.
 * 
 * Variant: Clone a linked list when a node's reference is also a value of any random node.  
 * 
 * @author gopi_karmakar
 */
public class PostingsList {

	public static void main(String[] args) {
		
		Node<String> head = createSamplePostingList();
			
		System.out.println("Original List:");
		print(head);
		
		Node<String> clonedList = cloneList(head);
		
		System.out.println("\nList Cloned List:");
		print(clonedList);
	}
	
	/**
	 * O(n) time complexity with only O(1) extra space complexity solution. 
	 */
	private static Node<String> cloneList(Node<String> head) {
		
		Node<String> tempHead = head;
		
		while(tempHead != null) {
			
			Node<String> newNode = new Node<>(tempHead.k);
			newNode.next = tempHead.next;
			tempHead.next = newNode;
			tempHead = newNode.next;
		}
		
		tempHead = head;		
		while(tempHead != null) {
			
			if(tempHead.jump != null) {
				
				tempHead.next.jump = tempHead.jump.next;
			}
			tempHead = tempHead.next.next;
		}
		
		tempHead = head;
		Node<String> newListHead = tempHead.next;
		
		while(tempHead.next != null) {
			
			Node<String> temp = tempHead.next;
			tempHead.next = temp.next;
			tempHead = temp;
		}
		
		return newListHead;
	}
		
	/////////////////////////////////// Helper Methods ////////////////////////////////////
	
	private static Node<String> createSamplePostingList() {
		
		SinglyLinkedList<String> postingList = new SinglyLinkedList<>();
		
		postingList.add("A");
		postingList.add("B");
		postingList.add("C");
		postingList.add("D");
		postingList.add("D");
		
		Node<String> head = postingList.head;
		
		head.jump = head.next.next;
		head.next.jump = head.next.next.next.next;
		head.next.next.jump = head.next;
		head.next.next.next.jump = head.next.next.next;
		
		return head;
	}
	
	private static void print(Node<String> head) {
		
		while(head != null) {
			
			System.out.println("K = " + head.k + " Jump = " + ((head.jump != null) ? head.jump.k : null));
			head = head.next;
		}
	}
}
