package HackerBlocksPractice;
import java.util.*;

/*
Pattern Printing
   1*2*3*10*11*12
     4*5*8*9
       6*7
 */ 
public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int n = N;
		int count1 = 1 , count2 = N*N + 1;
		int x = count2;
		for(int i = 0 ; i < N ; i++) {

			for(int spaces = 0 ; spaces < 2*i ; spaces++) {
				System.out.print(" ");
			}
			count2 = x;
			for(int j = 1 ; j <= (n*2) ; j++) {

				if(j<= (n*2)/2) {
					System.out.print(count1+"*");
					count1++;
				}

				else if(j >= (n*2)/2 && j< n*2) {
					System.out.print(count2+"*");
					count2++;
				}
				else {
					System.out.print(count2);
				}
			}
			System.out.println();
			x = x - (n - 1);
			n--;
		}
		s.close();
	}

}
