package HackerBlocksPractice;
import java.util.Scanner;

public class RemoveDuplicates {

	public static String RemoveDuplicate(String str){
		if(str.length() == 0 || str.length() == 1){
			return str;
		}
		if(str.charAt(0) == str.charAt(1)){
			return str.charAt(0) + RemoveDuplicate(str.substring(2));
		}
		return str.charAt(0) + RemoveDuplicate(str.substring(1));
	}
	public static void main(String args[]) {
		// Your Code Here
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println(RemoveDuplicate(str));
		s.close();
	}
}
