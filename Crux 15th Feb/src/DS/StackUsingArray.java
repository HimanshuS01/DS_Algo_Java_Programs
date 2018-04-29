package DS;

public class StackUsingArray {
	
	private int[] data;
	private int lastIndex;
	
	public StackUsingArray(int size) {
		data = new int[size];
		lastIndex = -1;
	}
	
	public int size() {
		return lastIndex + 1;
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int top() throws StackEmptyException {
		if (isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return data[lastIndex];
	}
	
	public void push(int newElement) {
		data[lastIndex + 1] = newElement;
		lastIndex++;
	}
	
	
	public int pop() throws StackEmptyException {
		if (isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		int element = data[lastIndex];
		data[lastIndex] = 0;
		lastIndex--;
		return element;
	}
	
}
