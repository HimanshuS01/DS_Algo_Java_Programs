package HackerBlocksPractice;

import java.util.*;
public class IsArraySortedUsingRecursion {

	public static boolean isSorted(int []arr,int beg,int end){

		if(beg >= end){
			return true;
		}
		boolean isRemainingSorted = isSorted(arr,beg+1,end);
		if(beg <= end && arr[beg]<=arr[beg+1] && isRemainingSorted){
			return true;
		}
		return false;

	}
	public static void main(String args[]) {
		// Your Code Here
		Scanner s = new Scanner(System.in);

		int num = s.nextInt();
		int [] arr = new int[num];
		for(int i = 0 ; i < num ; i++) {
			arr[i] = s.nextInt();
		}
		if(isSorted(arr,0,arr.length-1)){
			System.out.println("true");
		}
		else{
			System.out.println("false");
		}
	}
}
