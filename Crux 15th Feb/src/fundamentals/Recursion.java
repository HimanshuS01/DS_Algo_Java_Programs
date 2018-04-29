package fundamentals;

import java.util.Scanner;

import javax.print.attribute.standard.Finishings;

public class Recursion {

	public int fact(int n) {
		if (n == 0) {
			return 1;
		}

		return n*fact(n-1);
	}

	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		return fibonacci(n-1) + fibonacci(n-2);

	}
	
	public static long numRabbit(int n) {
		if (n <= 2) {
			return 0;
		}
		
		long count = n - 2;
		for (int i = n - 3; i >=0; i--) {
			count += numRabbit(i);
		}
		return count;
	}

	public static void selectionSortMultipleCopies(int[] input) {
		if (input.length <= 1) {
			return;
		}

		int minIndex = 0;
		for (int i =0; i < input.length; i++) {
			if (input[i] < input[minIndex]) {
				minIndex = i;
			}
		}

		int temp = input[minIndex];
		input[minIndex] = input[0];
		input[0] = temp;

		int[] smallerArray = new int[input.length - 1];

		for (int i = 1; i <= input.length - 1; i++) {
			smallerArray[i-1] = input[i];
		}

		selectionSortMultipleCopies(smallerArray);
		for (int i = 1; i <= input.length - 1; i++) {
			input[i] = smallerArray[i-1];
		}
	}

	// This function sorts elements of input array between beginIndex to the end
	//...inlcusive of beginIndex
	public static void selectionSort(int[] input, int beginIndex) {
		if (beginIndex == input.length - 1) {
			return;
		}

		int minIndex = beginIndex;
		for (int i =beginIndex; i < input.length; i++) {
			if (input[i] < input[minIndex]) {
				minIndex = i;
			}
		}

		int temp = input[minIndex];
		input[minIndex] = input[beginIndex];
		input[beginIndex] = temp;
		selectionSort(input, beginIndex+1);
		System.out.println(beginIndex);
	}

	public static boolean isSorted(int[] array) {
		if (array.length <= 1) {
			return true;
		}

		int[] smallerArray = new int[array.length -1];

		for (int i = 1; i <= array.length - 1; i++) {
			smallerArray[i-1] = array[i];
		}

		boolean isSmallerArraySorted = isSorted(smallerArray);
		if (isSmallerArraySorted == false) {
			return false;
		} else {
			if (array[0] <= array[1]) {
				return true;
			} else {
				return false;
			}

		}
	}

	// This function searches elementToBeSearched in input array between bI and eI both inclusive
	public static int binarySearch(int[] input, int elementToBeSearched, int beginIndex, int endIndex) {
		if (endIndex < beginIndex) {
			return -1;
		}

		int mid = (beginIndex + endIndex)/2;

		if (input[mid] == elementToBeSearched) {
			return mid;
		} else if (input[mid] > elementToBeSearched) {
			int answer = binarySearch(input, elementToBeSearched, beginIndex, mid - 1);
			return answer;
		} else {
			int answer = binarySearch(input, elementToBeSearched, mid + 1, endIndex);
			return answer;
		}
	}

	// Sorts array from begin to end both inclusive
	public static void mergeSort(int[] array, int begin, int end) {
		if (begin >= end) {
			return;
		}
		int mid = (begin + end)/2;
		mergeSort(array, begin, mid);
		mergeSort(array, mid + 1, end);

		merge(array, begin, mid, end);	
	}

	public static void merge(int[] array, int beginIndex, int mid, int endIndex) {

	}

	// Moves n discs from pole1 to pole3 using pole2
	public static void towerHanoi(int n, String pole1, String pole2, String pole3) {
		if (n == 0) {
			return;
		}
		if (n == 1) {
			System.out.println("Transfer disc from " + pole1 + " to " + pole3);
			return;
		}

		towerHanoi(n-1, pole1, pole3, pole2);
		System.out.println("Transfer disc from " + pole1 + " to " + pole3);
		towerHanoi(n-1, pole2, pole1, pole3);
	}

	public static String getKeypad(char c) throws InvalidKeypadEntryException, InvalidKeypadEntry2Exception{
		if (c == '2') {
			return "abc";
		} else if (c == '3') {
			return "def";
		}  else if (c == '4') {
			return "ghi";
		} else if (c == '5') {
			return "jkl";
		} else if (c == '6') {
			return "mno";
		} else if (c == '7') {
			return "pqrs";
		}  else if (c == '8') {
			return "tuv";
		} else if (c == '9'){
			return "wxyz";
		} else {
			InvalidKeypadEntryException e = new InvalidKeypadEntryException();
			//Exception e = new Exception();
			throw e;
		}
	}
	
	

