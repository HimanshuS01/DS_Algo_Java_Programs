package fundamentals;

import java.util.Scanner;

public class HelloWorld {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		Scanner s = new Scanner(System.in);
		int limit = s.nextInt();
		int x = 0;
		int a = 5;
		double b = 5;
		if (a == b) {
			System.out.println(a);
		}
		
		// prints till 300 F
		/*
		 * 
		 */
		while (x <= limit) {
			int c = (int)(5.0/9 * (x - 32));
			System.out.println(x + "   " + c);
			x = x + 20;
		}
		
	}

}
