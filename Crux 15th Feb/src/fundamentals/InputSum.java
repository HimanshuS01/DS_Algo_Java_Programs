package fundamentals;

import java.util.Scanner;

public class InputSum {

	public static int getSum(int[] input) {
		int sum = 0;
		int i = 0;
		
		while (i < input.length) {
			sum = sum + input[i];
			i++;
		}
		return sum;
	}
	
	
	public static int getLargest(int[] input) {
		int i = 0;
		int largestSoFar = Integer.MIN_VALUE;
		while (i < input.length) {
			if (input[i] > largestSoFar) {
				largestSoFar = input[i];
			}
			i++;
		}
		return largestSoFar;
	}
	
	
	public static int linearSearch(int[] input, int number) {
		for (int i =0; i  < input.length; i++) {
			if (input[i] == number) {
				return i;
			}
		}
		return -1;
	}
	
	public static void bubbleSort(int[] input1) {
		for (int endIndex = input1.length - 1; endIndex > 0; endIndex--) {
			for (int currentIndex = 0; currentIndex < endIndex; currentIndex++) {
				if (input1[currentIndex] > input1[currentIndex + 1]) {
					int temp = input1[currentIndex];
					input1[currentIndex] = input1[currentIndex + 1];
					input1[currentIndex + 1] = temp;
				}
			}
		}
	}
	
//	public static void quickSort(int[] input, int beginIndex, int endIndex) {
//		if (beginIndex >= endIndex) {
//			return;
//		}
//		
//		int pivotPosition = partition(input, beginIndex, endIndex);
//		quickSort(input, beginIndex, pivotPosition - 1);
//		quickSort(input, pivotPosition + 1 , endIndex);
//		
//	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 5;
		System.out.println(a++ + a++);
		System.out.println(++b + ++b);
		System.out.println(Integer.MAX_VALUE);
		
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter number of inputs");
//		int n = s.nextInt();
//		int[] input = new int[n];
//		System.out.println(input);
//		int i = 0;
//		while (i < n) {
//			System.out.println("Enter next number");
//			input[i] = s.nextInt();
//			i = i + 1;
//		}
//		
//		System.out.println(getSum(input));
//		System.out.println(getLargest(input));
//		System.out.println("Enter number to be searched");
//		int number = s.nextInt();
//		
//		System.out.println(linearSearch(input, number));
//		for (int ij = 0; ij < input.length; ij++) {
//			System.out.println(input[ij]);
//		}
//		bubbleSort(input);
//		
//		System.out.println("Sorted");
//		for (int ij = 0; ij < input.length; ij++) {
//			System.out.println(input[ij]);
//		}
	}

}
