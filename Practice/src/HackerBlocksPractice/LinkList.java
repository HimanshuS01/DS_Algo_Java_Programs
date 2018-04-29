package HackerBlocksPractice;
import java.util.*;

import sun.security.util.Length;

//https://www.geeksforgeeks.org/data-structures/linked-list/
/*
 * Do Following questions on Link List : Q 8,22,21,30,32,37,38,59
 */
public class LinkList {

	class Node<T>{
		T data;
		Node<Integer> next;
	}
	public static Scanner s;
	public static Node<Integer> CreateLL(){
		s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null;
		Node<Integer> temp = null;
		LinkList ll = new LinkList();
		while(data!=-1) {
			Node<Integer> newNode = ll.new Node<>();
			newNode.data = data;

			if(head == null) {
				head = newNode;
				temp = head;
			}
			else {
				temp.next = newNode;
				temp = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void PrintLL(Node<Integer> head) {

		Node<Integer> temp = head;
		while(temp != null) {
			System.out.print(temp.data+"-->");
			temp = temp.next;
		}
	}

	//KReverse LinkList
	public static Node<Integer> reverse(Node<Integer> head, int k)
	{
		Node<Integer> current = head;
		Node<Integer> next = null;
		Node<Integer> prev = null;

		int count = 0;

		while (count < k && current != null) 
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if (next != null) {
			head.next = reverse(next, k);
		}
		return prev;
	}          

	public static Node<Integer> Mid(Node<Integer> head){

		if(head == null || head.next == null) {
			return head;
		}
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		//We check for fast.next.next for the case 1-->2-->null(Just Imagine)
		while(fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static int count = 0;
	public static void KthNodeFromend(Node<Integer> head,int k) {
		if(head == null) {
			return;
		}
		KthNodeFromend(head.next, k);
		if((++count)== k) {
			System.out.println(head.data);
		}
	}

	public static Node<Integer> ReverseLL(Node<Integer> head)
	{
		if ((head == null) || (head.next == null)) {
			return head;
		}
		Node<Integer> smallerHead = ReverseLL(head.next);
		head.next.next = head;
		head.next = null;
		return smallerHead;
	}

	public static boolean CheckPallindrome(Node<Integer> head) {

		if(head == null || head.next == null) {
			return true;
		}
		Node<Integer> leftHead = head;
		Node<Integer> midNode = Mid(head);
		Node<Integer> rightHead = midNode.next;
		midNode.next = null;
		rightHead = ReverseLL(rightHead);
		while(leftHead != null && rightHead != null) {
			if(leftHead.data == rightHead.data) {
				leftHead = leftHead.next;
				rightHead = rightHead.next;
			}
		}
		if(leftHead == midNode && rightHead == null || leftHead == null && rightHead == null) {
			return true;
		}
		return false;
	}

	public static Node<Integer> Merge(Node<Integer> leftHead,Node<Integer> rightHead){

		if(leftHead == null) return rightHead;
		if(rightHead == null) return leftHead;

		if(leftHead.data <= rightHead.data) {
			leftHead.next = Merge(leftHead.next,rightHead);
			return leftHead;
		}
		else {
			rightHead.next = Merge(leftHead,rightHead.next);
			return rightHead;
		}

	}

	public static Node<Integer> MergeSort(Node<Integer> head){
		if(head == null || head.next == null) {
			return head;
		}
		Node<Integer> leftHead = head;
		Node<Integer> midNode = Mid(head);
		Node<Integer> rightHead = midNode.next;
		midNode.next = null;
		leftHead = MergeSort(leftHead);
		rightHead = MergeSort(rightHead);
		Node<Integer> mergedHead = Merge(leftHead,rightHead);
		return mergedHead;
	}

	//https://www.geeksforgeeks.org/sort-linked-list-already-sorted-absolute-values/
	//Time complexity is O(n): Space Complexity is O(1)
	public static Node<Integer> SortLinkListOnAbsoluteValues(Node<Integer> head){

		if(head == null || head.next == null) {
			return head;
		}

		Node<Integer> prev = head;
		Node<Integer> curr = head.next;

		while(curr!=null) {

			if(curr.data < prev.data) {
				prev.next = curr.next;
				curr.next = head;
				head = curr;
				curr = prev;
			}
			else {
				prev = curr;
			}
			curr = curr.next;
		}

		return head;

	}

	//https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
	//Recursive Solution : Time Complexity is O(n) 
	public static Node<Integer> pairWiseSwap(Node<Integer> head){

		if(head == null || head.next == null) {
			return head;
		}
		Node<Integer> remLL = null;
		if(head.next.next != null) {
			remLL = head.next.next;
		}
		Node<Integer> newHead = head.next;
		head.next.next = head;
		head.next = pairWiseSwap(remLL);

		return newHead;

	}


	//Try This Question : https://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/

	//This question : Array or link list in a Zig-Zag fashion
	//https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/

	public static Node<Integer> SegregateEvenOddLL(Node<Integer> head){

		if(head == null || head.next == null) {
			return head;
		}

		Node<Integer> evenHead = null;
		Node<Integer> evenEnd = null;
		Node<Integer> oddHead = null;
		Node<Integer> oddEnd = null;
		Node<Integer> curr = head;
		while(curr != null) {

			if(curr.data % 2 == 0) {
				if(evenHead == null) {
					evenHead = curr;
					evenEnd = evenHead;
				}
				else {
					evenEnd.next = curr;
					evenEnd = curr;
				}
			}
			else {
				if(oddHead == null) {
					oddHead = curr;
					oddEnd = oddHead;
				}
				else {
					oddEnd.next = curr;
					oddEnd = curr;
				}
			}
			curr = curr.next;
		}
		if(evenHead == null && oddHead == null) {
			return null;
		}
		evenEnd.next = oddHead;
		oddEnd.next = null;
		return evenHead;

	}

	//We can also do it recursively or can reverse the link list and multiply head by 2^0,2^1 and so on with
	//head.next,head.next.next etc..
	public static int BinaryLLToDecimal(Node<Integer> head){

		if(head == null) {
			return -1;
		}
		int res = 0;
		while(head != null) {
			res = (res << 1) + head.data;
			head = head.next;
		}
		return res;

	}

	//Find pair for given sum in a sorted singly linked without extra space
	//Time complexity is O(n) and space complexity is O(1).
	public static void PairForGivenSumLL(Node<Integer> head,int sum){

		if(head == null) {
			return;
		}
		Node<Integer> midNode = Mid(head);
		Node<Integer> head2 = ReverseLL(midNode.next);
		while(head != null && head2 != null) {
			if(head.data + head2.data == sum) {
				System.out.println("{"+head.data+","+head2.data+"}");
				head = head.next;
				head2 = head2.next;
			}
			else if(head.data + head2.data < sum) {
				head = head.next;
			}
			else {
				head2 = head2.next;
			}
		}	
	}

	public static int countCommon(Node<Integer> head1,Node<Integer> head2){

		int count = 0;
		while(head1 != null && head2 != null) {
			if(head1.data == head2.data) {
				count++;
				head1 = head1.next;
				head2 = head2.next;
			}
			else {
				break;
			}
		}
		return count;

	}

	/*
	 * Explanation for the below concept
	 * 2->3->7->3->2->12->24
     1. At 2, we compare null list to 3->7->3->2->12->24
     2. At 3, we compare 2 and 7->3->2->12->24
     3. At 7, we compare 2<-3 and 3->2->12->24 (Note the first half is reversed). 
        We get a hit here and result = 5 (odd)
     4. At 3, we compare 2<-3 <-7 and 2->12->24 (Note the first half is reversed) and so on
	 */
	
	public static int LengthOfLongestPallindromeLL(Node<Integer> head){

		if(head == null || head.next == null) {
			return 1;
		}
		Node<Integer> prev = null;
		Node<Integer> curr = head;
		int result = 0;
		while(curr != null) {
			Node<Integer> next = curr.next;
			curr.next = prev;

			//Since each node in LL is traversed twice hence TimeComplexity is O(n^2) and space is constant 
			result = Math.max(result, 2 * countCommon(prev,next) + 1);

			result = Math.max(result, 2 * countCommon(curr,next));


			prev = curr;
			curr = next;
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer> head = CreateLL();
		PrintLL(head);
		System.out.println();
		System.out.println(LengthOfLongestPallindromeLL(head));

		//		PairForGivenSumLL(head, 17);
		//		System.out.println(BinaryLLToDecimal(head));
		//		PrintLL(SegregateEvenOddLL(head));
		//		System.out.println();
		//		PrintLL(pairWiseSwap(head));
		//		System.out.println();
		//		PrintLL(SortLinkListOnAbsoluteValues(head));
		//		System.out.println(CheckPallindrome(head));
		//		System.out.println("Kth node from end is");
		//		KthNodeFromend(head, 3);
		//		Node<Integer> newHead = reverse(head, 3);
		//		System.out.println();
		//		PrintLL(newHead);
		System.out.println();
		//		System.out.println(Mid(head).data);
		//		Node<Integer> newHead1 = MergeSort(head);
		//		PrintLL(newHead1);
	}

}
