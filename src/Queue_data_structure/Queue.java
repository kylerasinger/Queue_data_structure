package Queue_data_structure;

//First in First out

public class Queue {
	
	private Node first = null;
	
	private class Node{
		Node link;
		int data;
		
		public Node(int i, Node n)
		{
			data = i;
			link = n;
		}
	}
	
	public void push(int i) {
		Node oldFirst = first;
		Node added = new Node(i, oldFirst);
		first = added;
	}
	
	public int pop()
	{
		Node tempfirst = first;
		first = first.link;		
		return tempfirst.data; 
	}
	
	public static void main(String[] args) {
		Queue queueTest = new Queue();
		
		queueTest.push(10);
		queueTest.push(13);
		queueTest.push(15);
		
		int current = 0;
		for(int i = 0; i < 3; i++) { //should output 101315
			current = queueTest.pop();
			System.out.print(current);
		}
		
		
	}

}
