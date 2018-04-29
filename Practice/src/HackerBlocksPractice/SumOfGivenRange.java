package HackerBlocksPractice;

import java.util.*;
public class SumOfGivenRange {

	public class Range{
		int beg;
		int end;
	}
	public static int SumOfArrayInGivenRange(int [] arr,int beg,int end){

		int sum = 0;
		for(int i = beg-1 ; i < end ; i++){
			sum = sum + arr[i];
		}
		return sum;
	}
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();

		for(int i = 0 ; i < testCases ; i++ ){

			int numElements = s.nextInt();
			int [] arr = new int[numElements];
			for(int j = 0 ; j < numElements ; j++){
				arr[j] = s.nextInt();
			}

			int p = s.nextInt();
			int q = s.nextInt();

			int [] output = new int[2*p];
			int outputIndex = 0;
			SumOfGivenRange m = new SumOfGivenRange();
//			Range range = m.new Range();
			//			int beg = 0;
			//			int end = 0;
			Range [] range_arr = new Range[p];
			for(int k = 0 ; k < p ; k++){

				Range range = m.new Range();
				range.beg = s.nextInt();
				range.end = s.nextInt();
				range_arr[k] = range;
				output[outputIndex] = SumOfArrayInGivenRange(arr,range.beg,range.end);
				outputIndex++;
			}

			int rangeIndex = 0;
			for(int l = 0 ; l < q ; l++){

				int indexToBeUpdated = s.nextInt();
				int elementToBeReplaced = s.nextInt();

				arr[indexToBeUpdated-1] = elementToBeReplaced;
				output[outputIndex] = SumOfArrayInGivenRange(arr,range_arr[rangeIndex].beg,range_arr[rangeIndex].end);
				outputIndex++;
				rangeIndex++;
			}
			if(rangeIndex < range_arr.length) {
				output[outputIndex] = SumOfArrayInGivenRange(arr,range_arr[rangeIndex].beg,range_arr[rangeIndex].end);
			}

			System.out.println("#Test_Case : "+ (i+1));
			for(int x = 0 ; x < output.length ; x++){

				if(x < p){
					System.out.println("Sum of values in given range = "+output[x]);
				}
				else{
					System.out.println("Updated sum of values in given range = "+output[x]);
				}
			}

		}
	}
}