package com.hyend.data.storage.structures;

/**
 * 
 * @author karmakargopi
 *
 * Singly LinkedList Implementation.
 */
public class SinglyLinkedList {

	private Node head = null;
	private Node tail = null;
	
	class Node {
		
		Object item;
		Node next;		
		Node(Object item) {
			this.item = item;
		}
	}
	
	public void addNode(Object item) {
		
		Node node = new Node(item);
		node.next = null;			
		if(head == null && tail == null) {
			head = tail = node;
			return;
		}
		tail.next = node;
		tail = tail.next;
	}
	
	public void addNewEnd(Object item) {
		
	}
	
	public void addNewHead(Object item) {
		
	}
	
	public void addNodeAfter(Object existItem, Object newItem) {
		
	}
	
	public void addNodeBefore(Object existItem, Object newItem) {
		
	}
	
	public void updateNode(Object existItem, Object newItem) {
		
	}
	
	public void delete(String item) {
		
		Node node = head;
		//Node previous = head;
		while(node != null) {
			if(node.item == item) break;
			node = node.next;
		}
		System.out.println(node);
		//node = node.next;
			
		/*while(node != null) {
			//System.out.println(node.item);
			if(node.item == item) {
				previous.next = node.next;
				node = null;
			}
			else {
				previous = node;
				node = node.next;
			}
		}*/
	}
	
	public void removeAllDuplicates() {
		
		Node current = head; 
		while(current.next != null) {
			Node previous = current;
			Node nextCurrent = current.next;
			while(nextCurrent.next != null) {
				if(nextCurrent.item.equals(current.item)) {
					previous.next = nextCurrent.next;
				}
				previous = nextCurrent;
				nextCurrent = nextCurrent.next;
			}
			if(nextCurrent.item.equals(current.item)) {
				previous.next = null;
			}
			current = current.next;
		}
	}
	
	public int getLength() {
		int length = 0;
		Node node = head;
		while(node != null) {
			length += 1;
			node = node.next;
		}
		return length;
	}
	
	public void printAllNodes() {
		
		Node node = head;
		while(node != null) {
			System.out.println(node.item);
			node = node.next;
		}
	}
}
