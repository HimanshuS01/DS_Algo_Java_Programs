package HackerBlocksPractice;
import java.util.*;
public class ValentinesMagicHackerBlocks {

	//We took long because on adding something to Integer.MAX_VALUE will exceed the integer limit resulting in a
	//Integer.MIN_VALUE as a answer
	public static long GetPairs(int [] chocolates,int [] candies,long [][]dp,int i,int j){

		
		int m = chocolates.length;
		int n = candies.length;

		//It means we have pair all the boys and no boy is left
		if(i == m) {
			return 0;
		}
		
		//It means girls are rejected and boys are still left so ignore this case by returning MAX_VALUE 
		if(j == n) {
			return Integer.MAX_VALUE;
		}
		if(dp[i][j] != -1){
			return dp[i][j];
		}
		//include current boy and girl 
		long ans1 = Math.abs(chocolates[i] - candies[j]) + GetPairs(chocolates,candies,dp,i+1,j+1);

		//don't include current girl
		long ans2 = GetPairs(chocolates,candies,dp,i,j+1);

		return dp[i][j] = Math.min(ans1,ans2);

	}
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int numBoys = s.nextInt();
		int numGirls = s.nextInt();

		int [] chocolates = new int[numBoys];
		int [] candies = new int[numGirls];
		for(int i = 0 ; i < numBoys ; i++){
			chocolates[i] = s.nextInt();
		}
		for(int i = 0 ; i < numGirls ; i++ ){
			candies[i] = s.nextInt();
		}
		long [][]dp = new long[chocolates.length][candies.length];
		for(int i = 0 ; i < chocolates.length ; i++){
			for(int j = 0 ; j < candies.length ; j++ ){
				dp[i][j] = -1;
			}
		}
		Arrays.sort(chocolates);
		Arrays.sort(candies);
		System.out.println(GetPairs(chocolates,candies,dp,0,0));


	}
}