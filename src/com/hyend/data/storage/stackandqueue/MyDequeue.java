package com.hyend.data.storage.stackandqueue;

public class MyDequeue {

	public static void main(String[] args) {
		
		StackWithMax<Integer> stack = new StackWithMax<>();
		stack.push(5);
		stack.push(3);
		stack.push(7);
		stack.push(-2);
		stack.push(1);
		stack.push(4);
				
		System.out.println("Element Popped = " + stack.pop());
		System.out.println("Max Element In Stack = " + stack.getMax());
	}
}
