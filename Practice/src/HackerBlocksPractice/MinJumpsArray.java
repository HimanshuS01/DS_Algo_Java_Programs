package HackerBlocksPractice;

public class MinJumpsArray {

	//https://hack.codingblocks.com/contests/c/251/1088
	//https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
	public static int MinJumps(int[] arr,int beg,int end) {

		if(beg == end) {
			return 0;
		}
		if(arr[beg] == 0) {
			return Integer.MAX_VALUE;
		}
		int minJumps = Integer.MAX_VALUE;
		for(int i = beg+1;i <= end && i <= beg + arr[beg];i++) {
			int min = MinJumps(arr, i, end);
			if((min != Integer.MAX_VALUE) && (min + 1 < minJumps)) {
				minJumps = min + 1;
			}
		}
		return minJumps;
	}

	//Using DP
	public static int MinJumps2(int []arr,int beg,int end) {
		if(beg == end || arr[0] == 0) {
			return 0;
		}
		int [] jumps = new int[arr.length];
		jumps[0] = 0;
		
		for(int i = 1 ; i < arr.length ; i++) {
			jumps[i] = Integer.MAX_VALUE;
			
			for(int j = 0 ; j < i ; j++) {
				if(i <= j+arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
					break;
				}
			}
		}
		return jumps[end];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(MinJumps(arr,0,arr.length-1));
	}

}
