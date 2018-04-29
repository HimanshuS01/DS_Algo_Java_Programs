package HackerBlocksPractice;
import java.util.*;
public class Fibonacci {

	//Top down approach using dp - Space and Time complexity is O(N)
	public static int Fibonaci(int number, int[] dp) {

		if(number == 0) {
			return 0;
		}
		if(number == 1) {
			return 1;
		}
		if(dp[number] != 0) {
			return dp[number];
		}
		return dp[number] = Fibonaci(number-1, dp) + Fibonaci(number-2, dp);
	}

	//Bottom Up iterative approach filling dp[] array from beginning
	public static int Fibonaci_BottomUp(int number,int []dp) {
		
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2 ; i <= number ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[number];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s  = new Scanner(System.in);
		int number = s.nextInt();
		int [] dp = new int[number+1];
		int ans = Fibonaci(number,dp);
		System.out.println(Fibonaci_BottomUp(number, dp));
		s.close();
	}

}
