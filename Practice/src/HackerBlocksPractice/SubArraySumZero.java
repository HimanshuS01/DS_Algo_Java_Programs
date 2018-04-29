package HackerBlocksPractice;
import java.util.*;
public class SubArraySumZero {

	//https://hack.codingblocks.com/contests/c/251/136
	public static String CheckIfSubarraySumZero(int [] arr){

		for(int i = 0 ; i < (1<<arr.length) ; i++){
			int sum = 0;
			for(int j = 0 ; j < arr.length ; j++){

				if((i & (1<<j)) > 0){
					sum += arr[j];
					if(sum == 0){
						return "Yes";
					}
				}
			}
		}
		return "No";
	}
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);

		int testCases = s.nextInt();
		String [] output = new String[testCases];
		for(int j = 0 ; j < testCases ; j++){

			int numElements = s.nextInt();
			int[] arr = new int[numElements];
			for(int i = 0 ; i < numElements ; i++){
				arr[i] = s.nextInt();
			}

			output[j] = CheckIfSubarraySumZero(arr);

		}
		for(int i = 0 ; i < output.length ; i++){
			System.out.println(output[i]);
		}
	}
}
