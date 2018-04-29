package DS;

public class Reverse {

	
	public static DoubleNode reverseRecursive3(Node<Integer> head) {
		if (head == null || head.next == null) {
			DoubleNode output = new DoubleNode();
			output.head = head;
			output.tail = head;
			return output;
		}
		
		DoubleNode smallerOutput = reverseRecursive3(head.next);
		smallerOutput.tail.next = head;
		head.next = null;
		
		DoubleNode output = new DoubleNode();
		output.head = smallerOutput.head;
		output.tail = head;
		return output;
		
	}
	
	public static Node<Integer> reverseRecursive2(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<Integer> smallerHead = reverseRecursive2(head.next);
		head.next.next = head;
		head.next = null;
		return smallerHead;
	}
	
	public static Node<Integer> reverseRecursive(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node<Integer> smallerHead = reverseRecursive(head.next);
		Node<Integer> temp = smallerHead;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;
		head.next = null;
		return smallerHead;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = LinkedList.takeLinkedListInput();
		Node<Integer> headReversed = reverseRecursive(head);
		LinkedList.printLinkedList(headReversed);
	}

}
