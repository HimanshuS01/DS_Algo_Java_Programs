package StringMatching;

public class LCS {

	public static String lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0)
			return "";
		
		String dpArray[][] = new String[s1.length() + 1][s2.length() + 1];
		
		for (int i = 0; i <= s1.length(); i++) {
			dpArray[i][0] = "";
		}
		
		for (int j = 0; j <= s2.length(); j++) {
			dpArray[0][j] = "";
		}
		
		
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j)) {
					dpArray[i][j] = s1.charAt(s1.length() - i) + dpArray[i-1][j-1];
				} else {
					if (dpArray[i-1][j].length() > dpArray[i][j-1].length()) {
						dpArray[i][j] = dpArray[i-1][j];
					} else {
						dpArray[i][j] = dpArray[i][j-1];
					}
				}
			}
		}
		return dpArray[s1.length()][s2.length()];
	}
	
	
	public static int lcsLen(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0)
			return 0;
		
		int dpArray[][] = new int[s1.length() + 1][s2.length() + 1];
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j)) {
					dpArray[i][j] = 1 + dpArray[i-1][j-1];
				} else {
					dpArray[i][j] = Math.max(dpArray[i-1][j], dpArray[i][j-1]);
				}
			}
		}
		return dpArray[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcdefgh";
		String s2 = "1a2c3f4g";
		int lcsLength = lcsLen(s1, s2);
		System.out.println(lcs(s1,s2));
	}

}
