package DS;

public class QueueusingLL<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		if(size==0){
			return true;
		}else{
			return false;
		}
	}
	public T front() throws QueueEmptyException{
		if(isEmpty()){
			QueueEmptyException e=new QueueEmptyException();
			throw e;
		}
		return head.data;
	}
	public void enqueue(T element){
		Node<T> newNode=new Node<T>();
		newNode.data=element;
		if(tail==null&&head==null){
			tail=newNode;
			head=newNode;
		}else{
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}
	public T dequeue() throws QueueEmptyException{
		if(isEmpty()){
			QueueEmptyException e=new QueueEmptyException();
			throw e;
		}
		if(size==1){
			size--;
			T element=head.data;
			head=head.next;
			tail=null;
			return element;
		}
		size--;
		T element=head.data;
		head=head.next;
		return element;
	}
}
