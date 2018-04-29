package fundamentals;

import java.util.Scanner;

public class StringUse {

	public static boolean isPalindrome(String a) {
		int startIndex = 0;
		int endIndex = a.length() - 1;
		
		while (startIndex < endIndex) {
			if (a.charAt(startIndex) != a.charAt(endIndex)) {
				return false;
			}
			startIndex++;
			endIndex--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		
		for (int i =0; i < a.length(); i++) {
			char ith = a.charAt(i);
			System.out.println(ith);
		}
		
		if (isPalindrome(a)) {
			System.out.println("Yes Palindrome");
		} else {
			System.out.println("Nope not a Palindrome");
		}
		
//		String plus = "+++";
//		String plus2 = plus;
//		
//		plus.replace('+', '-');
//		
//		System.out.println(plus);
//		System.out.println(plus2);
//		
//		String first = "Hello d";
//		String second = "Worl";
//		
//		String part1 = first.substring(0, 6);
//		String part2 = first.substring(6);
//		System.out.println(part1 + second + part2);
		
		
	}

}
