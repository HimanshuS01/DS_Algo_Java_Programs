package HackerBlocksPractice;

import java.util.Scanner;

//https://hack.codingblocks.com/practice/p/390/79
public class PrintEvenOddRecursion {

	public static void PrintEvenOdd(int num) {
		
		if(num <= 0) {
			return;
		}
		if(num %2 != 0) {
			System.out.println(num);		
		}
		PrintEvenOdd(--num);
		if(num %2 == 0 && num != 0) {
			System.out.println(num);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		PrintEvenOdd(num);
		if(num%2==0) {
			System.out.println(num);
		}
	}

}
