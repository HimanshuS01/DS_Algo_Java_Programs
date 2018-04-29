package HackerBlocksPractice;
import java.util.*;
public class CheckSumString {

	public static boolean isSumString(String str,int beg,int len1,int len2){

		String str1 = str.substring(beg,beg+len1);
		String str2 = str.substring(beg+len1,beg+len1+len2);
		String str3 = (Long.parseLong(str1) + Long.parseLong(str2))+ "";
		int len3 = str3.length();

		if(len3 > (str.length() - len1 - len2 - beg)){
			return false;
		}

		//This is a backtracking approach i.e. for every two sub strings we will check
		//if it is equal to the next string or not. If Not then we will take another
		//pair of two strings and check it again
		
		//We can extend this loop to any number for example in 12000000003
		//1+2 = 000000003 that can be handled by below loop by increasing the number of iteration
		for(int i = 0 ; i < 10 ; i++) {
			if((beg+len1+len2+len3 <= str.length()) && (str3.equals(str.substring(beg+len1+len2,beg+len1+len2+len3)))){

				if((beg + len1 + len2 + len3) == str.length()){
					return true;
				}
				else{
					return isSumString(str,beg+len1,len2,len3);
				}
			}
			//This is for the case : 123024... i.e. 1 + 23 = 024 because Long.parseLong("024") is 24.
			else{
				str3 = "0" + str3;
				len3++;
			}
		}
		return false;
	}

	public static boolean IsSumString(String str){

		for(int i = 1 ; i < str.length() ; i++){
			for(int j = 1 ; i+j < str.length() ; j++){

				if(isSumString(str,0,i,j)){
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		String str = s.nextLine();
		for(int i = 0 ; i < testCases ; i++){
			str = s.nextLine();
			System.out.println(IsSumString(str));
		}
	}
}