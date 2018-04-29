package DS;

public class StackUsingLL {

	private Node<Integer> head;
	private int size;
	
	public int top() throws StackEmptyException{
		if (size == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		return head.data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int pop() throws StackEmptyException {
		if (size == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		int toBeReturned = head.data;
		head = head.next;
		size--;
		return toBeReturned;
	}
	
	public void push(int newElement) {
		size++;
		Node<Integer> newNode = new Node<Integer>();
		newNode.data = newElement;
		newNode.next = head;
		head = newNode;
	}
	
	
	
}
