package Queue_data_structure;

//First in First out

public class Queue {
	
	private Node first = null;
	private Node last = null;
	
	private class Node{
		private Node linkBack;
		private int data;
		
		private Node(int i, Node link)
		{
			data = i;
			linkBack = link;
		}
	}	
	
	public void enque(int i) { //first doesn't change
		Node oldLast = last;
		last = new Node(i, null);
		
		if(oldLast == null)
		{
			first = last;
		}
		else
		{
			oldLast.linkBack = last; //ONE OF THESE IS WRONG
		}
	}
	
	public int deque() //last doesn't change
	{
		if(first == null)
		{
			throw new RuntimeException("Empty Queue ( must push(int i) before pop() ).");
		}
		
		int data = first.data;
		
		first = first.linkBack; //ONE OF THESE IS WRONG
		
		if(first == null) {
			last = null;
		}
		
		return data;
	}
	
	public Boolean isEmpty() {
		return first == null;
	}
	
	
	public int getMin() {
		Integer minimum = 2147483647;
				
		if(first == null) {throw new RuntimeException("Empty Queue ( must push(int i_ before pop() ).");}
		
		Node currentNode = first;
		
		while(currentNode.linkBack != null) {
			if(currentNode.data < minimum) { 
				minimum = currentNode.data; 
			}
			
			currentNode = currentNode.linkBack;
		}
		
		
		return minimum;
	}
	
	public static void main(String[] args) {
		Queue queueTest = new Queue();
		
		queueTest.enque(10);
		queueTest.enque(13);
		queueTest.enque(-15);
		queueTest.enque(2510);
		
		int minimum = queueTest.getMin();
		System.out.printf("Minimum of the queue is: %d\n\n", minimum);
		
		int current = 0;
		for(int i = 0; i < 4; i++) { //should output 101315
			current = queueTest.deque();
			System.out.printf("%d\n", current);
		}
		
		System.out.printf("\n%b", queueTest.isEmpty());
		
		
	}

}
