package fundamentals;

import java.util.Scanner;

public class Pattern {
	
	public static void printPattern(int n) {
		int currentRow = 1;
		int currentValue = 1;
		
		while (currentRow <= n) {
			int currentCol = 1;
			while (currentCol <= currentRow) {
				System.out.print(currentValue + " ");
				currentValue = currentValue + 1;
				currentCol = currentCol + 1;
			}
			System.out.println();
			currentRow = currentRow + 1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter number of rows");
		Scanner s = new Scanner(System.in);
		int g = s.nextInt();
		printPattern(g-1);
	}

}
