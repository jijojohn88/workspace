

import java.util.Scanner;

public class LongestPalindrome {

	public String longestPalindrome(String testString) {
		// boundary condition
		if (testString == null || testString.length() < 1) {
			return "";
		}
		// non-null string
		int start = 0, end = 0;
		for (int i = 0; i < testString.length(); i++) {
			int len1 = expandAroundCenter(testString, i, i);
			int len2 = expandAroundCenter(testString, i, i + 1);
			System.out.println("len1 = " + len1 + ", len2 = " + len2);
			int maxLength = Math.max(len1, len2);
			if (maxLength > end - start) {
				start = i - (maxLength - 1) / 2;
				end = i + maxLength / 2;
			}
		}
		return testString.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		if (L >= 0 && R < s.length()) {
			System.out.println("L Char = " + s.charAt(L) + ", R char = " + s.charAt(R));
		}
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter the palindrome");
		String input = reader.nextLine();
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		String palindrome = longestPalindrome.longestPalindrome(input);
		System.out.println("palindrome = " + palindrome);
		reader.close();
	}

}
