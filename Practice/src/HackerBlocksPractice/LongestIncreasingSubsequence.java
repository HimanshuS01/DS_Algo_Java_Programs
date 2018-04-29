package HackerBlocksPractice;

public class LongestIncreasingSubsequence {

	public static int LIS(int [] arr,int n,int max_lis) {
		
		if(n==1) {
			return 1;
		}
		int res = 1;
		int maxEndingHere = 1;
		
		for(int i = 1 ; i < n ; i++) {			
			res = LIS(arr,i,max_lis);
			if((arr[i-1] < arr[n-1]) && (res + 1 > maxEndingHere)) {
				maxEndingHere = res + 1;
			}
		}
		if(max_lis < maxEndingHere) {
			max_lis = maxEndingHere;
		}
		return maxEndingHere;
	}
	
	public static int lis(int [] arr,int n) {
		
		int max_lis = 1;
		return max_lis = LIS(arr,n,max_lis);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(lis(arr,arr.length));
	}

}
