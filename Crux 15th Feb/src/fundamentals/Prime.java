package fundamentals;

import java.util.Scanner;

public class Prime {
	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		// boolean isp = isPrime(n);
		int a;
		if (isPrime(n-1)) {
			System.out.println("prime");
		} else {
			a = 9;
			System.out.println("not prime");
		}
	}

}
