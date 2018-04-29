package HackerBlocksPractice;
import java.util.*;
public class LCS_Three_Strings {

	public static int LCS_Length(String str1,String str2,String str3){

		int n1 = str1.length();
		int n2 = str2.length();
		int n3 = str3.length();
		int dp[][][] = new int[n1+1][n2+1][n3+1];
		for(int i = 0 ; i <= n1 ; i++){
			for(int j = 0 ; j <= n2 ; j++){
				for(int k = 0 ; k <= n3 ; k++){

					if(i == 0 || j == 0 || k == 0){
						dp[i][j][k] = 0;
					}
					else if(str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j-1) == str3.charAt(k-1) && str3.charAt(k-1) == str1.charAt(i-1)){
						dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
					}
					else{
						dp[i][j][k] = Math.max(Math.max(dp[i][j][k-1],dp[i][j-1][k]),dp[i-1][j][k]);
					}
				}
			}
		}
		return dp[n1][n2][n3];
	}
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		int [] output = new int[testCases];

		for(int i = 0 ; i < testCases ; i++){

			String str1 = s.next();
			String str2 = s.next();
			String str3 = s.next();

			output[i] = LCS_Length(str1,str2,str3);

		}
		for(int i = 0 ; i < testCases ; i++){
			System.out.println(output[i]);
		}
	}
}