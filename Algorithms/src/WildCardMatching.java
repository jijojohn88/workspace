//https://leetcode.com/problems/wildcard-matching/
public class WildCardMatching {
	public static boolean isMatch(String s, String p) {
		int stringLength = s.length(), patternLength = p.length();
		int stringCounter = 0, patternCounter = 0;
		int starIdx = -1, sTmpIdx = -1;

		while (stringCounter < stringLength) {
			if (patternCounter < patternLength && (p.charAt(patternCounter) == '?' || p.charAt(patternCounter) == s.charAt(stringCounter))) {
				++stringCounter;
				++patternCounter;
			}
			else if (patternCounter < patternLength && p.charAt(patternCounter) == '*') {
				starIdx = patternCounter;
				sTmpIdx = stringCounter;
				++patternCounter;
			}
			else if (starIdx == -1) {
				return false;
			}
			else {
				patternCounter = starIdx + 1;
				stringCounter = sTmpIdx + 1;
				sTmpIdx = stringCounter;
			}
		}
		// The remaining characters in the pattern should all be '*' characters
		for (int i = patternCounter; i < patternLength; i++)
			if (p.charAt(i) != '*')
				return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println("----------WildCard matching problem-----------");
		String string = "aa";
		String pattern = "??";
		System.out.println(string + " vs " + pattern + " -> " + isMatch(string, pattern));
	}
}
