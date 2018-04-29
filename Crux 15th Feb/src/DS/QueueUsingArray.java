package DS;

public class QueueUsingArray {
	private int[] data;
	private int beginIndex;
	private int lastIndex;
	private int size;
	
	public QueueUsingArray() {
		data = new int[50];
		beginIndex = -1;
		lastIndex = -1;
	}
	
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}
	
	public int size() {
		return size;
	}
	
	public int front() throws QueueEmptyException {
		if (size() == 0) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		return data[beginIndex];
	}
	
	public void enqueue(int newElement) throws QueueFullException {
		if (size == data.length) {
			QueueFullException e = new QueueFullException();
			throw e;
		}
		
		lastIndex =  (lastIndex + 1) % data.length;
		data[lastIndex] = newElement;
		if (beginIndex == -1) {
			beginIndex = 0;
		}
		size++;
	}
	
	public int dequeue() throws QueueEmptyException {
		if (size() == 0) {
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		
		int temp= data[beginIndex];
		if (size() == 1) {
			beginIndex = -1;
			lastIndex = -1;
		} else {
			beginIndex = (beginIndex + 1) % data.length;
		}
		
		size--;
		return temp;
		
	}
	
}
