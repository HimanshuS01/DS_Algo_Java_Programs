package fundamentals;

public class Hamming {

	public static class HammingOutput {
		int hamming;
		String str2;
		public HammingOutput(int hamming, String str) {
			this.hamming = hamming;
			this.str2 = str;
		}
	}
	
	public static HammingOutput hamming(String str1, String str2) {
		if (str1.length() != str2.length()) {
			HammingOutput h = new HammingOutput(-1, "");
			return h;
		}
		
		if (str1.length() == 0) {
			HammingOutput h = new HammingOutput(0, "");
			return h;
		}
		
		HammingOutput smallHamming = hamming(str1.substring(1), str2.substring(1));
		
		if (str1.charAt(0) == str2.charAt(0)) {
			return new HammingOutput(smallHamming.hamming, str1.charAt(0) + smallHamming.str2);
		} else {
			char requiredChar1 = str1.charAt(0);
			char requiredChar2 = str2.charAt(0);
			String str = smallHamming.str2;
			for (int i =0; i < str.length(); i++) {
				if (str.charAt(i) == requiredChar1 && str1.charAt(i+1) == requiredChar2) {
					String outputString = str.charAt(i) + str.substring(0, i) + requiredChar2 + str.substring(i+1);
					return new HammingOutput(smallHamming.hamming -1, outputString);
				}
			}
			
			for (int i =0; i < str.length(); i++) {
				if (str.charAt(i) == requiredChar1 && str.charAt(i) != str1.charAt(i+1)) {
					String outputString = str.charAt(i) + str.substring(0, i) + requiredChar2 + str.substring(i+1);
					return new HammingOutput(smallHamming.hamming, outputString);
				}
			}
			
			for (int i =0; i < str.length(); i++) {
				if (str1.charAt(i+1) == requiredChar2 && str.charAt(i) != str1.charAt(i+1)) {
					String outputString = str.charAt(i) + str.substring(0, i) + requiredChar2 + str.substring(i+1);
					return new HammingOutput(smallHamming.hamming, outputString);
				}
			}
			return new HammingOutput(smallHamming.hamming + 1, requiredChar2 + str);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HammingOutput h = hamming("abcdefx", "dbcefay");
		System.out.println("distance " + h.hamming + " final " + h.str2);
	}

}
