package data_structure;

import java.util.LinkedList;

public class LinkedStack<E> {
	private LinkedList<E> list = new LinkedList<E>();
	
	public void push(E value) {
		list.addLast(value);
	}
	
	public E pop() {
		return list.removeLast();
	}
	
	public E peek() {
		return list.getLast();
	}
	
	public int size() {
		return list.size();
	}
	
	
	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.peek());
		System.out.println(stack.size());
		stack.pop();
		System.out.println(stack.peek());
	}

}
