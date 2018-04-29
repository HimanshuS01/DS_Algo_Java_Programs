package HackerBlocksPractice;

import java.util.Scanner;

public class OdometerProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int odometerValue = s.nextInt();
		int displacement = 0 ;
		int actualDistance = 0;
		int upDistance = s.nextInt();
		int backDistance = s.nextInt();
		int x = upDistance - backDistance;
		
		while(displacement <= odometerValue) {
			
			displacement += (upDistance - x);
			actualDistance = actualDistance + upDistance + backDistance;
			upDistance += 2;
			backDistance = backDistance + 2;
			x  = upDistance - backDistance ;
			
		}
		
		System.out.println("Actual Diatance is :"+actualDistance);
		s.close();
	}

}
