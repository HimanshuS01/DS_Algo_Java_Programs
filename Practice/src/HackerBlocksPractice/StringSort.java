package HackerBlocksPractice;

import java.util.*;
//https://hack.codingblocks.com/contests/c/251/103

public class StringSort {
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<String> strArr = new ArrayList<>();
		String str = s.nextLine();
		for(int i = 0 ; i < n ; i++){
			str = s.nextLine();
			strArr.add(str);
		}
		Collections.sort(strArr,new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {

				if(s1.toLowerCase().contains(s2.toLowerCase()) && s1.length() > s2.length()){
					return s2.compareToIgnoreCase(s1);
				}
				else if(s2.toLowerCase().contains(s1.toLowerCase()) && s2.length() > s1.length()){
					return s2.compareToIgnoreCase(s1);
				}
				return s1.compareToIgnoreCase(s2);
			}
		});

		System.out.println(strArr);
	}
}