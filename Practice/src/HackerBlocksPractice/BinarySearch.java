package HackerBlocksPractice;
import java.util.*;

public class BinarySearch {

	public static int lowerBoundIndex = -1;
	public static int upperBoundIndex = -1;
	public static int root = 0;

	@SuppressWarnings("unused")
	private static int LowerBound(int[] arr, int beg, int end,int element) {

		if(beg > end) {
			return lowerBoundIndex;
		}
		if(beg <= end) {
			int med = (beg+end)/2;
			if(arr[med] == element) {
				lowerBoundIndex = med;
				end = med-1;
			}
			else if(element < arr[med]) {
				end = med - 1;
			}
			else {
				beg = med + 1;
			}

			LowerBound(arr, beg, end, element);
		}
		return lowerBoundIndex;	
	}

	@SuppressWarnings("unused")
	private static int UpperBound(int[] arr, int beg, int end,int element) {

		if(beg > end) {
			return upperBoundIndex;
		}
		if(beg <= end) {
			int med = (beg+end)/2;
			if(arr[med] == element) {
				upperBoundIndex = med;
				beg = med+1;
			}
			else if(element < arr[med]) {
				end = med - 1;
			}
			else {
				beg = med + 1;
			}

			UpperBound(arr, beg, end, element);
		}
		return upperBoundIndex;	
	}

	//This fnxn only gives answer when the number is a perfect square
	public static int SquareRoot(int num,int beg,int end) {

		if(beg > end) {
			return root;
		}
		else if(beg <= end) {
			int med = (beg+end)/2;
			if(med * med == num) {
				root = med;
				return root;
			}
			else if( med * med < num) {
				beg = med + 1;
			}
			else {
				end = med - 1;
			}
			SquareRoot(num, beg, end);
		}

		return root;
	}

	private static boolean FeasibleSolution(int[] book_pages_arr, int minPages, int numStudents) {

		int pagesAlreadyAllocated = 0;
		int students_assigned = 1;
		for(int i = 0 ; i < book_pages_arr.length ; i++) {

			if(book_pages_arr[i] > minPages) {
				return false;
			}
			else if(pagesAlreadyAllocated + book_pages_arr[i] <= minPages) {
				pagesAlreadyAllocated += book_pages_arr[i];
			}
			else {
				students_assigned ++;
				pagesAlreadyAllocated = book_pages_arr[i];

				if(students_assigned > numStudents) {
					return false;
				}
			}
		}

		return true;
	}

	//https://www.geeksforgeeks.org/allocate-minimum-number-pages/
	public static int MinNumPages(int[] book_pages_arr,int numStudents) {

		int beg = 0;
		int end = Arrays.stream(book_pages_arr).sum();
		int ans = Integer.MAX_VALUE;
		while(beg <= end) {
			int med = (beg+end)/2;
			if(FeasibleSolution(book_pages_arr,med,numStudents)) {
				ans = Math.min(ans, med);
				end = med-1;
			}
			else {
				beg = med+1;
			}
		}
		return ans;
	}

	//https://github.com/coding-blocks-archives/nagarro-deepak/blob/master/03_divideAndConquer/inversionCount.cs
	public static int CountPairAfterMerging(int [] arr,int beg,int med,int end ) {

		int [] L = new int[med - beg + 1];
		int [] R = new int[end - med];

		int l = 0;
		int m = 0;
		for(int i = beg ; i <= end ; i++) {
			if(i <= med) {
				L[m] = arr[i];
				m++;
			}
			else {
				R[l] = arr[i];
				l++;
			}
		}

		int beg_left = 0;
		int begRight = 0;
		//Remember this step - k must be initialize to beg always (is cheej par mene bht time spent kiya he :( )
		int k = beg;
		int count = 0;
		while((beg_left < L.length) && (begRight < R.length)) {
			if(L[beg_left] <= R[begRight] ) {
				arr[k] = L[beg_left];
				beg_left++;
				k++;
			}

			else {
				count += L.length - beg_left ;
				arr[k] = R[begRight];
				k++;
				begRight++;
			}
		}
		while(beg_left < L.length) {
			arr[k] = L[beg_left];
			k++;
			beg_left++;
		}
		while(begRight < R.length) {
			arr[k] = L[begRight];
			k++;
			begRight++;
		}
		return count;
	}

	//Print Number of pairs in an array such that in pair second number is always less than the ist in pair
	public static int CountPairs(int [] arr,int beg,int end) {
		//		int count = 0;
		if(beg >= end) {
			return 0;
		}
		int med = (beg+end)/2;
		int leftCount = CountPairs(arr, beg, med);
		int rightCount = CountPairs(arr, med+1, end);
		int countAfterMerge = CountPairAfterMerging(arr,beg,med,end);
		return leftCount + countAfterMerge + rightCount;
	}

	//https://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
	private static void printSubsets(char[] ch, int n) {

		for(int i = 0 ; i < 8 ; i++) {
			
			for(int j = 0 ; j < n ; j++ ) {
				
				if((i & (1<<j)) > 0) {
					System.out.print(ch[j]);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		//		int [] arr = new int[8];
		//		for(int i = 0 ; i < arr.length ; i++) {
		//			arr[i] = s.nextInt();
		//		}
		//		int lowerBound = LowerBound(arr,0,arr.length-1,2);
		//		int upperBound = UpperBound(arr, 0, arr.length-1, 2);
		//		System.out.println(lowerBound);
		//		System.out.println(upperBound);

		//		System.out.println(SquareRoot(400, 1, 400));


		//		int [] book_pages_arr = {12,34,67,90};
		//		int numStudents = 2;
		//		System.out.println(MinNumPages(book_pages_arr,numStudents));

		int [] arr = {4,3,2,1,0};
		System.out.println(CountPairs(arr, 0, arr.length-1));
		
		char[] ch = {'a','b','c'};
		printSubsets(ch,3);
		
		
		s.close();
	}
}
