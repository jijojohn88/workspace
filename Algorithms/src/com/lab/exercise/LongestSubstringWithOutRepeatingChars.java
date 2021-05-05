package com.lab.exercise;

import java.util.Scanner;

public class LongestSubstringWithOutRepeatingChars {

	public static void main(String[] args) {
		int result = 0;
		System.out.print("Enter the input string to validate the longest non repeating sub chars:");
		Scanner scanner = new Scanner(System.in);

		String inputString = scanner.next();

		if (inputString == null || inputString.length() <= 0) {
			result = 0;
		} else {
			int left = 0, right = 0;
			Integer[] chars = new Integer[128];
			while (right < inputString.length()) {

				char c = inputString.charAt(right);
				Integer index = chars[c];

				if (index != null && index >= left && index < right) {
					left = index + 1;
				} else {
					chars[c] = right;

				}
				result = Math.max(result, right - left + 1);
				right++;

			}

		}
		System.out.println("result = " + result);
		scanner.close();

	}

}
