package fundamentals;

public class MergeSort {
	
	
	public static int[] merge(int[] input, int begin, int mid, int end) {
		int[] output = new int[end - begin + 1];
		int i = begin;
		int j = mid + 1;
		int k =0;
		while (i <= mid && j <= end) {
			if (input[i] < input[j]) {
				output[k] = input[i];
				i++;
				k++;
			} else {
				output[k] = input[j];
				k++;
				j++;
			}
		}
		
		while (i <= mid) {
			output[k] = input[i];
			i++;
			k++;
		}
		
		while (j <= end) {
			output[k] = input[j];
			k++;
			j++;
		}
		return output;
	}
	
//	public static void quickSort (int[] input, int beginIndex, int endIndex) {
//		// Base case
//		if (beginIndex >= endIndex)
//			return;
//		
//		//int pivot = input[beginIndex];
//		partition(input, beginIndex, endIndex);
//		quickSort(input, beginIndex, ------);
//		quickSort(input, -----, endIndex);
//		
//	}

	public static void mergeSort (int[] input, int beginIndex, int endIndex) {
		if (beginIndex >= endIndex) {
			return;
		}
		
		int mid = (beginIndex + endIndex)/2;
		mergeSort(input, beginIndex, mid);
		mergeSort(input, mid + 1, endIndex);
		
		int[] temp = merge(input, beginIndex, mid, endIndex);
		
		for (int i =0; i < temp.length; i++) {
			input[i + beginIndex] = temp[i];
		}
		
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
	
	public static long fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[10000];
		for (int i = 0; i < input.length; i++) {
			input[i] = input.length - i;
		}
		
		long startTime = System.currentTimeMillis();
		//mergeSort(input, 0, input.length - 1);
		long endTime = System.currentTimeMillis();
		//System.out.println("Time by merge sort " + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		fib(50);
		 endTime = System.currentTimeMillis();
		System.out.println("Time by fib " + (endTime - startTime));
//		for (int i = 0; i < input.length; i++) {
//			input[i] = input.length - i;
//		}
//		startTime = System.currentTimeMillis();
//		bubbleSort(input);
//		endTime = System.currentTimeMillis();
//		System.out.println("Time by bubble sort " + (endTime - startTime));
	}

}
