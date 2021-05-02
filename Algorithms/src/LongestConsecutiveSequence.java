

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/solution/
 * 
 * @author jjijo
 *
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] input = { 100, 4, 200, 1, 3, 2 };

		Set<Integer> myset = new HashSet<Integer>();
		for (int i : input) {
			myset.add(i);
		}
		Arrays.sort(input);

		int longestStreak = 0;
		for (int i : myset) {
			int currentStreak = 1;
			int currentNumber = i;
			if (!myset.contains(i - 1)) {

				while (myset.contains(currentNumber + 1)) {
					currentNumber++;
					currentStreak++;
				}
				longestStreak = Math.max(longestStreak, currentStreak);

			}
		}
		System.out.println(longestStreak);

	}

}
