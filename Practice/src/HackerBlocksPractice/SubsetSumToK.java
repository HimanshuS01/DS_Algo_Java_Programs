package HackerBlocksPractice;

public class SubsetSumToK {

	//Only for non negative elements
	//https://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
	
	
	//The above solution may try all subsets of given set in worst case. 
	//Therefore time complexity of the above solution is exponential. 
	//The problem is in-fact NP-Complete (There is no known polynomial time solution for this problem).
	
	
	public static boolean isSubsetSum(int[] arr,int beg,int sum) {
		
		if(beg>=arr.length && sum!=0) {
			return false;
		}
		if(sum == 0) {
			return true;
		}
		if(arr[beg] > sum) {
			return isSubsetSum(arr, beg+1, sum);
		}
		
		return isSubsetSum(arr, beg+1, sum) || isSubsetSum(arr, beg+1, sum-arr[beg]);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		int n = arr.length;
		if (isSubsetSum(arr,0,sum) == true)
			System.out.println("Found a subset with given sum");
		else
			System.out.println("No subset with given sum");
	}

}
