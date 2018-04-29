package HackerBlocksPractice;

import java.util.*;
public class ArraySubsetSumToZero {

	
	//Without recursion-> https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
		
	
	//Please Correct the logic for below program.Though it's printing correct output but not returning correct boolean
	public static boolean SubsetSumZero(int [] arr,int [] decision,int beg,int end){

		if(beg >= end){
			int sum = 0;
			for(int i = 0 ; i < decision.length ; i++){
				sum = sum + decision[i];
			}
			if(sum == 0) {
				for(int i = 0 ; i < decision.length ; i++) {
					System.out.print(decision[i]+" ");
				}
				System.out.println();
				return true;
			}
		}

		if(beg<end) {
			decision[beg] = 0;
			SubsetSumZero(arr,decision,beg+1,end);

			decision[beg] = arr[beg];
			SubsetSumZero(arr,decision,beg+1,end);
		}
		return false;

	}
	
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		for(int i = 0 ; i < testCases ; i++){

			int numElements = s.nextInt();
			int []arr = new int[numElements];
			int []decision = new int[numElements];
			for(int j = 0 ; j < numElements ; j++){
				arr[j] = s.nextInt();
			}
			if(SubsetSumZero(arr,decision,0,numElements)){
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}

	}
}