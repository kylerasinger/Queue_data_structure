package Queue_data_structure;

//First in First out

public class Queue {
	
	private Node first = null;
	private Node last = null;
	
	private class Node{
		private Node link;
		private int data;
		
		private Node(int i, Node n)
		{
			data = i;
			link = n;
		}
	}
	
	public void push(int i) { //first doesn't change
		Node oldLast = last;
		last = new Node(i, oldLast);
		
		if(oldLast == null)
		{
			first = last;
		}
		else
		{
			oldLast.link = last;
		}
	}
	
	public int pop() //last doesn't change
	{
		if(first == null)
		{
			throw new RuntimeException("Empty Queue ( must push(int i) before pop() ).");
		}
		int data = first.data;
		first = first.link; //set new first
		
		if(first == null) {
			last = null;
		}
		
		return data;
	}
	
	public int getMin() {
		Integer minimum = 2147483647;
		if(first == null) {throw new RuntimeException("Empty Queue ( must push(int i_ before pop() ).");}
		
		
		
		return minimum;
	}
	
	public static void main(String[] args) {
		Queue queueTest = new Queue();
		
		queueTest.push(10);
		queueTest.push(13);
		queueTest.push(15);
		
		int minimum = queueTest.getMin();
		System.out.printf("Minimum of the queue is: %d\n", minimum);
		
		int current = 0;
		for(int i = 0; i < 3; i++) { //should output 101315
			current = queueTest.pop();
			System.out.print(current);
			System.out.print("\n");
		}
		
		
	}

}
