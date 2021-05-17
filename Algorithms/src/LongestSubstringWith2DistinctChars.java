import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWith2DistinctChars {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> lastIndex = new HashMap<>();
		int result = 0;
		char first = 'a';
		char second = 'a';
		for (char c : s.toCharArray()) {

			if (lastIndex.containsKey(c)) {
				lastIndex.put(c, lastIndex.get(c) + 1);
			} else if (lastIndex.size() >= 2) {
				Character toremove = null;
				for (Character key : lastIndex.keySet()) {
					if (!key.equals(c) && !key.equals(first)) {
						toremove = key;
					}
				}
				lastIndex.remove(toremove);
				lastIndex.put(c, 1);
			} else {
				lastIndex.put(c, 1);
			}

			int sum = 0;
			for (int val : lastIndex.values()) {
				sum += val;
			}
			result = Math.max(result, sum);
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("abaccc"));
		//this is not complete and its giving wrong result
	}

}
