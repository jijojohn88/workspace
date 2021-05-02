

import java.util.Scanner;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

/**
 * have a left,right,and result so far 
 * left is not incremented if no char is repeating. 
 * right is incremented for every duplicate or non-duplicate. 
 * result will be the max of result so far. 
 * 
 * @author jjijo
 *
 */
public class LongestSubStringWithOutRepeatingChars {

	public static int lengthOfLongestSubstring(String charSequence) {

		Integer[] chars = new Integer[128];
		int left = 0, right = 0, resultSoFar = 0;
		while (right < charSequence.length()) {
			char c = charSequence.charAt(right);
			Integer oldRightIndex = chars[c];
			if (oldRightIndex != null && left >= oldRightIndex && oldRightIndex < right) {
				left = oldRightIndex + 1;
			}

			chars[c] = right;
			resultSoFar = Math.max(resultSoFar, right - left + 1);
			right++;
		}

		return resultSoFar;

	}

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter the testcase-string");
		String userName = myObj.nextLine(); // Read user input
		System.out.println("Username is: " + userName); // Output user input }
		System.out.println("largestSize = " + lengthOfLongestSubstring(userName));
		myObj.close();
	}

}
