package DS;

import java.util.Scanner;

public class LinkedList {

	public static Node<Integer> takeLinkedListInput() {
		Node<Integer> head = null;
		Node<Integer> prevNode = null;
		System.out.println("Enter next element");
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		while (input != -1) {
			Node<Integer> newNode = new Node<Integer>();
			newNode.data = input;
			newNode.next = null;

			if (head == null) {
				head = newNode;
			} else { 
				prevNode.next = newNode;
			}

			prevNode = newNode;
			System.out.println("Enter next element");

			input = s.nextInt();
		}
		return head;
	}

	public static void printLinkedList(Node<Integer> input) {
		Node<Integer> currentNode = input;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
	}

	public static Node<Integer> insertNode(Node<Integer> head, int newElement, int position){
		Node<Integer> newNode = new Node<Integer>();
		newNode.data = newElement;

		if (position == 0) {
			newNode.next = head;
			return newNode;
		}

		int currentPosition = 1;
		Node<Integer> temp = head;

		while (currentPosition < position) {
			temp = temp.next;
			currentPosition++;
		}

		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}

	public static Node<Integer> deleteNode(Node<Integer> head, int position) {
		if (position == 0) {
			return head.next;
		}

		int currentPosition = 1;
		Node<Integer> temp = head;

		while (currentPosition < position) {
			temp = temp.next;
			currentPosition++;
		}

		temp.next = temp.next.next;
		return head;
	}

	public static Node<Integer> swap(Node<Integer> head, int i, int j) {
		if (i == 0) {
			Node<Integer> ith = head;
			Node<Integer> prevj = null;
			Node<Integer> jth = head;
			int count = 0;
			while (count < j) {
				prevj = jth;
				jth = jth.next;
				count++;
			}
			head = jth;
			Node<Integer> nexti = ith.next;
			Node<Integer> nextj = jth.next;

			if (i == j - 1) {
				jth.next = ith;
				ith.next = nextj;
			} else {
				ith.next = nextj;
				prevj.next = ith;
				jth.next = nexti;
			}
			return head;

		}

		Node<Integer> previ = null;
		Node<Integer> ith = head;
		int count = 0;
		while (count < i) {
			previ = ith;
			ith = ith.next;
			count++;
		}

		Node<Integer> prevj = null;
		Node<Integer> jth = head;
		count = 0;
		while (count < j) {
			prevj = jth;
			jth = jth.next;
			count++;
		}
		Node<Integer> nexti = ith.next;
		Node<Integer> nextj = jth.next;

		if (i != j - 1) {

			previ.next = jth;
			prevj.next = ith;

			ith.next = nextj;
			jth.next = nexti;
		} else {
			previ.next = jth;
			ith.next = nextj;
			jth.next = ith;
		}

		return head;
	}
	
	public static int findMinPosition(Node<Integer> head) {
		int minPosition = 0;
		Node<Integer> minNode = head;
		Node<Integer> temp = head;
		int currentPosition = 0;
		
		while (temp != null) {
			if (temp.data < minNode.data) {
				minPosition = currentPosition;
				minNode = temp;
			}
			currentPosition++;
			temp = temp.next;
		}
		return minPosition;
	}

	
	public static Node<Integer> InsertionSort(Node<Integer> head) {
		if (head == null || head.next == null)
			return head;
		
		Node<Integer> sortedSoFar = head;
		Node<Integer> remaining = head.next;
		head.next = null;
		
		while (remaining != null) {
			Node<Integer> currentNode = remaining;
			remaining = remaining.next;
			
			Node<Integer> temp = sortedSoFar;
			Node<Integer> prevTemp = null;
			while (temp != null) {
				if (temp.data > currentNode.data) {
					if (prevTemp == null) {
						currentNode.next = sortedSoFar;
						sortedSoFar = currentNode;
					} else {
						currentNode.next = temp;
						prevTemp.next = currentNode;
					}
					break;
				}
				prevTemp = temp;
				temp = temp.next;
			}
			
			if (temp == null) {
				prevTemp.next = currentNode;
				currentNode.next = null;
			}
		}
		return sortedSoFar;
	}
	
	
	public static Node<Integer> selectionSortRecursive(Node<Integer> head) {
		if (head == null || head.next == null)
			return head;
		
		int minP = findMinPosition(head);
		head = swap(head, 0, minP);
		head.next = selectionSortRecursive(head.next);
		return head;
	}

	public static void printReverse(Node<Integer> head) {
		if (head == null) {
			return;
		}
		
		printReverse(head.next);
		System.out.println(head.data);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> input = takeLinkedListInput();
		printLinkedList(input);
		input = InsertionSort(input);
		printLinkedList(input);
		
		
		
		
		
	}

}
