package HackerBlocksPractice;

public class UniqueNumbers3 {

	//See Prateek bhaiya lecture 
	//https://hack.codingblocks.com/practice/p/207/458
	public static int CountUniqueNumber(int [] arr,int n) {
		
		int [] count = new int[64];
		
		for(int i = 0 ; i < n ; i++) {	
			int pos = 0;
			int no = arr[i];
			while(no > 0) {
				count[pos] += no & 1;
				pos++;
				no = no >> 1;//This is to right shift a number so as to scan every bit of a number starting
				//from the top left position.
			}
		}
		
		int ans = 0;
		int p = 1;
		for(int i = 0 ; i < count.length ; i++) {
			count[i] = count[i] % 3;//This will cancel out the numbers which occurs 3 times in an array
			ans += count[i] * p;//This step will calculate decimal number from binary count array
			p = p << 1;//This is the way to generate the power of 2 i.e. 2^0,2^1,2^2 and so on.
		}
		return ans;
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] arr = {7,7,8,7,3,3,8,3,8,2,2,2,12};
		int ans = CountUniqueNumber(arr,arr.length);
		System.out.print(ans);
	}

}