//	public static String[] keypadCombinations(String n) {
//		if (n.length() == 0) {
//			String[] output = new String[1];
//			output[0] = "";
//			return output;
//		}
//
//		String[] smallerOutput = keypadCombinations(n.substring(1));
//		String currentCharPossible = getKeypad(n.charAt(0));
//		String[] output = new String[smallerOutput.length * currentCharPossible.length()];
//		int k = 0;
//		for (int i = 0; i < currentCharPossible.length(); i++) {
//			for (int j = 0; j < smallerOutput.length; j++) {
//				output[k] = currentCharPossible.charAt(i) + smallerOutput[j];
//				k++;
//			}
//
//
//		}
//		return output;
//	}

	public static void printKeypad(String input, String outputSoFar){
		if (input.length() == 0) {
			System.out.println(outputSoFar);
			return;
		}
		String possibleCharForCurrentNumber;
		
		try {
			possibleCharForCurrentNumber = getKeypad(input.charAt(0));
		} catch(InvalidKeypadEntryException ex) {
			//possibleCharForCurrentNumber = "";
			System.out.println("Invalid input");
			return;
		} catch(InvalidKeypadEntry2Exception e) {
			System.out.println("9 is not allowed");
			return;
		} 
		
		for (int i =0; i < possibleCharForCurrentNumber.length(); i++) {
			printKeypad(input.substring(1), outputSoFar + possibleCharForCurrentNumber.charAt(i));
		}
	}

	public static int[][] subsetSum (int[] input, int begin, int sum) {
		if (begin >= input.length) {
			if (sum == 0) {
				int[][] output = new int[1][0];
				return output;
			} else {
				int[][] output = new int[0][0];
				return output;
			}
		}

		int[][] exclusiveOutput = subsetSum(input, begin + 1, sum);
		int[][] inclusiveOutput = subsetSum(input, begin + 1, sum - input[begin]);

		int[][] output = new int[inclusiveOutput.length + exclusiveOutput.length][input.length - begin];

		for (int i =0; i < exclusiveOutput.length; i++) {
			for (int j = 0; j < exclusiveOutput[i].length; j++) {
				output[i][j] = exclusiveOutput[i][j];
			}
		}

		for (int i =0 ; i < inclusiveOutput.length; i++) {
			for (int j = 0; j < inclusiveOutput[i].length; j++) {
				output[i + exclusiveOutput.length][j+1] = inclusiveOutput[i][j];
			}
			output[i + exclusiveOutput.length][0] = input[begin];
		}

		return output;
	}

	public static int[][] subsets(int[] input, int begin) {
		if (begin >= input.length) {
			int[][] output = new int[1][0];
			return output;
		}
		
		int[][] smallerOutput = subsets(input, begin + 1);
		int[][] output = new int[(int)Math.pow(2, input.length - begin)][input.length - begin];

		for (int i = 0; i < smallerOutput.length; i++) {
			for (int j = 0; j < smallerOutput[i].length; j++) {
				output[2*i][j] = smallerOutput[i][j];
				output[2*i + 1][j+1] = smallerOutput[i][j];
			}
			output[2*i + 1][0] = input[begin];
		}
		return output;
	}
