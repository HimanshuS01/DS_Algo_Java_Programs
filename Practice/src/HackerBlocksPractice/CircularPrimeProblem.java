package HackerBlocksPractice;

import java.util.Scanner;

public class CircularPrimeProblem {

	public static boolean isPrime(int n) {
		int x = 2;

		while (x <= n-1) {
			if (n % x == 0)  {
				return false;
			}
			x = x + 1;
		}
		return true;
	}

	public static int getLength(int num) {

		int len = 0;
		while(num != 0) {
			len ++;
			num = num / 10;
		}
		return len;
	}

	public static boolean isCircularPrime(int n) {


		if(!isPrime(n)) {
			return false;
		}

		int digitLength = getLength(n);

		for(int i = 0 ; i < digitLength-1 ; i++) {

			int lastDigit = n % 10;
			int x = n / 10;
			n = lastDigit * (int)Math.pow(10, digitLength-1) + x ;
			if(!isPrime(n)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner s = new Scanner(System.in);
		int number = s.nextInt();

		int countCircularPrime = 0;

		for(int i = 2 ; i <= number ; i++) {

			if(isCircularPrime(i)) {
				System.out.print(i+" ");
				countCircularPrime ++;
			}
		}
		System.out.println();
		System.out.println("Numberof circular prime is:" + countCircularPrime);
		
		s.close();
	}

}
