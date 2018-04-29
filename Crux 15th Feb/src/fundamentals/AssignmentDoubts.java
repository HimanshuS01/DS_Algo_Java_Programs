package fundamentals;

import java.util.Scanner;

public class AssignmentDoubts {

	public static void printTriplets(int[] input, int x) {
		for (int i =0; i < input.length; i++) {
			for (int j =0; j < i; j++) {
				for (int k =0; k < j; k++) {
					if (input[i] + input[j] + input[k] == x) {
						System.out.println(i + " "  + j + " " + k);
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		printTriplets(input, 0);
//		s.useDelimiter(",");
//		for (int i =0; i < 2; i++) {
//			String string = s.next();
//			System.out.println(string);
//			System.out.println(string.charAt(0));
//		}
//		s.useDelimiter("");
//		String string = s.next();
//		char c = string.charAt(0);
	}
}
