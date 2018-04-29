package HackerBlocksPractice;
import java.util.*;
public class MaximumBiotonicIncreasingSubsequence {

	public static int CalculateBiotonicLength(int [] arr){

		if(arr.length == 1){
			return 1;
		}
		int [] in = new int[arr.length];
		int [] dec = new int[arr.length];

		for(int i = 0 ; i < arr.length ; i++){
			in[i] = 1;
			dec[i] = 1;
		}

		//This logic is to find the Longest Increasing Subsequence using DP
		for(int i = 1; i < arr.length ; i++ ){
			for ( int j = 0; j < i; j++ ) {
				if ( arr[i] > arr[j] && in[i] < in[j] + 1){
					in[i] = in[j] + 1;
				}
			}
		}

		for(int i = arr.length-2 ; i >= 0 ; i--){
			for(int j = i+1 ; j < arr.length ; j++){
				if(arr[i] > arr[j] && dec[i] < dec[j] + 1){
					dec[i] = dec[j] + 1;
				}
			}
		}

		int max;
		max = in[0] + dec[0] - 1;
		for (int i = 1; i < arr.length; i++)
			if (in[i] + dec[i] - 1 > max)
				max = in[i] + dec[i] - 1;

		return max;
	}
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();

		int [] output = new int[testCases];

		for(int i = 0 ; i < testCases ; i++){

			int numElements = s.nextInt();
			int [] arr = new int[numElements];
			for(int j = 0 ; j < numElements ; j++){
				arr[j] = s.nextInt();
			}
			output[i] = CalculateBiotonicLength(arr);

		}
		for(int i = 0 ; i < output.length ; i++){
			System.out.println(output[i]);
		}
	}
}
