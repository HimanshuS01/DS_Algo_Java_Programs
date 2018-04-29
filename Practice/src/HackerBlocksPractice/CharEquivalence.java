package HackerBlocksPractice;

import java.util.Scanner;
//https://github.com/coding-blocks-archives/Launchpad17-Fasttrack/blob/master/11_some_more_recursion/charEquiv.cc
public class CharEquivalence {

	public static void printCharEquiv(char[] strArr,char[] dummyArr,int beg,int i) {
		
		
		if(beg >= strArr.length) {
			
			for(int j = 0 ; j < dummyArr.length ; j++) {
				System.out.print(dummyArr[j]);
			}
			System.out.println();
			return;
			
		}
		char curSymbol = strArr[beg];
	    int curDig = curSymbol - '0';  // '1' - '0' = 1 
	    char curChar = (char)('a' + curDig - 1); 
	    
	    dummyArr[i] = curChar;
	    printCharEquiv(strArr, dummyArr,beg+1, i + 1);

	    // 2 wale 
	    if (beg+1 >= strArr.length) return ;
	    dummyArr[i+1] = ' ';
	    char nextSymbol = strArr[beg + 1];
	    int nextDig = nextSymbol - '0';
	    int cur2DigNum = curDig * 10 + nextDig;
	    if (cur2DigNum > 26) return;
	    char char2Dig = (char)('a' + cur2DigNum - 1);
	    dummyArr[i] = char2Dig;
	    printCharEquiv(strArr, dummyArr,beg + 2, i + 1);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		char []strArr = str.toCharArray();
		char []dummyArr = new char[strArr.length];
		printCharEquiv(strArr,dummyArr,0,0);
	}

}
