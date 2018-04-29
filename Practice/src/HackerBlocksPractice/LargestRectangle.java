package HackerBlocksPractice;
import java.util.*;
public class LargestRectangle {

	public static int MaxArea(int []arr,int n) {

		Stack<Integer> st = new Stack<>();
		int topIndex = -1;
		int maxArea = -1;
		int area = -1;
		int i = 0;
		while(i < n) {
			if(st.isEmpty() || arr[i] >= arr[st.peek()]) {
				st.push(i++);
			}
			else {
				topIndex = st.peek();
				st.pop();
				area = arr[topIndex] * (st.empty() ? i : i - st.peek() - 1);

				if(area > maxArea) {
					maxArea = area;
				}
			}

		}
		while(!st.isEmpty()) {
			topIndex = st.peek();
			st.pop();
			area = arr[topIndex] * (st.empty() ? i : i - st.peek() - 1);

			if(area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] histogram = new int[n];
		for(int i = 0 ; i < n ; i++) {
			histogram[i] = s.nextInt();
		}
		System.out.println(MaxArea(histogram,n));
	}

}
