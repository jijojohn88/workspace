/*
Given an input string (v) and a pattern, implement a wildcard matching function with support for literal characters a through z and the wildcard character * (which matches zero or more of any character).

static boolean isMatch(String v, String pattern)
Part 1
// cat   c*t      → true
// cat   *t       → true
// dog   c*t      → false
// c abc t  c * t     -> true

// c abc t abc t = c * t * t 

//cat *d = false


Part 2
// cat   *c**t    → true
// cat   *t*a*c*  → false


cat [c] [a] [t] - string

c*t     [*] [t] - pattern

 */

public class PatternMatching {

	/*
	 * public static String prefix(String pattern) {
	 * 
	 * String prefix = ""; boolean starFound = false; for(int
	 * i=0;i<pattern.length;i++) {
	 * 
	 * if(pattern.charAt('*')) { starFound=true; break; } else { prefix = prefix +
	 * pattern.charAt(i); } }
	 * 
	 * if(!startFound || prefix.length() == 0) { return null; }
	 * 
	 * return prefix;
	 * 
	 * }
	 */
	public static String[] prefixAndSuffix(String pattern) {

		String[] returnValue = new String[2];
		String prefix = "";
		String suffix = "";
		boolean starFound = false;

		for (int i = 0; i < pattern.length(); i++) {

			if (pattern.charAt(i) == '*') {
				starFound = true;
			} else {
				if (starFound) {
					suffix = suffix + pattern.charAt(i);
				} else {
					prefix = prefix + pattern.charAt(i);
				}
			}
		}

		if (!starFound) {

			returnValue[0] = null;
			returnValue[1] = null;
		} else {
			returnValue[0] = prefix;
			returnValue[1] = suffix;
		}

		return returnValue;

	}

	static boolean isMatch(String string, String pattern) {

		// boolean returnValue = false;
		if (pattern == null && string == null) {
			return false;
		} else if (pattern.length() < 0 && string.length() < 0) {
			return false;
		}

		String[] combo = prefixAndSuffix(pattern);

		String prefix = combo[0];
		String suffix = combo[1];

		if (prefix == null && suffix == null) {

			for (int i = 0; i < string.length(); i++) {

				if (string.charAt(i) != pattern.charAt(i)) {
					return false;
				}

			}
			return true;
		} else if (prefix != null && prefix.length() > 0) {
			for (int i = 0; i < prefix.length(); i++) {

				if (string.charAt(i) != prefix.charAt(i)) {
					return false;
				}

			}
		} else if (suffix != null && suffix.length() > 0) {

			int stringCounter = string.length() - 1;
			for (int i = suffix.length() - 1; i > 0; i--) {

				if (string.charAt(stringCounter) != suffix.charAt(i)) {
					return false;
				}
				stringCounter--;
			}
			return true;
		} else if (prefix != null && prefix.length() > 0 && suffix != null && suffix.length() > 0) {
			for (int i = 0; i < prefix.length(); i++) {
				if (string.charAt(i) != prefix.charAt(i)) {
					return false;
				}
			}
			int stringCounter = string.length() - 1;
			for (int i = suffix.length() - 1; i > 0; i--) {

				if (string.charAt(stringCounter) != prefix.charAt(i)) {
					return false;
				}
				stringCounter--;
			}
			return true;
		}

		else {
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*') {
					return false;
				}
			}

			return true;

		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println("comparing cat- vs - c*t = " + isMatch("cat", "c*t"));
		System.out.println("comparing cat - vs - *t = " + isMatch("cat", "*t"));
		System.out.println("comparing cat - vs - cat = " + isMatch("cat", "cat"));
		System.out.println("comparing dog - vs - c*t = " + isMatch("dog", "c*t"));
		
		//part2
		System.out.println("comparing cat - vs - *c**t = " + isMatch("cat", "*c**t"));
		System.out.println("comparing cat - vs - *t*a*c* = " + isMatch("cat", "*t*a*c*"));

	}
}
