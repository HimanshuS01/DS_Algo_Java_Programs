package StringMatching;

import java.util.HashMap;

public class BoyerMoore {

	public static HashMap<Character, Integer> findLastOccurances(String s) {
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			h.put(s.charAt(i), i);
		}
		return h;
	}
	
	public static int boyerMoore(String s1, String s2) {
		HashMap<Character, Integer> lastOccurance = findLastOccurances(s2);
		int i = s2.length() - 1;
		while (i < s1.length()) {
			int j = s2.length()-1;
			int decrementInJ = 0;
			while (j >= 0) {
				if (s2.charAt(j) == s1.charAt(i - decrementInJ)) {
					j--;
					decrementInJ++;
					if (j == -1) {
						return i - (s2.length() - 1);
					}
				} else {
					Integer lastOccuranceOfLastChar = 
							lastOccurance.get(s1.charAt(i - decrementInJ));
					if (lastOccuranceOfLastChar == null) {
						i = i + j + 1;
					} else if (lastOccuranceOfLastChar > j) {
						i++;
					} else {
						i = i + j - lastOccuranceOfLastChar;
					}
					break;
				}
			}
		}
		return -1;
	}
 	
	public static void main(String args[]) {
		String s1 = "abxdefghijklbcxhgj";
		String s2 = "bcx";
		
		System.out.println(boyerMoore(s1,s2));
	}
	
}
