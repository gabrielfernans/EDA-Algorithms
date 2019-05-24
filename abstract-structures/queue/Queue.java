package queues;

public class Queue {
	
	private int[] queue;
	private int capacity, head, tail;
	
	public Queue(int capacity) {
		this.queue = new int[capacity];
		this.capacity = capacity;
		this.head = -1;
		this.tail = -1;
	}
	
	public boolean isEmpty() {
		return (this.head == -1 && this.tail == -1); 
	}
	
	public boolean isFull() {
		return ((this.tail + 1) % capacity) == this.head;
	}
	
	public void add(int n) {
		if (this.isFull()) {
			throw new RuntimeException("Is full");
		}
		
		if(this.isEmpty()) {
			this.head = 0;
			this.tail = 0;
			this.queue[head] = n;
		}
		
		else {
			tail = (tail + 1) % capacity;
			this.queue[tail] = n;
		}
	}
	
	public int remove() {
		if (this.isEmpty()) {
			throw new RuntimeException("Is empty");
		}
		int aux = this.queue[head];
		
		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		}
		
		else {
			this.head = ((this.head + 1) % capacity);
		}
		
		return aux;
	}
	
	public int head() {
		if (this.isEmpty()) {
			throw new RuntimeException("Is empty");
		}
		return this.queue[head];
	}
}
