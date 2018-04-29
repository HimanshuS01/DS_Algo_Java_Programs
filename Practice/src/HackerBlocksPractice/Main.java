package HackerBlocksPractice;
import java.util.*;
public class Main {

	public static int MaxCircularSum(int [] arr){

		int ans = arr[0];
		int [] dp = new int[arr.length];
		dp[0] = arr[0];
		int count = 1;
		while(count <  (2 * arr.length - 1)){
			int index = count % arr.length;
			if(index > 0) {
				dp[index] = Math.max(dp[index-1] + arr[index] , arr[index]);
			}else {
				dp[index] = Math.max(dp[arr.length-1] + arr[index] , arr[index]);
			}
			ans  = Math.max(ans,dp[index]);
			count++;
		}
		return ans;
	}
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		while(testCases -- >= 0){

			int numElements = s.nextInt();
			int [] arr = new int[numElements];
			for(int i = 0 ; i < numElements ; i++){
				arr[i] = s.nextInt();
			}
			System.out.println(MaxCircularSum(arr));
		}
	}
}