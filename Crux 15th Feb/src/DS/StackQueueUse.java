package DS;

import java.util.Stack;

public class StackQueueUse {

	public static boolean isExpressionBalanced(String s) {
		StackUsingLL stack = new StackUsingLL();
		for (int i =0; i < s.length(); i++) {
			try {
				if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
					stack.push(s.charAt(i));
				} else if (s.charAt(i) == '}') {
					if (stack.top() == '{') {
						stack.pop();
					} else {
						return false;
					}
				}else if (s.charAt(i) == ']') {
					if (stack.top() == '[') {
						stack.pop();
					} else {
						return false;
					}
				} else if (s.charAt(i) == ')') {
					if (stack.top() == '(') {
						stack.pop();
					} else {
						return false;
					}
				}
			}
			catch(StackEmptyException e) {
				return false;
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
		
	}
	
	public void reverseStack(StackUsingLL s) {
		StackUsingLL s1 = new StackUsingLL();
		StackUsingLL s2 = new StackUsingLL();
		while (!s.isEmpty()) {
			try {
				s1.push(s.pop());
			} catch (StackEmptyException e) {
				// Not possible
			}
		}
		
		while (!s1.isEmpty()) {
			try {
				s2.push(s1.pop());
			} catch (StackEmptyException e) {
				// Not possible
			}
		}
		
		while (!s2.isEmpty()) {
			try {
				s.push(s2.pop());
			} catch (StackEmptyException e) {
				// Not possible
			}
		}
	}
	
	public static int[] findSpans(int[] a) {
		if (a.length == 0)
			return new int[0];
		
		
		int[] output = new int[a.length];
		
		Stack<GPair<Integer, Integer>> s = new Stack<GPair<Integer, Integer>>();
		
		output[0] = 1;
		GPair<Integer, Integer> p = new GPair<Integer, Integer>();
		p.index = 0;
		p.value = a[0];
		s.push(p);
		
		for (int i = 1; i < a.length; i++) {
			
			while (!s.empty() && s.peek().value < a[i] ) {
				s.pop();
			}
			if (s.empty()) {
				output[i] = i + 1;
			} else {
				output[i] = i - s.peek().index;
			}
			
			GPair<Integer, Integer> p1 = new GPair<Integer, Integer>();
			p1.index = i;
			p1.value = a[i];
			s.push(p1);
		}
		
		return output;
		
	}

	public static void main(String[] args) throws QueueEmptyException, QueueFullException {
		int[] a = {10,9,8,15,4,2,7,6,10,8,6};
		int[] spans = findSpans(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " " + spans[i]);
		}
		// TODO Auto-generated method stub
//		int[] a = {1,2,3,4,5};
//		StackUsingLL s = new StackUsingLL();
//
//		for (int i =0; i < a.length; i++) {
//			s.push(a[i]);
//		}
//
//		while(!s.isEmpty()) {
//			try {
//				System.out.println(s.pop());
//			} catch (StackEmptyException e) {
//				// Cant come here
//				System.out.println("Cant come here");
//			}
//		}
//		int[] a = {1,2,3,4,5};
//		QueueUsingArray q = new QueueUsingArray();
//		for (int i =0; i < a.length; i++) {
//			try {
//				q.enqueue(a[i]);
//			} catch (QueueFullException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		System.out.println(q.dequeue());
//		q.enqueue(10);
//
//		while (!q.isEmpty()) {
//			System.out.println(q.dequeue());
//		}

	}

}
