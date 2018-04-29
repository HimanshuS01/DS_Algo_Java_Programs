package HackerBlocksPractice;

import java.util.*;
public class BiotonicSubArrayLength {

	public static int CalculateBiotonicLength(int [] arr){

		int [] in = new int[arr.length];
		int [] dec = new int[arr.length];
		in[0] = 1;
		dec[arr.length-1] = 1;
		for(int i = 1 ; i < arr.length ; i++){
			if(arr[i] >= arr[i-1] ){
				in[i] = in[i-1] + 1;
			}
			else{
				in[i]  = 1;
			}
		}
		for(int i = arr.length-1 ; i > 0 ; i--){
			if(arr[i-1] >= arr[i] ){
				dec[i-1] = dec[i]+1;
			}
			else{
				dec[i-1]  = 1;
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