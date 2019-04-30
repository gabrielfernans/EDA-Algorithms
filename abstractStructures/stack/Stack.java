package stacks;

public class Stack {
	
	private int[] stack;
	private int capacity;
	private int top;
	
	public Stack(int capacity) {
		this.stack = new int[capacity];
		this.capacity = capacity;
		this.top = -1;	
	}
	
	public boolean isEmpty() {
		return this.top == -1;
		
	}
	
	public boolean isFull() {
		return this.top == capacity - 1;
	}
	
	public void push (int n) {
		if (this.isFull()) {
			throw new RuntimeException("FullStackException");
		}
		this.top ++;
		this.stack[top] = n;
	}
	
	public int pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("EmptyStackException");
		}
		int topValue = this.stack[top];
		this.top --;
		return topValue;
	}
	
	public int peek() {
		if(this.isEmpty()) {
			throw new RuntimeException("EmptyStackException");
		}
		return this.stack[top];
	}
	
	public int size() {
		return this.top + 1;
	}
}	
