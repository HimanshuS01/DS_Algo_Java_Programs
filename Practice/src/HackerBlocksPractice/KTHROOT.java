package HackerBlocksPractice;
import java.util.*;
public class KTHROOT {

	//https://hack.codingblocks.com/contests/c/251/274
	public static void main(String args[]) {
		// Your Code Here

		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		while(testCases-- > 0){
			double ans = Math.pow(s.nextLong(),1.0/s.nextInt());
			if((ans*1000)%1000>990) ans = Math.ceil(ans);
			System.out.println((int)ans);
		}

	}
}
