

/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * 
 * @author jjijo
 *
 */

public class SplitAStringInBalancedStrings {

	public static void main(String[] args) {
		// String s = "RLRRLLRLRL";
		String s = "RLRRRLLRLL";

		int balancedCount = 0;
		int count = 0;

		for (int i = 0; i < s.length(); i++) {

			char currentChar = s.charAt(i);

			if ('L' == currentChar) {
				count++;
			} else if ('R' == currentChar) {
				count--;
			}

			if (count == 0) {
				balancedCount++;
			}
		}

		System.out.println(balancedCount);
	}

}
