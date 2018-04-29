package fundamentals;

import java.util.Scanner;

public class MultiDArray {

	public static void print2D(int[][] array2d) {
		for (int i = 0; i < array2d.length; i++) {
			for (int j = 0; j < array2d[i].length;j++) {
				System.out.println("a[" + i + "][" + j + "]=" + array2d[j][i]);
			}
		}
	}
	
	
	public static void spiralPrint(int[][] array2D) {
		if (array2D.length == 0) {
			return;
		}
		
		int up = 0; 
		int down = array2D.length - 1;
		int left = 0;
		int right = array2D[0].length - 1;
		int turn = 0;
		while (up <= down && left <= right) {
			if (turn == 0) {
				for (int col = left; col <= right; col++) {
					System.out.println(array2D[up][col]);
				}
				up++;
			}
			
			if (turn == 1) {
				for (int row = up; row <= down; row++) {
					System.out.println(array2D[row][right]);
				}
				right--;
			}
			if (turn == 2) {
				for (int col = right; col >= left; col--) {
					System.out.println(array2D[down][col]);
				}
				down--;
			}
			
			if (turn == 3) {
				for (int row = down; row >= up; row--) {
					System.out.println(array2D[row][left]);
				}
				left++;
			}
			turn = (turn + 1) % 4;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of rows");
		int m = s.nextInt();
		System.out.println("Enter number of columns");
		
		int n = s.nextInt();
		int[][] a = new int[m][n];
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.println("Enter element at " + i + " and " + j);
				a[i][j] = s.nextInt();
			}
		}
		spiralPrint(a);
	}

}
