package HackerBlocksPractice;
import java.util.*;

public class UniqueNumbers {

	public static int bitSize = 32;
	public static void main(String args[]) {
		// Your Code Here

		//https://www.geeksforgeeks.org/find-the-element-that-appears-once/
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int [] arr = new int[n];
		for(int i = 0 ; i < n ; i++){
			arr[i] = s.nextInt();
		}
		int result = 0;
		for(int i = 0 ; i < bitSize ; i++){

			int sum = 0;
			int x = 1<<i;

			for(int j = 0 ; j < n ; j++){

				if((arr[j] & x) == 0){
					sum++;
				}
			}

			if(sum % 3 == 0){
				result = result | x ;
			}

		}

		System.out.println(result);
		s.close();
	}  

}