//	
//	public static char getCode(String codeFor) {
//		if (codeFor.length() == 1) {
//			
//		}
//	}
	
	public static void printCodes(String x, String soFar) {
	if (x.length() == 0) {
			System.out.println(soFar);
			return;
		}
		
		if (x.length() == 1) {
			System.out.println(soFar + ((char)('a' + (x.charAt(0) - '1'))) );
			return;
		}
		
		
		char frontCharPossibility1 =  (char)('a' + (x.charAt(0) - '1'));
		printCodes(x.substring(1), soFar + frontCharPossibility1);
		
		
		if (x.charAt(0) == '1' || (x.charAt(0) == '2' && x.charAt(1) <= '6')) {
			char frontCharPossibility2;
			if (x.charAt(0) == '1') {
				frontCharPossibility2 = (char)(10 +  'a' + (x.charAt(1) - '1'));
			} else {
				frontCharPossibility2 = (char)(20 +  'a' + (x.charAt(1) - '1'));
			}
			printCodes(x.substring(2), soFar + frontCharPossibility2);
		}
	}

	public static String[] getCodes(String x) {
		if (x.length() == 0) {
			String[] output = new String[1];
			output[0] = "";
			return output;
		}
		
		if (x.length() == 1) {
			String[] output = new String[1];
			output[0] = ((char)('a' + (x.charAt(0) - '1'))) + "";
			return output;
		}
		
		
		char frontCharPossibility1 =  (char)('a' + (x.charAt(0) - '1'));
		String[] smallerOutput1 = getCodes(x.substring(1));
		String[] output = null;
		char frontCharPossibility2 = ' ';
		String[] smallerOutput2 = null;
		
		if (x.charAt(0) == '1' || (x.charAt(0) == '2' && x.charAt(1) <= '6')) {
			if (x.charAt(0) == '1') {
				frontCharPossibility2 = (char)(10 +  'a' + (x.charAt(1) - '1'));
			} else {
				frontCharPossibility2 = (char)(20 +  'a' + (x.charAt(1) - '1'));
			}
			smallerOutput2 = getCodes(x.substring(2));
		}
		
		if (smallerOutput2 == null) {
			output = new String[smallerOutput1.length];
		} else {
			output = new String[smallerOutput1.length + smallerOutput2.length];
		}
		int i = 0;
		for (String ans:smallerOutput1) {
			output[i] = frontCharPossibility1 + ans;
			i++;
		}
		
		if (smallerOutput2 != null) {
			for (String ans:smallerOutput2) {
				output[i] = frontCharPossibility2 + ans;
				i++;
			}
		}
		return output;
	}
	
	
	public static void subsetPrinting(int[] input, int begin, int[] arraySoFar) {
		if (begin >= input.length) {
			for (int i = 0; i < arraySoFar.length; i++) {
				System.out.print(arraySoFar[i] + " ");
			}
			System.out.println();
			return;
		}

		arraySoFar[begin] = 0;
		subsetPrinting(input, begin + 1, arraySoFar);

		arraySoFar[begin] = input[begin];
		subsetPrinting(input, begin + 1, arraySoFar);	
	}

	public static void printSumK(int[] input, int begin, int[] arraySoFar, int sum) {
		if (begin >= input.length) {
			int sum1 = 0;
			for (int i = 0; i < arraySoFar.length; i++) {
				sum1 = sum1 + arraySoFar[i];
			}
			if (sum1 == sum) {
				for (int i = 0; i < arraySoFar.length; i++) {
					System.out.print(arraySoFar[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		
		arraySoFar[begin] = 0;
		printSumK(input, begin + 1, arraySoFar, sum);

		arraySoFar[begin] = input[begin];
		printSumK(input, begin + 1, arraySoFar, sum);	

	}

	public static void print2D(int[][] array2d) {
		for (int i = 0; i < array2d.length; i++) {
			for (int j = 0; j < array2d[i].length;j++) {
				System.out.print(array2d[i][j] + " ");
			}
			System.out.println();
		}
	}


	public static long numRabbits2(int n) {
		if (n == 0) {
			return 1;
		}
		
		if (n <= 2) {
			return 0;
		} 
		return numRabbits2(n-1) + numRabbits2(n-3);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	//	String a = s.next();
//		//printKeypad(a, "");
//		String[] output = getCodes(a);
//		
//		for (String b: output) {
//			System.out.println(b);
//		}
//
//		System.out.println(output.length);
		int i = 0;
		int j = 10;
		
		int b = i ^ j;
		System.out.println(b);
		
	}

}
