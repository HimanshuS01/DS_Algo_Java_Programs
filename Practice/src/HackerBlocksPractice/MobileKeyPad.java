package HackerBlocksPractice;

import java.util.Scanner;

public class MobileKeyPad {

	public static String getKeypadNumbers(int num) {

		String[] arr = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		return arr[num-2];
	}
	
	public static void PrintMobileKeypadCombinations(String str,char[] decision,int beg,int i) {
		
		if(beg >= str.length()) {
			for(int j = 0 ; j < decision.length ; j++) {
				System.out.print(decision[j]);
			}
			System.out.println();
			return;
		}

		String keypadChars = getKeypadNumbers(str.charAt(beg)-'0');

		for(int j = 0 ; j < keypadChars.length() ; j++) {

			decision[i] = keypadChars.charAt(j);
			PrintMobileKeypadCombinations(str, decision, beg+1, i+1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		char[] decision = new char[str.length()];
		PrintMobileKeypadCombinations(str,decision,0,0);

	}

}
